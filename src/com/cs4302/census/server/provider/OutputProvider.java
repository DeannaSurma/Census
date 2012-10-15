package com.cs4302.census.server.provider;

import prefuse.data.search.Trie.TrieNode;

import com.cs4302.census.server.DAO.CountyDAO;
import com.cs4302.census.server.DAO.PlaceDAO;
import com.cs4302.census.server.DAO.StateDAO;
import com.cs4302.census.shared.Profile;
import com.cs4302.census.shared.entities.Place;
import com.cs4302.census.shared.entities.State;
import com.cs4302.census.shared.entities.County;
import com.google.inject.Inject;

public class OutputProvider {
  
  private final StateDAO stateDAO;
  private final CountyDAO countyDAO;
  private final PlaceDAO placeDAO;
  
  @Inject
  OutputProvider(StateDAO stateDAO, CountyDAO countyDAO, PlaceDAO placeDAO) {
    this.stateDAO = stateDAO;
    this.countyDAO = countyDAO;
    this.placeDAO = placeDAO;
  }
  
  public Profile getCountyList(Long stateID){
    // TODO
    return null;
  }
  
  public Profile getPlaceList(Long countyID){
    // TODO
    return null;
  }
 
 public Profile getPlaceProfile(Long placeID){
   Place place = placeDAO.getPlace(placeID);
   County county = countyDAO.getCounty(place.getCountyID());
   State state = stateDAO.getState(place.getStateID());
   return new Profile(state, county, place);
 }

 public String[] autoFill(long stateID, String inputString){
   State state = stateDAO.getState(stateID);
   TrieNode subTrie = state.getPlaceTrie().find(inputString);
   // TODO iterate through and get sample answers
   return null;
 }

}
