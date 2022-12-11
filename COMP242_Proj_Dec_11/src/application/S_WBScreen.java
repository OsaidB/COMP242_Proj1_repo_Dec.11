package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.Objects;

public class S_WBScreen extends StackPane {

	public S_WBScreen() {

		this.getStylesheets().add(Objects.requireNonNull(Main.class.getResource("c_styles.css")).toExternalForm());

		this.setPadding(new Insets(40, 40, 40, 40));

		this.getStyleClass().add("light-bg");

		VBox all = new VBox();
		all.setAlignment(Pos.CENTER);

		HBox main = new HBox();
		main.setAlignment(Pos.CENTER);
		main.setSpacing(30);

		VBox btns_pane = new VBox(40);
		btns_pane.setAlignment(Pos.CENTER);

		btns_pane.setPrefSize(300, 700);
		btns_pane.setMaxSize(300, 700);

		Image add_img_png = new Image(Objects.requireNonNull(HomeScreen.class.getResourceAsStream("add.png")));
		ImageView add_img = new ImageView(add_img_png);
		add_img.setFitHeight(40);
		add_img.setPreserveRatio(true);

		Image del_img_png = new Image(Objects.requireNonNull(HomeScreen.class.getResourceAsStream("delete.png")));
		ImageView del_img = new ImageView(del_img_png);
		del_img.setFitHeight(40);
		del_img.setPreserveRatio(true);

		Image search_img_png = new Image(Objects.requireNonNull(HomeScreen.class.getResourceAsStream("search.png")));
		ImageView search_img = new ImageView(search_img_png);
		search_img.setFitHeight(40);
		search_img.setPreserveRatio(true);

		Image list_img_png = new Image(Objects.requireNonNull(HomeScreen.class.getResourceAsStream("list.png")));
		ImageView list_img = new ImageView(list_img_png);
		list_img.setFitHeight(40);
		list_img.setPreserveRatio(true);

		Pane transparent_pane = new Pane();
		transparent_pane.getStyleClass().add("transparent_pane");

		Button add_btn = new Button("  Add   ", add_img);
		Button del_btn = new Button("  Delete", del_img);
		Button list_btn = new Button("  List  ", list_img);
		Button search_btn = new Button("  Search", search_img);

		add_btn.getStyleClass().add("btn");
		del_btn.getStyleClass().add("btn");
		list_btn.getStyleClass().add("btn");
		search_btn.getStyleClass().add("btn");

		search_btn.getStyleClass().add("dark-bg");

		btns_pane.getChildren().add(add_btn);
		btns_pane.getChildren().add(del_btn);
		btns_pane.getChildren().add(transparent_pane);
		btns_pane.getChildren().add(list_btn);
		btns_pane.getChildren().add(search_btn);

		VBox.setVgrow(add_btn, Priority.ALWAYS);
		VBox.setVgrow(del_btn, Priority.ALWAYS);
		VBox.setVgrow(list_btn, Priority.ALWAYS);
		VBox.setVgrow(search_btn, Priority.ALWAYS);

		Button back_btn = new Button("Back");
		back_btn.getStyleClass().add("back-button");

		all.getChildren().add(back_btn);

		main.getChildren().add(btns_pane);

		all.getChildren().add(main);

		back_btn.setOnAction((event) -> { // lambda expression
			Main.stage.getScene().setRoot(new WestBankScreen());
		});

		this.getChildren().add(all);

		this.getStyleClass().add("light-bg");

		add_btn.setOnAction((event) -> { // lambda expression
			Main.stage.getScene().setRoot(new S_WBForm("Add"));
		});
		del_btn.setOnAction((event) -> { // lambda expression
//			Main.stage.getScene().setRoot(new MediaForm("Delete"));
			Main.stage.getScene().setRoot(new S_WBForm("Delete"));
		});
		list_btn.setOnAction((event) -> { // lambda expression

			Stage st = new Stage();

//			ArrayList<Media> media = Main.sys.getAllMedia();

			Scene root_scene = null;

			st.setTitle("All Media Info");
			st.setScene(root_scene);
			st.setMinHeight(100);
			st.setMinWidth(300);
			st.show();

		});
		search_btn.setOnAction((event) -> { // lambda expression
			Main.stage.getScene().setRoot(new S_WBForm("Search"));
		});

	}
}
