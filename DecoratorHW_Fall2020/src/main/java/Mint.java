public class Mint extends CoffeeDecorator{
    private double cost = .50;
    public Mint(Coffee specialCoffee) {
        super(specialCoffee);
    }

    public double makeCoffee() {
        return specialCoffee.makeCoffee() + addMint();
    }

    private double addMint(){
        System.out.println(" + mint: $.50");
        return cost;
    }
}
