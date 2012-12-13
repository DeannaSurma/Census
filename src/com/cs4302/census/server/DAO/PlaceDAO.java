package com.cs4302.census.server.DAO;

import com.cs4302.census.shared.EntityInfo;
import com.cs4302.census.shared.entities.County;
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
	String countyID = stateFP.toString().concat(placeFP.toString());
    Place place;
    try{
    	place = ofy.get(Place.class, countyID);
    }
    catch(Exception e){
    	place = null;
    }
    return place;
  }

  public Place addPlace(Long stateFP, Long countyFP, Long placeFP, EntityInfo placeInfo){ 
	Place place = getPlace(stateFP, placeFP);
	if (place == null){
		place = new Place(stateFP, countyFP, placeFP, placeInfo);
	    ofy.put(place);
	}
    return place;
  }
  
}
