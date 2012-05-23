
public class GridPoint {
	
	protected String type;
	
	
	public GridPoint() {
		type = " ";
	}
	
	public boolean isEmpty(){
		if(type==" ")
			return true;
		return false;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String toString() {
		return " "+type; 
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
