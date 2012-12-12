package com.cs4302.census.shared.entities;

import java.io.Serializable;

import com.cs4302.census.shared.EntityInfo;
import com.googlecode.objectify.annotation.Entity;
import javax.persistence.Embedded;
import javax.persistence.Id;

@Entity(name="Place")
public class Place implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id String placeID;
    Long stateFP;
    Long countyFP;
    Long placeFP;
    @Embedded EntityInfo placeInfo;

    public Place() {}
    
    public Place(Long stateFP, Long countyFP, Long placeFP, EntityInfo placeInfo) {
      this.stateFP = stateFP;
      this.countyFP = countyFP;
      this.placeFP = placeFP;
      this.placeID = stateFP.toString().concat(placeFP.toString());
      this.placeInfo = placeInfo;
    }

	public String getPlaceID() {
		return placeID;
	}

	public Long getStateFP() {
		return stateFP;
	}

	public Long getCountyFP() {
		return countyFP;
	}

	public Long getPlaceFP() {
		return placeFP;
	}

	public EntityInfo getPlaceInfo() {
		return placeInfo;
	} 

}