package com.cs4302.census.server.DAO;

import com.cs4302.census.shared.CensusYear;
import com.cs4302.census.shared.entities.County;
import com.googlecode.objectify.Objectify;

public class CountyDAO {
  
  Objectify ofy;
  
  public County getCounty(Long countyID){
    return ofy.get(County.class, countyID);
  }
  
  public boolean addCounty(long stateID, long countyID, String countyName, CensusYear year, int population){ 
    boolean isNew = false;
    County county = getCounty(countyID);
    if (county == null){
      isNew = true;
      county = new County(stateID, countyID, countyName, year, population);
    }
    else{
      county.addPopulation(population, year);
    }
    ofy.put(county);
    return isNew;
  }
  
  public County addPlaceToCounty(long countyID, long placeID){
    County county = getCounty(countyID);
    county.addPlaceID(placeID);
    ofy.put(county);
    return county;
  }

}
