package com.cs4302.census.server.service.impl;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.inject.Inject;
import com.cs4302.census.server.provider.InputProvider;
import com.cs4302.census.server.service.InputService;
import com.cs4302.census.shared.CensusYear;

public class InputServiceImpl extends RemoteServiceServlet implements InputService {

  private static final long serialVersionUID = 1L;
  private final InputProvider importProvider;
  
  @Inject
  InputServiceImpl(InputProvider importProvider) {
    this.importProvider = importProvider;
  }
  
  // add state first
  public void insertState(CensusYear year, long stateID, String stateName, int population){ 
    importProvider.addState(year, stateID, stateName, population);
  }
  
  // add county second
  public void insertCounty(long stateID, long countyID, String countyName, CensusYear year, int population){ 
    importProvider.addCounty(stateID, countyID, countyName, year, population);
  }
  
  // add place last
  public void insertPlace(CensusYear year, long stateID, long countyID, long placeID, String placeName, int population){ 
    importProvider.addPlace(year, stateID, countyID, placeID, placeName, population);
  }
  
}


//public void addGoal(int userId, String title, String description) {
//  
//  Goal goal = new Goal(userId, title, description);
//  ofy.put(goal);
//  assert goal.getId() != null;
//}
//
//public void removeGoal(Long goalId) {
//  Key<Goal> goal = new Key<Goal>(Goal.class, goalId);
//  ofy.delete(goal);
//}
//
//public Goal getGoal(Long goalId) {
//  Key<Goal> goal = new Key<Goal>(Goal.class, goalId);
//  return ofy.get(goal);
//}
//
//public Goal[] getUserGoals(Long[] userIds) {
//  List<Goal> goals = new ArrayList<Goal>();
//  for (Long userId : userIds) {
//    Query<Goal> q = ofy.query(Goal.class).filter("userId =", userId);
//    for (Goal goal: q) {
//      goals.add(goal);
//      System.out.println(goal.getTitle());
//    }
//  }
//  return goals.toArray(new Goal[goals.size()]);
//}
