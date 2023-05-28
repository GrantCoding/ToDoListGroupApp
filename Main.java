package application;
	
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.collections.*;
import java.time.*;
import java.time.format.DateTimeFormatter;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		//Right side (AddTask)
		Label labelAddTask = new Label("Enter Task Name: ");
		labelAddTask.setFont(new Font("Arial", 15));
		labelAddTask.setStyle("-fx-font-weight: bold; -fx-text-fill: white");
		TextField userAddTaskField = new TextField();
		userAddTaskField.setMaxWidth(200.00);
		Button addbt = new Button("Add Task");
		//Due Date
		Label labelDueDate = new Label("Enter DueDate");
		labelDueDate.setFont(new Font("Arial", 15));
		labelDueDate.setStyle("-fx-font-weight: bold; -fx-text-fill: white");
		TextField dueDateField = new TextField();
		dueDateField.setText("mm/dd/yyyy");
		Button duebt = new Button("Set Due Date");
		//Category
		Label labelCategory = new Label("Enter Task Category");
		labelCategory.setFont(new Font("Arial", 15));
		labelCategory.setStyle("-fx-font-weight: bold; -fx-text-fill: white");
		TextField categField = new TextField();
		Button categbt = new Button("Set Task Category");
		//description button / remove task button / save file
		Button descbt = new Button("Save Task Description");
		Button removebt = new Button("Remove Task");
		Button savebt = new Button("Save File");
		
		//Left side (Display List)
		toDo toDoList = new toDo();
		ListView lv = new ListView();
		lv.setItems(FXCollections.observableArrayList(toDoList.tasks));
		lv.setMaxWidth(200);
		lv.setPrefHeight(600);
		lv.setMaxHeight(650);
		Label listOfTasks = new Label("List of Tasks: ");
		listOfTasks.setFont(new Font("Arial", 15));
		listOfTasks.setStyle("-fx-font-weight: bold; -fx-text-fill: white");
		Button loadbt = new Button("Load File");
		
		//Bottom (Sort buttons)
		Label buttonsLabel = new Label("Sort by:");
		buttonsLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: white");
		Button az = new Button("A-Z");
		Button dd = new Button("Due Date");
		Button complete = new Button("Completion");
		Button category = new Button("Category");

		//Constructing right side
		VBox vbRight = new VBox();
		VBox vbRight1 = new VBox();
		vbRight1.setSpacing(5);
		VBox vbRight2 = new VBox();
		vbRight2.setSpacing(5);
		vbRight1.getChildren().addAll(labelAddTask, userAddTaskField, addbt);
		vbRight2.getChildren().addAll(labelDueDate, dueDateField, duebt, labelCategory, categField, categbt, descbt);
		vbRight.setId("rightSide");
		vbRight.setPrefWidth(300.00);
		vbRight.setSpacing(375);
		vbRight.setPadding(new Insets(50.00, 20.00, 0, 35.00));
		vbRight.getChildren().addAll(vbRight1, vbRight2);
		
		//Constructing left side
		VBox vbLeft = new VBox(7);
		vbLeft.setId("leftSide");
		vbLeft.setPadding(new Insets(50.00, 0, 0, 20.00));
		vbLeft.getChildren().addAll(listOfTasks, lv, removebt);
		
		
		//Constructing the center of pane that contains the details of the task
		VBox vbCenter = new VBox();
		vbCenter.setId("center");
		vbCenter.setPadding(new Insets(50, 20, 0 ,35));
		vbCenter.setSpacing(50);
		HBox centerHB1 = new HBox();
		HBox centerHB2 = new HBox();
		HBox centerHB3 = new HBox();
		
		
		Label taskNameLabel = new Label("Task Name: ");
		taskNameLabel.setFont(new Font("Arial", 15));
		taskNameLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: white");
		taskNameLabel.setPrefWidth(90);
		taskNameLabel.setAlignment(Pos.CENTER_LEFT);
		Label taskNameText = new Label();
		taskNameText.setFont(new Font("Arial", 15));
		taskNameText.setStyle("-fx-font-weight: bold; -fx-text-fill: white");
		taskNameText.setPrefWidth(200);
		Label dueDateLabel = new Label("Due Date: ");
		dueDateLabel.setFont(new Font("Arial", 15));
		dueDateLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: white");
		Label dueDateText = new Label();
		dueDateText.setFont(new Font("Arial", 15));
		dueDateText.setStyle("-fx-font-weight: bold; -fx-text-fill: white");
		
		Label taskDescLabel = new Label("Task Description");
		taskDescLabel.setFont(new Font("Arial", 15));
		taskDescLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: white");
		taskDescLabel.setPrefWidth(289);
		TextArea taskDescriptionText = new TextArea();
		taskDescriptionText.setPrefHeight(200);
		taskDescriptionText.setPrefWidth(400);
		Label categLabel = new Label("Category: ");
		categLabel.setFont(new Font("Arial", 15));
		categLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: white");
		Label categText = new Label();
		categText.setFont(new Font("Arial", 15));
		categText.setStyle("-fx-font-weight: bold; -fx-text-fill: white");
		CheckBox completeBox = new CheckBox("Task Completed");
		completeBox.setTextFill(Color.WHITE);
		
		
		centerHB1.getChildren().addAll(taskNameLabel, taskNameText, dueDateLabel, dueDateText);
		centerHB2.getChildren().addAll(taskDescLabel, categLabel, categText);
		centerHB3.getChildren().addAll(taskDescriptionText);
		vbCenter.getChildren().addAll(centerHB1, centerHB2, centerHB3, completeBox);
		
		//Constructing bottom
		HBox hb = new HBox(80);
		hb.setId("sorting");
		hb.setPrefHeight(55.00);
		hb.setPadding(new Insets(15.00, 0, 10.00, 230.00));
		hb.getChildren().addAll(buttonsLabel, az, dd, complete, category);
		
		//Constructing full BorderPane/root/scene
		BorderPane root = new BorderPane();
		root.setCenter(vbCenter);
		root.setLeft(vbLeft);
		root.setRight(vbRight);
		root.setBottom(hb);
		Scene scene = new Scene(root,1200,800);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("To-Do List");
		primaryStage.show();
		
		//Event Handling for buttons (add button)
		addbt.setOnAction(e -> {
			String text = userAddTaskField.getText();
			userAddTaskField.clear();
			int i = toDoList.getNumOfTasks();
			if(text != "") {
				toDoList.addTask(new Task(text));
				lv.getItems().add(toDoList.getTask(i).toString());
			}
		}
		);
		//Event Handing for remove Button
		removebt.setOnAction(e -> {
			int index = lv.getSelectionModel().getSelectedIndex();
			if (index >= 0) {
				Task temp = toDoList.getTask(index);
			    lv.getItems().remove(index);
			    toDoList.removeTask(temp);
			}
		});
		//Event for adding a due date
		duebt.setOnAction(e -> {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate text = LocalDate.parse(dueDateField.getText(), formatter);
			int i = lv.getSelectionModel().getSelectedIndex();
			toDoList.getTask(i).setDueDate(text);
			dueDateText.setText(toDoList.getTask(i).getdueDate().toString());
			dueDateField.setText("mm/dd/yyyy");
		});
		//Event for saving the task description
		descbt.setOnAction(e -> {
			String text = taskDescriptionText.getText();
			int i = lv.getSelectionModel().getSelectedIndex();
			toDoList.getTask(i).setDesc(text);
		}); 
		//Event for saving the task category
		categbt.setOnAction(e -> {
			String text = categField.getText();
			int i = lv.getSelectionModel().getSelectedIndex();
			toDoList.getTask(i).setCategory(text);
			categText.setText(toDoList.getTask(i).getCategory());
			categField.clear();
		});
		//Event for marking task as completed
		completeBox.setOnAction(e -> {
			int i = lv.getSelectionModel().getSelectedIndex();
			toDoList.getTask(i).setStatus(completeBox.isSelected());
		});
		//Event for sorting
		// by title
		az.setOnAction(e -> {
			toDoList.sortByTitle();
			lv.getItems().clear();
			for(int i=0; i<toDoList.getNumOfTasks(); i++) {
				lv.getItems().add(toDoList.getTask(i).toString());
			}
		});
		// by date
		dd.setOnAction(e -> {
			toDoList.sortByDueDate();
			lv.getItems().clear();
			for(int i=0; i<toDoList.getNumOfTasks(); i++) {
				lv.getItems().add(toDoList.getTask(i).toString());
			}
		});
		// by completion
		complete.setOnAction(e -> {
			toDoList.sortByStatus();
			lv.getItems().clear();
			for(int i=0; i<toDoList.getNumOfTasks(); i++) {
				lv.getItems().add(toDoList.getTask(i).toString());
			}
		});
		// by Category
		category.setOnAction(e -> {
			toDoList.sortByCategory();
			lv.getItems().clear();
			for(int i=0; i<toDoList.getNumOfTasks(); i++) {
				lv.getItems().add(toDoList.getTask(i).toString());
			}
		});
		//descbt.setOnAction(null)
		//Event for center pane when clicking on a task
		lv.setOnMouseClicked(e -> {
			int i = lv.getSelectionModel().getSelectedIndex();
			taskNameText.setText(toDoList.getTask(i).toString());
			dueDateText.setText(toDoList.getTask(i).getdueDate().toString());
			categText.setText(toDoList.getTask(i).getCategory());
			taskDescriptionText.setText(toDoList.getTask(i).getDesc());
			completeBox.setSelected(toDoList.getTask(i).getStatus());
		});
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
