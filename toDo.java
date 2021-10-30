package java_todo;
import java.util.*;

//Rough draft/outline of the list class. I used Lance's Task class outline for the Task methods since I haven't implemented them. I figure we can add more methods
//and other changes as we improve on it and especially when we get to GUI and events in class. I picked an ArrayList for the container since it works like a vector in C++
//and holds objects (which could be Task objects for us). We can definitely change it to a different container if there is one that anyone thinks works better
//for our project.
public class toDo extends Task {

	public static void main (String[] args) {
		System.out.println("Please pick one of the following options:");
		System.out.println("-".repeat(30));
		System.out.println("1 --- Create New Task");
		System.out.println("2 --- Remove Task");
		System.out.println("3 --- Edit Task");
		System.out.println("4 --- Mark Task Complete");
		System.out.println("5 --- Print Tasks");
		System.out.println("6 --- Sort Tasks by Due Date");
		System.out.println("7 --- Sort Tasks by Title");
		System.out.println("8 --- Sort Tasks by Status");
		System.out.println("9 --- Sort Tasks by Category");
		System.out.println("10 --- Sort Tasks by Priority");
		System.out.println("-".repeat(30));
		
		Scanner userInput = new Scanner(System.in);
		int userInt = userInput.nextInt();

		//Task to send to functions
		//		Task value = new Task();
		switch (userInt) {
		case 1:
//			addTask();
			break;
		case 2:
//			RemoveTask()
			break;
		case 3:
//			editTask()
			break;
		case 4:
//			completeTask();
			break;
		case 5:
//			printTasks();
			break;
		case 6:
//			sortByDueDate();
			break;
		case 7:
//			sortByTitle();
			break;
		case 8:
//			sortByStatus();
			break;
		case 9:
//			sortByCategory();
			break;
		case 10:
//			sortByPriority();
			break;
		}
		
	}
	
	private static ArrayList<Task> tasks;
	
	public toDo() {
		tasks = new ArrayList<Task>();
		Task demoTask = new Task();
		this.addTask(demoTask);
	}
	public void addTask(Task t) {
		boolean duplicate = false;
		for (Task ele : tasks) {
			if (ele.equals(t)) {
				duplicate = true;
			}
		}
		if(!duplicate) {
			tasks.add(t);
		}
	}
	
	public void completeTask(Task t) {
		for (Task ele : tasks) {
			if(ele.equals(t)) { //For this to work, we should override the "public boolean equals(Task tk)" method of the Task class so that it checks for 
								//matching private data vars
				ele.setStatus(false);
			}
		}
	}
	
	public void removeTask(Task t) {
		for (Task ele : tasks) {
			if(ele.equals(t)) {
				tasks.remove(ele);
			}
		}
	}
	
	public void editTask(Task t, String id, boolean status, String projName, String dueDate, int day, int month, int year) {
		for (Task ele : tasks) {
			if(ele.equals(t)) {
				ele.setId(id);
				ele.setStatus(status);
				ele.setProjectName(projName);
				//ele.setDueDate(day, month, year);
				ele.setDay(day);
				ele.setMonth(month);
				ele.setYear(year);
			}
		}
	}
	
	public void printTasks() {
		for (Task t : tasks) {
			System.out.println(t); //Need to override toString of the Task class to print the title of the task
		}
	}
	
	public void sortByDueDate() {
	}
	
	public void sortByTitle() {
	}
	
	public void sortByStatus() {
	}
	
	public void sortByCategory(){
	}
	
	public void sortByPriority(){
		
	}
//	@Override
//	public String toString() {
//		for(Task t : tasks) {
//			System.out.printf("%s%s - %s", t.getStatus() ? "Checked " : "", t.getTitle(), t.getdueDate()); //Prints that the task is checked off if 
//																							//the task's status is true, otherwise prints nothing
//		}
//	} 
	}