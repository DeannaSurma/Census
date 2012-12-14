package com.cs4302.census.shared.profiles;

import java.io.Serializable;

import com.cs4302.census.shared.EntityInfo;
import com.googlecode.objectify.annotation.Entity;

@Entity(name="PlaceProfile")
public class PlaceProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	EntityInfo stateInfo;
	EntityInfo countyInfo;
	EntityInfo placeInfo;

	public PlaceProfile() {}

	public PlaceProfile(EntityInfo stateInfo, EntityInfo countyInfo, EntityInfo placeInfo) {
		super();
		this.stateInfo = stateInfo;
		this.countyInfo = countyInfo;
		this.placeInfo = placeInfo;
	}

	public EntityInfo getStateInfo() {
		return stateInfo;
	}

	public EntityInfo getCountyInfo() {
		return countyInfo;
	}

	public EntityInfo getPlaceInfo() {
		return placeInfo;
	}

}