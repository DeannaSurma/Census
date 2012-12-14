package com.cs4302.census.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("input")
public interface InputService extends RemoteService {
  void insertPlace();
}