public class Problem8TestDriver {
    public static void main(String[] args) {
        String[] items = {"foo", "bar", "baz", "lol", "name", "item", "lol", "dank"};
        ArrayCollection<String> coll = new ArrayCollection<String>();
        for (String word: items) {
            coll.add(word);
        }
        System.out.println(coll);
        System.out.println(coll.count("lol"));
        coll.removeAll("lol");
        System.out.println(coll);
        System.out.println(coll.count("lol"));
        
        String[] newItems = {"more", "words", "to", "add"};
        for (String word: newItems) {
            coll.add(word);
        }
        ArrayCollection<String> coll2 = new ArrayCollection<String>();
        ArrayCollection<String> combinedColl = coll.combine(coll2);
        System.out.println(combinedColl);
    }
}
