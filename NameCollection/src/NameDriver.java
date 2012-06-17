
public class NameDriver {
		public static void main(String[] args) {
			String[] names = new String[] { "James", "Sarah", "Erica", "Jennifer",
			"William" };
			NameCollection collection = new NameCollection(names);

			System.out.println("Names in the collection:");
			Enumeration e = collection.getEnumeration();
			
			while (e.hasNext()) {
				System.out.println("    " + e.getNext());
			}

	}

}
