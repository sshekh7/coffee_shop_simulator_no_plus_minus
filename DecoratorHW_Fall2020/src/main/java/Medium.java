public class Medium extends CoffeeDecorator{
    private double cost = 1.50;

    public Medium(Coffee specialCoffee) {
        super(specialCoffee);
    }

    public double makeCoffee() {
        return specialCoffee.makeCoffee() + addShot();
    }

    private double addShot() {
        System.out.println(" + medium coffee: $1.50");
        return cost;
    }
}
