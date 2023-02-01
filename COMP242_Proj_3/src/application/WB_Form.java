package application;

import java.util.Objects;

import DLists.DNode;
import DLists.Student;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WB_Form extends StackPane {

	public WB_Form(String Operation) {
		/*
		 * Operation could be:
		 * 
		 * 1-Add Literary 2-Add
		 * 
		 * 3-Delete Literary 4-Delete
		 * 
		 * 5-Search Literary 6-Search
		 * 
		 */

		this.getStylesheets().add(Objects.requireNonNull(this.getClass().getResource("c_form_styles.css")).toExternalForm());
		this.setPadding(new Insets(40, 40, 40, 40));
		this.getStyleClass().add("light-bg");

		VBox all = new VBox();
		all.setAlignment(Pos.CENTER);

		HBox main = new HBox();
		main.setAlignment(Pos.CENTER);
		main.setSpacing(30);

		GridPane grid = new GridPane();
		grid.setHgap(150);
		grid.setVgap(40);
		grid.setAlignment(Pos.CENTER);
		grid.getStyleClass().add("grid-pane");

		////////////////////////// important//////////////////////////
//		Text form_title = new Text(Operation + " WestBank Form");
		//////////////////////////////////////////////////////////////

//		form_title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

//		grid.add(form_title, 0, 0, 2, 1);

		Label seatNumber = new Label("Seat Number:");
		grid.add(seatNumber, 0, 1);

		TextField seatNumber_tf = new TextField();

		grid.add(seatNumber_tf, 1, 1);
		////////////////////////////// Submission ////////////////////////////

		Label st_lbl = new Label("Status");
		Label status = new Label("Waiting Submission");

		grid.add(st_lbl, 0, 7);
		grid.add(status, 1, 7);

		Button submit = new Button(Operation);

		if (Operation.equals("Update")) {
			submit.setText("Enter New Data");

		}

		submit.getStyleClass().add("small_btn");

		////////////////////////////// Operations ////////////////////////////
		////////////////////////////// Operations ////////////////////////////
		////////////////////////////// Operations ////////////////////////////
		submit.setOnAction((event) -> { // lambda expression

			switch (Operation) {
			/*
			 * 
			 * *
			 * 
			 * Deleteing
			 * 
			 * *
			 * 
			 */

			case "Delete" -> {
				if (seatNumber_tf.getText().length() < 1) {
					status.setText("Enter a valid Seat Number");
					status.getStyleClass().remove("success-label");
					status.getStyleClass().add("warning-label");
					return;
				}
//				boolean b = Main.sWB.deleteWBSorted(Integer.parseInt(seatNumber_tf.getText()));

				// public boolean deleteStudent(int seatNumber) {
				boolean b = Main.DB.deleteStudent(Integer.parseInt(seatNumber_tf.getText()));

				if (b == false) {
					status.setText("Student Not Found!");
					status.getStyleClass().remove("success-label");
					status.getStyleClass().add("warning-label");
					return;
				}
				status.setText("deleted successfully");
				status.getStyleClass().remove("warning-label");
				status.getStyleClass().add("success-label");
			}
			/*
			 * 
			 * *
			 * 
			 * Searching
			 * 
			 * *
			 * 
			 */

			case "Search" -> {
				if (seatNumber_tf.getText().length() < 1) {
					status.setText("Enter a valid Seat Number");
					status.getStyleClass().remove("success-label");
					status.getStyleClass().add("warning-label");
					return;
				}

//				W_B_Tawjihi m = Main.sWB.searchWBList(Integer.parseInt(seatNumber_tf.getText()));

				// public DNode findStudent(int seatNumber)
				DNode node = Main.DB.findStudent(Integer.parseInt(seatNumber_tf.getText()));

				if (node == null) {
					status.setText("Student Not Found!");
					status.getStyleClass().remove("success-label");
					status.getStyleClass().add("warning-label");
					return;
				}

				Stage st = new Stage();

				Scene root_scene = null;

				String g = node.data + "";
				ProcessResultsScreen pr = new ProcessResultsScreen(g);
				root_scene = new Scene(pr);

				st.setScene(root_scene);
				st.setMinHeight(100);
				st.setMinWidth(300);
				st.show();

				status.setText("Student Found Successfully");
				status.getStyleClass().remove("warning-label");
				status.getStyleClass().add("success-label");
			}
			case "Update" -> {

				if (seatNumber_tf.getText().length() < 1) {
					status.setText("Enter a valid Seat Number");
					status.getStyleClass().remove("success-label");
					status.getStyleClass().add("warning-label");
					return;
				}

//				W_B_Tawjihi m = Main.sWB.searchWBList(Integer.parseInt(seatNumber_tf.getText()));

				// public DNode findStudent(int seatNumber)
				DNode node = Main.DB.findStudent(Integer.parseInt(seatNumber_tf.getText()));

				if (node == null) {
					status.setText("Student Not Found!");
					status.getStyleClass().remove("success-label");
					status.getStyleClass().add("warning-label");
					return;
				}

				Stage st = new Stage();

				Scene root_scene = null;

				String g = node.data + "";
				ProcessResultsScreen pr = new ProcessResultsScreen(g);
				root_scene = new Scene(pr);

				st.setScene(root_scene);
				st.setMinHeight(100);
				st.setMinWidth(300);
				st.show();

				status.setText("Student Found Successfully");
				status.getStyleClass().remove("warning-label");
				status.getStyleClass().add("success-label");
			}
			}

		});
//////////////////////////////////////////////////////////////////////////
		/*
		 * Adding (special condition):
		 */
		if (Operation.equals("Add")) {
			// Adding average button{
			Label studentAvg = new Label("Student Average:");
			Label branchL = new Label("Branch:");

			grid.add(branchL, 0, 3);
			grid.add(studentAvg, 0, 4);

			TextField studentAvg_tf = new TextField();
			TextField branch_tf = new TextField();

			seatNumber_tf.textProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					if (!newValue.matches("\\d*")) {
						seatNumber_tf.setText(newValue.replaceAll("[^\\d]", ""));
					}
				}
			});

			grid.add(branch_tf, 1, 3);
			grid.add(studentAvg_tf, 1, 4);

			Pane spring = new Pane();
			spring.minHeightProperty().bind(studentAvg_tf.heightProperty());
			Pane spring2 = new Pane();
			spring2.minHeightProperty().bind(studentAvg_tf.heightProperty());

			grid.add(spring2, 0, 5);
			grid.add(spring, 0, 6);
			// Adding average button}
			submit.setOnAction((event) -> { // lambda expression

				if (seatNumber_tf.getText().length() < 1) {
					status.setText("Enter a valid Seat Number");
					status.getStyleClass().remove("success-label");
					status.getStyleClass().add("warning-label");
					return;
				}

				if (branch_tf.getText().length() < 1 || !branch_tf.getText().replaceAll(" ", "").equals("Literary")) {

					if (branch_tf.getText().replaceAll(" ", "").equals("Scientific")) {

					} else {
						status.setText("Enter a valid Branch");
						status.getStyleClass().remove("success-label");
						status.getStyleClass().add("warning-label");
						return;
					}

				}

				if (studentAvg_tf.getText().length() < 1) {
					status.setText("Enter a valid Average");
					status.getStyleClass().remove("success-label");
					status.getStyleClass().add("warning-label");
					return;
				}

				try {

//					W_B_Tawjihi stud = new W_B_Tawjihi(Integer.parseInt(seatNumber_tf.getText()), "Literary", Double.parseDouble(studentAvg_tf.getText()));
//					Main.sWB.insertWBSorrted(stud);

					Student stud = new Student(Integer.parseInt(seatNumber_tf.getText()), branch_tf.getText().replaceAll(" ", ""), Double.parseDouble(studentAvg_tf.getText()));
					Main.DB.insertStudent(stud);

					status.setText("Added Successfully");
					status.getStyleClass().remove("warning-label");
					status.getStyleClass().add("success-label");
				} catch (Exception e) {
					status.setText(e.getMessage());
					status.getStyleClass().remove("success-label");
					status.getStyleClass().add("warning-label");
				}

			});
		}

		grid.add(submit, 1, 8);

		/////////////////////////////////////////////////////////////////////////////

		Button back_btn = new Button("Back");
		back_btn.getStyleClass().add("back-button");

		all.getChildren().add(back_btn);

		main.getChildren().add(grid);

		all.getChildren().add(main);

		back_btn.setOnAction((event) -> { // lambda expression

			Main.stage.getScene().setRoot(new newWBScreen());

		});

		this.getChildren().add(all);

		this.getStyleClass().add("light-bg");
	}
}
