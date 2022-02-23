public interface CenturyStackInterface<T> { // 24 just asks for the interface soooo...
    public void push(T element);
    public void pop();
    public T top();
    public boolean isEmpty();
    public boolean isFull();
}
