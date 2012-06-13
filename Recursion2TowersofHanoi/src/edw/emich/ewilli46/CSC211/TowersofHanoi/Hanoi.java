package edw.emich.ewilli46.CSC211.TowersofHanoi;

public class Hanoi {
	boolean HasMoved = false;
	Disc temp = new Disc(0);
	int NumDisks = 4;
	int NumPosts = 3;
	String ToPost;

	public String getToPost() {
		return ToPost;
	}

	public void setToPost(String toPost) {
		ToPost = toPost;
	}

	public String getFromPost() {
		return FromPost;
	}

	public String PrintBoard(int numDisks, String fromPost, String toPost) {
		MoveTower(top, source, dest, spare);
		return ("complete");
	}

	/**
	 * Printing out the details of the move
	 * 
	 * @param d
	 *            -this.Disc
	 * @param From
	 *            - the From Post
	 * @param To
	 *            - the To Post
	 */
	public void Print(Disc d, Post From, Post To) {
		System.out.println("Move " + d.getNumber() + " From " + From.toString()
				+ " To " + To.toString());
	}

	public void MoveTower(Disc d, Post Scource, Post Dest, Post Spare) {
		
		if (top.OnPost != ToPost && second.OnPost != ToPost
				&& third.OnPost != ToPost && bot.OnPost != ToPost) {
			if (d.getNumber() == 1) {
				if (d.OnPost == Spare.toString()) {
					d.OnPost = Dest.toString();
					HasMoved = true;
					Dest.topPost = 1;
					Print(d, Spare, Dest);
				}
			} else if (d.OnPost == Dest.toString()) {
				d.OnPost = Scource.toString();
				HasMoved = true;
				Scource.topPost = 1;
				Print(d, Dest, Scource);
			}

			else if (d.OnPost == Scource.toString()) {
				d.OnPost = Spare.toString();
				HasMoved = true;
				Spare.topPost = 1;
				Print(d, Scource, Spare);
			}

			// else if (d.number != 1) {
			// if (Spare.topPost < d.number) {
			// d.OnPost = Dest.ToString();
			// HasMoved = true;
			// Dest.topPost = d.number;
			// Print(d, Scource, Dest);
			// count++;
		}

		if (Dest.topPost > d.getNumber()) {
			d.OnPost = Dest.toString();
			HasMoved = true;
			Dest.topPost = d.getNumber();
			Print(d, Spare, Dest);
		}

		else if (Dest.topPost < d.getNumber()) {
			d.OnPost = Spare.toString();
			HasMoved = true;
			Spare.topPost = d.getNumber();
			Print(d, Scource, Spare);
		}

		MoveTower(NextDisc(d), Scource, Dest, Spare);

		return;
	}

	public void setFromPost(String fromPost) {
		FromPost = fromPost;
	}

	String FromPost;

	Post source = new Post('A', 0);
	Post dest = new Post('B', 0);
	Post spare = new Post('C', 0);
	Disc top = new Disc(1);
	Disc second = new Disc(2);
	Disc third = new Disc(3);
	Disc bot = new Disc(4);

	public void SetStart() {
		top.setOnPost(source.toString());
		source.topPost = 1;
		second.OnPost = source.toString();
		third.OnPost = source.toString();
		bot.OnPost = source.toString();
	}

	Disc NextDisc(Disc d) {
		if (d.getNumber() == 1) {
			return (second);
		}
		if (d.getNumber() == 2) {
			return (third);
		}
		if (d.getNumber() == 3) {
			return (bot);
		}
		if (d.getNumber() == 4) {
			return (top);
		}
		return null;
	}

}
