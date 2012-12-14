package com.cs4302.census.client;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.cs4302.census.shared.EntityInfo;
import com.cs4302.census.shared.Tuple;
import com.cs4302.census.shared.profiles.CountyProfile;
import com.cs4302.census.shared.profiles.PlaceProfile;
import com.cs4302.census.shared.profiles.StateProfile;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.VisualizationUtils;
import com.google.gwt.visualization.client.visualizations.LineChart;
import com.google.gwt.visualization.client.visualizations.LineChart.Options;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Census implements EntryPoint {

	/* Declaring gui components that are field variables */
	RootPanel rootPanel;
	Label enterstatelabel;
	Label entercountylabel;
	Label placenamelabel;
	ListBox statelistbox;
	ListBox countylistbox;
	StateProfile stateprof;
	CountyProfile countyprof;
	private ListBox placelistbox;
	private SimplePanel simplePanel;
	private CheckBox useGrowth;

	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side service.
	 */
	private final InputServiceAsync inputService = GWT.create(InputService.class);
	private final OutputServiceAsync outputService = GWT.create(OutputService.class);
	public HashMap<String, Integer> statefips = new HashMap<String, Integer>();

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		boolean state = true;

		Runnable onLoadCallback = new Runnable() {
			public void run() {
				System.out.println("STATE_CHECK1");
				LineChart line = new LineChart(createTable(), createOptions());
				simplePanel.add(line);
			}
		};

		if (state){
			System.out.println("STATE_CHECK2");
			final Button sendButton = new Button("Send");
			final TextBox nameField = new TextBox();
			nameField.setText("GWT User");
			initializeGui(onLoadCallback);
		}
		else{

			inputService.insertPlace(new AsyncCallback<Void>() {
				@Override  
				public void onFailure(Throwable caught) {
					System.out.println("FAILED");
				}

				@Override
				public void onSuccess(Void result) {
					System.out.println("SUCCESS");

				}
			});
		}
	}


	protected AbstractDataTable createTable() {
		DataTable data = DataTable.create();
		data.addColumn(ColumnType.STRING, "Year");
		data.addColumn(ColumnType.NUMBER, "Wisconsin");
		data.addColumn(ColumnType.NUMBER, "Dane County");
		data.addRows(4);
		data.setValue(0, 0, "1970");
		data.setValue(1, 0, "1980");
		data.setValue(2, 0, "1990");
		data.setValue(3, 0, "2000");

		data.setValue(0, 1, 1000);
		data.setValue(1, 1, 2000);
		data.setValue(2, 1, 3000);
		data.setValue(3, 1, 4000);

		data.setValue(0, 2, 200);
		data.setValue(1, 2, 300);
		data.setValue(2, 2, 400);
		data.setValue(3, 2, 500);
		return data;
	}

	private void initializeGui(Runnable onLoadCallback) {
		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel rootPanel = RootPanel.get("nameFieldContainer");
		Label enterstatelabel = new Label("Enter State");
		rootPanel.add(enterstatelabel, 77, 47);
		enterstatelabel.setSize("71px", "22px");

		Label entercountylabel = new Label("Enter County");
		rootPanel.add(entercountylabel, 72, 86);

		Label placenamelabel = new Label("Enter Place Name");
		rootPanel.add(placenamelabel, 77, 127);

		countylistbox = new ListBox();
		countylistbox.addItem("Select State");
		rootPanel.add(countylistbox, 243, 86);
		countylistbox.setSize("161px", "24px");
		countylistbox.setVisibleItemCount(5);
		countylistbox.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent sender) {
				String stateName = statelistbox.getValue(statelistbox.getSelectedIndex());
				LineChart list = (LineChart) simplePanel.getWidget();
				createCountyTable(stateName);
				simplePanel.clear();
				simplePanel.add(list);

			}

		});  

		statelistbox = new ListBox();

		statelistbox.addItem("Alabama");
		statelistbox.addItem("Alaska");
		statelistbox.addItem("Arizona");
		statelistbox.addItem("Arkansas");
		statelistbox.addItem("California");
		statelistbox.addItem("Colorado");
		statelistbox.addItem("Connecticut");
		statelistbox.addItem("Delaware");
		statelistbox.addItem("Florida");
		statelistbox.addItem("Georgia");
		statelistbox.addItem("Hawaii");
		statelistbox.addItem("Idaho");
		statelistbox.addItem("Illinois");
		statelistbox.addItem("Indiana");
		statelistbox.addItem("Iowa");
		statelistbox.addItem("Kansas");
		statelistbox.addItem("Kentucky");
		statelistbox.addItem("Louisiana");
		statelistbox.addItem("Maine");
		statelistbox.addItem("Maryland");
		statelistbox.addItem("Massachusetts");
		statelistbox.addItem("Michigan");
		statelistbox.addItem("Minnesota");
		statelistbox.addItem("Mississippi");
		statelistbox.addItem("Missouri");
		statelistbox.addItem("Montana");
		statelistbox.addItem("Nebraska");
		statelistbox.addItem("Nevada");
		statelistbox.addItem("New Hampshire");
		statelistbox.addItem("New Jersey");
		statelistbox.addItem("New Mexico");
		statelistbox.addItem("New York");
		statelistbox.addItem("North Carolina");
		statelistbox.addItem("North Dakota");
		statelistbox.addItem("Ohio");
		statelistbox.addItem("Oklahoma");
		statelistbox.addItem("Oregon");
		statelistbox.addItem("Pennsylvania");
		statelistbox.addItem("Rhode Island");
		statelistbox.addItem("South Carolina");
		statelistbox.addItem("South Dakota");
		statelistbox.addItem("Tennessee");
		statelistbox.addItem("Texas");
		statelistbox.addItem("Utah");
		statelistbox.addItem("Vermont");
		statelistbox.addItem("Virginia");
		statelistbox.addItem("Washington");
		statelistbox.addItem("West Virginia");
		statelistbox.addItem("Wisconsin");
		statelistbox.addItem("Wyoming");
		rootPanel.add(statelistbox, 243, 52);
		statelistbox.setSize("161px", "24px");
		statelistbox.setVisibleItemCount(5);
		statelistbox.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent sender) {
				String stateName = statelistbox.getValue(statelistbox.getSelectedIndex());
				LineChart list = (LineChart) simplePanel.getWidget();
				createStateTable(stateName);
				simplePanel.clear();
				simplePanel.add(list);
			}

		});              
		placelistbox = new ListBox();
		placelistbox.addItem("Select State or County");
		rootPanel.add(placelistbox, 243, 116);
		placelistbox.setSize("161px", "25px");
		placelistbox.setVisibleItemCount(5);
		placelistbox.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent sender) {
				String stateName = statelistbox.getValue(statelistbox.getSelectedIndex());
				LineChart list = (LineChart) simplePanel.getWidget();
				list = new LineChart(createTable(), createOptions());
				simplePanel.clear();
				simplePanel.add(list);
			}
		});  

		Label titlelabel = new Label("Census Data Finder");
		titlelabel.setStyleName("h1");
		rootPanel.add(titlelabel, 170, 10);
		titlelabel.setSize("143px", "22px");

		simplePanel = new SimplePanel();
		rootPanel.add(simplePanel, 400, 0);
		simplePanel.setSize("1000px", "600px");

		useGrowth = new CheckBox("Use % Growth");
		rootPanel.add(useGrowth, 319, 10);

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending state to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		VisualizationUtils.loadVisualizationApi(onLoadCallback, LineChart.PACKAGE);
	}

	protected void createCountyTable(String stateName) {
		long fp = statefips.get(stateName);
		outputService.getStateProfile((Long) fp, new AsyncCallback<StateProfile>() {
			public void onFailure(Throwable caught) {
				return;
			}

			public void onSuccess(StateProfile result) {
				String countyname = countylistbox.getValue(countylistbox.getSelectedIndex());
				stateprof = result;
				outputService.getCountyList(result.getStateInfo().getID(),  new AsyncCallback<List<Tuple>>() {

					public void onFailure(Throwable caught) {
						return;
					}

					public void onSuccess(List<Tuple> tups) {
						buildcountytable(tups, stateprof);
					}



				});
			}
		});
	}

	public void buildcountytable(List<Tuple> tups, StateProfile result) {
		Iterator<Tuple> tupiter = tups.iterator();
		while (tupiter.hasNext())
		{
			Tuple t = tupiter.next();
			outputService.getCountyProfile(result.getStateInfo().getID(), t.getId(), new AsyncCallback<CountyProfile>() {

				public void onFailure(Throwable caught) {
					return;
				}

				public void onSuccess(CountyProfile result) {
					if (result.getCountyInfo().getName().equals(countylistbox.getValue(countylistbox.getSelectedIndex())))
					{
						int seventy = result.getCountyInfo().get1970();
						int eighty = result.getCountyInfo().get1980();
						int ninety = result.getCountyInfo().get1990();
						int two = result.getCountyInfo().get2000();
						int twoten = result.getCountyInfo().get2010();
						DataTable data = DataTable.create();
						data.addColumn(ColumnType.STRING, "Year");
						data.addColumn(ColumnType.NUMBER, result.getCountyInfo().getName());
						data.addColumn(ColumnType.NUMBER, result.getStateInfo().getName());                                
						if (!useGrowth.isChecked())
						{
							data.addRows(5);
							data.setValue(0, 0, "1970");
							data.setValue(1, 0, "1980");
							data.setValue(2, 0, "1990");
							data.setValue(3, 0, "2000");
							data.setValue(4, 0, "2010");

							data.setValue(0,  1, seventy);
							data.setValue(1, 1, eighty);
							data.setValue(2, 1, ninety);
							data.setValue(3, 1, two);
							data.setValue(4, 1, twoten);

							data.setValue(0,  2, result.getStateInfo().get1970());
							data.setValue(1, 2, result.getStateInfo().get1980());
							data.setValue(2, 2, result.getStateInfo().get1990());
							data.setValue(3, 2, result.getStateInfo().get2000());
							data.setValue(4, 2, result.getStateInfo().get2010());
							updatechart(data);
						}
						else
						{
							data.addRows(4);
							data.setValue(0, 0, "1970");
							data.setValue(1, 0, "1980");
							data.setValue(2, 0, "1990");
							data.setValue(3, 0, "2000");

							data.setValue(0, 1, 100*((eighty / seventy)/ eighty));
							data.setValue(1, 1, 100*((ninety / eighty) / ninety));
							data.setValue(2, 1, 100*((two / ninety) / two));
							data.setValue(3, 1, 100*((twoten / two) / twoten));

							seventy = result.getStateInfo().get1970();
							eighty = result.getStateInfo().get1980();
							ninety = result.getStateInfo().get1990();
							two = result.getStateInfo().get2000();
							twoten = result.getStateInfo().get2010();

							data.setValue(0, 2, 100*((eighty / seventy)/ eighty));
							data.setValue(1, 2, 100*((ninety / eighty) / ninety));
							data.setValue(2, 2, 100*((two / ninety) / two));
							data.setValue(3, 2, 100*((twoten / two) / twoten));
							updatechart(data);
						}

					}
					Iterator<Tuple> placeiter = result.getPlaceTuples().iterator();
					placelistbox.clear();
					handlePlacelist(result);
					while (placeiter.hasNext()) {
						placelistbox.addItem(placeiter.next().getName());
					}
				}

			});
		}
	}



	protected void createStateTable(String stateName) {

		long fp = statefips.get(stateName);
		outputService.getStateProfile((Long) fp, new AsyncCallback<StateProfile>() {

			public void onFailure(Throwable caught) {
				return;
			}

			public void onSuccess(StateProfile result) {
				if (!useGrowth.isChecked())
				{
					DataTable data = DataTable.create();
					data.addColumn(ColumnType.STRING, "Year");
					data.addColumn(ColumnType.NUMBER, result.getStateInfo().getName());
					data.addRows(5);
					data.setValue(0, 0, "1970");
					data.setValue(1, 0, "1980");
					data.setValue(2, 0, "1990");
					data.setValue(3, 0, "2000");
					data.setValue(4, 0, "2010");

					data.setValue(0, 1, result.getStateInfo().get1970());
					data.setValue(1, 1, result.getStateInfo().get1980());
					data.setValue(2, 1, result.getStateInfo().get1990());
					data.setValue(3, 1, result.getStateInfo().get2000());
					data.setValue(4, 1, result.getStateInfo().get2010());
					updatechart(data);
				}
				else {
					DataTable data = DataTable.create();
					int eighty = result.getStateInfo().get1980();
					int seventy = result.getStateInfo().get1970();
					int ninety = result.getStateInfo().get1990();
					int two = result.getStateInfo().get2000();
					int twoten = result.getStateInfo().get2010();
					data.addRows(4);
					data.addColumn(ColumnType.STRING, "Years");
					data.addColumn(ColumnType.NUMBER, result.getStateInfo().getName());

					data.setValue(0, 0, "1970-1980");
					data.setValue(1, 0, "1980-1990");
					data.setValue(2, 0, "1990-2000");
					data.setValue(3, 0, "2000-2010");


					data.setValue(0, 1, 100*((eighty-seventy) / seventy));
					data.setValue(1, 1, 100*((ninety-eighty) / eighty));
					data.setValue(2, 1, 100*((two-ninety) / ninety));
					data.setValue(3, 1, 100*((twoten-two)) / two);
					updatechart(data);
				}
				placelistbox.clear();
				handleCountyList(result);
			}

		});

	}

	protected void handlePlacelist(CountyProfile result) {
		outputService.getPlaceList(result.getStateInfo().getID(), result.getCountyInfo().getID(), new AsyncCallback<List<Tuple>>() {

			public void onFailure(Throwable caught) {
				return;
			}

			public void onSuccess(List<Tuple> result) {

				placelistbox.clear();
				Iterator<Tuple> placeiter = result.iterator();
				while (placeiter.hasNext())
				{
					placelistbox.addItem(placeiter.next().getName());
				}

			}

		});
	}

	protected void handleCountyList(StateProfile result) {
		outputService.getCountyList(result.getStateInfo().getID(), new AsyncCallback<List<Tuple>>() {

			public void onFailure(Throwable caught) {
				return;
			}

			public void onSuccess(List<Tuple> result) {
				countylistbox.clear();
				Iterator<Tuple> countyiter = result.iterator();
				while (countyiter.hasNext())
				{
					countylistbox.addItem(countyiter.next().getName());
				}
			}

		});
	}

	protected void updatechart(DataTable data) {
		LineChart list = (LineChart) simplePanel.getWidget();
		list = new LineChart(data, createOptions());
		simplePanel.clear();
		simplePanel.add(list);
	}

	protected void buildplacetable(PlaceProfile result)
	{
		EntityInfo countyInfo = result.getCountyInfo();
		EntityInfo stateInfo = result.getStateInfo();
		int seventy = result.getCountyInfo().get1970();
		int eighty = result.getCountyInfo().get1980();
		int ninety = result.getCountyInfo().get1990();
		int two = result.getCountyInfo().get2000();
		int twoten = result.getCountyInfo().get2010();
		DataTable data = DataTable.create();
		data.addColumn(ColumnType.STRING, "Year");
		data.addColumn(ColumnType.NUMBER, result.getCountyInfo().getName());
		data.addColumn(ColumnType.NUMBER, result.getStateInfo().getName());  
		data.addColumn(ColumnType.NUMBER, result.getPlaceInfo().getName());
		if (!useGrowth.isChecked())
		{
			data.addRows(5);
			data.setValue(0, 0, "1970");
			data.setValue(1, 0, "1980");
			data.setValue(2, 0, "1990");
			data.setValue(3, 0, "2000");
			data.setValue(4, 0, "2010");

			data.setValue(0,  1, seventy);
			data.setValue(1, 1, eighty);
			data.setValue(2, 1, ninety);
			data.setValue(3, 1, two);
			data.setValue(4, 1, twoten);

			data.setValue(0,  2, result.getStateInfo().get1970());
			data.setValue(1, 2, result.getStateInfo().get1980());
			data.setValue(2, 2, result.getStateInfo().get1990());
			data.setValue(3, 2, result.getStateInfo().get2000());
			data.setValue(4, 2, result.getStateInfo().get2010());

			data.setValue(0,  2, result.getPlaceInfo().get1970());
			data.setValue(1, 2, result.getPlaceInfo().get1980());
			data.setValue(2, 2, result.getPlaceInfo().get1990());
			data.setValue(3, 2, result.getPlaceInfo().get2000());
			data.setValue(4, 2, result.getPlaceInfo().get2010());
			updatechart(data);
		}
		else
		{
			data.addRows(4);
			data.setValue(0, 0, "1970");
			data.setValue(1, 0, "1980");
			data.setValue(2, 0, "1990");
			data.setValue(3, 0, "2000");

			data.setValue(0, 1, 100*((eighty / seventy)/ eighty));
			data.setValue(1, 1, 100*((ninety / eighty) / ninety));
			data.setValue(2, 1, 100*((two / ninety) / two));
			data.setValue(3, 1, 100*((twoten / two) / twoten));

			seventy = result.getStateInfo().get1970();
			eighty = result.getStateInfo().get1980();
			ninety = result.getStateInfo().get1990();
			two = result.getStateInfo().get2000();
			twoten = result.getStateInfo().get2010();

			data.setValue(0, 2, 100*((eighty / seventy)/ eighty));
			data.setValue(1, 2, 100*((ninety / eighty) / ninety));
			data.setValue(2, 2, 100*((two / ninety) / two));
			data.setValue(3, 2, 100*((twoten / two) / twoten));

			seventy = result.getPlaceInfo().get1970();
			eighty = result.getPlaceInfo().get1980();
			ninety = result.getPlaceInfo().get1990();
			two = result.getPlaceInfo().get2000();
			twoten = result.getPlaceInfo().get2010();

			data.setValue(0, 3, 100*((eighty / seventy)/ eighty));
			data.setValue(1, 3, 100*((ninety / eighty) / ninety));
			data.setValue(2, 3, 100*((two / ninety) / two));
			data.setValue(3, 3, 100*((twoten / two) / twoten));


			updatechart(data);
		}
	}

	protected void createPlaceTable(String stateName, String countyName) {
		outputService.getPlaceList(stateprof.getStateInfo().getID(), countyprof.getCountyInfo().getID(), new AsyncCallback<List<Tuple>>() {

			public void onFailure(Throwable caught) {
				return;
			}

			public void onSuccess(List<Tuple> result) {
				Iterator<Tuple> placeiter = result.iterator();
				String placename = placelistbox.getValue(placelistbox.getSelectedIndex());
				while (placeiter.hasNext())
				{
					Tuple place = placeiter.next();
					if (place.getName().equals(placename))
					{
						outputService.getPlaceProfile(stateprof.getStateInfo().getID(), countyprof.getCountyInfo().getID(), new AsyncCallback<PlaceProfile>() {

							public void onFailure(Throwable caught) {
								return;
							}

							public void onSuccess(PlaceProfile result) {
								buildplacetable(result);
							}

						});
					}
				}
			}

		});
	}

	protected Options createOptions() {
		Options options = Options.create();
		options.setWidth(1000);
		options.setHeight(1000);
		options.setTitle("Population");
		return options;
	}
}

