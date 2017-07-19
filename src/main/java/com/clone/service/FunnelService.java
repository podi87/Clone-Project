package com.clone.service;

import com.clone.model.*;
import com.clone.repository.EventToDatabaseRepository;
import com.clone.repository.FunnelEventRepository;
import com.clone.repository.FunnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class FunnelService {
  private final String url = "https://greenfox-kryptonite.herokuapp.com/api/funnels/";

  @Autowired
  private FunnelRepository funnelRepo;

  @Autowired
  private EventToDatabaseRepository eventToDatabaseRepository;

  @Autowired
  private FunnelEventRepository funnelEventRepository;


  public long createAndSaveFunnelFormat() {
    funnelRepo.save(new Funnel());
    return funnelRepo.findOne(funnelRepo.count()).getId();
  }

  public FunnelFormat createFunnelFormatWithNullData(long id) {
    PageViewLinks pageViewLinks = new PageViewLinks();
    FunnelData funnelData = new FunnelData();
    if (funnelRepo.count() == 0) {
      return new FunnelFormat();
    } else {
      Iterable<Funnel> funnelList = funnelRepo.findAll();
      for (Funnel f : funnelList) {
        if (f.getId() == id) {
          pageViewLinks = new PageViewLinks(url + id, null, null, null, null);
          break;
        }
      }
    }
    return new FunnelFormat(pageViewLinks, funnelData);
  }

  public boolean saveFunnelEvent(long id, String path) {
      Iterable<EventToDatabase> eventToDatabaseIterable = eventToDatabaseRepository.findAll();
      for (EventToDatabase e : eventToDatabaseIterable) {
        System.out.println(e.getPath());
        System.out.println("/"+path);
        if (e.getPath().equals(path)) {
          FunnelEvent funnelEvent = new FunnelEvent(e.getPath(), e.getCount(), funnelRepo.findOne(id));
          funnelEventRepository.save(funnelEvent);
          return true;
        }
      }
    return false;
  }

  public Funnel getFun(long id) {
    return funnelRepo.findOne(id);
  }

  public String delFun(long id) {
    String temp = "not working";
    for(Funnel f : funnelRepo.findAll()) {
      if (f.getId()==id) {
        funnelRepo.delete(id);
        temp = "deleted funnel with id: " + id;
      }
    }
    return temp;
  }

  public List<FunnelEvent> getFunnelEvents(long id) {
    return funnelRepo.findOne(id).getEvents();
  }


  public FunnelFormat returnFunnelJson( long id) {
    List<FunnelEvent> events = getFunnelEvents(id);
    List<Steps> included = new ArrayList<>();
    List<StepData> stepDatas = new ArrayList<>();
    for (int i = 0; i < events.size(); i++) {
      StepData stepData = new StepData(i + 1);
      stepDatas.add(stepData);
      int percent = countPercent(included, events.get(i).getCount());
      StepAttributes stepAttributes = new StepAttributes(events.get(i).getPath(), events.get(i).getCount(), percent);
      Steps steps = new Steps(i + 1L , "steps", stepAttributes);
      included.add(steps);
    }
    PageViewLinks pageViewLinks = new PageViewLinks(url + id + "/relationships/steps", null, null, null, url + id + "/steps");
    FunnelStep funnelStep = new FunnelStep(pageViewLinks, stepDatas);
    Relationships relationships = new Relationships(funnelStep);
    FunnelData funnelData = new FunnelData(id, relationships, included);
    PageViewLinks funnelSelfLink = new PageViewLinks(url + id, null, null, null, null);
    return new FunnelFormat(funnelSelfLink, funnelData);
  }

  public int countPercent(List<Steps> stepList, int count) {
    if (stepList.size() == 0) {
      return 10000;
    } else {
      return (count * 10000) / stepList.get(stepList.size() - 1).getAttributes().getCount();
    }
  }
}