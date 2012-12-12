package com.cs4302.census.client.service;

import com.cs4302.census.shared.profiles.CountyProfile;
import com.cs4302.census.shared.profiles.PlaceProfile;
import com.cs4302.census.shared.profiles.StateProfile;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("output")
public interface OutputService extends RemoteService {
  public CountyProfile getCountyProfile(Long stateFP, Long countyFP);
  public StateProfile getStateProfile(Long stateFP);
  public PlaceProfile getPlaceProfile(Long stateFP, Long placeFP);
}