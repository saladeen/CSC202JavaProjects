public class Problem15Driver {
    public static void main(String[] args) {
        Deque<String> dq = new Deque<String>(10);
        dq.push_back("one");
        dq.push_back("two");
        dq.push_front("three");
        dq.push_front("four");
        System.out.println(dq.pop_back());
        System.out.println(dq.pop_front());
    }
}
