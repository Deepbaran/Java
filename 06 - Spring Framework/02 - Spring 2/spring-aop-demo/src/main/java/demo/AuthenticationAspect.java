package demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAspect {

    //Execute the authenticatingPointCut for all the methods available in all the classes in demo package
    @Pointcut("within(demo..*)")
    public void authenticatingPointCut() {
    }

    //Execute the authorizationPointCut for all the methods available in all the classes in demo package
    @Pointcut("within(demo..*)")
    public void authorizationPointCut() {
    }

    //Call both authenticatingPointCut and authorizationPointCut
    @Before("authenticatingPointCut() && authorizationPointCut()")
    public void authenticate() {
        System.out.println("Authenticating the Request");
    }
}
