package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Objects;

import DLists.*;

public class WestBankScreen extends StackPane {

	public WestBankScreen() {

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
		Button science_btn = new Button("Scientific");

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

			try {
				readLitraryFile(Main.path);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Main.stage.getScene().setRoot(new newWBScreen());
		});

		science_btn.setOnAction((event) -> { // lambda expression

			try {
				readScienceFile(Main.path);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Main.stage.getScene().setRoot(new newWBScreen());
		});

		back_btn.setOnAction((event) -> { // lambda expression
			Main.stage.getScene().setRoot(new HomeScreen());
		});

	}

	public static void readLitraryFile(String path) throws Exception {

		BufferedReader reader = new BufferedReader(new FileReader(path));
//		System.out.println(reader.readLine());

		String line;

		while ((line = reader.readLine()) != null) {
//			System.out.println(line);
			String[] student = line.split(",");

			// put data into a student object
			int seatNum = Integer.parseInt(student[0]);
			String branch = student[1];
			double avg = Double.parseDouble(student[2]);

			if (branch.replaceAll(" ", "").equalsIgnoreCase("Literary")) {
				System.out.println(line);
				Student stud = new Student(seatNum, "Literary", avg);
				Main.DB.insertStudent(stud);
			}

		}
		reader.close();

	}

	public static void readScienceFile(String path) throws Exception {

		BufferedReader reader = new BufferedReader(new FileReader(path));
//		System.out.println(reader.readLine());

		String line;

		while ((line = reader.readLine()) != null) {
//			System.out.println(line);
			String[] student = line.split(",");

			// put data into a student object
			int seatNum = Integer.parseInt(student[0]);
			String branch = student[1];
			double avg = Double.parseDouble(student[2]);

			if (branch.equalsIgnoreCase("Scientific")) {
				System.out.println(line);
				Student stud = new Student(seatNum, "Scientific", avg);
				Main.DB.insertStudent(stud);
			}

		}
		reader.close();

	}
}
