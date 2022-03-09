public class Problem17 {
    public static void main(String[] args) {
        LLStack<Integer> stack = new LLStack<Integer>();
        stack.push(3);
        stack.push(6);
        stack.push(6);
        stack.push(9);
        stack.push(12);
        stack.push(15);
        stack.push(18);
        stack.push(19);
        stack.push(19);
        stack.push(20);
        LLNode<Integer> topNode = stack.top;
        System.out.println(contains(10, topNode));
    }
    public static boolean contains(int target, LLNode<Integer> list) {
        boolean contains = false;
        if (list.getInfo() == target) {
            contains = true;
        }
        if (list.getLink() == null) {// base case
            return contains;
        } else {
            return (contains || contains(target, list.getLink()));
        }
    }
}
