package application;
	
import javafx.application.Application;
import javafx.scene.control.ListView;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		//Right side (AddTask)
		Label labelAddTaskField = new Label("Task Name: ");
		labelAddTaskField.setFont(new Font("Arial", 15));
		labelAddTaskField.setStyle("-fx-font-weight: bold; -fx-text-fill: white");
		TextField userAddTaskField = new TextField();
		userAddTaskField.setMaxWidth(200.00);
		Button bt = new Button("Add Task");
		Button removebt = new Button("Remove Task");
		
		//Left side (Display List)
		toDo toDoList = new toDo();
		ListView lv = new ListView();
		
		//Bottom (Sort buttons)
		Label buttonsLabel = new Label("Sort by:");
		buttonsLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: white");
		Button az = new Button("A-Z");
		Button dd = new Button("Due Date");
		Button complete = new Button("Completion");
		Button category = new Button("Category");
		Button priority = new Button("Priority");

		
		//Constructing right side
		VBox vbRight = new VBox();
		vbRight.setId("rightSide");
		vbRight.setPrefWidth(300.00);
		vbRight.setPadding(new Insets(50.00, 20.00, 0, 35.00));
		vbRight.getChildren().addAll(labelAddTaskField, userAddTaskField, bt, removebt);
		
		//Constructing left side
		VBox vbCenter = new VBox();
		vbCenter.setId("center");
		vbCenter.setPadding(new Insets(50.00, 0, 0, 20.00));
		vbCenter.getChildren().addAll(lv);
		
		//Constructing bottom
		HBox hb = new HBox(80);
		hb.setId("sorting");
		hb.setPrefHeight(55.00);
		hb.setPadding(new Insets(15.00, 0, 10.00, 230.00));
		hb.getChildren().addAll(buttonsLabel, az, dd, complete, category, priority);
		
		//Constructing full BorderPane/root/scene
		BorderPane root = new BorderPane();
		root.setCenter(vbCenter);
		root.setRight(vbRight);
		root.setBottom(hb);
		Scene scene = new Scene(root,1200,800);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("To-Do List");
		primaryStage.show();
		
		//Event Handling for buttons
		bt.setOnAction(e -> {
			String text = userAddTaskField.getText();
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
			    lv.getItems().remove(index);
			}
		});
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}