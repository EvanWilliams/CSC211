package edw.emich.ewilli46.CSC211.TowersofHanoi;

public class Disc {
	public String OnPost;
	private int number;
	

	public Disc(int x) {
		number = x;
	}

	public String getOnPost() {
		return OnPost;
	}

	public void setOnPost(String onPost) {
		OnPost = onPost;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String toString() {

		return "" + number;
	}
}
