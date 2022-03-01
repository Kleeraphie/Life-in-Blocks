package de.kleeraphie.lib.storage;

import java.time.LocalDate;

public class Life {
	
	private int age;
	private String title;
	private LocalDate birthDate;
	private Section[] sections;
	
	public Life(int age, String title, LocalDate birthDate, Section[] sections) {
		this.age = age;
		this.title = title;
		this.birthDate = birthDate;
		this.sections = sections;
	}
	
	public Section getSectionByDate(LocalDate date) {
		
		for (Section s : sections) {
			if ((date.isAfter(s.getStartDate()) && date.isBefore(s.getEndDate())) || (date.isEqual(s.getStartDate()) && date.isEqual(s.getEndDate())))
				return s;
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder strB = new StringBuilder();
		
		strB.append("Life[");
		
		strB.append("age=");
		strB.append(age);
		strB.append(", ");
		
		strB.append("title=");
		strB.append(title);
		strB.append(", ");
		
		strB.append("birthDate=");
		strB.append(birthDate);
		strB.append(", ");
		
		strB.append("sections=[");
		for (Section s : sections) {
			strB.append(s.toString());
			strB.append(", ");
		}
		strB.delete(strB.length() - 3, strB.length() - 1);
		strB.append("]");
		
		strB.append("]");
		
		return strB.toString();
	}

}
