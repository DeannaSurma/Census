package com.cs4302.census.shared.profiles;

import java.io.Serializable;
import java.util.List;

import com.cs4302.census.shared.EntityInfo;
import com.cs4302.census.shared.Tuple;
import com.googlecode.objectify.annotation.Entity;

@Entity(name="StateProfile")
public class StateProfile implements Serializable {
  private static final long serialVersionUID = 1L;
  
  EntityInfo stateInfo;
  List<Tuple> placeTuples;
  
  public StateProfile() {}
  
  public StateProfile(EntityInfo stateInfo, List<Tuple> placeTuples) {
    super();
    this.stateInfo = stateInfo;
    this.placeTuples = placeTuples;
  }

public EntityInfo getStateInfo() {
	return stateInfo;
}

public List<Tuple> getPlaceTuples() {
	return placeTuples;
}

  
}