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
// Enumeration inner class
	class FooEnum implements Enumeration {
		int place = 0;
		String[] name;
		
		FooEnum(String[] c) {
			 name = c;
		}

		public boolean hasNext() {
			if (name.length >= place+1) {
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

}
