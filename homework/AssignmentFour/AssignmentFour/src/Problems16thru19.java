public class Problems16thru19 {
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

        // #16
        //System.out.println(numEvens(topNode));

        // #17
        //System.out.println(contains(15, topNode));
        
        // #18
        /*
        LLNode<Integer> removedList = remove(19, topNode);
        System.out.println(removedList.getInfo());
        while(removedList.getLink() != null) {
            removedList = removedList.getLink();
            System.out.println(removedList.getInfo());
        }
        */
        
        // #19
        /*
        LLNode<Integer> orderedAdd = insertOrdered(16, topNode);
        System.out.println(orderedAdd.getInfo());
        while(orderedAdd.getLink() != null) {
            orderedAdd = orderedAdd.getLink();
            System.out.println(orderedAdd.getInfo());
        }
        */
    }
    
    // #16
    public static int numEvens(LLNode<Integer> list) {
        int isEven = 0; // 0 = not even (doesn't increase # of evens) 1 = even (increases total # by 1)
        if (list.getInfo() % 2 == 0) {
            isEven = 1;
        }
        if (list.getLink() == null) { 
            return isEven;
        } else {
            return isEven + numEvens(list.getLink());
        }
    }

    // #17
    public static boolean contains(int target, LLNode<Integer> list) {
        boolean contains = false;
        if (list.getInfo() == target) {
            contains = true;
        }
        if (list.getLink() == null) {
            return contains;
        } else {
            return (contains || contains(target, list.getLink()));
        }
    }

    // #18
    public static LLNode<Integer> remove(int target, LLNode<Integer> list) {
        if (list == null) {
            return null;
        } 
        LLNode<Integer> post = remove(target, list.getLink());
        if (list.getInfo() != target) {
            list.setLink(post);
            return list;
        }
        return post;
    }

    // #19
    public static LLNode<Integer> insertOrdered(int target, LLNode<Integer> list) {
        if (list == null) {
            return new LLNode<Integer>(target);
        } else if (list.getInfo() <= target) {
            LLNode<Integer> inserted = new LLNode<Integer>(target);
            inserted.setLink(list);
            return inserted;
        } else {
            list.setLink(insertOrdered(target, list.getLink()));
            return list;
        }
    }
}
