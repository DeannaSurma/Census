package com.cs4302.census.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;

import com.cs4302.census.client.InputService;
import com.cs4302.census.server.provider.InputProvider;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class InputServiceImpl extends RemoteServiceServlet implements InputService {

  private static final long serialVersionUID = 1L;
  private InputProvider importProvider;

  public InputServiceImpl() {
    this.importProvider = new InputProvider();
  }
  
  public void insertPlace() {
	  ServletContext context = getServletContext();
		InputStream is = context.getResourceAsStream("/WEB-INF/places-sample.csv");
		  
		BufferedReader br;
		
		try {
			String l="";
			boolean isHeader = true;
			br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			while((l=br.readLine())!=null){
				if (isHeader) isHeader=false;
				else {
					String[] sa = l.split(",");
										
					importProvider.addPlace(Long.parseLong(sa[0]), sa[1],
							Integer.parseInt(sa[2]),
							Integer.parseInt(sa[3]),
							Integer.parseInt(sa[4]),
							Integer.parseInt(sa[5]),
							Integer.parseInt(sa[6]),
							
							Long.parseLong(sa[7]), sa[8],
							Integer.parseInt(sa[9]),
							Integer.parseInt(sa[10]),
							Integer.parseInt(sa[11]),
							Integer.parseInt(sa[12]),
							Integer.parseInt(sa[13]),
							
							Long.parseLong(sa[14]), sa[15],
							Integer.parseInt(sa[16]),
							Integer.parseInt(sa[17]),
							Integer.parseInt(sa[18]),
							Integer.parseInt(sa[19]),
							Integer.parseInt(sa[20]));
					System.out.println("XX");
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
  }
  
}