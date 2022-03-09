public class Problem13 {
    public static void main(String[] args) {
        System.out.println(reverseString("RECURSE"));
    }

    public static String reverseString(String current_substring) {
        //base case: string is sliced until length 1, there, just return current_substring as it's only 1 character
        if (current_substring.length() == 1) {
            System.err.println("Reached base case");
            return current_substring;
        } else {
            System.out.println("Calling reverseString on " + current_substring.substring(1) + ", adding " + current_substring.substring(0, 1) + " to the end");
            return reverseString(current_substring.substring(1)) + current_substring.substring(0, 1);
        }
        // in return statement, string is continually sliced into smaller strings starting at the 2nd index, these are put through reverse. At the END, because it's being reversed,
        // the substring of the current spot (just 1 character) is added to the rest of the string being reversed
    }
    //Not sure how to show 13b., just added some prints
}
