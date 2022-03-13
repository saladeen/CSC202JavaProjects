public class Deque<T> {
    // Need: push_back, push_front, pop_back, pop_front, back, front
    private T[] elements;
    private int numElements = 0;
    private int front = 0;
    private int back;

    public Deque(int capacity) {
        elements = (T[]) new Object[capacity];
        back = capacity - 1;
    }

    public void push_back(T element) throws QueueOverflowException {
        if (isFull()) {
            throw new QueueOverflowException("Push_back attempted on full queue");
        } else {
            back = (back + 1) % elements.length;
            elements[back] = element;
            numElements++;
        }
    }

    public void push_front(T element) throws QueueUnderflowException {
        if (isFull()) {
            throw new QueueOverflowException("Push_front attempted on a full queue");
        } else {
            front = (elements.length + front - 1) % elements.length; // if front = 0 -> (100 - 0 - 1) % 99 = 99, front = 1 -> 100 % 100 = 0, 101%100 = 1, etc.
            elements[front] = element;
            numElements++;
        }
    }

    public T pop_back() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException("Pop_back attempted on empty queue");
        } else {
            T temp = elements[back];
            elements[back] = null;
            back = (elements.length + back - 1) % elements.length;
            numElements++;
            return temp;
        }
    }

    public T pop_front() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException("Pop_front attempted on empty queue");
        } else {
            T temp = elements[front];
            elements[front] = null;
            front = (front + 1) % elements.length;
            numElements--;
            return temp;
        }
    }

    public T front() {
        return elements[front];
    }

    public T back() {
        return elements[back];
    }

    public boolean isEmpty() {
        return (numElements == 0);
    }

    public boolean isFull() {
        return (numElements == elements.length);
    }
}
