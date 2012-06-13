package edw.emich.ewilli46.CSC211.TowersofHanoi;

public class Post {
	int topDisc;
	int discs[] = new int[4];
	String name;
	
	public Post(String c) {
		name = c;
		topDisc = 0;
	}
//Method in Post to add disk(int) from discs[]
	//creates a stack and updates where the top is in the array
	public void addDisc(int x) {

		discs[topDisc] = x;
		if (discs.length > topDisc - 1)
			topDisc++;
		else
			return;
	}
//Method in post to remove a disk(int) from discs[]
	//Updates the stack
	public int removeDisc() {
		if (discs.length != 0)
			topDisc--;
		return discs[topDisc];
	}
//Debugging tool
	public String Show() {
		String out = "";
		for (int i = 0; i < topDisc; i++) {
			out += discs[i];
		}

		return out;

	}
	public String toString(){
		return name;
	}
}
