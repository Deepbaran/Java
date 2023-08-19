package demo;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
//@Scope(scopeName = "singleton") //Singleton by default
@Scope(scopeName = "prototype")
public class Doctor implements Staff, BeanNameAware {

    // To inject the properties we can either use the xml config or annotations.
    // But for injecting we must have getters and setters of that property.
    private String qualification;

//    public Doctor(String qualification) {
//        // When injecting constructor arguments in the Bean, getter-setter are not needed
//        this.qualification = qualification;
//    }

// Spring will instantiate the Nurse object once injected.
//    private Nurse nurse;

    public void assist() {
        System.out.println("Doctor is assisting");
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

//    public Nurse getNurse() {
//        return nurse;
//    }
//
//    public void setNurse(Nurse nurse) {
//        this.nurse = nurse;
//    }

    @Override
    public String toString() {
        return "Doctor{" +
                "qualification='" + qualification + '\'' +
                '}';
    }

    @Override
    public void setBeanName(String s) {
        // This is called just after all the properties are populated in the Bean after Bean creation
        System.out.println("Set Bean name method is called");
    }

    @PostConstruct // This is in the javax annotation api dependency
    public void postConstruct() {
        // This is a custom method in the Bean lifecycle
        //This will be called immediately after the Bean is created
        System.out.println("Post Construct Method is called");
    }
}
