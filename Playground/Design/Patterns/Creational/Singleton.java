public class Singleton {
    // Link -
    // https://www.educative.io/courses/software-design-patterns-best-practices/singleton-pattern

    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }

    synchronized public static getUniqueInstance() {
        if(uniqueInstance == null) {
            synchronized(Singleton.class) {
                if(uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return singletonInstance;
    }
}
