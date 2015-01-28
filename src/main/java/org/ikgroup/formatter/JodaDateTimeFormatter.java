package org.ikgroup.formatter;

import java.text.ParseException;
import java.util.Locale;

import javax.annotation.PostConstruct;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

public class JodaDateTimeFormatter implements Formatter<DateTime> {

	final Logger logger = LoggerFactory.getLogger(JodaDateTimeFormatter.class);

	private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

	private DateTimeFormatter dateFormat;

	@Autowired(required = false)
	private String datePattern;

	@PostConstruct
	public void init() {
		if (datePattern == null) {
			datePattern = DEFAULT_DATE_PATTERN;
		}
		dateFormat = DateTimeFormat.forPattern(datePattern);
	}

	@Override
	public String print(DateTime dateTime, Locale locale) {
		logger.info("Formatting datetime: " + dateTime);
		return dateFormat.print(dateTime);
	}

	@Override
	public DateTime parse(String dateTimeString, Locale locale) throws ParseException {
		logger.info("Parsing date string: " + dateTimeString);
		return dateFormat.parseDateTime(dateTimeString);
	}

}
