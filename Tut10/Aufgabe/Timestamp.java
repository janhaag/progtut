/**
 * This class represents a certain date together with a certain time of day.
 * A date consists of day, month and year. A time is modeled by hour and minute.
 * @author Karlsruhe Institute of Technology, IPD Pretschner/Snelting
 *
 */
public class Timestamp {

	/** the day of the represented date */
	private final int day;

	/** the month of the represented date */
	private final int month;

	/** the year of the represented date */
	private final int year;

	/** the hour of the represented time of day */
	private final int hour;

	/** the minute of the represented time of day */
	private final int min;

	/**
	 * Constructs a new timestamp from the given data.
	 * @param min minute of new timestamp
	 * @param hour hour of new timestamp
	 * @param day day of new timestamp
	 * @param month month of new timestamp
	 * @param year year of new timestamp
	 */
	public Timestamp(int min, int hour, int day, int month, int year) {
		if (min < 0 || min > 59) {
			throw new IllegalArgumentException("min out of range: " + min);
		} else if (hour < 0 || hour > 23) {
			throw new IllegalArgumentException("hour out of range: " + hour);
		} else if (day < 1 || day > 30) {
			throw new IllegalArgumentException("day out of range: " + day);
		} else if (month < 1 || month > 12) {
			throw new IllegalArgumentException("month out of range: " + month);
		}

		this.min = min;
		this.hour = hour;
		this.day = day;
		this.month = month;
		this.year = year;
	}

	/**
	 * Returns this timestamp's day.
	 * @return this timestamp's day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Returns this timestamp's month.
	 * @return this timestamp's month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Returns this timestamp's year.
	 * @return this timestamp's year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Returns this timestamp's hour.
	 * @return this timestamp's hour
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * Returns this timestamp's minute.
	 * @return this timestamp's minute
	 */
	public int getMin() {
		return min;
	}

	/**
	 * Returns a string representation of this timestamp.
	 * @return a string representation of this timestamp
	 */
	public String toString() {
		return getDay() + "." + getMonth() + "." + getYear() + " " + getHour() + ":" + getMin();
	}

	/**
	 * Returns the timestamp, which is one minute ahead of this one.
	 * @return the timestamp, which is one minute ahead of this one
	 */
	public Timestamp tick() {
		Timestamp nextTime = null;
		if (min < 59) {
			nextTime = new Timestamp(min + 1, hour, day, month, year);
		} else if (hour < 23) {
			nextTime = new Timestamp(0, hour + 1, day, month, year);
		} else if (day < 30) {
			nextTime = new Timestamp(0, 0, day + 1, month, year);
		} else if (month < 12) {
			nextTime = new Timestamp(0, 0, 1, month + 1, year);
		} else {
			nextTime = new Timestamp(0, 0, 1, 1, year + 1);
		}
		return nextTime;
	}

	/**
	 * Computes the zodiac belonging to this timestamp's date.
	 * @return the zodiac belonging to this timestamp's date
	 */
	public String getZodiac() {
		String zodiac;

		switch (month) {
		case 1:
			if (day < 21) {
				zodiac = "Capricornus";
			} else {
				zodiac = "Aquarius";
			}
			break;
		case 2:
			if (day < 20) {
				zodiac = "Aquarius";
			} else {
				zodiac = "Pisces";
			}
			break;
		case 3:
			if (day < 21) {
				zodiac = "Pisces";
			} else {
				zodiac = "Aries";
			}
			break;
		case 4:
			if (day < 21) {
				zodiac = "Aries";
			} else {
				zodiac = "Taurus";
			}
			break;
		case 5:
			if (day < 22) {
				zodiac = "Taurus";
			} else {
				zodiac = "Gemini";
			}
			break;
		case 6:
			if (day < 22) {
				zodiac = "Gemini";
			} else {
				zodiac = "Cancer";
			}
			break;
		case 7:
			if (day < 23) {
				zodiac = "Cancer";
			} else {
				zodiac = "Leo";
			}
			break;
		case 8:
			if (day < 24) {
				zodiac = "Leo";
			} else {
				zodiac = "Virgo";
			}
			break;
		case 9:
			if (day < 24) {
				zodiac = "Virgo";
			} else {
				zodiac = "Libra";
			}
			break;
		case 10:
			if (day < 24) {
				zodiac = "Libra";
			} else {
				zodiac = "Scorpio";
			}
			break;
		case 11:
			if (day < 23) {
				zodiac = "Scorpio";
			} else {
				zodiac = "Sagittarius";
			}
			break;
		case 12:
			if (day < 22) {
				zodiac = "Sagittarius";
			} else {
				zodiac = "Capricornus";
			}
			break;
		default:
			zodiac = "Unknown";
		}

		return zodiac;
	}

	/**
	 * Returns {@code true}, if this instance and the specified {@link Timestamp} are equal and {@code false}
	 * otherwise
	 *
	 * @param other the other timestamp
	 * @return {@code true}, if this instance and the specified {@link Timestamp} are equal, {@code false} otherwise
	 */
	public boolean equals(Timestamp other) {
		return other != null && year == other.year && month == other.month && day == other.day && hour == other.hour
			&& min == other.min;
	}

}
