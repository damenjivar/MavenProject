package com.java.Sep_30_Day9_SpecialClasses;

import java.util.Date;

public class Util {

	public static String emailWithDateTimeStamp() {
		Date date = new Date();
		System.out.println(date);
		String emailTimeStamp = date.toString().replace(" ", "_").replace(":", "_");
		System.out.println(emailTimeStamp);
		return "seleniumpanda" + emailTimeStamp + "@gmail.com";

	}

}
