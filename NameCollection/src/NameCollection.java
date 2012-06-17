/**
 * Class that implements a list of names and provides an Enumeration for
 * accessing the names.
 */
public class NameCollection {
	/**
	 * Array of names
	 */
	private String[] names = null;

	public NameCollection(String[] names) {
		this.names = names;
	}

	public Enumeration getEnumeration() {
		FooEnum collect = new FooEnum(names);
		return collect;
	}

	class FooEnum implements Enumeration {
		int place = 0;
		String[] name;
		
		FooEnum(String[] c) {
			 name = c;
		}

		public boolean hasNext() {
			if (name.length > place+1) {
				return true;
			} else
				return false;
		}

		public Object getNext() {
			if (hasNext()==true) {
				String obj =name[place];
				place++;
				return obj;
				} 
			
			else
				return null;
		}

	}

	// --------------------------------
	// ----- ENTER YOUR CODE HERE -----
	// --------------------------------
	/*
	 * You should define an inner class that implements Enumeration
	 * //-------------------------------- // --------- END USER CODE --------
	 * //--------------------------------
	 * 
	 * /** getEnumeration should return an instance of your inner class that
	 * implements the Enumeration interface where hasNext() and getNext()
	 * correspond to data stored within the names array.
	 */

	// --------------------------------
	// ----- ENTER YOUR CODE HERE -----
	// --------------------------------

	// --------------------------------
	// --------- END USER CODE --------
	// --------------------------------

}
