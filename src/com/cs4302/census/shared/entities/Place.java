package com.cs4302.census.shared.entities;

import java.io.Serializable;

import com.cs4302.census.shared.CensusYear;
import com.cs4302.census.shared.Population;
import com.googlecode.objectify.annotation.Entity;
import javax.persistence.Embedded;
import javax.persistence.Id;

@Entity(name="Place")
public class Place implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id Long placeID;
    long countyID;
    long stateID;
    String placeName;
    @Embedded Population population;

    public Place() {}
    
    public Place(CensusYear year, long stateID, long countyID, long placeID, 
                 String placeName, int population) {
      this.stateID = stateID;
      this.countyID = countyID;
      this.placeID = placeID;
      this.placeName = placeName;
      this.population = new Population();
      this.addPopulation(population, year);
    }

    public long getPlaceID() {
      return placeID;
    }

    public long getCountyID() {
      return countyID;
    }

    public long getStateID() {
      return stateID;
    }

    public String getName() {
      return placeName;
    }

    public Population getPopulation() {
      return population;
    }

    public void setPlaceID(long placeID) {
      this.placeID = placeID;
    }

    public void setCountyID(long countyID) {
      this.countyID = countyID;
    }

    public void setStateID(long stateID) {
      this.stateID = stateID;
    }

    public void setName(String placeName) {
      this.placeName = placeName;
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