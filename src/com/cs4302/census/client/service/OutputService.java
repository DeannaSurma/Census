package com.cs4302.census.client.service;

import java.util.List;

import com.cs4302.census.shared.Tuple;
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
  public List<Tuple> getCountyList(Long stateFP);
  public List<Tuple> getPlaceList(Long stateFP, Long countyFP);
}