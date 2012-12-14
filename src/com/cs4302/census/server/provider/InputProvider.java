package com.cs4302.census.server.provider;

import com.cs4302.census.server.DAO.CountyDAO;
import com.cs4302.census.server.DAO.PlaceDAO;
import com.cs4302.census.server.DAO.StateDAO;
import com.cs4302.census.shared.EntityInfo;

public class InputProvider {
  
  private final StateDAO stateDAO;
  private final CountyDAO countyDAO;
  private final PlaceDAO placeDAO;
  
  public InputProvider() {
	  this.stateDAO = new StateDAO();
	  this.countyDAO = new CountyDAO();
	  this.placeDAO = new PlaceDAO();
  }

 public void addPlace(Long stateFP,  String stateName,  int state70,  int state80,  int state90,  int state00,  int state10,
		 Long countyFP, String countyName, int county70, int county80, int county90, int county00, int county10,
		 Long placeFP,  String placeName,  int place70,  int place80,  int place90,  int place00,  int place10){ 
	 
	 EntityInfo placeInfo = new EntityInfo(placeName, placeFP, place70, place80, place90, place00, place10);
	 EntityInfo countyInfo = new EntityInfo(countyName, countyFP, county70, county80, county90, county00,  county10);
	 EntityInfo stateInfo = new EntityInfo(stateName, stateFP, state70, state80, state90, state00,  state10);
     
	 boolean newPlace = placeDAO.addPlace(stateFP, countyFP, placeFP, placeInfo);
	 boolean newCounty = countyDAO.addCounty(stateFP, countyFP, placeFP, countyInfo, newPlace, placeName);
	 boolean newState = stateDAO.addState(stateFP, countyFP, stateInfo, newCounty, countyName);
	 
 }
  
}
