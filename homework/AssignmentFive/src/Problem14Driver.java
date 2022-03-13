public class Problem14Driver {
    public static void main(String[] args) {
        ArrayListUnboundedQueue<String> test = new ArrayListUnboundedQueue<String>();
        test.enqueue("one");
        test.enqueue("two");
        test.enqueue("three");
        test.enqueue("four");
        test.enqueue("five");
        test.dequeue();
        System.out.println(test.size());
        System.out.println(test.isEmpty());
        System.out.println(test.isFull());
    }
}
