public class Problem16 {
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
        System.out.println(numEvens(topNode));
    }
    
    public static int numEvens(LLNode<Integer> list) {
        int isEven = 0; // 0 = not even (doesn't increase # of evens) 1 = even (increases total # by 1)
        if (list.getInfo() % 2 == 0) {
            isEven = 1;
        }
        if (list.getLink() == null) { // base case
            return isEven;
        } else {
            return isEven + numEvens(list.getLink());
        }
    }
}
