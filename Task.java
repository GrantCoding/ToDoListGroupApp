package application;

import java.util.Date;

public class Task {
	
	//Private data fields
	private String title;
	private boolean status;
	private Date dueDate;
	private String category;
	private int priority;
	
	//Accessor methods
	public String getTitle() {
		return title;
	}
	public boolean getStatus() {
		return status;
	}
	public Date getdueDate() {
		return dueDate;
	}
	public String getCategory() {
		return category;
	}
	public int getPriority() {
		return priority;
	}
	
	//Mutator methods
	public void setTitle(String title) {
		this.title = title;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setDueDate(Date newDate) {
		this.dueDate = newDate;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setPriority(int priority) {
		this.priority = priority;
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
		this.dueDate = new Date();
		this.category = "Default";
		this.priority = 1;
	}
	public Task(String title) {
		this.title = title;
		this.status = false;
		this.dueDate = new Date();
		this.category = "Default";
		this.priority = 1;
	}
	public Task(String title, boolean status, Date dueDate) {
		this.title = title;
		this.status = status;
		this.dueDate = dueDate;
		this.category = "Default";
		this.priority = 1;
	}
	public Task(String title, boolean status, Date dueDate, String category) {
		this.title = title;
		this.status = status;
		this.dueDate = dueDate;
		this.category = category;
		this.priority = 1;
	}
	public Task(String title, boolean status, Date dueDate, int priority) {
		this.title = title;
		this.status = status;
		this.dueDate = dueDate;
		this.category = "Default";
		this.priority = priority;
	}
	
}