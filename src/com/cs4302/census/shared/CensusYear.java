package com.cs4302.census.shared;

public enum CensusYear {
  Y2000(2000),
  Y1990(1990),
  Y1980(1980),
  Y1970(1970);
  
  CensusYear(final int value) {
    this.value = value;
  };
  private final int value;
  public int getValue(){
    return this.value;
  }
}
