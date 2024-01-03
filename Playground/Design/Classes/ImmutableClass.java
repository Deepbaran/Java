public class ImmutableClass {
    /*
     * 1. Declare the class as final so it can’t be extended.
     * 2. Make all fields private so that direct access is not allowed.
     * 3. Don’t provide setter methods for variables.
     * 4. Make all mutable fields final so that its value can be assigned only once.
     * 5. Initialize all the fields via a constructor performing deep copy.
     * 6. Perform cloning of objects in the getter methods to return a copy rather
     * than returning the actual object reference.
     * 7. in Java override equals(), hashcode() and toString() as well
     */
}
