public class Factory {
    // Link -
    // https://www.educative.io/courses/software-design-patterns-best-practices/factory-method-pattern

    public Bird makeBird(String variant) {
        switch (variant) {
            case "avian":
                return new AvianBird();
            case "nonAvian":
                return new NonAvianBird();
            default:
                return new Bird();
        }
    }

}

class Bird {
    // Making it protected, so that the child classes can inherit it
    protected boolean fly;

    public boolean canFly() {
        return fly;
    }
}

class AvianBird extends Bird {
    public AvianBird() {
        fly = true;
    }

    public boolean canFly() {
        return fly;
    }
}

class NonAvianBird extends Bird {
    public AvianBird() {
        fly = false;
    }

    public boolean canFly() {
        return fly;
    }
}
