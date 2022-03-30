import java.util.Iterator;

public class TestIterator {
    public static void main(String[] args) {
        String[] words = {"a","bunch","of","words","test"};
        ABList<String> list = new ABList<String>();
        for (String i: words) {
            list.add(i);
        }
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
        // doesn't change representation
        System.out.println("\n" + list);

        Iterator<String> iter2 = list.iterator();
        System.out.println(iter2.next());
        iter2.remove();
        //changes underlying list
        System.out.println("\n" + list);
    }
}
