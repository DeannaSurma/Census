package com.cs4302.census.client;

import com.cs4302.census.shared.profiles.StateProfile;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
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
	  boolean state = false;
	  
	  // state = true -> Mitch - displaying info
	  // state = false -> Ken - uploading info
	  if (state){
		  // use outputService
		  final TextBox nameField = new TextBox();
	      nameField.setText("GWT User");
		  
	  }
	  else{
		  
		  inputService.insertPlace(1l,"HI",2, 3,4,5,6, 1l,"HI",2, 3,4,5,6, 1l,"HI",2, 3,4,5,6, new AsyncCallback<Void>() {
			   @Override  
			   public void onFailure(Throwable caught) {
		            System.out.println("FAILED2");
		        }

				@Override
				public void onSuccess(Void result) {
					 System.out.println("SUCCESS2");
					// TODO Auto-generated method stub
					
				}
		    });
		  // read from file, iterate, use inputService
		  // inputService.insertPlace(stateID, stateName, state70, state80, state90, state00, state10, countyID, countyName, county70, county80, county90, county00, county10, placeID, placeName, place70, place80, place90, place00, place10, new Async...)
	  }
	  
	  
//	  outputService.getStateProfile(1l, new AsyncCallback<StateProfile>() {
//
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void onSuccess(StateProfile result) {
//				System.out.println(result.toString());
//				// TODO Auto-generated method stub
//				
//			}
//			
//			
//		});
	  

  
  }
}
