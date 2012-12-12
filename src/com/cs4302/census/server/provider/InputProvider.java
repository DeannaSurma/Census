package com.cs4302.census.server.provider;

import com.cs4302.census.server.DAO.CountyDAO;
import com.cs4302.census.server.DAO.PlaceDAO;
import com.cs4302.census.server.DAO.StateDAO;
import com.cs4302.census.shared.EntityInfo;
import com.google.inject.Inject;

public class InputProvider {
  
  private final StateDAO stateDAO;
  private final CountyDAO countyDAO;
  private final PlaceDAO placeDAO;
  
  @Inject
  InputProvider(StateDAO stateDAO, CountyDAO countyDAO, PlaceDAO placeDAO) {
    this.stateDAO = stateDAO;
    this.countyDAO = countyDAO;
    this.placeDAO = placeDAO;
  }

 public void addPlace(long stateFP,  String stateName,  int state70,  int state80,  int state90,  int state00,  int state10,
		 long countyFP, String countyName, int county70, int county80, int county90, int county00, int county10,
		 long placeFP,  String placeName,  int place70,  int place80,  int place90,  int place00,  int place10){ 
	 
	 EntityInfo placeInfo = new EntityInfo(placeName, placeFP, place70, place80, place90, place00, place10);
	 EntityInfo countyInfo = new EntityInfo(countyName, countyFP, county70, county80, county90, county00,  county10);
	 EntityInfo stateInfo = new EntityInfo(stateName, stateFP, state70, state80, state90, state00,  state10);
     
	 placeDAO.addPlace(stateFP, countyFP, placeFP, placeInfo);
	 countyDAO.addCounty(stateFP, countyFP, placeFP, countyInfo);
	 stateDAO.addState(stateFP, countyFP, stateInfo);
 }
  
}
