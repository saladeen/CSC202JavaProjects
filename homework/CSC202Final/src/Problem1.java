
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first line: ");
        String[] first = sc.nextLine().split(" ");
        System.out.println("Enter the second line: ");
        String[] second = sc.nextLine().split(" ");
        // union, difference, intersection in ascending alphabetical order
        //SortedArrayCollection<String> test = new SortedArrayCollection<String>();
        String[] union = union(first, second);
        String[] difference = difference(first, second);
        String[] intersection = intersection(first, second);
        System.out.println("The union is: ");
        print(union);
        System.out.println("The difference is:");
        print(difference);
        System.out.println("The intersection is:");
        print(intersection);
        sc.close();
    }

    public static void print(String[] arr) {
        for (String word: arr) {
            System.out.println(word);
        }
    }


    public static String[] union(String[] first, String[] second) {
        String[] union = new String[first.length + second.length];
        int i=0;
        while(i<first.length) {
            union[i] = first[i];
            i++;
        }
        while(i<first.length + second.length) {
            union[i] = second[i-first.length];
            i++;
        }
        Arrays.sort(union);
        return union;
    }

    public static String[] difference(String[] first, String[] second) {
        // in the first set but not the second set
        List<String> secondList = Arrays.asList(second);
        List<String> differenceList = new ArrayList<String>();
        for (int i=0; i<first.length; i++) {
            if (!secondList.contains(first[i])) {
                differenceList.add(first[i]);
            }
        }
        String[] returnArray = new String[differenceList.size()];
        for (int i=0; i<differenceList.size(); i++) {
            returnArray[i] = differenceList.get(i);
        }
        Arrays.sort(returnArray);
        return returnArray;
    }

    public static String[] intersection(String[] first, String[] second) {
        List<String> secondList = Arrays.asList(second);
        List<String> intersectionList = new ArrayList<String>();
        for (int i=0; i<first.length; i++) {
            if (secondList.contains(first[i])) {
                intersectionList.add(first[i]);
            }
        }
        String[] returnArray = new String[intersectionList.size()];
        for (int i=0; i<intersectionList.size(); i++) {
            returnArray[i] = intersectionList.get(i);
        }
        Arrays.sort(returnArray);
        return returnArray;
    }
}
