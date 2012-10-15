package com.cs4302.census.server.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("output")
public interface OutputService extends RemoteService {
  public void autoFill(long stateID, String inputString);
  public void getCountyList(Long stateID);
  public void getPlaceList(Long countyID);
  public void getPlaceProfile(Long placeID);
}