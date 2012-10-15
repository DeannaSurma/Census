package com.cs4302.census.server.service.impl;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.inject.Inject;
import com.cs4302.census.server.provider.OutputProvider;
import com.cs4302.census.server.service.OutputService;

public class OutputServiceImpl extends RemoteServiceServlet implements OutputService {

  private static final long serialVersionUID = 1L;
  private final OutputProvider outportProvider;
  
  @Inject
  OutputServiceImpl(OutputProvider outportProvider) {
    this.outportProvider = outportProvider;
  }

  @Override
  public void autoFill(long stateID, String inputString) {
    outportProvider.autoFill(stateID, inputString);
    
  }

  @Override
  public void getCountyList(Long stateID) {
    outportProvider.getCountyList(stateID);
  }

  @Override
  public void getPlaceList(Long countyID) {
    outportProvider.getPlaceList(countyID);
  }

  @Override
  public void getPlaceProfile(Long placeID) {
    outportProvider.getPlaceProfile(placeID);
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
