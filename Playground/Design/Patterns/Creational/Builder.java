public class Builder {
    // Link -
    // https://www.educative.io/courses/software-design-patterns-best-practices/builder-pattern

    public static void main(String[] args) {
        Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirBags(4).build(); // build function returns the
                                                                                     // Vehicle object with all the
                                                                                     // properties set to VehicleBuilder
                                                                                     // where Airbags is set
        System.out.println(car.getEngine());
        System.out.println(car.getWheel());
        System.out.println(car.getAirbags());
    }
}

class Vehicle {
    // requied parameter
    private String engine;
    private int wheel;

    // Optional parameter
    private int airbags;

    public String getEngine() {
        return engine;
    }

    public int getWheel() {
        return wheel;
    }

    public int getAirbags() {
        return airbags;
    }

    private Vehicle(VehicleBuilder builder) {
        this.engine = builder.engine;
        this.wheel = builder.wheel;
        this.airbags = builder.airbags;
    }

    public static class VehicleBuilder {
        private String engine;
        private int wheel;

        private int airbags;

        public VehicleBuilder(String engine, int wheel) {
            this.engine = engine;
            this.wheel = wheel;
        }

        public VehicleBuilder setAirBags(int airbags) {
            this.airbags = airbags;
            // return this object once airbags is set
            return this;
        }

        public Vehicle build() {
            // A object of Vehicle instantiated with this VehicleBuilder class is returned
            return new Vehicle(this);
        }
    }
}