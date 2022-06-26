public class VegBurger implements Burger {
    VegBurger vegBurger;
    boolean cheese;
    boolean ketchup;

    public void addCheese() {
        this.cheese = true;
    }

    public void addKetchup() {
        this.ketchup = true;
    }

    public Burger getBurger() {
        return this;
    }
}