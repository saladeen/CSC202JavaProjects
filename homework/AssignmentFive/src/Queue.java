// Linked list queue, basically taken from LinkedQueue.java in bookFiles
public class Queue<T> implements QueueInterface<T> {
    LLNode<T> front;
    LLNode<T> rear;
    int numElements = 0;

    public Queue() {
        front = null;
        rear = null;
    }

    public void enqueue(T element) {
        LLNode<T> newNode = new LLNode<T>(element);
        if (rear == null) {
            front = newNode;
        } else {
            rear.setLink(newNode);
        }
        rear = newNode;
        numElements++;
    }

    public T dequeue() throws QueueOverflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException("Dequeue attempted on empty queue.");
        } else {
            T element = front.getInfo();
            front = front.getLink();
            if (front == null) {
                rear = null;
            }
            numElements--;
            return element;
        }
    }

    public boolean isFull() {
        return false; // Never full :)
    }

    public boolean isEmpty() {
        return (front == null);
    }

    public int size() {
        return numElements;
    }
    
}
