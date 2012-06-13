package edw.emich.ewilli46.CSC211.TowersofHanoi;

public class Hanoi {
	//private boolean HasMoved = false;
	// private int NumDisks = 4;
	// private int NumPosts = 3;
	private String ToPost;
	private String FromPost;
	private Post source = new Post("A");
	private Post dest = new Post("B");
	private Post spare = new Post("C");
	int Disc;
//	private Disc top = new Disc(1);
//	private Disc second = new Disc(2);
//	private Disc third = new Disc(3);
//	private Disc bot = new Disc(4);

	Hanoi(){
		source.addDisc(4);
		source.addDisc(3);
		source.addDisc(2);
		source.addDisc(1);
	}
	public String getToPost() {
		return ToPost;
	}

//	public void setToPost(String toPost) {
//		ToPost = toPost;
//	}
//
//	public String getFromPost() {
//		return FromPost;
//	}

//	public String PrintBoard(int numDisks, String fromPost, String toPost) {
//		MoveTower(top, source, dest, spare);
//		return ("complete");
//	}

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
	public void Print(int i, Post From, Post To) {
		System.out.println("Move " + i + " From " + From.toString()
				+ " To " + To.toString());
	}

	public void MoveTower() {
		MoveTower(4, source, dest, spare);
	}
	
	
//	Function MoveTower(disc, Source,Dest,spare) :
//		if disc==1
//			move disc from source to dest
//		Else:
//			MoveTower(disc-1 , Source,spare,dest)
//			move disc from source to dest
//			MoveTower(disc-1 , spare , dest, source)
	//End If
	private void MoveTower(int d, Post Source, Post Dest, Post Spare) {
		if (d==1)
		{
			Dest.addDisc(Source.removeDisc());
			Print(d,Source,Dest);
		}
		else	
		{
			MoveTower(d-1,Source,Spare,Dest);
			Dest.addDisc(Source.removeDisc());
			Print(d,Source,Dest);
			MoveTower(d-1,Spare,Dest,Source);
		}
		
		
	
		}


	}
