package com.capgemini.opencsv;

public class CSVBuilderFactory {
	public static ICSVBuilder createCSVBuilder() {
		return new OpenCSVBuilder();
	}
}
