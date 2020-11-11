public class Chocolate extends CoffeeDecorator {
    private double cost = 1.00;
    public Chocolate(Coffee specialCoffee) {
        super(specialCoffee);
    }
    public double makeCoffee() {
        return specialCoffee.makeCoffee() + addChocolate();
    }

    private double addChocolate(){
        System.out.println((" + chocolate: $1.00"));
        return cost;
    }
}
