public class Car {
    private String id;
    private int mileage;
    private int mpg;
    private double cost;
    private double salesPrice;
    private boolean sold;
    private double priceSold;
    private double profit;

    public Car() {
        this.id = "";
        this.mileage = 0;
        this.mpg = 0;
        this.cost = 0.0;
        this.salesPrice = 0.0;
    }

    public Car(String id, int mileage, int mpg, double cost, double salesPrice) {
        this.id = id;
        this.mileage = mileage;
        this.mpg = mpg;
        this.cost = cost;
        this.salesPrice = salesPrice;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMileage() {
        return this.mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getMpg() {
        return this.mpg;
    }

    public void setMpg(int mpg) {
        this.mpg = mpg;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getSalesPrice() {
        return this.salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public boolean isSold() {
        return this.sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public double getPriceSold() {
        return this.priceSold;
    }

    public void setPriceSold(double priceSold) {
        this.priceSold = priceSold;
    }

    public double getProfit() {
        return this.profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public int compareMPG(Car otherCar) {
        if (this.mpg < otherCar.mpg) {
            return -1;
        } else if (this.mpg > otherCar.mpg) {
            return 1;
        }
        return 0;
    }

    public int compareMiles(Car otherCar) {
        if (this.mileage < otherCar.mileage) {
            return -1;
        } else if (this.mileage > otherCar.mileage) {
            return 1;
        }
        return 0;
    }

    public int comparePrice(Car otherCar) {
        if (this.cost < otherCar.cost) {
            return -1;
        } else if (this.cost > otherCar.cost) {
            return 1;
        }
        return 0;
    }

    public void sellCar(double priceSold) {
        this.priceSold = priceSold;
        this.sold = true;
        this.profit = this.priceSold - this.cost;
    }

    public String toString() {
        return "Car: " + this.id + ", Mileage: " + this.mileage + ", MPG: " + this.mpg + ", Sold: "
                + (this.sold ? "Yes, " : "No, ") + "Cost: $" + this.cost + ", Selling price: $" + this.salesPrice
                + ", Sold for $" + this.priceSold + ", Profit: $" + this.profit;
    }
}