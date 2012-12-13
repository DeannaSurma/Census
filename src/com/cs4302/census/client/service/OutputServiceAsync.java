package com.cs4302.census.client.service;

import java.util.List;

import com.cs4302.census.shared.Tuple;
import com.cs4302.census.shared.profiles.CountyProfile;
import com.cs4302.census.shared.profiles.PlaceProfile;
import com.cs4302.census.shared.profiles.StateProfile;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface OutputServiceAsync {
  public void getCountyProfile(Long stateFP, Long countyFP, AsyncCallback<CountyProfile> async);
  public void getStateProfile(Long stateFP, AsyncCallback<StateProfile> async);
  public void getPlaceProfile(Long stateFP, Long placeFP, AsyncCallback<PlaceProfile> async);
  public void getCountyList(Long stateFP, AsyncCallback<List<Tuple>> callback);
  public void getPlaceList(Long stateFP, Long countyFP, AsyncCallback<List<Tuple>> callback);
}