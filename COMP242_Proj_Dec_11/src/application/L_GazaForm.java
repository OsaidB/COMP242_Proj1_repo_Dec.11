package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Objects;

public class L_GazaForm extends StackPane {

	public L_GazaForm(String Operation) {

		this.getStylesheets()
				.add(Objects.requireNonNull(this.getClass().getResource("c_form_styles.css")).toExternalForm());

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

		Text form_title = new Text(Operation + " Literary Gaza Form");

		form_title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

		grid.add(form_title, 0, 0, 2, 1);

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
		submit.getStyleClass().add("small_btn");

		/////////////////////////////////////////////////////////////////////////////
		if (Operation.equals("Add")) {

			Label studentAvg = new Label("Student Average:");
			grid.add(studentAvg, 0, 3);

			TextField studentAvg_tf = new TextField();

			studentAvg_tf.textProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					if (!newValue.matches("\\d*")) {
						studentAvg_tf.setText(newValue.replaceAll("[^\\d]", ""));
					}
				}
			});

			grid.add(studentAvg_tf, 1, 3);

			Pane spring = new Pane();
			spring.minHeightProperty().bind(studentAvg_tf.heightProperty());
			Pane spring2 = new Pane();
			spring2.minHeightProperty().bind(studentAvg_tf.heightProperty());

			grid.add(spring2, 0, 5);
			grid.add(spring, 0, 6);

			submit.setOnAction((event) -> { // lambda expression

				if (seatNumber_tf.getText().length() < 1) {
					status.setText("Enter a valid Seat Number");
					status.getStyleClass().remove("success-label");
					status.getStyleClass().add("warning-label");
					return;
				}

				if (studentAvg_tf.getText().length() < 1) {
					status.setText("Enter a valid Average");
					status.getStyleClass().remove("success-label");
					status.getStyleClass().add("warning-label");
					return;
				}

				try {

					GazaTawjihi stud = new GazaTawjihi(Integer.parseInt(seatNumber_tf.getText()), "Literary",
							Double.parseDouble(studentAvg_tf.getText()));
					Main.lGaza.insertGazaSorrted(stud);

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

		/////////////////////////////////////////////////////////////////////////////

		submit.setOnAction((event) -> { // lambda expression

			switch (Operation) {

			case "Delete" -> {
				if (seatNumber_tf.getText().length() < 1) {
					status.setText("Enter a valid Seat Number");
					status.getStyleClass().remove("success-label");
					status.getStyleClass().add("warning-label");
					return;
				}
				Main.lGaza.deleteGazaSorted(Integer.parseInt(seatNumber_tf.getText()));

				status.setText("deleted successfully");
				status.getStyleClass().remove("warning-label");
				status.getStyleClass().add("success-label");
			}

			case "Search" -> {
				if (seatNumber_tf.getText().length() < 1) {
					status.setText("Enter a valid Seat Number");
					status.getStyleClass().remove("success-label");
					status.getStyleClass().add("warning-label");
					return;
				}
				GazaTawjihi m = Main.lGaza.searchGazaList(Integer.parseInt(seatNumber_tf.getText()));

				if (m == null) {
					status.setText("Name Not Found! OR you are trying to search in an empty list!");
					status.getStyleClass().remove("success-label");
					status.getStyleClass().add("warning-label");
					return;
				}


				Stage st = new Stage();

				Scene root_scene = null;

				String g = m + "";
				ProcessResultsScreen pr = new ProcessResultsScreen(g);
				root_scene = new Scene(pr);

				st.setScene(root_scene);
				st.setMinHeight(100);
				st.setMinWidth(300);
				st.show();
				
				
				
				status.setText("Found stident");
				status.getStyleClass().remove("warning-label");
				status.getStyleClass().add("success-label");
			}

			}

		});

		grid.add(submit, 1, 8);

		/////////////////////////////////////////////////////////////////////////////

		Button back_btn = new Button("Back");
		back_btn.getStyleClass().add("back-button");

		all.getChildren().add(back_btn);

		main.getChildren().add(grid);

		all.getChildren().add(main);

		back_btn.setOnAction((event) -> { // lambda expression
			Main.stage.getScene().setRoot(new L_GazaScreen());
		});

		this.getChildren().add(all);

		this.getStyleClass().add("light-bg");
	}
}
