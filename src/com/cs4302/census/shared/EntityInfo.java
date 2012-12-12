package com.cs4302.census.shared;

import java.io.Serializable;

import javax.persistence.Id;

import com.googlecode.objectify.annotation.Entity;

@Entity(name="EntityInfo")
public class EntityInfo implements Serializable {
    private static final long serialVersionUID = 1L;

  String name;
  @Id Long id;
  int p1970;
  int p1980;
  int p1990;
  int p2000;
  int p2010;
  
  public EntityInfo(){
    super();
  }
  
  public EntityInfo(String name, Long id, int p1970, int p1980, int p1990, int p2000, int p2010) {
    super();
    this.name = name;
    this.id = id;
    this.p1970 = p1970;
    this.p1980 = p1980;
    this.p1990 = p1990;
    this.p2000 = p2000;
    this.p2010 = p2010;
  }
  
  public String getName(){
	  return name;
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
  
}