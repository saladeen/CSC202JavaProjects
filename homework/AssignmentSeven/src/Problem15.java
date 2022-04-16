import java.util.Iterator;

public class Problem15 {
    public static void main(String[] args) {
        
    }

    public static int compare(ListInterface<String> list1, ListInterface<String> list2) {
        // returns count of elements common to both lists
        // iterate through list1
        // can't use contains() because thats an ABList method not ListInterface-defined one
        Iterator<String> iter = list1.iterator();
        int count = 0;
        while (iter.hasNext()) {
            if(list2.contains(iter.next()))
        }
    }
}
