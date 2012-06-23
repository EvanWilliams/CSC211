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
	private SListNode Slist[];

	// Constructors & Helper Method
	SList(int x, SListNode LHead) // Default constructor: Creates an empty list
	{
		Slist = new SListNode[x];
		Slist[0] = LHead;
		head = LHead;
		cursor = LHead;
		for(int i =0;i<x;i++)
		{
			
		}

	}

	// --------------------------------------------------------------------
	//
	// In-lab operations
	//
	// --------------------------------------------------------------------

	void moveToBeginning() // Move to beginning
	{

	}

	void insertBefore(Object newElement) // Insert before cursor
	{

	}

	@Override
	public void insert(Object newElement) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

	@Override
	public void replace(Object newElement) {
		// TODO Auto-generated method stub

	}

	public boolean isFull() {
		return false;

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotoBeginning() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotoEnd() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotoNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotoPrior() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getCursor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showStructure() {
		// TODO Auto-generated method stub

	}

} // class SList