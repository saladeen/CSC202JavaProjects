//---------------------------------------------------------------------------
// ArrayBoundedQueue.java        by Dale/Joyce/Weems                Chapter 4
//
// Implements QueueInterface with an array to hold the queue elements.
//
// Two constructors are provided: one that creates a queue of a default
// capacity and one that allows the calling program to specify the capacity.
//---------------------------------------------------------------------------

public class ArrayBoundedQueue<T> implements QueueInterface<T>
{
  protected final int DEFCAP = 100; // default capacity
  protected T[] elements;           // array that holds queue elements
  protected int numElements = 0;    // number of elements in this queue
  protected int front = 0;          // index of front of queue
  protected int rear;               // index of rear of queue

  public ArrayBoundedQueue() 
  {
    elements = (T[]) new Object[DEFCAP];
    rear = DEFCAP - 1;
  }

  public ArrayBoundedQueue(int maxSize) 
  {
    elements = (T[]) new Object[maxSize];
    rear = maxSize - 1;
  }

  public void enqueue(T element)
  // Throws QueueOverflowException if this queue is full;
  // otherwise, adds element to the rear of this queue.
  {  
    if (isFull())
      throw new QueueOverflowException("Enqueue attempted on a full queue.");
    else
    {
      rear = (rear + 1) % elements.length;
      elements[rear] = element;
      numElements = numElements + 1;
    }
  }

  public T dequeue()
  // Throws QueueUnderflowException if this queue is empty;
  // otherwise, removes front element from this queue and returns it.
  {   
    if (isEmpty())
      throw new QueueUnderflowException("Dequeue attempted on empty queue.");
    else
    {
      T toReturn = elements[front];
      elements[front] = null;
      front = (front + 1) % elements.length;
      numElements = numElements - 1;
      return toReturn;
    }
  }

  public boolean isEmpty()
  // Returns true if this queue is empty; otherwise, returns false.
  {              
    return (numElements == 0);
  }

  public boolean isFull()
  // Returns true if this queue is full; otherwise, returns false.
  {              
    return (numElements == elements.length);
  }
  
  public int size()
  // Returns the number of elements in this queue.
  {
    return numElements;
  }
  
  // New methods added for Problem 12
  public String toString() {
    String combined = "";
    for (int i=front; i<=rear; i++) {
      combined += (elements[i] + "\n");
    }
    return combined;
  }

  public int space() {
    return (elements.length - numElements);
  }

  public void remove(int count) throws QueueUnderflowException {
    for (int i = 0; i < count; i++) {
      if (numElements == 0) {
        throw new QueueOverflowException("Tried to remove from an empty queue");
      } else {
        elements[front] = null;
        front = (front + 1) % elements.length;
        numElements = numElements - 1;
      }
    }
  }

  public boolean swapStart() {
    if (numElements < 2) {
      return false;
    } else {
      int ftemp = (front + 1) % elements.length;
      T temp = elements[front];
      elements[front] = elements[ftemp];
      elements[ftemp] = temp;
      return true;
    }
  }

  public boolean swapEnds() {
    if (numElements < 2) {
      return false;
    } else {
      T temp = elements[front];
      elements[front] = elements[rear];
      elements[rear] = temp;
      return true;
    }
  }

  // Methods added for Question 30
  public boolean safeEnqueue(T element) {
    if (isFull()) {
      return false;
    } else {
      rear = (rear + 1) % elements.length;
      elements[rear] = element;
      numElements = numElements + 1;
      return true;
    }
  }

  public T safeDequeue() {
    if (isEmpty()) {
      return null;
    } else {
      T toReturn = elements[front];
      elements[front] = null;
      front = (front + 1) % elements.length;
      numElements = numElements - 1;
      return toReturn;
    }
  }
}