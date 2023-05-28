package application;

import java.time.*;

public class Task {
	
	//Private data fields
	private String title;
	private boolean status;
	private LocalDate dueDate;
	private String category;
	private String desc;
	
	//Accessor methods
	public String getTitle() {
		return title;
	}
	public boolean getStatus() {
		return status;
	}
	public LocalDate getdueDate() {
		return dueDate;
	}
	public String getCategory() {
		return category;
	}
	public String getDesc() {
		return desc;
	}
	
	//Mutator methods
	public void setTitle(String title) {
		this.title = title;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setDueDate(LocalDate newDate) {
		this.dueDate = newDate;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	//.equals()
	public boolean equals(Task t) {
		return (this.title==t.title && this.dueDate==t.dueDate);
	}
	
	//toString
	@Override
	public String toString() {
		return title;
	}
	
	//Constructors
	public Task() {
		this.title = "Unnamed Task";
		this.status = false;
		this.dueDate = LocalDate.now();
		this.category = "Default";
		this.desc = "";
	}
	public Task(String title) {
		this.title = title;
		this.status = false;
		this.dueDate = LocalDate.now();
		this.category = "Default";
		this.desc = "";
	}
	public Task(String title, boolean status, LocalDate dueDate) {
		this.title = title;
		this.status = status;
		this.dueDate = dueDate;
		this.category = "Default";
		this.desc = "";
	}
	public Task(String title, boolean status, LocalDate dueDate, String category) {
		this.title = title;
		this.status = status;
		this.dueDate = dueDate;
		this.category = category;
		this.desc = "";
	}
}