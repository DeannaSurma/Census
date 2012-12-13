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
	String countyID = stateFP.toString().concat(countyFP.toString());
    County county;
    try{
    	county = ofy.get(County.class, countyID);
    }
    catch(Exception e){
    	county = null;
    }
    return county;
  }

  public County addCounty(Long stateFP, Long countyFP, Long placeFP, EntityInfo countyInfo){ 
	County county = getCounty(stateFP, countyFP);
    if (county == null){
      county = new County(stateFP, countyFP, countyInfo);
    }
    county.addPlaceFP(placeFP);
    ofy.put(county);
    return county;
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
