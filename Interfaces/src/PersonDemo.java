/**
 * Class for a person with a name and dates for birth and death. Class
 * invariant: A Person always has a date of birth, and if the Person has a date
 * of death, then the date of death is equal to or later than the date of birth.
 */
// Person now implements cloneable
class Person implements Cloneable {
	private String name;
	private Date born;
	private Date died; // null indicates still alive.

	/**
	 * Warning: these are poorly written constructors. This is to force you to
	 * implement the clone methods properly
	 */
	public Person(String initialName, Date birthDate, Date deathDate) {
		if (consistent(birthDate, deathDate)) {
			name = initialName;
			born = birthDate;
			died = deathDate;
		} else {
			System.out.println("Inconsistent dates. Aborting.");
			System.exit(0);
		}
	}

	public Person(Person original) {
		if (original == null) {
			System.out.println("Fatal error.");
			System.exit(0);
		}

		name = original.name;
		born = original.born;
		died = original.died;
	}

	public void set(String newName, Date birthDate, Date deathDate) {
		if (consistent(birthDate, deathDate)) {
			name = newName;
			born = new Date(birthDate);
			if (deathDate == null)
				died = null;
			else
				died = new Date(deathDate);
		} else {
			System.out.println("Inconsistent dates. Aborting.");
			System.exit(0);
		}
	}

	public String toString() {
		String diedString;
		if (died == null)
			diedString = ""; // Empty string
		else
			diedString = died.toString();

		return (name + ", " + born + "-" + diedString);
	}

	public boolean equals(Person otherPerson) {
		if (otherPerson == null)
			return false;
		else
			return (name.equals(otherPerson.name)
					&& born.equals(otherPerson.born) && datesMatch(died,
							otherPerson.died));
	}

	/**
	 * To match date1 and date2 must either be the same date or both be null.
	 */
	private boolean datesMatch(Date date1, Date date2) {
		if (date1 == null)
			return (date2 == null);
		else if (date2 == null) // && date1 != null
			return false;
		else
			// both dates are not null.
			return (date1.equals(date2));
	}

	/**
	 * Precondition: newDate is a consistent date of birth. Postcondition: Date
	 * of birth of the calling object is newDate.
	 */
	public void setBirthDate(Date newDate) {
		if (consistent(newDate, died))
			born = new Date(newDate);

		else {
			System.out.println("Inconsistent dates. Aborting.");
			System.exit(0);
		}
	}

	/**
	 * Precondition: newDate is a consistent date of death. Postcondition: Date
	 * of death of the calling object is newDate.
	 */
	public void setDeathDate(Date newDate) {

		if (!consistent(born, newDate)) {
			System.out.println("Inconsistent dates. Aborting.");
			System.exit(0);
		}

		if (newDate == null)
			died = null;
		else
			died = new Date(newDate);
	}

	public void setName(String newName) {
		name = newName;
	}

	/**
	 * Precondition: The date of birth has been set, and changing the year part
	 * of the date of birth will give a consistent date of birth. Postcondition:
	 * The year of birth is (changed to) newYear.
	 */
	public void setBirthYear(int newYear) {
		if (born == null) // Precondition is violated
		{
			System.out.println("Fata; Error. Aborting.");
			System.exit(0);
		}
		born.setYear(newYear);
		if (!consistent(born, died)) {
			System.out.println("Inconsistent dates. Aborting.");
			System.exit(0);
		}
	}

	/**
	 * Precondition: The date of death has been set, and changing the year part
	 * of the date of death will give a consistent date of death. Postcondition:
	 * The year of death is (changed to) newYear.
	 */
	public void setDeathYear(int newYear) {
		if (died == null) // Precondition is violated
		{
			System.out.println("Fata; Error. Aborting.");
			System.exit(0);
		}
		died.setYear(newYear);
		if (!consistent(born, died)) {
			System.out.println("Inconsistent dates. Aborting.");
			System.exit(0);
		}
	}

	public String getName() {
		return name;
	}

	public Date getBirthDate() {
		return new Date(born);
	}

	public Date getDeathDate() {
		if (died == null)
			return null;
		else
			return new Date(died);
	}

	/**
	 * To be consistent, birthDate must not be null. If there is no date of
	 * death (deathDate == null), that is consistent with any birthDate.
	 * Otherwise, the birthDate must come before or be equal to the deathDate.
	 */
	private boolean consistent(Date birthDate, Date deathDate) {
		if (birthDate == null)
			return false;
		else if (deathDate == null)
			return true;
		else
			return (birthDate.precedes(deathDate) || birthDate
					.equals(deathDate));
	}

	// --------------------------------
	// ----- ENTER YOUR CODE HERE -----
	// --------------------------------
	// Protected clone method fix
	public Object clone() {
		try {
			return super.clone();
		} catch (Exception e) {
			return null;
		}
	}

	// --------------------------------
	// --------- END USER CODE --------
	// --------------------------------

}

/**
 * Demonstration class for testing Person's clone() method.
 */
public class PersonDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		Date birth = new Date(7, 14, 1929);
		Date death = new Date(5, 4, 2001);
		Person person = new Person("John Doe", birth, death);
		Person clone = (Person) person.clone();
		System.out.println("Person: " + person);
		System.out.println("Person's clone: " + clone);
		System.out.println("person.equals(clone)? : " + (person.equals(clone)));
		person.setDeathYear(2003);
		System.out.println();
		System.out.println("After changing Person's death year:");
		System.out.println("Person: " + person);
		System.out.println("Person's clone: " + clone);
		System.out.println("person.equals(clone)? : " + (person.equals(clone)));

		// Make sure null Date fields are handled correctly
		Person living = new Person("Jane Doe", birth, null);
		Person livingClone = (Person) living.clone();
		System.out.println();
		System.out.println("Living Person: " + living);
		System.out.println("Living Person's clone: " + livingClone);
		System.out.println("living.equals(livingClone)? : "
				+ (living.equals(livingClone)));
		System.out.println();
		living.setBirthYear(2003);
		System.out.println("After changing birth year:");
		System.out.println("Living Person: " + living);
		System.out.println("Living Person's clone: " + livingClone);
		System.out.println("living.equals(livingClone)? : "
				+ (living.equals(livingClone)));
	}

}
//OutPut:
//	Person: John Doe, July 14, 1929-May 4, 2001
//	Person's clone: John Doe, July 14, 1929-May 4, 2001
//	person.equals(clone)? : true
//
//	After changing Person's death year:
//	Person: John Doe, July 14, 1929-May 4, 2003
//	Person's clone: John Doe, July 14, 1929-May 4, 2003
//	person.equals(clone)? : true
//
//	Living Person: Jane Doe, July 14, 1929-
//	Living Person's clone: Jane Doe, July 14, 1929-
//	living.equals(livingClone)? : true
//
//	After changing birth year:
//	Living Person: Jane Doe, July 14, 2003-
//	Living Person's clone: Jane Doe, July 14, 2003-
//	living.equals(livingClone)? : true
//
