//--------------------------------------------------------------------
//
//  Laboratory 7                                       SListNode.jshl
//
//  Class definition for the singly linked list implementation of 
//  the List ADT
//
//  The student is to complete all missing or incomplete method 
//     implementations for each class (SList and SListNode)
//
//--------------------------------------------------------------------

class SListNode
{
    // Data members
    private Object element;         // List element
    private SListNode next;         // Reference to the next element
    
    // Constructor
    SListNode ( Object elem, SListNode nextPtr )
        // Creates a list node containing element elem and next pointer
        // nextPtr.
    {

    }
    
    // Class Methods used by client class
    SListNode getNext( )                    // Return reference to next element
    {
		return next;

    }
    
    SListNode setNext( SListNode nextVal )  // Set reference to next element
    {
		return nextVal;                                       //  & return that reference

    }
    
    Object getElement( )             // Return the element in the current node
    {
		return element;

    }
    
    void setElement(Object newElem)         // Set current element to newElem 
    {                                 

    }
    
} // class SListNode
