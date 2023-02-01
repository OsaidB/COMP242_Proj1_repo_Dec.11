package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.Objects;

public class HomeScreen extends StackPane {

	public HomeScreen() {

		this.getStylesheets().add(Objects.requireNonNull(Main.class.getResource("home_styles.css")).toExternalForm());

		this.setPadding(new Insets(80, 80, 80, 80));

		this.getStyleClass().add("light-bg");

		VBox main = new VBox();
		main.setAlignment(Pos.CENTER);
		main.setSpacing(30);

		Image illustration_svg = new Image(Objects.requireNonNull(HomeScreen.class.getResourceAsStream("kyo-azuma-x_TJKVU1FJA-unsplash.jpg")));
		ImageView illustration = new ImageView(illustration_svg);

		illustration.setPreserveRatio(true);

		illustration.fitHeightProperty().bind(main.heightProperty().divide(5).multiply(4));

		HBox btns_pane = new HBox(80);

		btns_pane.setPrefHeight(94);
		btns_pane.minWidth(600);
		btns_pane.setAlignment(Pos.CENTER);
		btns_pane.prefWidthProperty().bind(main.widthProperty().divide(3).multiply(2));
		btns_pane.maxWidthProperty().bind(main.widthProperty());

		Pane transparent_pane = new Pane();
		transparent_pane.getStyleClass().add("transparent_pane");

		Button load = new Button("Load DB");

		load.getStyleClass().add("btn");

		btns_pane.getChildren().add(load);
		btns_pane.getChildren().add(transparent_pane);

		HBox.setHgrow(load, Priority.ALWAYS);

		main.getChildren().add(illustration);
		main.getChildren().add(btns_pane);

		this.getChildren().add(main);

		this.getStyleClass().add("light-bg");

		load.setOnAction((event) -> { // lambda expression
			
			
			try {
				Main.fileChooser();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			
			
			
			
			Main.stage.getScene().setRoot(new WestBankScreen());
		});


	}
	
}
