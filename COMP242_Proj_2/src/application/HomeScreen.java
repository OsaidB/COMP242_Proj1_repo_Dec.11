package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextFlow;
import java.util.Objects;

public class HomeScreen extends StackPane {

	public HomeScreen() {

		this.getStylesheets().add(Objects.requireNonNull(Main.class.getResource("myCss.css")).toExternalForm());

		this.setPadding(new Insets(80, 80, 80, 80));

		this.getStyleClass().add("light-bg");

		VBox pane = new VBox();
		pane.setAlignment(Pos.CENTER);
		pane.setSpacing(30);

		HBox hButton = new HBox();
		hButton.setAlignment(Pos.CENTER);
		hButton.setSpacing(30);

		hButton.setPadding(new Insets(20, 20, 20, 120));
		Button loadBut = new Button("Load");

		Label pathLabel = new Label("");
//		text.setStyle("-fx-font-size: 10");
		pathLabel.setStyle("-fx-text-fill: black; -fx-font-size: 18; -fx-background-color : white;");
//		text.setStyle("-fx-background-color : white;");
		pathLabel.setPadding(new Insets(5, 5, 5, 5));
		pathLabel.setPrefWidth(600);
		// Button displayBut = new Button("Display");
		Button backBut = new Button("Back");
		loadBut.setPrefWidth(130);
		// displayBut.setPrefWidth(100);
		backBut.setPrefWidth(130);
		hButton.getChildren().addAll(backBut, pathLabel, loadBut);

/////////////////////////////
//Equations
		GridPane gp1 = new GridPane();
		gp1.setAlignment(Pos.CENTER);

		gp1.setVgap(15);
		gp1.setHgap(15);
		gp1.setPadding(new Insets(10));

		Label equations = new Label("Equations:  ");

		TextArea t = new TextArea(); // TextArea to display Equations
		t.setEditable(false);

		Button clearBT = new Button("Refresh");
		HBox txtAreaHB = new HBox();
		txtAreaHB.setAlignment(Pos.CENTER);
		txtAreaHB.setSpacing(30);

		t.setStyle("-fx-font-size: 2em;");///////////////////////////////////////////

		txtAreaHB.getChildren().addAll(t, clearBT);
		gp1.add(equations, 0, 2);
		gp1.add(txtAreaHB, 0, 3);
/////////////////////////////
//Files
		/* final */ GridPane gp2 = new GridPane();
		gp2.setAlignment(Pos.TOP_LEFT);

//		gp2.setVgap(15);
//		gp2.setHgap(15);
//		gp2.setPadding(new Insets(10));

		Label files = new Label("Files:  ");

//		HBox txtAreaHB2 = new HBox();
//		txtAreaHB2.setAlignment(Pos.CENTER);
//		txtAreaHB2.setSpacing(30);
//
//		txtAreaHB2.getChildren().addAll(t2, clearBT2);
		gp2.add(files, 0, 2);
//		gp2.add(txtAreaHB2, 0, 3);
/////////////////////////////

		VBox vTable = new VBox();
		vTable.setAlignment(Pos.CENTER_LEFT);
		vTable.setSpacing(30);

		Label process = new Label("Process:  ");

		Label note = new Label("");

		HBox notePros = new HBox();
		notePros.setAlignment(Pos.CENTER_LEFT);
		notePros.setSpacing(30);

		notePros.getChildren().addAll(process, note);

		Button exitButt = new Button("Exit");
		exitButt.setPrefWidth(520);

		vTable.getChildren().addAll(notePros, exitButt);
///////////////////////////////////////////////////////////

		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER_LEFT);

		gp.setVgap(15);
		gp.setHgap(15);
		gp.setPadding(new Insets(10));

		pane.getChildren().addAll(hButton, gp1, gp2, gp, vTable);
//		pane.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));

		this.getChildren().add(pane);

///////////////////////////////////////////////////////////fileChooser
		backBut.setDisable(true);
		loadBut.setOnAction(e -> {
			gp.getChildren().clear();
			try {

				boolean isFileValid = Main.fileChooser();
				pathLabel.setText(Main.path);

				if (isFileValid) {// true= file is Valid
					note.setText("Files Contents Have Been loaded And Processed Successfully.");
					note.setTextFill(Color.GREEN);

					loadBut.setDisable(true);
					backBut.setDisable(false);

					// table.setItems(getTable());
				} else {// false= file is InValid
					note.setText("Erorr: The File You Are Trying To load Is Invalid.");
					note.setTextFill(Color.RED);
				}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				loading(gp, t, pathLabel, backBut, note, loadBut);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
//		if (!Main.filesPaths.isEmpty()) {
		backBut.setOnAction((event) -> { // lambda expression
			Main.filesPaths.pop();
			if (!Main.filesPaths.isEmpty()) {
				Main.path = (String) Main.filesPaths.peek().key;/////////////

//			Main.readFile(lastPath);
//			
//			loading(gp, t, pathLabel);
//			

				try {
					gp.getChildren().clear();
					boolean isFileValid = Main.readFile(Main.path);
					pathLabel.setText(Main.path);

					if (isFileValid) {// true= file is Valid
						note.setText("Files Contents Have Been loaded And Processed Successfully.");
						note.setTextFill(Color.GREEN);

						if (Main.filesPaths.isEmpty()) {
							loadBut.setDisable(false);
						}

						// table.setItems(getTable());
					} else {// false= file is InValid
						note.setText("Erorr: The File You Are Trying To load Is Invalid.");
						note.setTextFill(Color.RED);
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					loading(gp, t, pathLabel, backBut, note, loadBut);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {// stack is empty
					// clearing everything
				loadBut.setDisable(false);
				backBut.setDisable(true);
				pathLabel.setText("");
				t.setText("");
//				process.setText("");
				note.setText("");
				gp.getChildren().clear();
			}
		});

//		} else {
//			backBut.setDisable(true);
//		}
	}

	public static void loading(GridPane gp, TextArea t, Label pathLabel, Button backBut, Label note, Button loadBut) throws Exception {
/////////////////////////////////////	equations	/////////////////////////////////////	
		String text1 = "";
		for (Equation eq : Main.equations) {

			text1 = text1 + "" + eq + "\n";
		}

		t.setText(text1);
/////////////////////////////////////	files	/////////////////////////////////////

		Hyperlink hyperFile = new Hyperlink();
		hyperFile.setStyle("-fx-font-size: 2em;");

//	final	TextFlow flow = new TextFlow(hyperFile);/////////////////
//		flow.getChildren().removeAll();

		int counter = 0;
		
		String[] files = Main.files2.split("\n");

		for (String file : files) {
			System.out.println(file);
//		}
//		
//		for (String file : Main.files) {
//			System.out.println("another \t"+file);
			
			hyperFile = new Hyperlink(file);

			TextFlow flow = new TextFlow(hyperFile);
//							flow = new TextFlow(hyperFile);
			flow.setStyle("-fx-font-size: 2em;");
//			flow.setPadding(new Insets(10));

			gp.addRow(counter, flow);
			counter++;
			hyperFile.setStyle("-fx-text-fill: #111111;");

			hyperFile.setOnAction(event -> {/////////////////////////////////////////////////////////////////////////////////////////////

				try {
					Main.filesPaths.push(file);
					Main.path = file;

					backBut.setDisable(false);
					flow.getChildren().clear();
					gp.getChildren().clear();

					boolean isFileValid = Main.readFile(file);
					pathLabel.setText(file);// we can say ( pathLabel.setText(Main.path) ) too

					if (isFileValid) {// true= file is Valid
						note.setText("Files Contents Have Been loaded And Processed Successfully.");
						note.setTextFill(Color.GREEN);

						if (Main.filesPaths.isEmpty()) {
							loadBut.setDisable(false);
						}

						// table.setItems(getTable());
					} else {// false= file is InValid
						note.setText("Erorr: The File You Are Trying To load Is Invalid.");
						note.setTextFill(Color.RED);
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					gp.getChildren().removeAll();///////
					gp.getChildren().clear();
					loading(gp, t, pathLabel, backBut, note, loadBut);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});

		}
	}

}
