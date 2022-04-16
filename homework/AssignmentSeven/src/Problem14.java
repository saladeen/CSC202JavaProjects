public class Problem14 {
    public static void main(String[] args) {
        ListInterface<String> list = new ABList<String>();
        String[] words = {"a","bunch","of","words","test"};
        for (int i=0; i<words.length; i++) {
            list.add(i, words[i]);
        }
        System.out.println(last(list));

        ListInterface<String> list2 = new ABList<String>();
        System.out.println(last(list2));
    }

    public static String last(ListInterface<String> list) {
        if (list.size() == 0)
            return null;
        else
            return list.get(list.size() - 1);
    }
}
