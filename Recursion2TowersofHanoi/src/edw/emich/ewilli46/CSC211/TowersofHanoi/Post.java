package edw.emich.ewilli46.CSC211.TowersofHanoi;
public class Post {
	int topPost;
	String result;

	public Post(char c, int x) {
		topPost = x;

		result = "" + c;
	}

	public String toString() {
		return result;
	}
}
