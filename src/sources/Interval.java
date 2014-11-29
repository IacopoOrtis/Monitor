package sources;

import java.util.Comparator;

public class Interval {
	byte days = 0;
	byte hour = 0;
	byte minute = 0;
	int seconds = 0;
	long mseconds = 0;

	public Interval(byte days, byte hour, byte minute) throws Exception {
		this.set(days, hour, minute, 0, 0);
	}

	public Interval(byte days, byte hour, byte minute, int seconds) throws Exception {
		this.set(days, hour, minute, seconds, 0);
	}

	public Interval(byte days, byte hour, byte minute, int seconds, long mseconds) throws Exception {
		this.set(days, hour, minute, seconds, mseconds);
	}

	/**
	 * This function sets/changes the interval. The expression is intended as a
	 * number of hours and minutes, not in a 24h format. E.g.: inteval 120 min ;
	 * 36 hours & 120 min ; 24 hours
	 * 
	 * @param days
	 * @param hour
	 * @param minute
	 * @param seconds
	 * @param mseconds
	 * @throws Exception
	 */
	public void set(byte days, byte hour, byte minute, int seconds, long mseconds) throws Exception {
		if (days < 0) {
			throw new Exception("Days can't be less then zero");
		}
		if (hour < 0) {
			throw new Exception("Hours can't be less then zero");
		}
		if (minute < 0) {
			throw new Exception("Minutes can't be less then zero");
		}
		if (seconds < 0) {
			throw new Exception("Minutes can't be less then zero");
		}
		if (mseconds < 0) {
			throw new Exception("Minutes can't be less then zero");
		}
		if (days == 0 && minute == 0 && hour == 0 && seconds == 0 && mseconds == 0) {
			throw new Exception("Is not possible set an empty interval");
		}
		this.days = days;
		this.hour = hour;
		this.minute = minute;
		this.seconds = seconds;
		this.mseconds = mseconds;
	}
}

class IntervalComparator implements Comparator<Interval> {

	@Override
	public int compare(Interval o1, Interval o2) {
		if ((((o1.days * 24 + o1.hour) * 60 + o1.minute) * 60 + o1.seconds) * 1000 + o1.mseconds < (((o2.days * 24 + o2.hour) * 60 + o2.minute) * 60 + o2.seconds) * 1000 + o2.mseconds) {
			return 0;
		} else {
			return 1;
		}

	}
}
