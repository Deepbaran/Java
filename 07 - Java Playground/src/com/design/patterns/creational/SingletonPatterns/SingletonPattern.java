/*
Singleton - It ensures that there is only one instance/object of an Class is created.

When should we use Singleton Patterns:
1. Ensure that a class has only one instance.
2. Easily access the sole instance of a class.
3. Control it's instantiation.
4. Restrict the number of instances.
5. Acces a global variable.

How it works:
1. Hide the constructors of the class.
2. Define a public static operation (getInstance()) that returns the sole instance of the class.

In short, the singleton pattern forces it to be responsible for ensuring that it is only instantiated once. A hidden constructor,
declared private or protected, ensures that the class can never be instantiated  from outside the class.

----------------------------------------------------------------------
Common Uses:
1. The Abstract factory, Factory Method, Builder and Prototype patterns can use Singleton.
2. Facade objects are often singletons because only one facade object is required.
3. State objects are often singletons.
4. Singletons are often preferred to global variables because:
    a. They do not pollute the global namespace with unnecessary variables.
    b. They permit lazy allocation and initialization, whereas global variables in many languages will always consume resources.
5. Logging is a classic example of a singleton.

----------------------------------------------------------------------
Cons:
1. Singleton is considered as anti-pattern by many as it introduces global state into an application, often unnecessarily.
    This in turn can place potential restrictions on any abstraction that uses the singleton, for example by preventing
    concurrent use of multiple instances. Furthermore, because it is often exposed as a globally visible accessor, its presence
    complicate dependency analysis by introducing a potential dependency on the singleton in all code it is visible to, thus
    requiring analysis of implementation details to determine if a dependency actually exists.
2. Singletons also violates the Single-Responsibility Principle, because not only are they reponsible for singleton's normal task,
    it must also ensure that only one is instantiated.
3. Another drawback is that Singletons are difficult to test because they carry global state for the duration of the program.
    Specifically because unit testing required loosely coupled classes in order to isolate what's being tested. Additionally,
    when a certain class interacts with a singleton, that class and the singleton becomes tightly coupled, making it impossible
    to test the class on its own without also testing the singleton.
 */

public class SingletonPattern {
    private static final SingletonPattern INSTANCE = null;

    private SingletonPattern() {}

    public static SingletonPattern getInstance() {
        if(INSTANCE == null) {
                    INSTANCE = new SingletonPattern();
        }
        return INSTANCE;
    }
}