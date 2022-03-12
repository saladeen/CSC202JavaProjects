public class Problem9 {
    public static void main(String[] args) {
        ArrayBoundedQueue<String> q = new ArrayBoundedQueue<String>();
        q.enqueue("l");
        q.enqueue("m");
        q.enqueue("a");
        q.enqueue("o");

        nineD(q);
        System.out.println(q.dequeue());
    }

    public static String nineA(ArrayBoundedQueue<String> q) {
        // this will break if <2 elements in queue but I didn't bother hardening because the problem assumes it
        q.dequeue();
        return q.dequeue();
    }

    public static String nineB(ArrayBoundedQueue<String> q) {
        String last = "";
        while(!q.isEmpty()) {
            last = q.dequeue();
        }
        return last;
    }

    public static String nineC(ArrayBoundedQueue<String> q) {
        // I think I literally have to dequeue then queue everything
        ArrayBoundedQueue<String> newQ = new ArrayBoundedQueue<String>();
        String last = "";
        while (!q.isEmpty()) {
            last = q.dequeue();
            newQ.enqueue(last);
        }
        while(!newQ.isEmpty()) {
            q.enqueue(newQ.dequeue());
        }
        return last;
    }

    public static void nineD(ArrayBoundedQueue<String> q) {
        ArrayBoundedQueue<String> newQ = new ArrayBoundedQueue<String>();
        String curr = "";
        while(!q.isEmpty()) {
            curr = q.dequeue();
            System.out.println(curr);
            newQ.enqueue(curr);
        }
        while(!newQ.isEmpty()) {
            q.enqueue(newQ.dequeue());
        }
    }

}
