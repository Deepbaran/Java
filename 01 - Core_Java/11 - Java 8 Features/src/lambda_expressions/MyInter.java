package lambda_expressions;

@FunctionalInterface //Because of this compiler will stop you from creating multiple abstract functions inside the functional interface. Although using this is annotation is optional
public interface MyInter {
	public abstract void sayHello();
}


// How to use:
// create separate class and implement this interface
// anonymous class for implementing interface
// Lambda expression