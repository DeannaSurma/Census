package com.cs4302.census.shared;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;

@Entity(name="Tuple")
public class Tuple implements Serializable {
    private static final long serialVersionUID = 1L;

	String name;
	Long id;
	
	public Tuple(){}
	  
	public Tuple(String data){
		super();
	    String[] d = data.split("-");
	    id = Long.parseLong(d[0]);
	    name = d[1];
	}

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

}
