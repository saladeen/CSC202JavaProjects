import java.util.Scanner;

public class Problem10 {
    public static void main(String[] args) {
        
        ArrayBoundedQueue<String> mQ = new ArrayBoundedQueue<String>();
        ArrayBoundedQueue<String> fQ = new ArrayBoundedQueue<String>();

        String input = "";
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Input a gender and name (x done to quit)");
            input = sc.nextLine();
            String[] split = input.split(" ");
            if (split[0].equals("m")) {
                mQ.enqueue(split[1]);
            } else if (split[0].equals("f")) {
                fQ.enqueue(split[1]);
            } else if (split[0].equals("x") && split[1].equals("done")) {
                break;
            }
        }
        sc.close();

        System.out.print("males: ");
        while(!mQ.isEmpty()) {
            System.out.print(mQ.dequeue() + " ");
        }
        System.out.print("females: ");
        while(!fQ.isEmpty()) {
            System.out.print(fQ.dequeue() + " ");
        }
    }


    public static void testMethod() {
        String s = "m Fred";
        String[] k = s.split(" ");
        for (String i : k) {
            System.out.println(i + "k");
        }
    }
}
