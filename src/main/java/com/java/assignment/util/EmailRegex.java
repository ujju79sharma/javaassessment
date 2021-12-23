package com.java.assignment.util;

import java.util.regex.Pattern;

public class EmailRegex {

	public static boolean patternMatches(String emailAddress) {

		String regexPattern = "^(.+)@(\\S+)$";
		return Pattern.compile(regexPattern).matcher(emailAddress).matches();
	}
}
