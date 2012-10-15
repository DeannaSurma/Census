package com.cs4302.census.server.service;

import com.cs4302.census.shared.CensusYear;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface InputServiceAsync {
  public void insertState(CensusYear year, long stateID, String stateName, int population, AsyncCallback<Void> async);
  public void insertCounty(long stateID, long countyID, String countyName, CensusYear year, int population, AsyncCallback<Void> async);
  public void insertPlace(CensusYear year, long stateID, long countyID, long placeID, String placeName, int population, AsyncCallback<Void> async); 
}