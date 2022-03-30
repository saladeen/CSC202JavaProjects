public class TestIndexed {
    public static void main(String[] args) {
        String[] words = {"a","bunch","of","words","test"};
        ABList<String> list = new ABList<String>();
        for (String i: words) {
            list.add(i);
        }
        System.out.println(list);
        list.add(0, "this");
        System.out.println(list);
        list.set(3, "foo");
        System.out.println(list);
        System.out.println(list.get(2) + "\n");
        list.remove(0);
        System.out.println(list);

    }
}
