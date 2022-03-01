package de.kleeraphie.lib.storage;

import java.awt.Color;
import java.time.LocalDate;

public class Section {
	
	private String name;
	private Color color;
	private LocalDate startDate, endDate;
	
	public Section(String name, Color color, LocalDate startDate, LocalDate endDate) {
		this.name = name;
		this.color = color;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	@Override
	public String toString() {
		// TODO: store life as r, g & b values instead of java color component
		return "Section[name=" + name + ", color=" + color + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

}
