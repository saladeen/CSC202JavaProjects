public class Problem12Driver {
    // Methods added to ArrayBoundedQueue
    public static void main(String[] args) {
        ArrayBoundedQueue<Integer> idk = new ArrayBoundedQueue<Integer>();
        idk.enqueue(70);
        idk.enqueue(563);
        idk.enqueue(8);
        idk.enqueue(0);
        idk.enqueue(-57);

        System.out.println(idk);
        //System.out.println(idk.space());
        //idk.remove(2);
        //idk.swapStart();
        idk.swapEnds();
        System.out.println(idk);
    }
}