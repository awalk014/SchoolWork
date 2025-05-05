public class CarLotTester {
    public static void main(String[] args) {
        try {
            CarLot newCarLot = new CarLot();
            newCarLot.addCar("carID#1", 5000, 25, 35000.50, 40000.50);
            newCarLot.addCar("carID#2", 7000, 35, 40000.50, 45000.50);
            newCarLot.addCar("carID#3", 12000, 100, 55000.99, 62750.00);
            newCarLot.sellCar("carID#1", 37000.50);

            System.out.println(newCarLot.getAverageMpg());
            System.out.println(newCarLot.getTotalProfit());
            System.out.println(newCarLot.findCarByIdentifier("carID#1"));
            System.out.println(newCarLot.getCarWithBestMPG());
            System.out.println(newCarLot.getCarWithBestMileage());
            System.out.println(newCarLot.getCarsSortedByMPG());
            System.out.println(newCarLot.getCarsInOrderOfEntry());

            newCarLot.saveToDisk();


            CarLot secondCarLot = new CarLot();

            secondCarLot.loadFromDisk();

            System.out.println(secondCarLot.getAverageMpg());
            System.out.println(secondCarLot.getTotalProfit());
            System.out.println(secondCarLot.findCarByIdentifier("carID#1"));
            System.out.println(secondCarLot.getCarWithBestMPG());
            System.out.println(secondCarLot.getCarWithBestMileage());
            System.out.println(secondCarLot.getCarsSortedByMPG());
            System.out.println(secondCarLot.getCarsInOrderOfEntry());

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
