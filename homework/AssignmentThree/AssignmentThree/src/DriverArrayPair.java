public class DriverArrayPair {
    public static void main(String[] args) {
        PairInterface<String> pair = new ArrayPair<String>(String.class, "foo", "bar"); 
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
        pair.setSecond("baz");
        System.out.println(pair.getSecond());
    }
}
