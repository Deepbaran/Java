package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* demo.ShoppingCart.checkout(..))")
    public void beforeLogger(JoinPoint jp) {
        //Before calling demo.ShoppingCart.checkout() method (irrespective of the return type, hence the *) and with any number of parameters (hence the ..),
        //we want to call demo.LoggingAspect.logger() method.
        System.out.println(jp.getSignature());
        String arg = jp.getArgs()[0].toString();
        System.out.println("Before Logger with Argument: " + arg);
    }

    //execution(* *.*.checkout(..)) -> execute for anyReturnType anyPackage.anyClass.checkout() method with any number of parameters
    //.. -> Match any number of parameters
    @After("execution(* *.*.checkout(..))")
    public void afterLogger() {
        System.out.println("After Logger");
    }

    @Pointcut("execution(* demo.ShoppingCart.quantity(..))")
    public void afterReturningPointCut() {
        //This pointcut has to be executed at all quantity methods with any arguments inside the ShoppingCart class, inside the demo package with any return type
    }

    @AfterReturning(pointcut = "afterReturningPointCut()",
    returning = "retVal")
    public void afterReturning(String retVal) {
        System.out.println("After Returning: " + retVal);
    }
}
