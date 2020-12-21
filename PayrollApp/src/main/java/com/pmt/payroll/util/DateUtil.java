package com.pmt.payroll.util;

import java.time.format.DateTimeFormatter;

public class DateUtil {

	public final static DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static String formatDate(String dob) throws Exception {
		if (dob.length() != 8) {
			throw new Exception("Date length is not proper");
		}
		String year = dob.substring(0, 4);
		String month = dob.substring(4, 6);
		String day = dob.substring(6);
		return year + "-" + month + "-" + day;
	}

}
