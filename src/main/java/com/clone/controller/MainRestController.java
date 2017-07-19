package com.clone.controller;


import com.clone.model.FunnelFormat;
import com.clone.model.Status;
import com.clone.model.StepBody;
import com.clone.repository.CloneRepository;
import com.clone.service.FunnelService;
import com.clone.service.MonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
public class MainRestController {


  @Autowired
  private CloneRepository cloneRepository;

  @Autowired
  private MonitoringService monitoringService;

  @Autowired
  private FunnelService funnelService;


  @RequestMapping(value = "/clone", method = RequestMethod.GET)
  public Status heartbeat() throws Exception {
    return monitoringService.databaseCheck(cloneRepository);
  }

  @RequestMapping(value = "/api/funnels", method = RequestMethod.POST)
  public String funnelSave() {
    return "funnel has been created with id: " + funnelService.createAndSaveFunnelFormat();
  }

  @RequestMapping(value = "/api/funnels/{id}", method = RequestMethod.GET)
  public FunnelFormat getNullFunnel(@PathVariable(name = "id") long id, HttpServletRequest request) {
    return funnelService.createFunnelFormatWithNullData(id);
  }

  @RequestMapping(value = "/api/funnels/{id}/steps", method = RequestMethod.POST)
  public boolean getStepFunnel(@PathVariable(name = "id") long id, @RequestBody StepBody stepBody) {
    return funnelService.saveFunnelEvent(id, stepBody.getPath());
  }

  @RequestMapping(value = "/api/funnels/{id}/steps", method = RequestMethod.GET)
  public FunnelFormat getNullFunnel(@PathVariable(name = "id") long id) {
    return funnelService.returnFunnelJson(id);
  }

  @RequestMapping(value = "/api/funnels/{id}/delete", method = RequestMethod.DELETE)
  public String deleteFun(@PathVariable(name = "id") long id) {
    return funnelService.delFun(id);
  }

}
