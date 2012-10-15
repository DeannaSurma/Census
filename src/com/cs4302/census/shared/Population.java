package com.cs4302.census.shared;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;

@Entity(name="Population")
public class Population implements Serializable {
    private static final long serialVersionUID = 1L;

  int p1970;
  int p1980;
  int p1990;
  int p2000;
  int p2010;
  
  public Population(){
    super();
  }
  
  public Population(int p1970, int p1980, int p1990, int p2000, int p2010) {
    super();
    this.p1970 = p1970;
    this.p1980 = p1980;
    this.p1990 = p1990;
    this.p2000 = p2000;
    this.p2010 = p2010;
  }

  public int get1970() {
    return p1970;
  }

  public int get1980() {
    return p1980;
  }

  public int get1990() {
    return p1990;
  }

  public int get2000() {
    return p2000;
  }

  public int get2010() {
    return p2010;
  }

  public void set1970(int p1970) {
    this.p1970 = p1970;
  }

  public void set1980(int p1980) {
    this.p1980 = p1980;
  }

  public void set1990(int p1990) {
    this.p1990 = p1990;
  }

  public void set2000(int p2000) {
    this.p2000 = p2000;
  }

  public void set2010(int p2010) {
    this.p2010 = p2010;
  }
  
}
