package com.cs4302.census.server.provider;

import com.cs4302.census.server.DAO.CountyDAO;
import com.cs4302.census.server.DAO.PlaceDAO;
import com.cs4302.census.server.DAO.StateDAO;
import com.cs4302.census.shared.CensusYear;
import com.cs4302.census.shared.entities.County;
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

 // add state first
 public void addState(CensusYear year, long stateID, String stateName, int population){ 
   stateDAO.addState(year, stateID, stateName, population);
 }
 
 // add county second
 public void addCounty(long stateID, long countyID, String countyName, CensusYear year, int population){ 
   if (countyDAO.addCounty(stateID, countyID, countyName, year, population)){
     stateDAO.addCountyToState(stateID, countyID);
   }
 }
 
 // add place last
 public void addPlace(CensusYear year, long stateID, long countyID, long placeID, String placeName, int population){ 
   if (placeDAO.addPlace(year, stateID, countyID, placeID, placeName, population)){
     County county = countyDAO.addPlaceToCounty(countyID, placeID);
     stateDAO.addPlaceToState(stateID, placeID, county.getCountyName(), placeName);
   }
 }
  
}
