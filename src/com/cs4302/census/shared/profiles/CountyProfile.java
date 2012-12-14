package com.cs4302.census.shared.profiles;

import java.io.Serializable;
import java.util.List;

import com.cs4302.census.shared.EntityInfo;
import com.cs4302.census.shared.Tuple;
import com.googlecode.objectify.annotation.Entity;

@Entity(name="CountyProfile")
public class CountyProfile implements Serializable {
  private static final long serialVersionUID = 1L;
	
  EntityInfo stateInfo;
  EntityInfo countyInfo;
  List<Tuple> placeTuples;
  
  public CountyProfile() {}
  
  public CountyProfile(EntityInfo stateInfo, EntityInfo countyInfo, List<Tuple> placeTuples) {
    super();
    this.stateInfo = stateInfo;
    this.countyInfo = countyInfo;
    this.placeTuples = placeTuples;
  }

public EntityInfo getStateInfo() {
	return stateInfo;
}

public EntityInfo getCountyInfo() {
	return countyInfo;
}

public List<Tuple> getPlaceTuples() {
	return placeTuples;
}

}