
public class GridPoint {
	
	protected char type;
	
	
	public GridPoint() {
		type = ' ';
	}
	
	public boolean isEmpty(){
		if(type==' ')
			return true;
		return false;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public String toString() {
		return ""+type; 
		}
	//@Override
	//public void move() {
		// TODO Auto-generated method stub
		
	//}

	//@Override
	public void doBiology() {
		// TODO Auto-generated method stub
		
	}

}
