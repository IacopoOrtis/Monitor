package core;

import java.util.Random;
import java.util.Timer;

import sources.SourceInterface;
import actions.ActionInterface;

public class Monitor {

	public void setNewInterval() {
		Timer timer = new Timer();
		Random random = new Random(10);//x il primo avvio
		//timer.schedule(task, random.nextInt(60), 1000);
	}

	public ActionInterface newAction(String actionType) {
		switch (actionType.toLowerCase()) {
		case "message":
			//return new sources.Http();
			return null;
		default:
			return null;
		}
	}

	/**
	 * This function will return a new source according to the type input
	 * parameter
	 * 
	 * @param type
	 *            The type ( in string format ) of new source you want.
	 * @return It returns the chosen source object
	 * @throws Exception
	 */
	public SourceInterface giveMeNewSource(String type) throws Exception {

		switch (type.toLowerCase()) {
		case "http":
			return new sources.Http();
		case "ftp":
		case "ical":
		case "direttory":
		case "rss":
		case "git":
			throw new NoticeException("The type \"" + type.toString() + "\" of source is not implemented jet!");
		default:
			throw new Exception("Programming error! This message should never be seen!");
		}
	}

}
