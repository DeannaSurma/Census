package com.cs4302.census.server.service.impl;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.inject.Inject;
import com.cs4302.census.client.service.InputService;
import com.cs4302.census.server.provider.InputProvider;

public class InputServiceImpl extends RemoteServiceServlet implements InputService {

  private static final long serialVersionUID = 1L;
  private final InputProvider importProvider;
  
  @Inject
  InputServiceImpl(InputProvider importProvider) {
    this.importProvider = importProvider;
  }
  
  public void insertPlace(long stateFP,  String stateName,  int state70,  int state80,  int state90,  int state00,  int state10,
		  long countyFP, String countyName, int county70, int county80, int county90, int county00, int county10,
		  long placeFP,  String placeName,  int place70,  int place80,  int place90,  int place00,  int place10){
	  importProvider.addPlace(stateFP, stateName, state70, state80, state90, state00, state10, 
			  countyFP, countyName, county70, county80, county90, county00, county10, 
			  placeFP, placeName, place70, place80, place90, place00, place10);
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
