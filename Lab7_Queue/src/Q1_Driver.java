import java.util.Random;
import java.util.Scanner;

public class Q1_Driver {

	public static void main(String args[]) {

		Queue customerQ = new Queue();

		Random rand = new Random(System.currentTimeMillis());

		System.out.print("Length of simulation (in minutes):");
		Scanner scan = new Scanner(System.in);
		int timeLength = scan.nextInt();

		int customer;
		int totalServed = 0;
		int timeWaited;
		int totalWait = 0;
		int longestWait = 0;
		for (int currMinute = 0; currMinute < timeLength; currMinute++) {

			if (!customerQ.isEmpty()) {
				customer = customerQ.dequeue();
				totalServed++;

				timeWaited = currMinute - customer;
				totalWait = totalWait + timeWaited;

				if (timeWaited > longestWait) {
					longestWait = timeWaited;
				}
			}

			int random = rand.nextInt(4);
			if (random == 1) {
				System.out.println("Add One Customer To The Line.\n");
				customerQ.enqueue(currMinute);
			} else if (random == 2) {
				System.out.println("Add Two Customers To The Line.\n");
				customerQ.enqueue(currMinute);
				customerQ.enqueue(currMinute);
			} else {
				System.out.println("##\tDont Add Any Customer To The Line.\t##");
			}

		}
		System.out.println("\n\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("\nTime In Minutes: " + timeLength);
		System.out.println("Total Number Of Customers Served: " + totalServed);
		System.out.println("Longest Wait: " + longestWait);

		double avg = totalWait / totalServed;
		System.out.println("Average Wait: " + avg);

		scan.close();
	}

}
