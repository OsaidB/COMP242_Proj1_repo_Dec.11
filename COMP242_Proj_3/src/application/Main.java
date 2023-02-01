package application;

import java.io.File;
import DB.*;
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.Scene;

public class Main extends Application {

//	static DLinkedList<W_B_Tawjihi> lWB = new DLinkedList<>(); // Literary WestBank
//	static DLinkedList<W_B_Tawjihi> sWB = new DLinkedList<>(); // Science WestBank
//	
	static TawjihiDS DB = new TawjihiDS();
	
	static String path="";
	static Stage stage;

	@Override
	public void start(Stage stage) throws Exception {
		Main.stage = stage;

//		readWBFile();
		HomeScreen main = new HomeScreen();

		Scene root_scene = new Scene(main);

		stage.setTitle("Tawjihi Systems - Osaid baba - 1203115");
		stage.setScene(root_scene);
		stage.setMaximized(true);
		
//		stage.setHeight(100);
//		stage.setWidth(700);
//		
////		stage.setMaxHeight(100);
////		stage.setMaxWidth(40);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}


//	public static void readWBFile() throws Exception {
//		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\97059\\git\\COMP242_Proj1_repo_Dec.11\\COMP242_Proj_Dec_11\\src\\application\\WestBank.txt"));
////		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\OAB2K\\git\\COMP242_Proj1_repo_Dec.11\\COMP242_Proj_Dec_11\\src\\application\\WestBank.txt"));
////		System.out.println(reader.readLine());
//		String line;
//
//		while ((line = reader.readLine()) != null) {
////			System.out.println(line);
//			String[] student = line.split(",");
//
//			// put data into a tawjihi object
//			int seatNum = Integer.parseInt(student[0]);
//			String branch = student[1];
//			double avg = Double.parseDouble(student[2]);
//
//			W_B_Tawjihi stud = new W_B_Tawjihi(seatNum, branch, avg);
//
//			if (branch.equalsIgnoreCase("Literary")) {
//				lWB.insertWBSorrted(stud);
//			} else {
//				sWB.insertWBSorrted(stud);
//			}
//
//		}
//		reader.close();
//
//	}
	
	public static void fileChooser() throws Exception {// false= file is invalid

		FileChooser fc1 = new FileChooser();
		fc1.getExtensionFilters().addAll(new ExtensionFilter("Text File", "*txt"));
		File file1 = fc1.showOpenDialog(stage);
		fc1.setTitle("Choose DB Path");
//		System.out.println(file1);

//////////////////////////////////////////////////////////////////////////////////filechooser done

		String path = file1.getPath();
		
		Main.path=path;
//		return readFile(path);
	}
	
}
