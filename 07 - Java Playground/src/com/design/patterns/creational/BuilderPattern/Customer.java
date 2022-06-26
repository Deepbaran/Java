public class Customer {
    public void main() {
        NonVegBurger nonVegBurger = new NonVegBurger();
        Director director = new Director(nonVegBurger);
        director.order(false, true);

        Burger burger = nonVegBurger.getBurger();
    }
}