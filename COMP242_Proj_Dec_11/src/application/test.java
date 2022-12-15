package application;

public class test {

	public static void main(String[] args) throws Exception {
//		
		DLinkedList<GazaTawjihi> dList =new DLinkedList<>();
//		
//		dList.insertLast(55);
//		dList.insertLast(60);
//
//		
//		System.out.println(dList);
//		
//		readGazaFile();
		Main.readGazaFile();
		Main.readWBFile();

		// System.out.println(Main.lWB);
		// System.out.println(Main.sWB);
//		 System.out.println(Main.lGaza);
//		System.out.println(Main.sGaza);

//		Main.sGaza.displayTopTen();
		
//		System.out.println(Main.sGaza.gazaMean());
//		System.out.println(Main.lGaza.gazaMean());
//		System.out.println(Main.sWB.wbMean());
//		System.out.println(Main.lWB.wbMean());
		/////////////////////////
		
//		System.out.println(Main.sGaza.modeGaza()+"\n");
//		System.out.println(Main.lGaza.modeGaza()+"\n");
//		
//		System.out.println(Main.sWB.modeWB()+"\n");
//		System.out.println(Main.lWB.modeWB()+"\n");
		
//============================================================
//		dList=Main.lGaza.gazaDisplayTopTen();
//		System.out.println(dList);

		System.out.println("\n\n");
		Main.lGaza.gazaFindAbove(99.4);
//============================================================
		
	}

}
