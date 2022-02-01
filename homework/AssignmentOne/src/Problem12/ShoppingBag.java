package Problem12;
import java.util.Scanner;

public class ShoppingBag {
    private int numberOfItems;
    private double totalCost;
    private double taxRate;

    public ShoppingBag(double tax) {
        numberOfItems = 0;
        totalCost = 0.0;
        taxRate = tax;
    }

    public void place(int itemsNum, double costPer) {
        numberOfItems += itemsNum;
        totalCost += itemsNum * costPer;
    }

    public String toString() {
        return "Items in bag: " + numberOfItems + "\nSubtotal: " + totalCost + "\nTotal with tax: " + getTotal();
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public double getSubtotal() {
        return totalCost;
    }

    public double getTotal() {
        return totalCost * (1 + taxRate);
    }
}

class ShoppingBagDriver {
    public static void main(String[] args) {
        ShoppingBag bag = new ShoppingBag(0.06); //tax = 6%
        int count = 1;
        Scanner sc  = new Scanner(System.in);

        while(count != 0) {
            System.out.println("Enter count (use 0 to stop):");
            count = sc.nextInt();
            System.out.println("Enter cost: ");
            double cost = sc.nextDouble();
            bag.place(count, cost);
        }
        System.out.println(bag.toString());
        sc.close();
    }
}