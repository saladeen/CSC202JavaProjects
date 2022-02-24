//----------------------------------------------------------------------
// LinkedStack.java         by Dale/Joyce/Weems                Chapter 2
//
// Implements StackInterface using a linked list to hold the elements.
//-----------------------------------------------------------------------

public class LinkedStack<T> implements StackInterface<T>
{
  protected LLNode<T> top;   // reference to the top of this stack

  public LinkedStack()
  {
    top = null;
  }

  public void push(T element)
  // Places element at the top of this stack.
  { 
    LLNode<T> newNode = new LLNode<T>(element);
    newNode.setLink(top);
    top = newNode;
  }     

  public void pop()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise removes top element from this stack.
  {                  
    if (isEmpty())
      throw new StackUnderflowException("Pop attempted on an empty stack.");
    else
      top = top.getLink();
  }

  public T top()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise returns top element of this stack.
  {                 
    if (isEmpty())
      throw new StackUnderflowException("Top attempted on an empty stack.");
    else
      return top.getInfo();
  }

  public boolean isEmpty()
  // Returns true if this stack is empty, otherwise returns false.
  {              
    return (top == null); 
  }

  public boolean isFull()
  // Returns false - a linked stack is never full
  {              
      return false;
  }

  public String toString() {
      String el = "";
      LLNode<T> ref = top;
      while (ref != null) {
          el += ref.getInfo() + " -> "; // using arrows to specify linking, extra one at the end unfortunately but just ignore that
          ref = ref.getLink();
      }
      return el;
  }

  public int size() {
      LLNode<T> ref = top;
      int size = 0;
      while (ref != null) {
        size += 1;
        ref = ref.getLink();
      }
      return size;
  }

  public void popSome(int count) throws StackUnderflowException {
      if (count > size()) {
          throw new StackUnderflowException();
      } else {
        for (int i=0; i<count; i++) {
            top = top.getLink();
        }
      }
  }

  
  public boolean swapStart() {
    if (size() < 2) {
      return false;
    } else {
      // very contrived, I'm sure there are better ways to do this
      T tempFirst = top.getInfo();
      T tempSecond = top.getLink().getInfo();
      pop();
      pop();
      push(tempFirst);
      push(tempSecond);
      return true;
    }
  }
  

  public T poptop() throws StackUnderflowException {
    if (isEmpty()) {
      throw new StackUnderflowException();
    } else {
      T temp = top.getInfo();
      pop();
      return temp;
    }
  }
}

