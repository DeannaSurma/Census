package com.cs4302.census.shared.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cs4302.census.shared.EntityInfo;
import com.googlecode.objectify.annotation.Entity;
import javax.persistence.Embedded;
import javax.persistence.Id;

@Entity(name="State")
public class State implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id Long stateFP;
    @Embedded EntityInfo stateInfo;
    List<Long> countyFPs;
    List<String> countyNames;

    public State() {}
    
    public State(Long stateFP, EntityInfo stateInfo) {
      this.stateFP = stateFP;
      this.stateInfo = stateInfo;
      this.countyFPs = new ArrayList<Long>();
      this.countyNames = new ArrayList<String>();
    }
    
    public void addCountyFP(Long countyFP){
      this.countyFPs.add(countyFP);
      this.countyNames.add(stateFP.toString().concat("-".concat(countyFP.toString())));
    }
    
    public long getStateFP() {
      return stateFP;
    }
    
    public EntityInfo getStateInfo(){
    	return stateInfo;
    }
    
    public List<Long> getCountyFPs() {
      return countyFPs;
    }
    
    public List<String> getCountyNames() {
        return countyNames;
      }

}