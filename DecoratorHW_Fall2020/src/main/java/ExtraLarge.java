public class ExtraLarge extends CoffeeDecorator{
    private double cost = 2.00;

    public ExtraLarge(Coffee specialCoffee) {
        super(specialCoffee);
    }

    public double makeCoffee() {
        return specialCoffee.makeCoffee() + addShot();
    }

    private double addShot() {
        System.out.println(" + extra large coffee: $2.00");
        return cost;
    }
}
