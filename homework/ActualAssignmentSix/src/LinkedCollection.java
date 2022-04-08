//---------------------------------------------------------------------------
// LinkedCollection.java          by Dale/Joyce/Weems               Chapter 5
//
// Implements the CollectionInterface using a linked collection.
// Null elements are not allowed. Duplicate elements are allowed.
// One constructor is provided, one that creates an empty collection.
//---------------------------------------------------------------------------


public class LinkedCollection<T> implements CollectionInterface<T>  
{
  protected LLNode<T> head;       // head of the linked list
  protected int numElements = 0;  // number of elements in this collection

  // set by find method
  protected boolean found;        // true if target found, else false
  protected LLNode<T> location;   // node containing target, if found
  protected LLNode<T> previous;   // node preceding location

  public LinkedCollection()
  {
    numElements = 0;
    head = null;
  }

  // added methods for #30
  public String toString() {
    String result = "";
    LLNode<T> curr = head;
    while(curr != null) {
      result += curr.getInfo().toString() + " -> ";
      curr = curr.getLink();
    }
    return result;
  }

  public int count(T target) {
    LLNode<T> curr = head;
    int count = 0;
    while(curr != null) {
      if(curr.getInfo().equals(target)) {
        count++;
      }
      curr = curr.getLink();
    }
    return count;
  }

  public void removeAll(T target) {
    LLNode<T> location = head;
    while (location != null) {
      if(location.getInfo().equals(target)) {
        // if head node, just delete head
        if (location.equals(head)) {
          head = head.getLink();
        } else { // otherwise need to relink
          previous.setLink(location.getLink());
        }
        numElements--;
      }
      previous = location;
      location = location.getLink();
    }
  }

  public LinkedCollection<T> combine(LinkedCollection<T> other) {
    // it says SortedArrayCollection in the question but im assuming thats a typo
    LinkedCollection<T> newColl = new LinkedCollection<T>();
    LLNode<T> curr = head;
    while(curr != null) {
      LLNode<T> newNode = new LLNode<T>(curr.getInfo());
      newNode.setLink(newColl.head);
      newColl.head = newNode;
      curr = curr.getLink();
    }
    curr = other.head;
    while(curr != null) {
      LLNode<T> newNode = new LLNode<T>(curr.getInfo());
      newNode.setLink(newColl.head);
      newColl.head = newNode;
      curr = curr.getLink();
    }
    return newColl;
  }

  public boolean add(T element)
  // Adds element to this collection.
  {
    LLNode<T> newNode = new LLNode<T>(element);
    newNode.setLink(head);
    head = newNode;
    numElements++;
    return true;
  }

  protected void find(T target)
  // Searches the collection for an occurence of an element e such that
  // e.equals(target). If successful, sets instance variables
  // found to true, location to node containing e, and previous
  // to the node that links to location. If not successful, sets 
  // found to false.
  {
    location = head;
    found = false;

    while (location != null) 
    {
      if (location.getInfo().equals(target))  // if they match
      {
       found = true;
       return;
      }
      else
      {
        previous = location;
        location = location.getLink();
      }
    }
  }

  public int size()
  // Returns the number of elements on this collection. 
  {
    return numElements;
  }

  public boolean contains (T target)
  // Returns true if this collection contains an element e such that 
  // e.equals(target); otherwise, returns false.
  {
    find(target);
    return found;
  }

  public boolean remove (T target)
  // Removes an element e from this collection such that e.equals(target)
  // and returns true; if no such element exists, returns false.
  {
    find(target);
    if (found)
    {
      if (head == location)     
        head = head.getLink();    // remove first node
      else
        previous.setLink(location.getLink());  // remove node at location

      numElements--;
    }
    return found;
  }

  public T get(T target)
  // Returns an element e from this collection such that e.equals(target);
  // if no such element exists, returns null.
  {
    find(target);    
    if (found)
      return location.getInfo();
    else
      return null;
  }
    
  public boolean isEmpty()
  // Returns true if this collection is empty; otherwise, returns false.
  {
    return (numElements == 0);  
  }

  public boolean isFull()
  // Returns true if this collection is full; otherwise, returns false.
  {
    return false;  // Linked implementation is never full
  }  
}
