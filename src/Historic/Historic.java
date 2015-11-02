package Historic;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Historic extends Observable {
	private static Historic instance = null;

	protected Historic() {
		eventList.add(" Mahjong Game ");
		eventList.add("Initialisation");
		eventList.add("--------------");
		eventList.add("Starting  Game");
		eventList.add("--------------");
	}

	public static Historic getInstance() {
		if (instance == null) {
			instance = new Historic();
		}
		return instance;
	}

	private List<String> eventList = new ArrayList<>();

	public String getEvents() {
		String events = "";
		for (int k = 0; k < 5; k++) {
			events += eventList.get(eventList.size() - (5 - k)) + "\n";
		}
		return events;
	}
	
	public void addEvent(String event){
		eventList.add(event);
		setChanged();
		notifyObservers();
	}
}
