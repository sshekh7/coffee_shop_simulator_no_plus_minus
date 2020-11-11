public class Large extends CoffeeDecorator{
    private double cost = 1.75;

    public Large(Coffee specialCoffee) {
        super(specialCoffee);
    }

    public double makeCoffee() {
        return specialCoffee.makeCoffee() + addShot();
    }

    private double addShot() {
        System.out.println(" + large coffee: $1.75");
        return cost;
    }
}
