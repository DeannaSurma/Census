package com.cs4302.census.server.provider;

import java.util.List;

import com.cs4302.census.server.DAO.CountyDAO;
import com.cs4302.census.server.DAO.PlaceDAO;
import com.cs4302.census.server.DAO.StateDAO;
import com.cs4302.census.shared.EntityInfo;
import com.cs4302.census.shared.Tuple;
import com.cs4302.census.shared.entities.Place;
import com.cs4302.census.shared.profiles.CountyProfile;
import com.cs4302.census.shared.profiles.PlaceProfile;
import com.cs4302.census.shared.profiles.StateProfile;
import com.google.inject.Inject;

public class OutputProvider {
  
  private final StateDAO stateDAO;
  private final CountyDAO countyDAO;
  private final PlaceDAO placeDAO;
  
  @Inject
  OutputProvider(StateDAO stateDAO, CountyDAO countyDAO, PlaceDAO placeDAO) {
    this.stateDAO = stateDAO;
    this.countyDAO = countyDAO;
    this.placeDAO = placeDAO;
  }
  
  public StateProfile getStateProfile(Long stateFP){
	  List<Tuple> countyList = stateDAO.getCountyList(stateFP);
	  EntityInfo stateInfo = stateDAO.getState(stateFP).getStateInfo();
	  return new StateProfile(stateInfo, countyList);
 }
  
  public CountyProfile getCountyProfile(Long stateFP, Long countyFP){
	  List<Tuple> placeList = countyDAO.getPlaceList(stateFP, countyFP);
	  EntityInfo countyInfo = countyDAO.getCounty(stateFP,countyFP).getCountyInfo();
	  EntityInfo stateInfo = stateDAO.getState(stateFP).getStateInfo();
	  return new CountyProfile(stateInfo, countyInfo, placeList);
 }
  
  public PlaceProfile getPlaceProfile(Long stateFP, Long placeFP){
	  Place place = placeDAO.getPlace(stateFP,placeFP);
	  EntityInfo placeInfo = place.getPlaceInfo();
	  EntityInfo countyInfo = countyDAO.getCounty(stateFP,place.getCountyFP()).getCountyInfo();
	  EntityInfo stateInfo = stateDAO.getState(stateFP).getStateInfo();
	  return new PlaceProfile(stateInfo, countyInfo, placeInfo);
 }

}
