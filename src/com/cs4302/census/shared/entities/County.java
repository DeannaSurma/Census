package com.cs4302.census.shared.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cs4302.census.shared.EntityInfo;
import com.googlecode.objectify.annotation.Entity;
import javax.persistence.Embedded;
import javax.persistence.Id;

@Entity(name="County")
public class County implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id String countyID;
    Long stateFP;
    Long countyFP;
    @Embedded EntityInfo countyInfo;
    List<Long> placeFPs;
    List<String> placeNames;

    public County() {}
    
    public County(Long stateFP, Long countyFP, EntityInfo countyInfo) {
      this.stateFP = stateFP;
      this.countyFP = countyFP;
      this.countyID = stateFP.toString().concat(countyFP.toString());
      this.countyInfo = countyInfo;
      this.placeFPs = new ArrayList<Long>();
      this.placeNames = new ArrayList<String>();
    }
    
    public void addPlaceFP(Long placeFP){
      this.placeFPs.add(placeFP);
      this.placeNames.add(stateFP.toString().concat("-".concat(placeFP.toString())));
    }

	public String getCountyID() {
		return countyID;
	}

	public Long getStateFP() {
		return stateFP;
	}

	public Long getCountyFP() {
		return countyFP;
	}

	public EntityInfo getCountyInfo() {
		return countyInfo;
	}

	public List<Long> getPlaceFPs() {
		return placeFPs;
	}   
	
	public List<String> getPlaceNames() {
		return placeNames;
	}   

}