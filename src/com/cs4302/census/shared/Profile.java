package com.cs4302.census.shared;

import java.io.Serializable;

import com.cs4302.census.shared.entities.County;
import com.cs4302.census.shared.entities.Place;
import com.cs4302.census.shared.entities.State;

public class Profile implements Serializable {
    private static final long serialVersionUID = 1L;

    State state;
    County county;
    Place place;

    public Profile() {}
    
    public Profile(State state, County county, Place place) {
      this.state = state;
      this.county = county;
      this.place = place;
    }

    public State getState() {
      return state;
    }

    public County getCounty() {
      return county;
    }

    public Place getPlace() {
      return place;
    }

    public void setState(State state) {
      this.state = state;
    }

    public void setCounty(County county) {
      this.county = county;
    }

    public void setPlace(Place place) {
      this.place = place;
    }
    
}