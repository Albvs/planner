package com.albvs.todolist;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class TestClass {

	public static void main(String[] args) {
		
		LocalDateTime time = LocalDateTime.of(2018, Month.APRIL, 20, 6, 15);
		
		// System.out.println(time.format(DateTimeFormatter.ofPattern("HH:mm")));
		
		System.out.println(time);
		
		int newYear = 2019;
		int newMonth = 5;
		int newDay = 21;
		int newHour = 16;
		int newMinute = 20;
		
		time = time.withYear(newYear).withMonth(newMonth).withDayOfMonth(newDay).withHour(newHour).withMinute(newMinute);
		
		System.out.println(time);
		
		
	}

}
