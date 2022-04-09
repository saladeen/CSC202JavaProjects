public class Problem31TestDriver {
    public static void main(String[] args) {
        char[] someChars = {'a','h','z','m','o','t','g','b','c','y'};
        SortedLinkedCollection<Character> sortColl = new SortedLinkedCollection<Character>();
        for (char c: someChars) {
            sortColl.add(c);
        }
        
    }
}
