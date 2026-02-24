// Car Rental Management System

class Car {

    String carModel;
    int rentPerDay;
    int daysRented;

    // Parameterized Constructor
    Car(String carModel, int rentPerDay, int daysRented) {
        this.carModel = carModel;
        this.rentPerDay = rentPerDay;
        this.daysRented = daysRented;
    }

    // Calculate Total Rent (Before Discount)
    int calculateTotalRent() {
        return rentPerDay * daysRented;
    }

    // Calculate Discount
    double calculateDiscount() {

        double totalRent = calculateTotalRent();

        if (daysRented > 15) {
            return totalRent * 0.10;   // 10% discount
        } 
        else if (daysRented > 7) {
            return totalRent * 0.05;   // 5% discount
        } 
        else {
            return 0;
        }
    }

    // Calculate Final Payable Amount
    double calculateFinalPayment() {
        return calculateTotalRent() - calculateDiscount();
    }

    // Display Car Rental Details
    void displayDetails() {

        System.out.println("=================================");
        System.out.println("Car Model        : " + carModel);
        System.out.println("Rent Per Day     : Rs. " + rentPerDay);
        System.out.println("Days Rented      : " + daysRented);
        System.out.println("Total Rent       : Rs. " + calculateTotalRent());
        System.out.printf("Discount         : Rs. %.2f\n", calculateDiscount());
        System.out.printf("Final Payment    : Rs. %.2f\n", calculateFinalPayment());
        System.out.println("=================================\n");
    }
}

// Main Class
public class task05 {

    public static void main(String[] args) {

        System.out.println("===== CAR RENTAL MANAGEMENT SYSTEM =====\n");

        Car[] cars = new Car[5];

        cars[0] = new Car("Toyota", 3000, 5);
        cars[1] = new Car("Honda", 3500, 10);
        cars[2] = new Car("BMW", 8000, 20);
        cars[3] = new Car("Kia", 2500, 8);
        cars[4] = new Car("Audi", 9000, 3);

        Car highestIncomeCar = cars[0];

        for (Car car : cars) {

            car.displayDetails();

            if (car.calculateFinalPayment() > highestIncomeCar.calculateFinalPayment()) {
                highestIncomeCar = car;
            }
        }

        System.out.println("******** HIGHEST RENTAL INCOME ********");
        System.out.println("Car Model  : " + highestIncomeCar.carModel);
        System.out.printf("Income     : Rs. %.2f\n", highestIncomeCar.calculateFinalPayment());
        System.out.println("***************************************");
    }
}