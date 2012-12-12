package com.cs4302.census.shared;

public class Tuple {

	String name;
	Long id;
	  
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
