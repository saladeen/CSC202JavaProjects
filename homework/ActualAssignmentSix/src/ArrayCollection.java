//---------------------------------------------------------------------------
// ArrayCollection.java          by Dale/Joyce/Weems                Chapter 5
//
// Implements the CollectionInterface using an array.
//
// Null elements are not allowed. Duplicate elements are allowed.
//
// Two constructors are provided: one that creates a collection of a default
// capacity, and one that allows the calling program to specify the capacity.
//---------------------------------------------------------------------------

public class ArrayCollection<T> implements CollectionInterface<T>  
{
  protected final int DEFCAP = 100; // default capacity
  protected T[] elements;           // array to hold collection�s elements
  protected int numElements = 0;    // number of elements in this collection

  // set by find method
  protected boolean found;  // true if target found, otherwise false
  protected int location;   // indicates location of target if found

  public ArrayCollection() 
  {
    elements = (T[]) new Object[DEFCAP];
  }

  public ArrayCollection(int capacity) 
  {
    elements = (T[]) new Object[capacity];
  }

  // Methods added for #8, 5.2
  public String toString() {
    String output = "";
    for (int i=0; i<numElements; i++) {
      output += elements[i] + ", ";
    }
    return output;
  }

  public int count(T target) {
    int count = 0;
    for(int i=0; i<numElements; i++) {
      if(elements[i].equals(target)) {
        count += 1;
      }
    }
    return count;
  }

  public void removeAll(T target) { // breaks if last element is a dupe unfortunately, but removes everything else
    for (int i=0; i<numElements; i++) {
      if (elements[i].equals(target)) {
        elements[i] = elements[numElements - 1]; // Overwrite the match with the last element
        elements[numElements - 1] = null; // Remove the duplicate element at last index
        numElements--;
      }
    }
  }

  public ArrayCollection<T> combine(ArrayCollection<T> other) {
    ArrayCollection<T> newColl = new ArrayCollection<T>(numElements + other.numElements);
    for (int i=0; i<numElements; i++) {
      newColl.elements[i] = elements[i];
    }
    for (int j=0; j<other.numElements; j++) {
      newColl.elements[j + numElements] = other.elements[j];
    }
    newColl.numElements = numElements + other.numElements;
    return newColl;
  }

  protected void find(T target)
  // Searches elements for an occurrence of an element e such that
  // e.equals(target). If successful, sets instance variables
  // found to true and location to the array index of e. If
  // not successful, sets found to false.
  {
    location = 0;
    found = false;

    while (location < numElements) 
    {
      if (elements[location].equals(target))
      {  
        found = true;
        return;
      }
      else
        location++;
    }
  }

  public boolean add(T element)
  // Attempts to add element to this collection.
  // Returns true if successful, false otherwise.
  {
    if (isFull())
      return false;
    else
    {
      elements[numElements] = element;
      numElements++;
      return true;
    }
  }

  public boolean remove (T target)
  // Removes an element e from this collection such that e.equals(target)
  // and returns true; if no such element exists, returns false.
  {
    find(target);    
    if (found)
    {
      elements[location] = elements[numElements - 1];
      elements[numElements - 1] = null;
      numElements--;  
    }
    return found;
  }
  
  public boolean contains (T target)
  // Returns true if this collection contains an element e such that 
  // e.equals(target); otherwise, returns false.
  {
    find(target);
    return found;
  }

  public T get(T target)
  // Returns an element e from this collection such that e.equals(target);
  // if no such element exists, returns null.
  {
    find(target);    
    if (found)
      return elements[location];
    else
      return null;
  }
  
  public boolean isFull()
  // Returns true if this collection is full; otherwise, returns false.
  {
    return (numElements == elements.length);
  }

  public boolean isEmpty()
  // Returns true if this collection is empty; otherwise, returns false.
  {
    return (numElements == 0);  
  }

  public int size()
  // Returns the number of elements in this collection. 
  {
    return numElements;
  }
}
