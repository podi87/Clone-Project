package com.clone.service;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;


public class EndPointInterceptor extends HandlerInterceptorAdapter {

  private MonitoringService monitoringService = new MonitoringService();





  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    Enumeration<String> names = request.getHeaderNames();
    while (names.hasMoreElements()) {
      System.out.println(names.nextElement());
    }
    System.out.println(request.getInputStream());
    monitoringService.endpointLogger(request.getRequestURI());
    return true;
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    System.out.println(response.getContentType());
  }

}
