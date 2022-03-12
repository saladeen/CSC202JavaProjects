public class Problem6 {
    public static void main(String[] args) {
        //sixATest();
        sixBTest();
    }

    //6a.
    public static void evenOddSort(Queue<Integer> startQ, Queue<Integer> evenQ, Queue<Integer> oddQ) {
        boolean someStartQ = true;
        while(someStartQ) {
            try {
                Integer current = startQ.dequeue();
                if (current % 2 == 0) {
                    evenQ.enqueue(current);
                } else {
                    oddQ.enqueue(current);
                }
            } catch(QueueUnderflowException e) {
                someStartQ = false; 
            }
        }
    }

    //6b.
    public static void zipQueues(Queue<Integer> queueA, Queue<Integer> queueB, Queue<Integer> queueC) {
        boolean someA = true;
        boolean someB = true;
        int splitTracker = 0;
        while (someA || someB) {
            if (splitTracker % 2 == 0) {
                splitTracker++;
                try {
                    Integer current = queueA.dequeue();
                    queueC.enqueue(current);
                } catch(QueueUnderflowException e) {
                    someA = false;
                }
            } else {
                splitTracker++;
                try {
                    Integer current = queueB.dequeue();
                    queueC.enqueue(current);
                } catch(QueueUnderflowException e) {
                    someB = false;
                }
            }
        }
    }

    public static void sixBTest() {
        Queue<Integer> queueA = new Queue<Integer>();
        Queue<Integer> queueB = new Queue<Integer>();
        Queue<Integer> queueC = new Queue<Integer>();

        queueA.enqueue(1);
        queueA.enqueue(2);
        queueA.enqueue(3);
        queueA.enqueue(4);

        queueB.enqueue(5);
        queueB.enqueue(6);

        zipQueues(queueA, queueB, queueC);
        printQueue(queueA);
        printQueue(queueB);
        printQueue(queueC);
    }

    public static void sixATest() {
        Queue<Integer> startQ = new Queue<Integer>();
        startQ.enqueue(5);
        startQ.enqueue(67);
        startQ.enqueue(10);
        startQ.enqueue(445);
        startQ.enqueue(1);
        startQ.enqueue(88);
        startQ.enqueue(27);
        startQ.enqueue(112);

        Queue<Integer> evenQ = new Queue<Integer>();
        Queue<Integer> oddQ = new Queue<Integer>();

        evenOddSort(startQ, evenQ, oddQ);
        printQueue(startQ);
        printQueue(evenQ);
        printQueue(oddQ);
    }

    public static void printQueue(Queue<Integer> q) {
        boolean someQ = true;
        while(someQ) {
            try {
                Integer current = q.dequeue();
                System.out.println(current);
            } catch (QueueUnderflowException e) {
                someQ = false;
                System.out.println();
            }
        }
    }
}
