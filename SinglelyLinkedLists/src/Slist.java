import java.util.Scanner;

//--------------------------------------------------------------------
//
//  Laboratory 7                                         SList.jshl
//
//  Class definitions for the singly linked list implementation of 
//  the List ADT
//
//  The student is to complete all missing or incomplete method 
//     implementations for each class (Slist and SListNode)
//
//--------------------------------------------------------------------

class SList implements List {
	// Data members
	private SListNode head, // Reference to the beginning of the list
	cursor; // Reference to current cursor position

	// Constructors & Helper Method
	SList() // Default constructor: Creates an empty list
	{
		head = null;
		cursor = null;

	}

	// --------------------------------------------------------------------
	//
	// In-lab operations
	//
	// --------------------------------------------------------------------

	void moveToBeginning() // Move to beginning
	{
		SListNode Hold = new SListNode();
		if (cursor.next == null) {
			cursor.next = head;
			head = cursor;
		} else {
			Hold.element = cursor.element;
			gotoPrior();
			cursor.next = cursor.next.next;
			gotoNext();
			Hold.next = head;
			head = Hold;
		}
	}

	public void setCursor(SListNode cursor) {
		this.cursor = cursor;
	}

	void insertBefore(SListNode newElement) // Insert before cursor
	{
		cursor.next = newElement;
	}

	public void remove() {
		if (cursor == head) {
			cursor = null;
			head = null;
		} else {
			gotoPrior();
			if (cursor.next.next != null)
				cursor.next = cursor.next.next;
			else
				cursor.next = null;
		}
	}

	public void replace(SListNode newElement) {
		cursor = newElement;
	}

	public boolean isFull() {
		return false;

	}

	public void clear() {
		head = null;
		cursor = null;
	}

	public boolean isEmpty() {
		if (head.element == null)
			return true;

		return false;
	}

	public boolean gotoBeginning() {
		if (head != null) {
			cursor = head;
			return true;
		}
		return false;
	}

	public boolean gotoEnd() {
		SListNode buffer = new SListNode();

		if (isEmpty() == false) {
			buffer = head.next;
			while (buffer.next != null) {
				buffer = buffer.next;
			}
			if (buffer.next == null) {
				cursor = buffer;
				System.out.println("The Cursor is now at the last position");
				return true;
			}
		}
		// go to end of the list and put cursor on the last node
		System.out.println("Could not reach the last position");
		System.out.println("It must be that you have no values in the List");
		return false;
	}

	public boolean gotoNext() {
		if (cursor.next != null) {
			cursor = cursor.next;
			return true;
		}
		return false;
	}

	public boolean gotoPrior() {
		SListNode Stepper = new SListNode();
		if (cursor != head) {
			if (cursor == head.next) {
				cursor = head;
				return true;
			}
			if (head.next != cursor) {

				Stepper = head.next;
				while (Stepper.next != cursor) {
					if (Stepper.next == null) {
						System.out.println("Fatal Error Check code");
						return false;
					}
					Stepper = Stepper.next;
				}
				if (Stepper.next == cursor) {
					cursor = Stepper;
					return true;
				}

			}

		}
		return false;
	}

	public Object getCursor() {
		return cursor;

	}

	public void showStructure() {
		SListNode showStepper = new SListNode();
		// Mark cursor
		showStepper = head;
		if (head != null) {
			if (head.next == null) {
				System.out.print(head.element);
				// if(cursor == showStepper)
				System.out.print("'");
			} else if (head == cursor)
				System.out.print(head.element + "'");
			else
				System.out.print(head.element + " ");

			while (showStepper.next != null) {
				showStepper = showStepper.next;
				System.out.print(showStepper.element);
				if (cursor == showStepper)
					System.out.print("'");
				else
					System.out.print(" ");
			}
		} else if (head == null) {
			System.out.println("Empty List");
		}

	}

	public void insert(Object newElement) {
		SListNode newNode = new SListNode();
		if (head == null) {
			newNode.element = newElement;
			head = newNode;
			cursor = newNode;
		} else {
			newNode.element = newElement;
			newNode.next = cursor.next;
			cursor.next = newNode;
			cursor = newNode;
		}

	}

	public void replace(Object newElement) {
		SListNode aNewNode = new SListNode();
		newElement = aNewNode.element;
		gotoPrior();
		cursor.next.next = aNewNode.next;
		cursor.next = aNewNode;
		cursor = cursor.next;
	}

} // class SList