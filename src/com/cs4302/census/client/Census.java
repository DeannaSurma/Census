package com.cs4302.census.client;

import com.cs4302.census.client.service.InputService;
import com.cs4302.census.client.service.InputServiceAsync;
import com.cs4302.census.client.service.OutputService;
import com.cs4302.census.client.service.OutputServiceAsync;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Census implements EntryPoint {
  /**
   * The message displayed to the user when the server cannot be reached or
   * returns an error.
   */
  private static final String SERVER_ERROR = "An error occurred while "
      + "attempting to contact the server. Please check your network "
      + "connection and try again.";

  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */
  private final InputServiceAsync inputService = GWT.create(InputService.class);
  private final OutputServiceAsync outputService = GWT.create(OutputService.class);

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
	  boolean state = true;
	  
	  // state = true -> Mitch - displaying info
	  // state = false -> Ken - uploading info
	  if (state){
		  // use outputService
		  final Button sendButton = new Button("Send");
	      final TextBox nameField = new TextBox();
	      nameField.setText("GWT User");
		  
	  }
	  else{
		  
		  // read from file, iterate, use inputService
		  // inputService.insertPlace(stateID, stateName, state70, state80, state90, state00, state10, countyID, countyName, county70, county80, county90, county00, county10, placeID, placeName, place70, place80, place90, place00, place10, new Async...)
	  }
	  
	  

  
  }
}
