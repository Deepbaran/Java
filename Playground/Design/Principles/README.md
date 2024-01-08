## [Link](https://www.designgurus.io/blog/essential-software-design-principles-you-should-know-before-the-interview)

# SOLID:
- ### Single Responsibility Principle (SRP):
  - Each unit of code should only have one job or responsibility. A unit can be a class, module, function, or component. This keeps code modular and removes the risk of tight coupling.
- ### Open-Closed Principle (OCP):
  - Units of code should be open for extension but closed for modification. You should be able to extend functionality with additional code rather than modifying existing ones. This principle can be applied to component-based systems such as React frontend.
- ### Liskov Substitution Principle (LSP):
  - You should be able to substitute objects of a base class with objects of its subclass without altering the 'correctness' of the program.
  - For example, with a Bird base class, you might assume, it should have a 'fly' method. But what about the birds that can't fly? Like a penguin, in this example, having 'fly' method in the Bird class would violate LSP.
- ### Interface Segregation Principle (ISP):
  - Provide multiple interfaces with specific responsibilities rather than small set of general-purpose interfaces. Client shouldn't need to know about the methods & properites that don't relate to their use case.
    - Complexity ↓
    - Code Flexibility ↑
- ### Dependency Inversion Principle (DIP):
  - You should depend on abstractions, not on concrete classes. Use abstractions to decouple dependencies between different parts of the system.Direct calls between units of code shouldn't be done. Instead interfaces or abstractions should be used.