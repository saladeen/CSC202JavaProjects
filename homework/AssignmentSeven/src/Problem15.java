import java.util.Iterator;

public class Problem15 {
    public static void main(String[] args) {
        ListInterface<String> testList = new ABList<String>();
        ListInterface<String> testList2 = new ABList<String>();
        String[] words = {"some", "words", "in", "a", "string", "array"};
        String[] words2 = {"some", "more", "words", "test", "foo", "a"};
        for (int i=0; i<words.length; i++) {
            testList.add(i, words[i]);
            testList2.add(i, words2[i]);
        }
        System.out.println(compare(testList, testList2));
    }

    public static int compare(ListInterface<String> list1, ListInterface<String> list2) {
        // returns count of elements common to both lists
        // iterate through list1
        // can't use contains() because thats an ABList method not ListInterface-defined one
        Iterator<String> iter = list1.iterator();
        int count = 0;
        while (iter.hasNext()) {
            String n = iter.next();
            for (int i=0; i<list2.size(); i++) {
                if (list2.get(i).equals(n)) {
                    count++;
                }
            }
        }
        return count;
    }
}
