import java.io.IOException;
import java.util.Scanner;

public class CarLotMain {
    public CarLotMain() {
    }

    public static void main(String[] args) {
        CarLot carLot = new CarLot();

        Scanner input = new Scanner(System.in);

        int option;

        do {
            System.out.println("\n[0] Exit");
            System.out.println("[1] Add a car to inventory");
            System.out.println("[2] Sell a car from inventory");
            System.out.println("[3] List inventory by order of acquisition");
            System.out.println("[4] List Inventory From Best MPG to Worst MPG");
            System.out.println("[5] Display car with best MPG");
            System.out.println("[6] Display car with the highest mileage");
            System.out.println("[7] Display overall MPG for the entire inventory");
            System.out.println("[8] Display profit for all sold cars");
            System.out.println("[9] Save to Disk");
            System.out.println("[10] Load from Disk\n");

            System.out.print("Enter a number from 0 to 10: ");
            option = input.nextInt();

            // My enhancement is to change the if, else-if chain into a switch statement to simplify reading the code

            switch (option) {
                case 0: {
                    break;
                }

                case 1: {
                    System.out.print("Enter an Identifier. This must be a String that describes the car: ");
                    String newCarIdentifier = input.next();

                    System.out.print("Enter the Mileage. The current mileage on the car: ");
                    int newCarMileage = input.nextInt();

                    System.out.print("Enter the MPG. The Car's MPG rating: ");
                    int newCarMpg = input.nextInt();

                    System.out.print("Enter the Cost. The amount that the dealer paid for the car: ");
                    double newCarCost = input.nextDouble();

                    System.out.print("Enter the Sales Price. The asking price for the Car: ");
                    double newCarSalesPrice = input.nextDouble();

                    carLot.addCar(newCarIdentifier, newCarMileage, newCarMpg, newCarCost, newCarSalesPrice);

                    System.out.println("Car " + newCarIdentifier + " has been added to inventory!");
                }

                case 2: {
                    System.out.print("Enter identifier of car to sell: ");
                    String carIdentifier = input.next();

                    Car carToSell = carLot.findCarByIdentifier(carIdentifier);

                    if (carToSell != null) {
                        carToSell.sellCar(carToSell.getCost());
                        System.out.println("Car " + carIdentifier + " has been sold!");
                    } else {
                        System.out.println("Car " + carIdentifier + " does not exist!");
                    }
                }

                case 3: {
                    System.out.println(carLot.getCarsInOrderOfEntry());
                }

                case 4: {
                    System.out.println(carLot.getCarsSortedByMPG());
                }

                case 5: {
                    System.out.println(carLot.getCarWithBestMPG());
                }

                case 6: {
                    System.out.println(carLot.getCarWithBestMileage());
                }

                case 7: {
                    System.out.println(carLot.getAverageMpg());
                }

                case 8: {
                    System.out.println(carLot.getTotalProfit());
                }

                case 9: {
                    try {
                        carLot.saveToDisk();
                    } catch (IOException e) {
                        System.out.println("Count save the inventory to file: " + e.getMessage());
                    }
                }

                case 10: {
                    try {
                        carLot.loadFromDisk();
                    } catch (Exception e) {
                        System.out.println("Couldn't load the file: " + e.getMessage());
                    }
                }
            }

        } while (option >= 1 && option <= 10);

        input.close();
    }
}
