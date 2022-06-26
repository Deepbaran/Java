public class Director {
    Burger burger;

    public Director(Burger burger) {
        this.burger = burger;
    }

    public void order(boolean cheese, boolean ketchup) {
        if(cheese) {
            this.burger.addCheese();
        }
        if(ketchup) {
            this.burger.addKetchup();
        }
    }
}