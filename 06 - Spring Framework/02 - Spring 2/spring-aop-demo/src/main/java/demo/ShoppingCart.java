package demo;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {

    public void checkout(String status) {
        //With AOP, we need to separate out the below cross-cutting concerns (Aspects):
        //Logging
        //Authentication & Authorization
        //Sanitization (Sanitize the data)
        System.out.println("Checkout Method from ShoppingCart Called!");
    }

    public int quantity() {
        return 2;
    }
}
