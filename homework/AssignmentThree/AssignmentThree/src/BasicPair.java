public class BasicPair<T> implements PairInterface<T> {
    T first, second;

    public BasicPair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public T getFirst() {
        return first;
    }

    @Override
    public T getSecond() {
        return second;
    }

    @Override
    public void setFirst(T first) {
        this.first = first;
    }

    @Override
    public void setSecond(T second) {
        this.second = second;
    }
}
