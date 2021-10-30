package java_todo;

public class Task {
	// task variables
	private String id;
	private String title;
	private boolean status;
	private String projectName;
	
	private int day;
	private int month;
	private int year;
	private String dueDate;
	
	// task methods
	//		get methods
	public String getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public boolean getStatus() {
		return status;
	}
	public String getProjectName() {
		return projectName;
	}
	public String getdueDate() {
		return dueDate;
	}
	
	//		set methods
	public void setId(String id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public void setYear(int year) {
		this.year = year;
	}
	// sets dueDate to "mm/dd/yr"
	public void setDueDate(int month, int day, int year) {
		this.dueDate = month + "/" + day + "/" + year;
	}
	
	// task constructor
	public static Task buildTask(String id, String title, boolean status, String projectName, int day, int month, int year) {
		Task task = new Task();
		
		task.setId(id);
		task.setTitle(title);
		task.setStatus(status);
		task.setProjectName(projectName);
		
		task.setMonth(month);
		task.setDay(day);
		task.setYear(year);
		task.setDueDate(month, day, year);
		
		
		return task;
	}
	
}
