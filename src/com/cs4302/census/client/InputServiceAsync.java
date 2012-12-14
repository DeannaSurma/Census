package com.cs4302.census.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface InputServiceAsync {
	void insertPlace(AsyncCallback<Void> async);
}