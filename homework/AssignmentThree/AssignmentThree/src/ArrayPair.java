import java.lang.reflect.Array;

public class ArrayPair<T> implements PairInterface<T> {
    private T[] pair;

    public ArrayPair(Class<T> clazz, T first, T second) {
        final T[] pair = (T[]) Array.newInstance(clazz, 2); // https://stackoverflow.com/questions/529085/how-to-create-a-generic-array-in-java I still don't really get this
        pair[0] = first;
        pair[1] = second;
        this.pair = pair;
    }

    @Override
    public T getFirst() {
        return pair[0];
    }

    @Override
    public T getSecond() {
        return pair[1];
    }

    @Override
    public void setFirst(T first) {
        pair[0] = first;
    }

    @Override
    public void setSecond(T second) {
        pair[1] = second;
    }
    
}
