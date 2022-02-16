import java.security.SecureRandom;

public class FortySeven<T extends Comparable<T>> {
    public void selectionSort(T[] array) {
        int len = array.length;
        int comparisons = 0;
        int swaps = 0;
        for (int i=0; i < len-1; i++) {
            int smallest_index = i;
            for (int j=i+1; j < len; j++) {
                if (array[j].compareTo(array[smallest_index]) < 0) {
                    smallest_index = j;
                }
                comparisons++; // Comparison is run whether the if statement block is executed or not
            }
            
            T temp = array[smallest_index];
            array[smallest_index] = array[i];
            array[i] = temp;
            swaps++;
        }
        //printer(array);
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
    }

    public void printer(T[] array) {
        // 'print in columns of five'
        for(int i=0; i<array.length; i++) {
            System.out.print(array[i] + " ");
            if ((i+1)%5 == 0) {
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        int n = 1000;
        Integer arr[] = new Integer[n];
        SecureRandom srand = new SecureRandom();
        // Initialize with random numbers between 1 and 1000
        for (int i=0; i<arr.length; i++) {
            arr[i] = srand.nextInt(1000) + 1;
        }
        FortySeven<Integer> sorter = new FortySeven<Integer>();
        //sorter.printer(arr);
        sorter.selectionSort(arr);
        // With n=1000, swaps are 999 and comparisons are 499500
        // Swaps are in line with O(n)
        // Comparisons are in line with O(n^2), and follow the formula (n^2 - n)/2
    }
}

