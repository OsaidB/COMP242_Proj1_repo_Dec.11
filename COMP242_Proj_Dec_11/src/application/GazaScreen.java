package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import java.util.Objects;

public class GazaScreen extends StackPane {

	public GazaScreen() {

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

		Button literary_btn = new Button("Literary");
		Button science_btn = new Button("Science");
		
		Button back_btn = new Button("Back");
		back_btn.getStyleClass().add("back-button");
		
		literary_btn.getStyleClass().add("btn");
		science_btn.getStyleClass().add("btn");

		btns_pane.getChildren().add(back_btn);

		btns_pane.getChildren().add(literary_btn);
		btns_pane.getChildren().add(science_btn);
		btns_pane.getChildren().add(transparent_pane);

		HBox.setHgrow(literary_btn, Priority.ALWAYS);
		HBox.setHgrow(science_btn, Priority.ALWAYS);

		main.getChildren().add(illustration);
		main.getChildren().add(btns_pane);

		this.getChildren().add(main);

		this.getStyleClass().add("light-bg");

		literary_btn.setOnAction((event) -> { // lambda expression
			Main.stage.getScene().setRoot(new L_GazaScreen());
		});

		science_btn.setOnAction((event) -> { // lambda expression
			Main.stage.getScene().setRoot(new S_GazaScreen());
		});

		back_btn.setOnAction((event) -> { // lambda expression
			Main.stage.getScene().setRoot(new HomeScreen());
		});

	}
}
