++++++++++
Concepts:
++++++++++
==========
Structure for Developing Web Applications:
==========
> In a typical web application we have:
1. Web Layer: UI of the application (Frontend. e.g: Angular, Servlet, JSP)
2. Business Layer: Business Logic (Backend. e.g: Spring)
3. Data Layer: Interacts with external interfaces and the database (e.g: Hibernate, Spring Data, JDBC)

> When Business Layer needs some data from the database, it calls some method in the data layer. This means that the Business layer is DEPENDENT on the data layer.

> Similarly, if the user wants to store some data using the UI, then the Web Layer calls the Business Layer. So, the Web Layer is DEPENDENT on the Business Layer (or some class inside the Business Layer).

==========
Spring:
==========
> Beans: Instance of an object.

> POJO: Plain Old Java Object.

> Spring manages the dependencies, Injects the dependencies wherever they are needed and it manages the entire life-cycle of the beans. That is why it is called dependency management as far as beans are concerned.

> Spring does Dependency Management, Dependency Injection, Autowiring, etc.

> Spring Framework Instantiates the objects and populates the dependencies.

> The search that Spring does for the Components is called ComponentScan. The COmponents found during the ComponentScan will be turned into beans.

> Annotation: It is a tag that provides metadata for a class, interface, etc.

> @Component: This tells Spring which instances it needs to manage. Without this we will get NoSuchBeanDefinitionException.

> @ComponentScan(): Scan the specific package and it's sub-packages for @Component.

> @Autowired: It tells Spring to look for all the available instances that it manages using the @Component annotation and find the matching instances for the objcet with this annotation.
This is what internally happening:

			@Component
			public class ComplexBusinessService {
				@Autowired
				SortAlgorithm sortAlgorithm;
			}
			@Component
			public class BubbleSortAlgorithm implements SortAlgorithm {}
			
							|| - Translates to
			
			SortAlgorithm sortAlgorithm = new BubbleSortAlgorithm();
			ComplexBusinessService businessService = new ComplexBusinessService(sortAlgorithm);
			
Spring understands that sortAlgorithm is a dpenedency of ComplexBusinessService. Spring makes sure that all the instances it manages will be instantiated with all their dependencies properly populated.
Injecting the BubbleSortAlgorithm in the sortAlgorithm as dpenedency in ComplexBusinessService is called Dependency Injection.

> A Bean is created once all of its dependencies are found using ComponentScan and become Beans for Spring to manage. Only after this a Bean is created. If a dependency has a dependency of it's own then that dependency is made a Bean first.

> Spring Framework helps in creating Loosely coupled Applications.

> @SpringBootApplication: It is used for the class that has the main method. Spring will automatically do Component search, in the package and subpackages where it is present, for the beans. This initializes the Application Context.

> @Primary: This will make this component take precedence over other components when being Autowired by type.

> @Qualifier(""): Using this annotation we can give specific names to beans and then specify which bean to Autowire. This takes precedence over @Primary.

> If we do not define a particular bean (either through @Primary or @Qualifier("")) to use for dependency injection where two implementations are present, then Spring will throw Exception saying 2/3/4/.. beans are present for a single Dependency Injection.

> If we get NoSuchBeanDefinitionException, make sure we are using the right combination of @Component, @Primary and @Autowired.

> Previous convention was, all mandatory dependencies should be constructed using constructor injection. For all optional dependencies, use setter injection.

----------
Spring Modules:
----------
> Core Container:
1. Beans
2. Core
3. Context
4. SpEL
> Data Access/Integration:
1. JDBC
2. ORM [Object Relational Model]
3. OXM
4. JMS
5. Transactions
> Web:
1. WebSocket
2. Servlet
3. Web
4. Portlet
> AOP
> Aspects
> Instrumentation
> Messaging
> Test [SpringTest]

----------
Spring Projects:
----------
> Spring Boot [Quickly Build Applications]
> Spring Cloud [Build Cloud Native Apps]
> Spring Data [Consistent Data Access]
> Spring Integration [Application Integration]
> Spring Batch [Batch Applications]
> Spring Security [Protect Your Applications]
> Spring HATEOAS [HATEOAS Compatible Services]
> Others... [Spring Web Services, Spring Session, etc.]

----------
Spring Popularity:
----------
1. Enables Testable Code
2. No Plumbing Code
3. Flexible Architecture
4. Staying Current/Updated 

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

----------
Bean Scope:
----------
1. Singleton: One instance per Spring Context. This is default. No @Scope() means the Bean Scope is Singleton [@Scope("singleton") / @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)]

2. prototype: New bean whenever requested. [@Scope("prototype") / @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)]

3. request: One bean per HTTP request

4. session: One bean per HTTP session.

> If the bean is Singleton and the dependency is prototype, we will get the same instance of the dependency for all the instances of the bean. To get different instances of the dependency, we need to use "proxy". "proxy" will make sure that the dependency will get different instances everytime it is called. [@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode=ScopedProxyMode.TARGET_CLASS)]

> For getting different instances of the prototype dependency in a singleton bean, we need to use "proxy".

> Try to keep the number of instances/objects as minimum as possible.

> Spring Context Singleton Vs GOF (Gang Of Four) Singleton:
1. In GOF Singleton, it means ONE INSTANCE PER JVM. In Spring Context Singleton, it means ONE INSTANCE PER APPLICATION CONTEXT. There can be multiple Application Context in a JVM. So, there can be multiple Spring Context Singleton in a JVM but only one GOF Singleton.

----------
Bean LifeCycle Methods:
----------
> The entire lifecycle of a bean is managed by Spring. More specifically by IOC Container.

> Spring IOC Container creates beans that are with @Component and also make sure that it is destroyed once it is no longer needed. So, by default the entire LifeCycle of a bean is maintained by the Spring IOC Container.

> @PostConstruct: This would be executed as soon as the bean is created and initialized using the dependencies.

> @PreDestroy: This would be executed just before the bean is destroyed.

----------
CDI (Context and Dependency Injection):
----------
> Java EE Dependency Injection Standard (JSR-330)

> CDI tries to standardize the Dependency Injection and Context as part of the Java EE. CDI is like the interface that defines different annotations. CDI is the interface that shows how to do Dependency Injection (It is similar to JPA and Hibernate. JPA is an interface that shows how to do things and Hibernate is the implementation). CDI is the interface and Spring is the implementation.

> Spring Supports most annotations
	o @Inject (@Autowired)
	o @Named (@Component & @Qualifier)
	o @Singleton (Defines a scope of Singleton

> Maven Dependency:
<dependency>
	<groupId>javax.inject</groupId>
	<artifactId>javax.inject</artifactId>
	<version>1</version>
</dependency>

> CDI is just like JPA and Hibernate (JPA is the interface and Hibernate is the implementation. We can use JPA and later change the implementaion from Hibernate to something.). Similarly, the CDI is the interface and Spring is the implementation under the hood.

----------
Spring Core:
----------
> BeanFactory is defined inside the Spring Factory. The basic bean management is done inside Spring Core.

> Maven Dependency: [Remove the spring-boot dependency when using spring core.]
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-core</artifactId>
</dependency>

<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-context</artifactId>
</dependency>

> @Configuration: This is used to initialize the Application Context for Spring Core. [@SpringBootApplication is used to initialize Application Context for Spring Boot]. This defines that the Class is a Spring Configuration.

> Getting the Application Context:
 o Spring Boot:
	ApplicationContext applicationContext = 
			SpringApplication.run(<ApplicationClass>.class);
			
 o Spring Core:
	AnnotationConfigApplicationContext applicationContext = 
			new AnnotationConfigApplicationContext(<ApplicationClass>.class);
			
> @ComponentScan: Scans the current package and sub-packages for Components. Spring Core needs an explicit @ComponentScan. Spring Boot does the ComponentScan for the current package and sub-packages automatically.

> Unlike Spring Boot, we need to add the sl4j-api dependency to use Logger in Spring Core. Dependency:
<!--API-->
<dependency>
 	<groupId>org.slf4j</groupId>
	<artifactId>slf4j-api</artifactId>
</dependency>
		
<!--Implementation of the API-->
<dependency>
	<groupId>ch.qos.logback</groupId>
	<artifactId>logback-classic</artifactId>
</dependency>

----------
IOC Container vs Application Context vs Bean Factory:
----------
> The control of creating the dependency was with the bean itself. But with Spring, we are shifting that responsibility from the bean to Spring. This is called IOC. So, the control is shifting from the Component that needs the dependency to the Framework that is going to inject the dependency in the Component. The Program that causes this is called the IOC Container. IOC Container manages the beans, autowires them and injects dependencies. In Spring there are two implementations of the IOC Container. One is the Application Context (recommended) and the other is the Bean Factory.

> Beans are java objects that are configured at run-time by Spring IoC Container. BeanFactory represents a basic IoC container which is a parent interface of ApplicationContext. BeanFactory uses Beans and their dependencies metadata to create and configure them at run-time.

> Bean Factory has the Core Features of Spring (Spring Core). And Application Context has all that Bean Factory has with extra features. Apllication Context is Bean Factory++
	o Spring's AOP features
	o |18n capabilities
	o WebApplicationContext for web applications etc.
	
----------
@Component vs @Service vs @Repository vs @Controller:
----------
UI Layer --> Business Layer --> Data Layer

> @Component - Generic Component.
> @Repository - encapsulating storage, retrieval and search behavior typically from a relational database. (Data Layer)
> @Service - Business Service Facade. For Pure Business Logic. (Business Layer)
> @Controller - Controller in MVC pattern. For API end-points. (UI Layer)

> In Spring MVC, controller methods are the final destination point that a web request can reach. After being invoked, the controller method starts to process the web request by interacting with the service layer to complete the work that needs to be done.

> So, anything that is providing a Business Logic is @Service and anything that is talking to the database is @Repository

> @Repository, @Service, @Controller are Spring Framework Stereotypes that we can use inplace of @Component to better classify the functionality of the component. They are used in Spring AOP.

> Spring provides lots of Exception translation facility for @Repository.

> With the @Service we can easily log everything that comes in our Business layers.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

----------
Spring Test:
----------
> TO do test for a Spring project without spring boot, use these dependencies:
		<dependency>
	    	<groupId>org.springframework</groupId>
	    	<artifactId>spring-test</artifactId>
	    	<scope>test</scope>
	    </dependency>
	    
	    <dependency>
	    	<groupId>junit</groupId>
	    	<artifactId>junit</artifactId>
	    	<scope>test</scope>
	    </dependency>
	    
	    <dependency>
	    	<groupId>org.mockito</groupId>
	    	<artifactId>mockito-core</artifactId>
	    	<scope>test</scope>
	    </dependency>
		
> Try to avoid Spring Unit Test as much as possible and use JUnit and Mockito for Unit Tests.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

----------
Spring Boot:
----------
> To create REST APIs and Web Application, we will need the starter project WEB. It uses Apache Tomcat as inbuilt container.

> For Spring Boot 3.0 we need atleast Java 17

> File > Import > Existing Maven Project > Select the pom.xml

> Goals:
Enable building production ready applications quickly.
 - Spring Initializr
 - Spring Boot Starter Project
 - Spring Boot Auto Configuration
 - Spring DevTools
Production Ready
 - Logging
 - Different Configuration for Different Environments
  o Profiles, ConfigurationProperties
 - Monitoring (Spring Boot Actuator)
Provide common non-fictional features.
 - embedded servers
 - metrics
 - health checks
 - externalized configuration

> What Sprint Boot is NOT!:
Zero code generation.
Neither an application server nor a web server.

> Features:
Quickly Create Spring applications
Quick Starter Projects with Auto Configuration
 - Web
 - JPA
Embedded Servers - Tomcat, Jetty or Undertow
Production-ready features
 - metrics and health checks
 - externalized configuration
 - Monitoring for our application by using Spring Boot Actuator. We can monitor the processes, they ran successfully or failed, etc.
 - Externalized Configuration. The Configuration varies between different environments. The Configuration is different in dev than the configuration in production. Different properties files can be created different environments by following naming conventions. Spring Boot provides this feature built-in.
 
 > "WEB" Dependency should be added in Spring Boot Initializer while creating a Spring Initializer Project to create a REST Application.
 
 > Autoconfiguration: The feature of the Spring Boot that automatically configures a lot of things that help in managing the beans, is called autoconfiguration.
 Spring Boot looks at a)Frameworks available on the CLASSPATH, b)Existing configuration for the application. Based on these, Spring Boot provides basic configuration needed to configure the application wuth these frameworks. THis is called Auto Configuration.
 
 > @ConditionalOnClass({A.class,B.class,...}): This annotation makes sure that only if beans A, B, ... are on the CLASSPATH, only then the component should be initialized. Spring Boot takes care of this automatically due to the Auto Configuration feature.
 
 > @ConditionalOnMissingBean({A.class,B.class,...}): This annotation makes sure that only if beans A, B, ... are not on the CLASSPATH, only then the component should be initialized. Spring Boot takes care of this automatically due to the Auto Configuration feature.
	
Spring Boot Starter Projects:
----------
> Spring Starters are convenient dependency descriptors for different features.

1. spring-boot-starter-web-services - SOAP Web Services
2. spring-boot-starter-web - Web & RESTful applications. This brings in spring-webmvc, spring-web, spring-boot-starter-tomcat and spring-boot-starter-json
3. spring-boot-starter-test - Unit Testing and Integration Testing
4. spring-boot-starter-jdbc - Traditional JDBC
5. spring-boot-starter-hateoas - Add HATEOAS feature to your services
6. spring-boot-starter-security - Authentication and Authorization using Spring Security
7. spring-boot-starter-data-jpa - Spring Data JPA with Hibernate
8. spring-boot-starter-cache - Enabling Spring Framework's caching support
9. spring-boot-starter-data-rest - Expose Simple REST Services using Spring Data REST
10. spring-boot-starter-json - JSON Conversion. Java Object to JSON and JSON to Java Object
11. spring-boot-starter-tomcat - Embeded Tomcat Container
12. spring-web and spring-webmvc - For Spring MVC REST APIs

Spring Boot Auto Configuration:
----------
> We need lot of configuration to build Spring app:
 - ComponentScan, DispatchServlet, Data Sources, JSON Conversion,...

> To simplify it:
 - Auto Configuration: Automated configuration for you app
  o Decided based on:
   - which frameworks (spring starter projects) are in the Class Path?
   - What is the existing configuration (Annotations etc)?
  o Example: Spring Boot Starter Web
   - Dispatch Servlet (DispatchServletAutoConfiguration)
   - Embeded Servlet Container - Tomcat is the default (EmbeddedWebServerFactoryCustomizerAutoConfiguration)
   - Default Error Pages (ErrorMVCAutoConfiguration)
   - Bean <-> JSON (JacksonHttpMessageConvertersConfiguration)

> All the Autoconfiguration is defined inside the jar, org.springframework.boot.autoconfig package and sub packages.

> The ErrorMVCAutoConfiguration class makes sure that if the url is not mapped, error page should be shown.

Spring Boot Actuator: [spring-boot-starter-actuator]
----------
> Spring Boot Actuator is a sub-project of the Spring Boot Framework. It includes a number of additional features that help us to monitor and manage the Spring Boot application. It contains the actuator endpoints (the place where the resources live).

> Using the actuator we can read a lot of metadata about the application (beans that are configured, how auto configuration worked, how many times a specific service is called, how many times a specific service has failed, etc.).

> Spring Actuator provides many REST services for monitoring the application that can be viewed using the hal browser. To use the hal browser, we need to add the dependency, "spring-data-rest-hal-browser".

> URL to access the Spring Actuator of a running Spring Application: "http://localhost:8080/actuator"

> To enable the web exposure in the actuator, add this line  to the "application.properties" file in the resources directory: 
management.endpoints.web.exposure.include=*
This will monitor & manage all the endpoint exposures of the HTTP.

Spring Boot Developer Tool: [spring-boot-devtools]
----------
> With this dependency, any Java changes made will be reflected in the server automatically rather than manually stopping and restarting the web application.

> This will not load the beans that are maven dependencies. It will only load the application beans again. As the application beans are the ones that will change and not the maven dependencies. Whereas restarting the server loads everything. Which makes Spring Boot Developer Tool faster when making changes in the Java code and not adding or removing Maven dependencies, because then we will need to restart the server to load those newly added dependencies in the server or remove the removed dependencies from the server.

> Spring Boot Devtool cannot handle changes in pom.xml. For this we need to restart the server.

Production Ready with Spring Boot:
-----------
=> Profiles
> Applications have different environments: Dev, QA, Stage, Prod, ...
> Different environments need different configuration:
 - Different Databases
 - Different Web Services
> How can you provide different configuration for different environments?
 - Profiles: Environment specific configuration

=> ConfigurationProperties
> To create a lot of application configuration for the application, then the recommended approach is to use Configuration Properties.
> This helps to externalize all the configurations needed in the application.

=> Embedded Servers
> Deploy Applications in older days (WAR Approach):
 - Step 1: Install Java
 - Step 2: Install Web/Application Server
  o Tomcat/WebSphere/WebLogic etc
 - Step 3: Deploy the application WAR (Web Archive)
  o This is the OLD WAR Approach
  o Complex to setup!
  
> Embedded Server - Simple alternative
 - Step 1: Install Java
 - Step 2: Run JAR file
 - Make JAR not WAR (Credit: Josh Long!)
 - Embedded Server Examples:
  o spring-boot-starter-tomcat
  o spring-boot-starter-jetty
  o spring-boot-starter-undertow

=> Actuator
> This enables us to monitor the activities of the Spring Boot applications.
> URL for the actuator: http://localhost:8080/actuator
> Enable all end points of the actuator by adding the below line in properties file.
management.endpoints.web.exposure.include=*
> For all the Beans that are autoconfigured, we can find them in the actuator [http://localhost:8080/actuator/beans]

> Monitor and manage your application in your production.
> Provides a number of endpoints:
 - beans: Complete list of Spring beans in your app
 - health: Application health information
 - metrics: Application metrics
 - mappings: Details around Request Mappings

Spring vs Spring MVC vs Spring Boot:
----------
> Spring:
1. Most important feature of Spring Framework is Dependency Injection. At the core of all Spring Modules is Dependency Injection or IOC. This is important because, when DI and IOC is used properly, we can develop loosely coupled applications. And loosely coupled applications can be easily unit tested.

2. Spring Framework reduce Boilerplate Code/Reduce Duplication and Promote Decoupling/Increase Unit Testability.

3. Spring provides good integration with other frameworks (e.g. Hibernate, JUnit, Mockito, etc).

4. @Component, @Autowired, @ComponentScan, etc.

> Spring MVC:
1. Spring MVC Framework provides decoupled way of developing web applications. Spring MVC helps in separation of concerns. With simple concepts like Dispatcher Servlet, ModelAndView and View Resolver, it makes it easy to develop web applications.

2. Simplify building web apps and REST API.

3. @Controller, @RestController, @RequestMapping("/books")

> Spring Boot:
1. Build PRODUCTION-READY apps QUICKLY

2. Starter Projects - Make it easy to build variety of applications

3. Auto Configuration - Eliminate configuration to setup Spring, Spring MVC and other frameworks!

4. Enable non functional requirements (NFRs):
 - Actuator: Enables Advanced Monitoring of applications
 - Embedded Server: No need for separate application servers!
 - Logging and Error Handling
 - Profiles and ConfigurationProperties

5. Spring Boot provides lots of dependencies built in.

6. Spring Boot automates a lot of jobs.

7. Spring Boot provides Auto Configuration.

8. Spring provides a lot of starter projects for creating production ready web applications faster:
	a. spring-boot-starter - To use advanced features like monitoring & tracing to your application out of the box.
	
	b. spring-boot-starter-undertow, spring-boot-starter-jetty, spring-boot-starter-tomcat - To pick specific Embedded Servlet Container.
	
	c. spring-boot-starter-logging - For logging using logback
	
	d. spring-boot-starter-log4j2 - Logging using Log4j2
	
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

----------
Spring AOP: [Aspect Oriented Programming]
----------
> Dependency:
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>

> Spring uses AspectJ nowadays instead of AOP.

> Spring AOP is used to intercept any calls to the Beans. So, any Beans managed by the Spring Framework, we can intercept the calls and do something around that. 

> AOP stands for Aspect Oriented Programming. For Cross cutting Concerns (Concerns that do not fall in any of the three main layers, Web, Business and Data) like logging, security, etc. AOP is the best approach for implementing them.

> @Before("execution(* PACKAGE.*.*(..))") -  Annotated methods run exactly before the all methods matching with pointcut expression [execution(* PACKAGE.*.*(..))]. The logic inside the annotated method is called "Advice".

> execution(* PACKAGE.*.*(..)) - This is called a "Pointcut". It is also known as "JoinPoint". This defines what kind of method you would want to intercept. First * denotes all return types. PACKAGE is the Package of the Class(es) in where the method(s) is situated. The 2nd * is for all Classes. The 3rd * is for all method calls. (..) is for all arguments.

> Aspect - The Combination of Advice and Pointcut is called a Aspect. So, Aspect is basically, "What method to intercept and what to do".

> JoinPoint - This is a specific interception of a method call. It is a specific interception instance.

> Weaving & Weaver - The process where all of this Aspect gets weaved around our code is called, Weaving. Spring AOP makes sure that all the interceptions gets executed at the right moment. This is called weaving. The framework that does this is called a Weaver. So, Spring AOP is a weaver. So, the Process of implementing the AOP around our method calls is called weaving and the framework that does the weaving is called a weaver.

> @After("execution(* PACKAGE.*.*(..))") - This will intercept after the executation of the method call.

> @AfterReturning(value="execution(* PACKAGE.*.*(..))", returning="result") - Annotated methods run exactly after all the method calls matching with pointcut expression returns the value after running successfully. This can take two arguments. First one is the Pointcut expression, this cannot be missed. The 2nd one is optional, this will map the returned value to the specified variable.

> @AfterThrowing(value="execution(* PACKAGE.*.*(..))", throwing="exception") - This will intercept any exception that are thrown.

> @Around("execution(* PACKAGE.*.*(..))") - This will intercept the method call and then allow it to proceed (not block it) and then find the time taken. Using this we can do something before the executation of the method call and do something after the executation of the method call.

> ProceedingJoinPoint - This allows us to continue with the execution of the method call.

> @Pointcut("execution(* PACKAGE.*.*(..))") - Used for reusing a particular pointcut in different places.

> All the JoinPoints are defined by AspectJ and implemented by Spring AOP.

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

----------
Spring JDBC, JPA and Spring Data:
----------
> Dependencies: jdbc, jpa, h2, web

> H2 - In memory Database/Embedded database. It deletes any data once the application stops running.

> TO make the database URL of H2 constant (http://localhost:8080/h2-console) put these lines in the "application.properties" file:
[
spring.datasource.url=jdbc:h2:mem:testdb;NON_KEYWORDS=USER
spring.data.jpa.repositories.bootstrap-mode=default
# Only when working with H2
spring.jpa.defer-datasource-initialization=true
]
To enable the h2 console, enter this line in "application.properties": [spring.h2.console.enabled=true]
Make sure that the JDBC URL value is "jdbc:h2:mem:testdb" in the H2 console URL.

> All DDL(Data Definition Language) - Table Creations and data updates should be done in "schema.sql" file in the resources folder.

> JPA - Java Persistence API. JPA is an ORM (Object Relation Model) i.e., mapping an Object to a Relation (table). JPA is an interface and Hibernate (a popular ORM framework) is the concrete class that implements JPA. To use JPA, we must use a ORM framework like Hibernate.

> In JPA, we directly map the Object to the Relation. Unlike JDBC or Spring JDBC where we needed to write complex queries. So, JPA says why do we need to map the query result set to a object, why not map the object to the rows in the table.

> So with the help of JPA, the duty of writing the query shifts from the user to the framework.

> JPA defines a set of annotations. A set of interfaces. Hibernate is the most popular implementation of JPA. Hibernate has more features than JPA.

> JPA is the most popular standard way of doing Object-Relational-Mapping (ORM). Basically any object we create is a row of the table (Mapping the relation (table) to the object of a class).

> To see the SQL query that is going into the database, write this line in "application.properties":
spring.jpa.show-sql=true

> With Hibernate we do not need to write any queries. All the queries are created by Hibernate which is the JPA implementation.

> HQL - Hibernate Query Language

> JPQL - Java Persistence Query Language

> Spring Data comes in with predefined repositories. Where we do not need to repeat Entity name everytime. It is an interface and not a class.

> Ignore Spring JDBC. Focus only on Spring JPA [JpaDemoApplication.java & SpringDataDemoApplication.java].

Connect Other Databases:
----------
> LINK: https://github.com/in28minutes/spring-master-class/tree/master/04-spring-jdbc-to-jpa#connecting-to-my-sql-and-other-databases

> Steps:
1. Install MySQL and Setup Schema
2. Remove H2 dependency from pom.xml
3. Add MySQL (or your database) dependency to pom.xml:
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
4. Configure application.properties:
[
spring.jpa.hibernate.ddl-auto=none
spring.datasource.url=jdbc:mysql://localhost:3306/person_example
spring.datasource.username=personuser
spring.datasource.password=YOUR_PASSWORD
]
5. Restart the app and You are ready!

> Things to note:
1. Spring Boot chooses a default value for you based on whether it thinks your database is embedded (default create-drop) or not (default none).
2. spring.jpa.hibernate.ddl-auto is the setting to perform SchemaManagementTool actions automatically
	a. none : No action will be performed.
	b. create-only : Database creation will be generated.
	c. drop : Database dropping will be generated.
	d. create : Database dropping will be generated followed by database creation.
	e. validate : Validate the database schema
	f. update : Update the database schema
3. Reference: https://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#configurations-hbmddl

> application.properties:
[
#none, validate, update, create, create-drop
spring.jpa.hibernate.ddl-auto=create
]

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

----------
Spring MVC:
----------
> @RequestParam - https://www.javatpoint.com/spring-mvc-requestparam-annotation

> ModelMap, ModelView and Map - http://www.javabyexamples.com/using-model-modelmap-and-modelview-in-spring-mvc

> REST Client - https://www.freecodecamp.org/news/rest-api-tutorial-rest-client-rest-service-and-api-calls-explained-with-code-examples/

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

----------
Spring Security:
----------


----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

==========
Maven:
==========
> Maven gives a good structure to the project and helps in managing dependencies.

> The Configuration used in the projects is defined in the file pom.xml (Project Object Model).

> In pom.xml file, we can find groupId and artifactId. artifactId is the name that we gave to the specific project. groupId and artifactId are important as any other project wanting to use this project will need this groupId and artifactId.

> Other important part is version. SNAPSHOT defines that the version is under development.

> packaging defines how we want to package this project. (jar, ear, war)

> <java.version> tag defines the version of the Java that we are using.

> <dependencies> tag holds all the packages that we need in this project as dependency.

> <scope> tag defines in which scope the package is used. (e.g. test, runtime)

> dependencies of the dependencies is called transitive dependencies. The transitive dependencies are also loaded in the project.

> Each dependency has a groupId and artifactId and optionally a version.

> Maven has two important concepts when it comes to repositories:
1. Local Repository: Local System. Stores only the verion of the dependency that is specified. If version is not specified then the current published version is used.
2. Remote Maven Repository: Central Repositories. Stores all the versions of all dependencies. 

> To know where the local repository is present, follow these steps: Windows > Preferences > Maven > User Settings > Local Repository

> mvn install vs mvn deploy: Copies the created jar to local maven repository - a temp folder in the system.

> Just like Java classes, the pom file can inherit a parent. It is defined using the <parent> tag.

> src/main/java - Source Code

> src/main.resources - Source Code Resources

> src/test/java - Test Code

> src/test/resources - Test Code Resources

> POM: Project Object Model. pom.xml is the file that has all the maven project configurations, dependencies and configurations of the repositories.

>> <artifactId>: Name that we are giving to a specific project. [<groupId> and <artifaceId> are required to use a project to another project as maven dpenedency]

>> <version>: Defines the version of the project.

>> <packaging>: Defines how the project will be packaged (.jar, .war, .ear).
[
.jar - Java Archive
.war - Web Archive
.ear - Enterprise Archive
]

>> <parent>: Defines the project that the current project is inheriting from.

>> <dependencies>: It holds all the <dpenedency> of the project.

----------
Maven Build Life Cycle:
----------
> Pre-defined sequence of steps that are done when we run a maven command. Plugins can be attached to lifecycle stages. Default plugins are already defined in the super pom.

> mvn install
	o package - creates the jar
	o install - copies the create jar to local maven repository - a temp folder on my machine where maven stores the files.

> Build LifeCycle: [Steps that are followed in creating a new package out of the project and deploying it]
1. Validate
2. Compile
3. Test
4. Package
5. Integration Test
6. Verify
7. Install
8. Deploy

> mvn clean install - Executes all the LifeCycle steps upto install.
A. Validate & Compile:
1. Deletes the target folder [maven-clean-plugin:<version>:clean (default-clean)]
2. Makes the source resources available [maven-resource-plugin:<version>:resources (default-resources)]
3. Compile the source code [maven-compiler-plugin:<version>:compile (default-compile)]
4. Make the test resources available [maven-resources-plugin:<version>:testResources (default-testResources)]
5. Compile the test code [maven-compiler-plugin:<version>:testCompile (default-testCompile)]
6. Test executation takes place [maven-surefire-plugin:<version>:test (default-test)]

B. Test:
1. T E S T S start running one by one and show number of Failures, Errors and Skipped.

C. Package: 
1. This is the Build phase that creates the .jar file.
2. Installs the .jar file in the repository.

----------
Working of Maven:
----------
> Local Repository - Repository in the local system.

> Remote Maven Repository - Central repository on the internet where all the versions of all the dependencies are stored.

----------
Maven Commands:
----------
> Irrespective which LifeCycle we are executing, all the LifeCycle stages before that will also be executed.

> mvn clean install - Executes all the LifeCycle steps upto install. [Do this whenever you start working on a existing project in a repository]

> mvn compile - Compiles the source code. [Ignores the already compiled source code]

> mvn clean compile - Cleans the already compiled source code and compiles all the source code.

> mvan test-compile - Compiles the test code. [Source code also compiles]

> mvn test - Runs the unit test. [Validate -> Compile -> Test]

> mvn package - The project is bult and a.jar file is created.

> mvn install - Installs the built .jar file in the local maven repository.

> mvn deploy - Installs the built .jar file in the remote maven repository.

> mvn help:effective-settings - While building the mavne project, whatever settings are used (repositories and everything) gets printed in the console.

> mvn help:effective-pom - The entire content of the pom including the super pom is printed.

> mvn dpenedency:tree - All the dependencies that we are getting in the project.

> mvn dpenedency:sources - Sources of the dependencies are printed.

> mvn <Command(s)> --debug - Maven will execute any command that is used with --debug, in DEBUG mode.

> To run these inside Eclipse, Right Click on the project and choose Maven Build. In the Goals section write the command (without mvn) and click on Run.

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

==========
Eclipse Shortcuts:
==========
1. Ctrl + Space -> Suggestions
2. Ctrl + 1 -> Suggesting Names
3. Ctrl + Shift + R -> Search through all the projects for a particular file
4. Ctrl + Shift + T -> Search through all the projects for a particular Class
5. Ctrl + L -> Just to a Line
6. Ctrl + F -> Search for a phrase in a file
7. Ctrl + D -> Delete Line
8. Ctrl + Shift + F -> Refactor the code
9. Ctrl + Shift + O -> Organize the Imports
8. F3 -> Goto Declaration
9. F4 -> Type Hierarchy
10. Ctrl + Shift + L -> List of shortcuts

> Go to Windows (Eclipse) > Preferences > Save Actions:
	Choose - Format edited lines and Organize imports and save.
	
> For Code Generation: RMB > Source

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

++++++++++
Terms:
++++++++++
==========
Spring Core:
==========
1. Dependency: When a class is dependent on another class's object to function normally then the second class is called the Dependency of the first class.

2. Coupling
	a. Tight Coupling [Not Good Code !!!]
			class A {
				B b = new B();
			}
	b. Loose Coupling [Good Code !!!]
			class A {
				B b;
				public A(B b) {
					this.b = b;
				}
			}
					
3. Component & Bean: The Class that is managed by Spring is called Component and the Instances that Spring manages is called Bean. Beans are POJOs (plain old Java object) managed by Spring.
 
4. Autowiring: The process where Spring identifies the matches for the dependencies and populates them is called Autowiring. Types of Autowiring:
	a. Autowiring by type
	b. Autowiring by name
	
5. Dependency Injection(DI): Dependency Injection is a fundamental aspect of the Spring framework, through which the Spring container â€œinjectsâ€� objects into other objects or â€œdependenciesâ€�. Simply put, this allows for loose coupling of components and moves the responsibility of managing components onto the container. Types of DI:
	a. Constructor Injection
	b. Getter/Setter Injection
	c. No Constructor or Getter/Setter Injection
  
6. Inversion of Control(IOC): Giving the control from the class that needs the dpenedency to the frameworks is called IOC. Rather than the class itself creating the instances for the dependencies, Spring will create the dependencies.

7. IOC Container: Anything that is implementing IOC. In a typical Spring project the IOC container is the Application Context.
8. Application Context: Where all the Beans are created and managed. This is where all the core logic happens.

==========
Maven:
==========
1. Transitive Dependency: Dependency of the dependencies is called Transitive Dependency.

++++++++++
Annotations:
++++++++++
@SpringBootApplication
@Component
@Primary
@Qualifier()
@Autowired
@Scope()
@ComponentScan() / @ComponentScan
@Configuration

@PostConstruct
@PreDestroy

@Named
@Inject
@Singleton

@Service
@Repository
@Controller

@Value("${propertyName}")
@PropertySource("classpath:...")

@RestController
@GetMapping("/path")
@RequestParam

@ConditionalOnClass({A.class,B.class,...})
@ConditionalOnMissingBean({A.class,B.class,...})

@ConfigurationProperties(prefix="...")

@Aspect
@Before("execution(* PACKAGE.*.*(..))")
@After("execution(* PACKAGE.*.*(..))")
@AfterReturning(value="execution(* PACKAGE.*.*(..))", returning="result")
@AfterThrowing(value="execution(* PACKAGE.*.*(..))", throwing="exception")
@Around("execution(* PACKAGE.*.*(..))")
@Pointcut("execution(* PACKAGE.*.*(..))")

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

@Entity
@Table(name="Person")
@NamedQuery(name="find_all_persons", query="select p from Person p")
@Id
@GeneratedValue
@Column(name="name")
@Transactional
@PersistenceContext

@RunWith(...)
@ContextConfiguration(classes=...) / @ContextConfiguration(locations="....xml")
@Test
@Mock
@InjectMocks
@Rule

++++++++++
Spring Addons for Eclipse:
++++++++++
1. Spring Tools

++++++++++
Killing Tasks:
++++++++++
1. netstat  -ano  |  findstr <PORT>
2. taskkill  /F  /PID  <Process Id>

++++++++++
Links:
++++++++++
- Web Services - 
- REST API - 
- SOAP - 

++++++++++
Topics:
++++++++++
> Dispatcher Servlet
> How a Spring application runs
> Difference between Spring MVC and Spring Boot
