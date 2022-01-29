public class ShoppingBag {
    private int numberOfItems;
    private double totalCost;
    private double taxRate;

    public ShoppingBag(int items, double cost, double tax) {
        numberOfItems = items;
        totalCost = cost;
        taxRate = tax;
    }

    public void place(int itemsNum, double costPer) {
        numberOfItems += itemsNum;
        totalCost += itemsNum * costPer;
    }

    public String toString() {
        return "Items in bag: " + numberOfItems + "\nSubtotal: " + totalCost + "\nTotal with tax: " + totalCost * (1.0 + taxRate);
    }
}
