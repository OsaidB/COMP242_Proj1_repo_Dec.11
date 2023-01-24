package application;

import base.cStack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application {

	static cStack<String> filesPaths = new cStack<>();

	static String path = "";
	static Stage stage;
	static String files2 = "";
	static ArrayList<Equation> equations = new ArrayList<Equation>();

	@Override
	public void start(Stage stage) throws Exception {
		Main.stage = stage;

		HomeScreen main = new HomeScreen();

		Scene root_scene = new Scene(main);

		String css = this.getClass().getResource("myCss.css").toExternalForm();
		root_scene.getStylesheets().add(css);

		stage.setTitle("Equations Application - Osaid baba - 1203115");
		stage.setScene(root_scene);
		stage.setMaximized(false);
		stage.setMinHeight(700);
		stage.setMinWidth(700);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static boolean fileChooser() throws Exception {// false= file is invalid

		FileChooser fc1 = new FileChooser();
		fc1.getExtensionFilters().addAll(new ExtensionFilter("Text File", "*242"));
		File file1 = fc1.showOpenDialog(stage);
		fc1.setTitle("Choose Path for Flight List");
//		System.out.println(file1);

//////////////////////////////////////////////////////////////////////////////////filechooser done

		String path = file1.getPath();
		Main.filesPaths.push(path);

		return readFile(path);
	}

	public static boolean arePair(String openTag, String closeTag) {

		if (openTag.equals("<242>") && closeTag.equals("</242>")) {
			return true;
		} else if (openTag.equals("<files>") && closeTag.equals("</files>")) {
			return true;
		} else if (openTag.equals("<file>") && closeTag.equals("</file>")) {
			return true;
		} else if (openTag.equals("<equations>") && closeTag.equals("</equations>")) {
			return true;
		} else if (openTag.equals("<equation>") && closeTag.equals("</equation>")) {
			return true;
		}

		return false;

	}

	public static boolean readFile(String path) throws Exception {
		Main.path = path;

		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line1;

		boolean isValidFile = true;

		ArrayList<String> allLines = new ArrayList<String>();

		while ((line1 = reader.readLine()) != null) {

			allLines.add(line1.replaceAll("\\s", ""));

		} // now "allLines" is an arraylist full of lines readed from the file

		cStack<String> stack = new cStack<>(allLines.size());//

		equations.clear();
//		files.clear();
		files2 = "";
		String lineToEdit = "";

		for (String oneLine : allLines) {
//			System.out.println(oneLine);
			if (oneLine.contains("<equation>") && oneLine.contains("</equation>")) {
				lineToEdit = oneLine;
				lineToEdit = lineToEdit.replaceAll("\\<[^>]*>", "");

				Equation n = new Equation(lineToEdit);
				equations.add(n);
			}
			if (oneLine.contains("<file>") && oneLine.contains("</file>")) {
				lineToEdit = oneLine;
				lineToEdit = lineToEdit.replaceAll("\\<[^>]*>", "");

//				files.add(lineToEdit);
				files2 = files2 + "\n" + lineToEdit;
			}

			String[] line = oneLine.split("\\s+");

			for (String word : line) {
//				System.out.println(word);///////////////////////////////////////////

				if (word.contains("<242>")) {
					if (!word.contains("</242>")) {
						stack.push("<242>");
					}

				} else if (word.contains("<files>")) {
					if (!word.contains("</files>")) {
						stack.push("<files>");
					}

				} else if (word.contains("<file>")) {
					if (!word.contains("</file>")) {
						stack.push("<file>");
					}

				} else if (word.contains("<equations>")) {
					if (!word.contains("</equations>")) {
						stack.push("<equations>");
					}

				} else if (word.contains("<equation>")) {
					if (!word.contains("</equation>")) {
						stack.push("<equation>");
					}
//////////////////////////////////////////////////////////////////////////////////
				} else if (word.contains("</242>")) {

					if (stack.isEmpty()/* في عندي تسكيرة! بس الستاك فاضي! ف فش اشي نعمله بوب اصلا! ف انفاليد */ || !arePair(stack.peek().toString(), "</242>")) {
						System.out.println(stack.peek().toString());
						isValidFile = false;

					} else {
						stack.pop();
					}

				} else if (word.contains("</files>")) {

					if (stack.isEmpty() || !arePair(stack.peek().toString(), "</files>")) {
						isValidFile = false;
					} else {
						stack.pop();
					}

				} else if (word.contains("</file>")) {

					if (stack.isEmpty() || !arePair(stack.peek().toString(), "</file>")) {
						isValidFile = false;
					} else {
						stack.pop();
					}

				} else if (word.contains("</equations>")) {

					if (stack.isEmpty() || !arePair(stack.peek().toString(), "</equations>")) {
						isValidFile = false;
					} else {
						stack.pop();
					}

				} else if (word.contains("</equation>")) {

					if (stack.isEmpty() || !arePair(stack.peek().toString(), "</equation>")) {
						isValidFile = false;
					} else {
						stack.pop();
					}

				}

			}

		}
		reader.close();

//		System.out.println(stack);

		return isValidFile;
	}

}