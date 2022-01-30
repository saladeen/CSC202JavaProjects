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
