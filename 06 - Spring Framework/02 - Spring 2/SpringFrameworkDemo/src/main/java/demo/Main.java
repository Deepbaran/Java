package demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //ApplicationContext extends BeanFactory
        //So, there are more features in the ApplicationContext

        //This needs XML configuration in the resources
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("spring.xml");

        // Java based Configuration
        ApplicationContext context =
                new AnnotationConfigApplicationContext(BeanConfig.class); //BeanConfig class defines the configurations of our annotations


        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        Doctor doctor = new Doctor();
        //Creating doctor bean using Spring XML configuration
//        Doctor doctor = context.getBean(Doctor.class);
//        Doctor doctor = (Doctor) context.getBean("doctor"); //We can get the bean with the bean id also. But we will need to cast it

//        Nurse nurse = context.getBean(Nurse.class);
//        Nurse nurse = (Nurse) context.getBean("nurse");

//        doctor.assist();
//        nurse.assist();

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Decoupling objects
//        Staff staff = context.getBean(Doctor.class);
//        Staff staff = context.getBean(Nurse.class);
//
//        staff.assist();
//        System.out.println(staff.getQualification());

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        Doctor staff = context.getBean(Doctor.class);
//        staff.assist();
//        System.out.println(staff.getQualification());

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        Staff staff = context.getBean(Doctor.class);
//        staff.assist();

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Singleton Bean Scope
//        Doctor doctor = context.getBean(Doctor.class);
//        doctor.assist();
//        doctor.setQualification("MBBS");
//        System.out.println(doctor); //Doctor{qualification='MBBS'}
//
//        Doctor doctor1 = context.getBean(Doctor.class);
        // As the Doctor bean is of Singleton scope by default, so we have only one bean throughout the context.
        // So, doctor1 and doctor are the same bean
//        System.out.println(doctor1); //Doctor{qualification='MBBS'}

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Now, as we have set the Bean scope for Doctor as prototype, everytime we try to get a Bean from the container, we will get a new Doctor Bean
        // But for the @Scope to work as expected, that Bean must be annotated as a Component
//        Doctor doctor = context.getBean(Doctor.class);
//        doctor.assist();
//        doctor.setQualification("MBBS");
//        System.out.println(doctor); //Doctor{qualification='MBBS'}
//
//        Doctor doctor1 = context.getBean(Doctor.class);
//        System.out.println(doctor1); //Doctor{qualification='null'}

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Bean Lifecycle - BeanNameAware Interface usecase
        Doctor doctor = context.getBean(Doctor.class);
        doctor.assist();
        doctor.setQualification("MBBS");
        /*
        Set Bean name method is called
        Post Construct Method is called
        Doctor is assisting
         */
    }
}
