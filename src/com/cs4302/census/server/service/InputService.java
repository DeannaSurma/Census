package com.cs4302.census.server.service;

import com.cs4302.census.shared.CensusYear;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("input")
public interface InputService extends RemoteService {
  public void insertState(CensusYear year, long stateID, String stateName, int population);
  public void insertCounty(long stateID, long countyID, String countyName, CensusYear year, int population);
  public void insertPlace(CensusYear year, long stateID, long countyID, long placeID, String placeName, int population); 
}