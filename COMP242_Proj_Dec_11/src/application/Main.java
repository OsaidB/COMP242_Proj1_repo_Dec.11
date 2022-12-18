package application;

import java.io.BufferedReader;
import java.io.FileReader;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application {

//	DLinkedList<GazaTawjihi> gTaw = new DLinkedList<>();
//	DLinkedList<W_B_Tawjihi> wbTaw = new DLinkedList<>();
	static DLinkedList<GazaTawjihi> lGaza = new DLinkedList<>(); // Literary Gaza
	static DLinkedList<GazaTawjihi> sGaza = new DLinkedList<>(); // Science Gaza
	static DLinkedList<W_B_Tawjihi> lWB = new DLinkedList<>(); // Literary WestBank
	static DLinkedList<W_B_Tawjihi> sWB = new DLinkedList<>(); // Science WestBank

	static Stage stage;

	@Override
	public void start(Stage stage) throws Exception {
		Main.stage = stage;

		readGazaFile();
		readWBFile();
		HomeScreen main = new HomeScreen();

		Scene root_scene = new Scene(main);

		stage.setTitle("Tawjihi Systems - Osaid baba - 1203115");
		stage.setScene(root_scene);
		stage.setMaximized(true);
		stage.setMinHeight(1000);
		stage.setMinWidth(1000);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static void readGazaFile() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(
				"C:\\Users\\97059\\git\\COMP242_Proj1_repo_Dec.11\\COMP242_Proj_Dec_11\\src\\application\\Gaza.txt"));
//		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\OAB2K\\eclipse-workspaces\\Osa-_-2022oct\\COMP242_Proj1\\src\\application\\Gaza.txt"));
//		System.out.println(reader.readLine());
		String line;

		while ((line = reader.readLine()) != null) {
//			System.out.println(line);
			String[] student = line.split(",");

			// put data into a tawjihi object
			int seatNum = Integer.parseInt(student[0]);
			String branch = student[1];
			double avg = Double.parseDouble(student[2]);

			GazaTawjihi stud = new GazaTawjihi(seatNum, branch, avg);

			if (branch.equalsIgnoreCase("Literary")) {
				lGaza.insertGazaSorrted(stud);
			} else {
				sGaza.insertGazaSorrted(stud);
			}

		}
		reader.close();

	}

	public static void readWBFile() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(
				"C:\\Users\\97059\\git\\COMP242_Proj1_repo_Dec.11\\COMP242_Proj_Dec_11\\src\\application\\WestBank.txt"));
//		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\OAB2K\\eclipse-workspaces\\Osa-_-2022oct\\COMP242_Proj1\\src\\application\\WestBank.txt"));
//		System.out.println(reader.readLine());
		String line;

		while ((line = reader.readLine()) != null) {
//			System.out.println(line);
			String[] student = line.split(",");

			// put data into a tawjihi object
			int seatNum = Integer.parseInt(student[0]);
			String branch = student[1];
			double avg = Double.parseDouble(student[2]);

			W_B_Tawjihi stud = new W_B_Tawjihi(seatNum, branch, avg);

			if (branch.equalsIgnoreCase("Literary")) {
				lWB.insertWBSorrted(stud);
			} else {
				sWB.insertWBSorrted(stud);
			}

		}
		reader.close();

	}
}
