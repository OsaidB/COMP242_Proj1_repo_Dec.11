package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.Objects;

public class newWBScreen extends StackPane {

	public newWBScreen() {

		this.getStylesheets().add(Objects.requireNonNull(Main.class.getResource("c_styles.css")).toExternalForm());
		this.setPadding(new Insets(40, 40, 40, 40));
		this.getStyleClass().add("light-bg");
		this.setAlignment(Pos.CENTER);

////////////////////////////////////////////////
		// create a menu
		Menu menu = new Menu("Menu");

		// create menuitems
		MenuItem add = new MenuItem("Add");
		MenuItem delete = new MenuItem("Delete");
		MenuItem update = new MenuItem("Update");
		MenuItem search = new MenuItem("Search");
		// add menu items to menu
		menu.getItems().add(add);
		menu.getItems().add(delete);
		menu.getItems().add(update);
		menu.getItems().add(search);

		// create a menubar
		MenuBar mb = new MenuBar();
		mb.setMaxWidth(150);
		// add menu to menubar
		mb.getMenus().add(menu);

		mb.getStyleClass().add("menu");

		// create a VBox
		VBox vb = new VBox(mb);
		vb.setAlignment(Pos.CENTER);
////////////////////////////////////////////////	

//?*?*?*/?*?8?8/8//88?/*?**/8*?*/8*//8*/?*?*?/*?*?8?8/8//88?*?**/8*/?*/8*//8*/
		add.setOnAction((event) -> { // lambda expression
			Main.stage.getScene().setRoot(new WB_Form("Add"));
		});
		delete.setOnAction((event) -> { // lambda expression
			Main.stage.getScene().setRoot(new WB_Form("Delete"));
		});
		search.setOnAction((event) -> { // lambda expression
			Main.stage.getScene().setRoot(new WB_Form("Search"));
		});
		update.setOnAction((event) -> { // lambda expression
			Main.stage.getScene().setRoot(new WB_Form("Update"));
		});
//?*?*?*/?*?8?8/8//88?/*?**/8*?*/8*//8*/?*?*?/*?*?8?8/8//88?*?**/8*/?*/8*//8*/

		VBox all = new VBox();
		all.setAlignment(Pos.CENTER);
		all.setSpacing(30);
		all.setPadding(new Insets(40));

		HBox main = new HBox();
		main.setAlignment(Pos.CENTER);
		main.setSpacing(30);

		VBox btns_pane = new VBox(40);
		btns_pane.setAlignment(Pos.CENTER);

		btns_pane.setMinWidth(BASELINE_OFFSET_SAME_AS_HEIGHT);

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
		Button del_btn = new Button("  Delete  ", del_img);
		Button search_btn = new Button("Search", search_img);
		Button update_btn = new Button("Update", search_img);

		Button mode_btn = new Button("Seats AVL's Height", search_img);
//		mode_btn.setMinWidth(300);
		mode_btn.setMinWidth(btns_pane.getPrefWidth());
		Button mean_btn = new Button("Grades AVL's Height", search_img);

		Button printData_btn = new Button("Print Data", list_img);
		Button aboveGrada_btn = new Button("Students Got A Given Grade", list_img);

		add_btn.getStyleClass().add("btn");
		del_btn.getStyleClass().add("btn");
		printData_btn.getStyleClass().add("btn");
		aboveGrada_btn.getStyleClass().add("btn");
		search_btn.getStyleClass().add("btn");
		update_btn.getStyleClass().add("btn");

		mode_btn.getStyleClass().add("btn");
		mean_btn.getStyleClass().add("btn");
		search_btn.getStyleClass().add("dark-bg");
		update_btn.getStyleClass().add("dark-bg");

		btns_pane.getChildren().add(add_btn);
		btns_pane.getChildren().add(del_btn);
		btns_pane.getChildren().add(mode_btn);
		btns_pane.getChildren().add(mean_btn);
		btns_pane.getChildren().add(printData_btn);
		btns_pane.getChildren().add(aboveGrada_btn);

		btns_pane.getChildren().add(update_btn);
		btns_pane.getChildren().add(search_btn);

		Button back_btn = new Button("Back");
		back_btn.getStyleClass().add("back-button");
//		VBox.setVgrow(back_btn, Priority.ALWAYS);

		VBox.setVgrow(add_btn, Priority.ALWAYS);
		VBox.setVgrow(del_btn, Priority.ALWAYS);
		VBox.setVgrow(printData_btn, Priority.ALWAYS);
		VBox.setVgrow(aboveGrada_btn, Priority.ALWAYS);

		VBox.setVgrow(update_btn, Priority.ALWAYS);
		VBox.setVgrow(search_btn, Priority.ALWAYS);
		VBox.setVgrow(mode_btn, Priority.ALWAYS);

		VBox.setVgrow(mean_btn, Priority.ALWAYS);

//		all.getChildren().add(back_btn);

		all.getChildren().add(vb);
		all.getChildren().add(back_btn);
//		main.getChildren().add(back_btn);

		main.getChildren().add(btns_pane);

		all.getChildren().add(main);

		this.getChildren().add(all);

		this.getStyleClass().add("light-bg");
//////////////////////////////////setOnAction//////////////////////////////////
		back_btn.setOnAction((event) -> { // lambda expression
			Main.DB.resetAll();

			Main.stage.getScene().setRoot(new WestBankScreen());
		});
		add_btn.setOnAction((event) -> { // lambda expression
			Main.stage.getScene().setRoot(new WB_Form("Add"));
		});
		del_btn.setOnAction((event) -> { // lambda expression
			Main.stage.getScene().setRoot(new WB_Form("Delete"));
		});
		search_btn.setOnAction((event) -> { // lambda expression
			Main.stage.getScene().setRoot(new WB_Form("Search"));
		});
		update_btn.setOnAction((event) -> { // lambda expression
			Main.stage.getScene().setRoot(new WB_Form("Update"));
		});

		printData_btn.setOnAction((event) -> { // lambda expression

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

			Button Linked_btn = new Button("  LinkedList  ");
			Linked_btn.getStyleClass().add("btn");

			Button gradesT_btn = new Button("  Grades AVL  ");
			gradesT_btn.getStyleClass().add("btn");

			Button seatsT_btn = new Button("   Seats AVL   ");
			seatsT_btn.getStyleClass().add("btn");

			g.add(Linked_btn, 0, 0);
			g.add(gradesT_btn, 0, 1);
			g.add(seatsT_btn, 0, 2);

			Linked_btn.setOnAction((event2) -> { // lambda expression
				Stage st2 = new Stage();

				Scene root_scene2 = null;

//				String wbAboveGrada = Main.sWB.wbFindAbove(Double.parseDouble(grade_tf.getText()));////////////////////////////////////////
//				String students=Main.DB.allStudentsGot(Double.parseDouble(grade_tf.getText()));

//				if (students == "null") {
//					status.setText("There are no students with this Grade.");
//					status.getStyleClass().remove("success-label");
//					status.getStyleClass().add("warning-label");
//					return;
//				}

				String Linked = Main.DB.allStudentsDList.toString();

				ProcessResultsScreen pr = new ProcessResultsScreen(Linked);
				root_scene2 = new Scene(pr);

				ScrollPane scrollPane = new ScrollPane();

				scrollPane.setContent(pr);

				scrollPane.setPrefSize(470, 850);
				scrollPane.setMaxSize(500, 900);

				root_scene2 = new Scene(scrollPane);

				this.setAlignment(Pos.CENTER);

				st2.setTitle("LinkedList Content:");
				st2.setScene(root_scene2);
				st2.setMaxHeight(900);
				st2.setMaxWidth(500);
				st2.show();
			});

			gradesT_btn.setOnAction((event2) -> { // lambda expression
				Stage st2 = new Stage();

				Scene root_scene2 = null;

//				String gradesT = Main.DB.gradesT.toString();
//				Main.DB.gradesT.print();

				String gradesT = Main.DB.gradesT.newPrint();
				ProcessResultsScreen pr = new ProcessResultsScreen(gradesT);
				root_scene2 = new Scene(pr);

				ScrollPane scrollPane = new ScrollPane();

				scrollPane.setContent(pr);

				scrollPane.setPrefSize(1500, 700);

//				scrollPane.setMaxSize(500, 900);

				root_scene2 = new Scene(scrollPane);

				st2.setTitle("Grades Tree:");
				st2.setScene(root_scene2);

				st2.show();
			});

			seatsT_btn.setOnAction((event2) -> { // lambda expression
				Stage st2 = new Stage();

				Scene root_scene2 = null;

//				String gradesT = Main.DB.gradesT.toString();
//				Main.DB.gradesT.print();

				String seatsT = Main.DB.seatsT.newPrint();

				StackPane s = new StackPane();

				s.getStylesheets().add(Objects.requireNonNull(this.getClass().getResource("c_form_styles.css")).toExternalForm());

				s.setPadding(new Insets(30, 43, 30, 57));

//				s.setHeight(900);
				Label res_lbl = new Label(seatsT);
				res_lbl.setFont(new Font(200));

				res_lbl.setAlignment(Pos.CENTER);
				s.setAlignment(Pos.CENTER);

				s.getChildren().add(res_lbl);

//				ProcessResultsScreen pr = new ProcessResultsScreen(seatsT);

				root_scene2 = new Scene(s);

				ScrollPane scrollPane = new ScrollPane();

				scrollPane.setContent(s);

				scrollPane.setPrefSize(1500, 700);
//				scrollPane.setMaxSize(500, 900);

				root_scene2 = new Scene(scrollPane);

				st2.setTitle("Seats_Based Tree:");
				st2.setScene(root_scene2);

				st2.show();
			});

//			g.add(grade_tf, 1, 1);

			m.getChildren().add(g);

			sp.getChildren().add(m);
			sp.getStyleClass().add("light-bg");

			root_scene = new Scene(sp);

			st.setTitle("Students that got the grade you gave:");
			st.setScene(root_scene);
			st.setMinHeight(100);
			st.setMinWidth(300);

			st.show();

			//
//			Stage st = new Stage();
//
//			Scene root_scene = null;
//
////			DLinkedList<W_B_Tawjihi> wbTop10 = Main.sWB.wbDisplayTopTen();////////////////////////////////////////
////
////			top10Screen ls = new top10Screen(wbTop10);
////			root_scene = new Scene(ls);
//
//			ScrollPane scrollPane = new ScrollPane();
//
////			scrollPane.setContent(ls);
//
//			root_scene = new Scene(scrollPane);
//			
//			st.setTitle("All Top 10 Students Info");
//			st.setScene(root_scene);
//			st.setMinHeight(100);
//			st.setMinWidth(300);
//			st.show();

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

			Label grade = new Label("The Grade:");
			Label status = new Label("Waiting Submission");

			g.add(grade, 0, 1);
			g.add(status, 1, 2);

			TextField grade_tf = new TextField();

			Button enter_btn = new Button("  Enter  ");
			enter_btn.getStyleClass().add("btn");

			g.add(enter_btn, 1, 3);

			enter_btn.setOnAction((event2) -> { // lambda expression
				Stage st2 = new Stage();

				Scene root_scene2 = null;

//				String wbAboveGrada = Main.sWB.wbFindAbove(Double.parseDouble(grade_tf.getText()));////////////////////////////////////////
				String students = Main.DB.allStudentsGot(Double.parseDouble(grade_tf.getText()));

				if (students == "null") {
					status.setText("There are no students with this Grade.");
					status.getStyleClass().remove("success-label");
					status.getStyleClass().add("warning-label");
					return;
				}

				ProcessResultsScreen pr = new ProcessResultsScreen(students);
				root_scene2 = new Scene(pr);

				st.setTitle("Enter Grade:");
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

			st.setTitle("Students that got the grade you gave:");
			st.setScene(root_scene);
			st.setMinHeight(100);
			st.setMinWidth(300);
			st.show();
		});
		mode_btn.setOnAction((event) -> { // lambda expression

			Stage st = new Stage();

			Scene root_scene = null;

			int height = Main.DB.seatsT.height();

			String g = height + "";
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

			int height = Main.DB.gradesT.height();

			String g = height + "";
			ProcessResultsScreen pr = new ProcessResultsScreen(g);
			root_scene = new Scene(pr);

			st.setTitle("The Mode");
			st.setScene(root_scene);
			st.setMinHeight(100);
			st.setMinWidth(300);
			st.show();
		});

	}
}
