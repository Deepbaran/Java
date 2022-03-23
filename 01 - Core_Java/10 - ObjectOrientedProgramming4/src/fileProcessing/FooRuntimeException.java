// Create Exceptions in their own package and then import them

package fileProcessing;

public class FooRuntimeException extends Exception {
	public FooRuntimeException(String message) {
		super(message); // To make sure that our personal exception message is shown
	}
}
