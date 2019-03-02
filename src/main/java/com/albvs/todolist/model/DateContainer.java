package com.albvs.todolist.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class DateContainer {
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	public DateContainer() {}
	public DateContainer(LocalDate date) {
		this.date = date;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
}
