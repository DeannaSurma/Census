package com.cs4302.census.shared.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cs4302.census.shared.CensusYear;
import com.cs4302.census.shared.Population;
import com.googlecode.objectify.annotation.Entity;
import javax.persistence.Embedded;
import javax.persistence.Id;

@Entity(name="County")
public class County implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id Long countyID;
    Long stateID;
    String countyName;
    List<Long> placeIDs;
    @Embedded Population population;

    public County() {}
    
    public County(long stateID, long countyID, String countyName, 
                  CensusYear year, int population) {
      this.stateID = stateID;
      this.countyID = countyID;
      this.countyName = countyName;
      this.placeIDs = new ArrayList<Long>();
      this.population = new Population();
      this.addPopulation(population, year);
    }

    public Long getCountyID() {
      return countyID;
    }

    public Long getStateID() {
      return stateID;
    }

    public String getCountyName() {
      return countyName;
    }

    public List<Long> getPlaceIDs() {
      return placeIDs;
    }

    public Population getPopulation() {
      return population;
    }

    public void setCountyID(Long countyID) {
      this.countyID = countyID;
    }

    public void setStateID(Long stateID) {
      this.stateID = stateID;
    }

    public void setCountyName(String countyName) {
      this.countyName = countyName;
    }

    public void setPlaceIDs(List<Long> placeIDs) {
      this.placeIDs = placeIDs;
    }

    public void setPopulation(Population population) {
      this.population = population;
    }
    
    public void addPlaceID(Long placeID){
      if (!this.placeIDs.contains(placeID)){
        this.placeIDs.add(placeID);
      }
    }

    public void addPopulation(int population, CensusYear year){
      switch(year.getValue()){
        case 1970:
          this.population.set1970(population);
          break;
        case 1980:
          this.population.set1980(population);
          break;
        case 1990:
          this.population.set1990(population);
          break;
        case 2000:
          this.population.set2000(population);
          break;
        case 2010:
          this.population.set2010(population);
          break;
      }
    }

}