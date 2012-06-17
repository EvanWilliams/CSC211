package edw.emich.ewilli46.CSC211.TowersofHanoi;

public class Hanoi {
	private Post source = new Post("A");
	private Post dest = new Post("B");
	private Post spare = new Post("C");
	int Disc;

	Hanoi(){
		source.addDisc(4);
		source.addDisc(3);
		source.addDisc(2);
		source.addDisc(1);
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
	public void Print(int i, Post From, Post To) {
		System.out.println("Move " + i + " From " + From.toString()
				+ " To " + To.toString());
	}

	public void MoveTower() {
		MoveTower(4, source, dest, spare);
	}
	//Recursive function to move the tower from scource to dest.
	
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
