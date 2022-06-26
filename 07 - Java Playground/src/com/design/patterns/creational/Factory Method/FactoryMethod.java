public class FactoryMethod {
    private Factory teacherFactory = new Factory();

    public void period(String period) {
        if(period == null) {
            System.out.println("Off Period");
        } else {
            teacherFactory.getTeacher(period);
        }
    }
}

class Factory {
    public Teacher getTeacher(String teacher) {
        if(teacher.equals("English")) {
            return new EnglishTeacher();
        } else if(teacher.equals("Math")) {
            return new MathTeacher();
        }
        return null;
    }
}

interface Teacher {
    public void teach();
}

class EnglishTeacher implements Teacher {
    public Teacher teach() {
        System.out.println("Teaching English");
    }
}

class MathTeacher implements Teacher {
    public Teacher teach() {
        System.out.println("Teaching Math");
    }
}