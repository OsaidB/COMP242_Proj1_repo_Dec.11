package application;

import java.util.Objects;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class ProcessResultsScreen extends StackPane {

	public ProcessResultsScreen(String results) {

		this.getStylesheets().add(Objects.requireNonNull(this.getClass().getResource("c_form_styles.css")).toExternalForm());

		this.setPadding(new Insets(60));

		Label res_lbl = new Label(results);

		this.getChildren().add(res_lbl);

	}

}
