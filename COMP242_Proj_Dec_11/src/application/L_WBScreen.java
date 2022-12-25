package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.Objects;

public class L_WBScreen extends StackPane {

	public L_WBScreen() {

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

		Button add_btn = new Button("   Add   ", add_img);
		Button del_btn = new Button("Delete", del_img);
		Button search_btn = new Button("Search", search_img);
		Button mode_btn = new Button("Mode", search_img);
		Button mean_btn = new Button("Mean", search_img);

		Button top10_btn = new Button("Display Top 10 Students", list_img);
		Button aboveGrada_btn = new Button("Students That Are Above A Given Grade", list_img);

		add_btn.getStyleClass().add("btn");
		del_btn.getStyleClass().add("btn");
		top10_btn.getStyleClass().add("btn");
		aboveGrada_btn.getStyleClass().add("btn");
		search_btn.getStyleClass().add("btn");
		mode_btn.getStyleClass().add("btn");
		mean_btn.getStyleClass().add("btn");
		search_btn.getStyleClass().add("dark-bg");

		btns_pane.getChildren().add(add_btn);
		btns_pane.getChildren().add(del_btn);
		btns_pane.getChildren().add(mode_btn);
		btns_pane.getChildren().add(mean_btn);
		btns_pane.getChildren().add(top10_btn);
		btns_pane.getChildren().add(aboveGrada_btn);
		btns_pane.getChildren().add(search_btn);

		VBox.setVgrow(add_btn, Priority.ALWAYS);
		VBox.setVgrow(del_btn, Priority.ALWAYS);
		VBox.setVgrow(top10_btn, Priority.ALWAYS);
		VBox.setVgrow(aboveGrada_btn, Priority.ALWAYS);
		VBox.setVgrow(search_btn, Priority.ALWAYS);
		VBox.setVgrow(mode_btn, Priority.ALWAYS);
		VBox.setVgrow(mean_btn, Priority.ALWAYS);

		Button back_btn = new Button("Back");
		back_btn.getStyleClass().add("back-button");
		
		all.getChildren().add(back_btn);

		main.getChildren().add(btns_pane);
		
		all.getChildren().add(main);

		this.getChildren().add(all);

		this.getStyleClass().add("light-bg");
//////////////////////////////////setOnAction//////////////////////////////////
		back_btn.setOnAction((event) -> { // lambda expression
			Main.stage.getScene().setRoot(new WestBankScreen());
		});
		add_btn.setOnAction((event) -> { // lambda expression
			Main.stage.getScene().setRoot(new WB_Form("Add Literary"));
		});
		del_btn.setOnAction((event) -> { // lambda expression
			Main.stage.getScene().setRoot(new WB_Form("Delete Literary"));
		});
		search_btn.setOnAction((event) -> { // lambda expression
			Main.stage.getScene().setRoot(new WB_Form("Search Literary"));
		});
		top10_btn.setOnAction((event) -> { // lambda expression

			Stage st = new Stage();

			Scene root_scene = null;

			DLinkedList<W_B_Tawjihi> wbTop10 = Main.lWB.wbDisplayTopTen();////////////////////////////////////////

			top10Screen ls = new top10Screen(wbTop10);
//			root_scene = new Scene(ls);

			ScrollPane scrollPane = new ScrollPane();

			scrollPane.setContent(ls);

			root_scene = new Scene(scrollPane);
			
			st.setTitle("All Top 10 Students Info");
			st.setScene(root_scene);
			st.setMinHeight(100);
			st.setMinWidth(300);
			st.show();

		});
		aboveGrada_btn.setOnAction((event) -> { // lambda expression

			Stage st = new Stage();

			Scene root_scene = null;

			StackPane sp = new StackPane();

			sp.setPadding(new Insets(40, 40, 40, 40));

			sp.getStyleClass().add("light-bg");

			HBox m = new HBox();
			m.setAlignment(Pos.CENTER);
			m.setSpacing(30);

			GridPane g = new GridPane();
			g.setHgap(150);
			g.setVgap(40);
			g.setAlignment(Pos.CENTER);
			g.getStyleClass().add("grid-pane");

			Label grade = new Label("The Specific Grade:");
			g.add(grade, 0, 1);

			TextField grade_tf = new TextField();

			Button enter_btn = new Button("  Enter  ");
			enter_btn.getStyleClass().add("btn");

			g.add(enter_btn, 1, 2);

			enter_btn.setOnAction((event2) -> { // lambda expression
				Stage st2 = new Stage();

				Scene root_scene2 = null;

				String wbAboveGrada = Main.lWB.wbFindAbove(Double.parseDouble(grade_tf.getText()));////////////////////////////////////////

				ProcessResultsScreen pr = new ProcessResultsScreen(wbAboveGrada);
				root_scene2 = new Scene(pr);

				st.setTitle("The Number And The Percentage Of Students That Are Above A Given Grade");
				st2.setScene(root_scene2);
				st2.setMinHeight(100);
				st2.setMinWidth(300);
				st2.show();
			});

			g.add(grade_tf, 1, 1);

			m.getChildren().add(g);

			sp.getChildren().add(m);
			sp.getStyleClass().add("light-bg");

			root_scene = new Scene(sp);

			st.setTitle("The Number And The Percentage Of Students That Are Above A Given Grade");
			st.setScene(root_scene);
			st.setMinHeight(100);
			st.setMinWidth(300);
			st.show();
		});
		mode_btn.setOnAction((event) -> { // lambda expression

			Stage st = new Stage();

			Scene root_scene = null;

			double mode = Main.lWB.modeWB();////////////////////////////////////////
			String g = mode + "";
			ProcessResultsScreen pr = new ProcessResultsScreen(g);
			root_scene = new Scene(pr);

			st.setTitle("The Mode");
			st.setScene(root_scene);
			st.setMinHeight(100);
			st.setMinWidth(300);
			st.show();

		});
		mean_btn.setOnAction((event) -> { // lambda expression

			Stage st = new Stage();

			Scene root_scene = null;

			double mode = Main.lWB.wbMean();////////////////////////////////////////
			String g = mode + "";
			ProcessResultsScreen pr = new ProcessResultsScreen(g);
			root_scene = new Scene(pr);

			st.setTitle("The Mean");
			st.setScene(root_scene);
			st.setMinHeight(100);
			st.setMinWidth(300);
			st.show();

		});

	}
}
