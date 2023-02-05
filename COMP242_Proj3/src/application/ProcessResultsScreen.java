package application;

import java.util.Objects;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class ProcessResultsScreen extends StackPane {

	public ProcessResultsScreen(String results) {

		this.getStylesheets().add(Objects.requireNonNull(this.getClass().getResource("c_form_styles.css")).toExternalForm());

		this.setPadding(new Insets(30,43,30,57));

		this.setHeight(900);
		Label res_lbl = new Label(results);

		res_lbl.setAlignment(Pos.CENTER);
		this.setAlignment(Pos.CENTER);

		
		this.getChildren().add(res_lbl);

	}

}
