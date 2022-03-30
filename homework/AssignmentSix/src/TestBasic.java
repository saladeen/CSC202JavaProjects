public class TestBasic {
    public static void main(String[] args) {
        String[] words = {"a","bunch","of","words","test"};
        ABList<String> list = new ABList<String>();
        for (String i: words) {
            list.add(i);
        }
        System.out.println(list);
        list.remove("a");
        System.out.println(list);
        if (list.contains("words")) {
            System.out.println("Contains the word: words");
        }
        System.out.println(list.get("of"));
        System.out.println(list.size());
    }
}
