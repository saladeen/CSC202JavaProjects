public class ThirtyFive {
    public static void main(String[] args) {
        int arr[] = new int[10];
        for(int i=0; i<arr.length; i++) {
            arr[i] = i * i;
        }
        for (int j : arr) {
            System.out.println(j);
        } // idk why they want two loops
    }
}
