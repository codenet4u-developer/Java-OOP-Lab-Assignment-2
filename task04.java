// Electricity Bill Generator - Method Overloading

class Consumer {

    String name;
    int unitsConsumed;

    // Constructor
    Consumer(String name, int unitsConsumed) {
        this.name = name;
        this.unitsConsumed = unitsConsumed;
    }

    // Method 1: Domestic Consumer (Slab Based)
    double calculateBill() {

        double billAmount;

        if (unitsConsumed <= 100) {
            billAmount = unitsConsumed * 10;
        } 
        else if (unitsConsumed <= 300) {
            billAmount = (100 * 10) + ((unitsConsumed - 100) * 15);
        } 
        else {
            billAmount = (100 * 10) + (200 * 15) + ((unitsConsumed - 300) * 25);
        }

        return billAmount;
    }

    // Method 2: Commercial Consumer (Overloaded Method)
    double calculateBill(double commercialRate) {
        return unitsConsumed * commercialRate;
    }

    // Display Bill
    void displayBill(double billAmount, String consumerType) {

        System.out.println("=================================");
        System.out.println("Consumer Name   : " + name);
        System.out.println("Units Consumed  : " + unitsConsumed);
        System.out.println("Consumer Type   : " + consumerType);
        System.out.printf("Total Bill      : Rs. %.2f\n", billAmount);
        System.out.println("=================================\n");
    }
}

// Main Class
public class task04 {

    public static void main(String[] args) {

        System.out.println("===== ELECTRICITY BILLING SYSTEM =====\n");

        // Create Consumers
        Consumer consumer1 = new Consumer("Ali", 80);
        Consumer consumer2 = new Consumer("Babar", 250);
        Consumer consumer3 = new Consumer("Haris", 400);

        // Domestic Billing
        System.out.println("----- Domestic Consumers -----\n");

        double bill1 = consumer1.calculateBill();
        consumer1.displayBill(bill1, "Domestic");

        double bill2 = consumer2.calculateBill();
        consumer2.displayBill(bill2, "Domestic");

        // Commercial Billing (Using Overloaded Method)
        System.out.println("----- Commercial Consumer -----\n");

        double bill3 = consumer3.calculateBill(30.0);
        consumer3.displayBill(bill3, "Commercial");

        System.out.println("===== BILLING PROCESS COMPLETED =====");
    }
}