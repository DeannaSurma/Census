package com.cs4302.census.shared.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cs4302.census.shared.BaseTuple;
import com.cs4302.census.shared.CensusYear;
import com.cs4302.census.shared.Population;
import com.googlecode.objectify.annotation.Entity;
import javax.persistence.Embedded;
import javax.persistence.Id;

import prefuse.data.search.Trie;

@Entity(name="State")
public class State implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id long stateID;
    List<Long> countyIDs;
    String stateName;
    @Embedded Population population;
    @Embedded Trie placeTrie;

    public State() {}
    
    public State(CensusYear year, long stateID, String stateName, int population) {
      this.stateID = stateID;
      this.stateName = stateName;
      this.countyIDs = new ArrayList<Long>();
      this.population = new Population();
      this.addPopulation(population, year);
      this.placeTrie = new Trie(false);
    }
    
    public void addPlace(long placeID, String placeName, String countyName){
      String placeString = placeName+ " ,"+countyName;
      BaseTuple bt = new BaseTuple(placeID);
      this.placeTrie.addString(placeString, bt);
    }
    
    public long getStateID() {
      return stateID;
    }
    
    public Trie getPlaceTrie(){
      return placeTrie;
    }

    public List<Long> getCountyIDs() {
      return countyIDs;
    }

    public String getStateName() {
      return stateName;
    }

    public Population getPopulation() {
      return population;
    }

    public void setStateID(long stateID) {
      this.stateID = stateID;
    }

    public void setCountyIDs(List<Long> countyIDs) {
      this.countyIDs = countyIDs;
    }

    public void setStateName(String stateName) {
      this.stateName = stateName;
    }

    public void setPopulation(Population population) {
      this.population = population;
    }

    public void addCountyID(Long countID){
      this.countyIDs.add(countID);
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