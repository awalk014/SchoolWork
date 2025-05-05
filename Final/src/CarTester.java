public class CarTester {
    public static void main(String[] args) {
        try {
            Car carOne = new Car();
            Car carTwo = new Car("carTwo", 5000, 25, 35000.50, 40000.50);

            carOne.sellCar(37000.50);
            carTwo.sellCar(37000.50);

            System.out.println(carOne.compareMPG(carTwo));
            System.out.println(carOne.compareMiles(carTwo));
            System.out.println(carOne.comparePrice(carTwo));

            System.out.println(carTwo.compareMPG(carOne));