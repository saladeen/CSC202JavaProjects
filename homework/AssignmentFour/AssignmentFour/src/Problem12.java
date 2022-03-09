import java.util.Arrays;

public class Problem12 {
    static int[] values = {7, 2, 3, 8, 3, 9};

    public static int smallestValue(int first) {
        // consider passing it index 5, base case: just returns values[first]
        // this happens when first = last position of array
        // then we start propagating back up with the value of the array instead of the index
        if (first == values.length - 1) {
            return values[first];
        } else {
            return Math.min(values[first], smallestValue(first+1));
        }
        
        
    }
    public static void main(String[] args) {
        System.out.println(smallestValue(0)); 
    }
}
