import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class CarLot extends ArrayList<Car> {

    CarLot() {
        //
    }

    public void addCar(String id, int mileage, int mpg, double cost, double salesPrice) {
        this.add(new Car(id, mileage, mpg, cost, salesPrice));
    }

    public Car findCarByIdentifier(String identifier) {
        for (Car car : this) {
            if (car.getId().equals(identifier)) {
                return car;
            }
        }
        return null;
    }

    public double getAverageMpg() {
        int totalMpg = 0;

        for (Car car : this) {
            totalMpg += car.getMpg();
        }

        return totalMpg / this.size();
    }

    public ArrayList<Car> getCarsSortedByMPG() {
        ArrayList<Car> sortedInventory = new ArrayList<Car>(this);

        for (int i = 0; i < sortedInventory.size(); i++) {
            int currentMinMpg = sortedInventory.get(i).getMpg();
            Car currentMinCar = sortedInventory.get(i);

            int currentMinIndex = i;

            for (int j = i + 1; j < sortedInventory.size(); j++) {
                if (currentMinMpg > sortedInventory.get(j).getMpg()) {
                    currentMinMpg = sortedInventory.get(j).getMpg();
                    currentMinCar = sortedInventory.get(j);
                }
            }

            if (currentMinIndex != i) {
                sortedInventory.set(currentMinIndex, sortedInventory.get(i));
                sortedInventory.set(i, currentMinCar);
            }
        }

        return sortedInventory;
    }

    public ArrayList<Car> getCarsInOrderOfEntry() {
        return this;
    }

    public Car getCarWithBestMPG() {
        int highestMpg = -1;
        Car carWithHighestMpg = new Car();

        for (Car car : this) {
            if (car.getMpg() > highestMpg) {
                highestMpg = car.getMileage();
                carWithHighestMpg = car;\
            }
        }

        return carWithHighestMpg;
    }

    public Car getCarWithBestMileage() {
        int highestMileage = -1;
        Car carWithHighestMileage = new Car();

        for (Car car : this) {
            if (car.getMileage() > highestMileage) {
                highestMileage = car.getMileage();
                carWithHighestMileage = car;
            }
        }

        return carWithHighestMileage;
    }

    public double getTotalProfit() {
        double totalProfit = 0;

        for (Car car : this) {
            totalProfit += car.getProfit();
        }

        return totalProfit;
    }

    public void sellCar(String identifier, double priceSold) throws IllegalArgumentException {
        Car carToSell = this.findCarByIdentifier(identifier);
        carToSell.sellCar(priceSold);
    }

    public ArrayList<Car> getInventory() {
        return this;
    }

    public void setInventory(ArrayList<Car> inventory) {
        int count = 0;
        for (Car car: this) {
            car = inventory.get(count);
            count++;
        }
    }

    public void saveToDisk() throws IOException {
        File csvFile = new File("carlot.csv");


        PrintWriter printer = new PrintWriter(csvFile);
        ArrayList<Car> cars = this;
        for (Car car: cars) {
            String line = car.getId() + "," + car.getMileage() + "," + car.getMpg() + "," + car.getCost() + "," + car.getSalesPrice();
            printer.println(line);
        }

        printer.close();
        System.out.println("File Saved");
    }

    public ArrayList<Car> loadFromDisk() {

        this.clear();
        try {
            File file = new File("carlot.csv");
            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] lineArray = line.split(",", 5);
                String id = lineArray[0];
                int mileage = Integer.parseInt(lineArray[1]);
                int mpg = Integer.parseInt(lineArray[2]);
                double cost = Double.parseDouble(lineArray[3]);
                double salesPrice = Double.parseDouble(lineArray[4]);
                Car car = new Car(id, mileage, mpg, cost, salesPrice);
                this.add(car);
            }
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Inventory loaded from disk: " + this.toString());

        return this;
    }

}
