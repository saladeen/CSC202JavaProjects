public class Problem30TestDriver {
    public static void main(String[] args) {
        String[] words = {"a", "set", "of", "various", "words", "in", "a", "list", "format"};
        LinkedCollection<String> linkedColl = new LinkedCollection<String>();
        for (String w: words) {
            linkedColl.add(w);
        }
        System.out.println(linkedColl);
        System.out.println(linkedColl.count("a"));
        linkedColl.removeAll("a");
        System.out.println(linkedColl);

        String[] words2 = {"some", "more", "things"};
        LinkedCollection<String> coll2 = new LinkedCollection<String>();
        for (String w: words2) {
            coll2.add(w);
        }
        LinkedCollection<String> combinedColl = linkedColl.combine(coll2);
        System.out.println(combinedColl);
        
    }
}
