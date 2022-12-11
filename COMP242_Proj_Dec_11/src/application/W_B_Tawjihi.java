package application;

public class W_B_Tawjihi {


	private int seatNumber;
	private String branch;
	private double avg;

	public W_B_Tawjihi(int seatNumber, String branch, double avg) {
		this.seatNumber = seatNumber;
		this.branch = branch;
		this.avg = avg;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	@Override
	public String toString() {
		return "WestBank Tawjihi [" + seatNumber + "," + branch + "," + avg + "]";
	}

}