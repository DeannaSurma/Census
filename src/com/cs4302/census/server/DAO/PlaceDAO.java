package com.cs4302.census.server.DAO;

import com.cs4302.census.shared.CensusYear;
import com.cs4302.census.shared.entities.Place;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;

public class PlaceDAO {
  
  Objectify ofy;

  public PlaceDAO() {
    ObjectifyService.register(Place.class);
    ofy = ObjectifyService.begin();
  }
  
  public boolean addPlace(CensusYear year, long stateID, long countyID, long placeID, String placeName, int population){
    boolean isNew = false;
    Place place = getPlace(placeID);
    if (place == null){
      isNew = true;
      place = new Place(year, stateID, countyID, placeID, placeName, population);
    }
    else{
      place.addPopulation(population, year);
    }
    ofy.put(place);
    return isNew;
  }
  
  public Place getPlace(Long placeID){
    return ofy.get(Place.class, placeID);
  }

  // query
  public Place queryPlace(String placeName, String countyName){
    Query<Place> q = ofy.query(Place.class).filter("stateID =", placeName);
    return ofy.get(q.getKey());
  }
  
}
