package com.cs4302.census.server.DAO;

import java.util.ArrayList;
import java.util.List;

import com.cs4302.census.shared.EntityInfo;
import com.cs4302.census.shared.Tuple;
import com.cs4302.census.shared.entities.County;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class CountyDAO {
  
  Objectify ofy;

  public CountyDAO() {
    ObjectifyService.register(County.class);
    ofy = ObjectifyService.begin();
  }
  
  public County getCounty(Long stateFP, Long countyFP){
	System.out.println("GET_COUNTY");
	String countyID = stateFP.toString().concat(countyFP.toString());
    County county = null;
    try{
    	county = ofy.get(County.class, countyID);
    }
    catch(Exception e){ }
    return county;
  }

  // true if added new county
  public boolean addCounty(Long stateFP, Long countyFP, Long placeFP, EntityInfo countyInfo, boolean newPlace, String placeName){ 
	System.out.println("ADD_COUNTY");
	County county = getCounty(stateFP, countyFP);
    boolean status = false;
	if (county == null){
      county = new County(stateFP, countyFP, countyInfo);
      status = true;
    }
    county.addPlaceFP(placeFP, placeName, newPlace);
    ofy.put(county);
    return status;
  }
  
	  
  public List<Tuple> getPlaceList(Long stateFP, Long countyFP){
		 County county = this.getCounty(stateFP, countyFP);
		 List<String> placeNames = county.getPlaceNames();
		 List<Tuple> placeTuples = new ArrayList<Tuple>();
		 for(String placeName : placeNames ){
			 placeTuples.add(new Tuple(placeName));
		 }
		 return placeTuples;
  }
  
}
