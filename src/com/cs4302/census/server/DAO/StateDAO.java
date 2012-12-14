package com.cs4302.census.server.DAO;

import java.util.ArrayList;
import java.util.List;

import com.cs4302.census.shared.EntityInfo;
import com.cs4302.census.shared.Tuple;
import com.cs4302.census.shared.entities.State;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class StateDAO {
  
  Objectify ofy;

  public StateDAO() {
    ObjectifyService.register(State.class);
    ofy = ObjectifyService.begin();
  }
  
  public State getState(Long stateFP){
	State state;
    try{
    	state = ofy.get(State.class, stateFP);
    }
    catch(Exception e){
    	state = null;
    }
    return state;
  }

  public boolean addState(Long stateFP, Long countyFP, EntityInfo stateInfo, boolean newCounty, String countyName){ 
	  State state = getState(stateFP);
	    boolean status = false;
		if (state == null){
			state = new State(stateFP, stateInfo);
	      status = true;
	    }
		state.addCountyFP(countyFP, countyName, newCounty);
	    ofy.put(state);
	    return status;
	  }
    
  public List<Tuple> getCountyList(Long stateFP){
	    State state = this.getState(stateFP);
	    List<String> countyNames = state.getCountyNames();
	    List<Tuple> countyTuples = new ArrayList<Tuple>();
	    for(String countyData : countyNames ){
	    	countyTuples.add(new Tuple(countyData));
	    }
	    return countyTuples;
  }
  
}
