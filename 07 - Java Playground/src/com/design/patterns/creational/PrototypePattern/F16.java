public class F16 implements IAircraftPrototype {
    F16Engine f16Engine = new F16Engine();

    public void fly() {
        System.out.println("F-16 Flying...");
    }

    public IAircraftPrototype clone() {
        return F16();
    }

    public void setF16Engine(F16Engine f16Engine) {
        this.f16Engine = f16Engine;
    }
}