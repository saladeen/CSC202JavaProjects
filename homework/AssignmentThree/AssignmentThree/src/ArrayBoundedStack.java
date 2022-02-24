//----------------------------------------------------------------
// ArrayBoundedStack.java    by Dale/Joyce/Weems         Chapter 2
//
// Implements StackInterface using an array to hold the 
// stack elements.
//
// Two constructors are provided: one that creates an array of a 
// default size and one that allows the calling program to 
// specify the size.
//----------------------------------------------------------------

public class ArrayBoundedStack<T> implements StackInterface<T> 
{
  protected final int DEFCAP = 100; // default capacity
  protected T[] elements;           // holds stack elements
  protected int topIndex = -1;      // index of top element in stack

  public ArrayBoundedStack() 
  {
    elements = (T[]) new Object[DEFCAP];
  }

  public ArrayBoundedStack(int maxSize) 
  {
    elements = (T[]) new Object[maxSize];
  }

  public void push(T element)
  // Throws StackOverflowException if this stack is full,
  // otherwise places element at the top of this stack.
  {      
    if (isFull())
      throw new StackOverflowException("Push attempted on a full stack.");
    else
    {
      topIndex++;
      elements[topIndex] = element;
    }
  }

  public void pop()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise removes top element from this stack.
  {                  
    if (isEmpty())
      throw new StackUnderflowException("Pop attempted on an empty stack.");
    else
    {
      elements[topIndex] = null;
      topIndex--;
    }
  }

  public T top()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise returns top element of this stack.
  {                 
    T topOfStack = null;
    if (isEmpty())
      throw new StackUnderflowException("Top attempted on an empty stack.");
    else
      topOfStack = elements[topIndex];
    return topOfStack;
  }

  public boolean isEmpty()
  // Returns true if this stack is empty, otherwise returns false.
  {              
    return (topIndex == -1); 
  }

  public boolean isFull()
  // Returns true if this stack is full, otherwise returns false.
  {              
    return (topIndex == (elements.length - 1));
  }

  public String toString() {
      String el = "";
      for (int i=0; i<=topIndex; i++) {
          el += elements[i] + " ";
      }
      return el;
  }

  public int size() {
    if (isEmpty()) {
      return 0;
    } else {
      return topIndex + 1;
    }
  }

  public void popSome(int count) throws StackUnderflowException {
    if (count > size()) {
      throw new StackUnderflowException();
    } else {
      for (int i=0; i < count; i++) {
        pop();
      }
    }
  }

  public boolean swapStart() {
    if (size() < 2) {
      return false;
    } else { // swap the TOP two elements
      T temp = elements[topIndex];
      elements[topIndex] = elements[topIndex - 1];
      elements[topIndex - 1] = temp;
      return true;
    }
  }

  public T poptop() throws StackUnderflowException {
    if (isEmpty())
      throw new StackUnderflowException("Pop attempted on an empty stack.");
    else
    {
      T el = elements[topIndex];
      elements[topIndex] = null;
      topIndex--;
      return el;
    }
  }
}