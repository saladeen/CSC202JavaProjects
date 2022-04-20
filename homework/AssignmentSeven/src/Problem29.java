import java.util.Scanner;


public class Problem29 {
    public static void main(String[] args) {
        // User enters a list of countries, puts them in SortedABList, prints list + count, no duplicates
        Scanner sc = new Scanner(System.in);
        ABList<String> countries = new ABList<String>();
        while(true) {
            System.out.println("Enter a country you've visited. Type exit to exit. No duplicates");
            String input = sc.next();
            if(countries.contains(input)) {
                System.out.println("Duplicate country, not adding");
            } else if(input.equals("exit")) {
                break;
            }
             else {
                countries.add(input);
            }
        }
        System.out.println("You've visited " + countries.size() + " countries: " + countries);
        sc.close();
    }
}
