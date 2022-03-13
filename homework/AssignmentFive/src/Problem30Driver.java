public class Problem30Driver {
    public static void main(String[] args) {
        ArrayBoundedQueue<Integer> arQ = new ArrayBoundedQueue<Integer>();
        Queue<String> lQ = new Queue<String>();

        arQ.safeEnqueue(50);

        System.out.println(arQ.safeDequeue());
        System.out.println(arQ.safeDequeue());

        lQ.safeEnqueue("1");
        
        System.out.println(lQ.safeDequeue());
        System.out.println(lQ.safeDequeue());
    }
}
