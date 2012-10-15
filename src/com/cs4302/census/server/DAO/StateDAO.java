package com.cs4302.census.server.DAO;

import com.cs4302.census.shared.CensusYear;
import com.cs4302.census.shared.entities.State;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class StateDAO {
  
  Objectify ofy;

  public StateDAO() {
    ObjectifyService.register(State.class);
    ofy = ObjectifyService.begin();
  }
  
  public State getState(Long stateID){
    return ofy.get(State.class, stateID);
  }
  
  public State addState(CensusYear year, long stateID, String stateName, int population){ 
    State state = getState(stateID);
    if (state == null){
      state = new State(year, stateID, stateName, population);
    }
    else{
      state.addPopulation(population, year);
    }
    ofy.put(state);
    return state;
  }
  
  public State addCountyToState(long stateID, long countyID){
    State state = getState(stateID);
    state.addCountyID(countyID);
    ofy.put(state);
    return state;
  }
  
  public State addPlaceToState(long stateID, long placeID, String countyName, String placeName){
    State state = getState(stateID);
    state.addPlace(placeID, placeName, countyName);
    ofy.put(state);
    return state;
  }
  
}
