public class DriverBasicPair {
    public static void main(String[] args) {
        PairInterface<String> testPair = new BasicPair<String>("apple", "banana");
        System.out.println(testPair.getFirst());
        System.out.println(testPair.getSecond());
        testPair.setSecond("kiwi");
        System.out.println(testPair.getSecond());
    }
}