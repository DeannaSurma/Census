package com.cs4302.census.server.DAO;

import com.cs4302.census.shared.EntityInfo;
import com.cs4302.census.shared.entities.Place;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class PlaceDAO {
  
  Objectify ofy;

  public PlaceDAO() {
    ObjectifyService.register(Place.class);
    ofy = ObjectifyService.begin();
  }
  
  public Place getPlace(Long stateFP, Long placeFP){
	String placeID = stateFP.toString().concat(placeFP.toString());
    Place place = null;
    try{
    	place = ofy.get(Place.class, placeID);
    }
    catch(Exception e){ }
    return place;
  }

  // true if added new place
  public boolean addPlace(Long stateFP, Long countyFP, Long placeFP, EntityInfo placeInfo){ 
	Place place = getPlace(stateFP, placeFP);
	if (place == null){
		place = new Place(stateFP, countyFP, placeFP, placeInfo);
	    ofy.put(place);
	    return true;
	}
    return false;
  }
  
}
