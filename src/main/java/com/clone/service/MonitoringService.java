package com.clone.service;

import com.clone.model.Log;
import com.clone.model.Status;
import com.clone.repository.CloneRepository;
import org.springframework.stereotype.Service;

@Service
public class MonitoringService {

  private LogService logging = new LogService();

  public Status databaseCheck(CloneRepository cloneRepository) throws Exception {
    if (cloneRepository == null) {
      logging.log("ERROR", "Database not presented.");
      logging.log("DEBUG", "Database may not exist. Check database connection or existence.");
      return new Status("ok", "error");
    } else if (cloneRepository.count() > 0) {
      logging.log("INFO",
          "Database connection is ok and contains " + cloneRepository.count() + " element(s).");
      return new Status("ok", "ok");
    } else {
      logging.log("INFO", "Database connection is ok.");
      logging.log("WARN", "Database is empty.");
      return new Status("ok", "error");
    }
  }



  public Log endpointLogger(String pathVariable) {
    if (pathVariable.equals("/clone")) {
      return logging.log("INFO", "HTTP-REQUEST=GET at " + pathVariable);
    } else {
      return logging.log("ERROR", "HTTP-ERROR at " + pathVariable);
    }
  }
}