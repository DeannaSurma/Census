package com.cs4302.census.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface InputServiceAsync {
	public void insertPlace(long stateID,  String stateName,  int state70,  int state80,  int state90,  int state00,  int state10,
			  long countyID, String countyName, int county70, int county80, int county90, int county00, int county10,
			  long placeID,  String placeName,  int place70,  int place80,  int place90,  int place00,  int place10,
			  AsyncCallback<Void> async);
}