package com.cs4302.census.server.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface OutputServiceAsync {
  public void autoFill(long stateID, String inputString, AsyncCallback<Void> async);
  public void getCountyList(Long stateID, AsyncCallback<Void> async);
  public void getPlaceList(Long countyID, AsyncCallback<Void> async);
  public void getPlaceProfile(Long placeID, AsyncCallback<Void> async);
}