import java.util.ArrayList;

public class ArrayListUnboundedQueue<T> implements QueueInterface<T> {
    private ArrayList<T> elements;
    
    public ArrayListUnboundedQueue() {
        elements = new ArrayList<T>();
    }

    public void enqueue(T element) throws QueueOverflowException {
        elements.add(element);
    }

    public T dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueOverflowException("Dequeue attempted on an empty stack");
        } else {
            return elements.remove(0);
        }
    }

    public boolean isFull() {
        // Never full
        return false;
    }

    public boolean isEmpty() {
        return (elements.size() == 0);
    }

    public int size() {
        return elements.size();
    }
    
}
