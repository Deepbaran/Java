package classes_and_objects;

public class FractionUse {

	/*
	 * If an exception occurs then the function will throw exception through the
	 * throw keyword to the function that is calling it, till it reaches main. If
	 * main also throws exception then the complier will give error and show the
	 * thrown exception. If, a function does not throw the exception and instead
	 * handles it, then it will use try-catch. If no exception occurs, then try will
	 * be executed. If exception occurs, then try will be executed upto the line
	 * which is throwing the exception and then catch will be executed. We, can add
	 * a finally statement too. Whether a exception occurs or not, the finally will
	 * be executed in both the cases even if one of them is returning the function,
	 * finally will be executed.
	 * 
	 * The 'try' block should be followed by either a 'catch' block or a 'finally'
	 * block
	 * 
	 * In java, there is a convention that either catch the exception(with
	 * try-catch) and handle it and don't let the exception go forward or, mention
	 * the exception(using throw). This convention is called "catch-or-specifier".
	 * 
	 */

//	public static void temp() throws ZeroDenominatorException {
	public static void temp() {
		Fraction f1 = new Fraction(20, 30);
		f1.print();
		// 2/3

		f1.setNumerator(12);
		// 4/1
		int d = f1.getDenominator();
		System.out.println(d);
		f1.print();
//		
		f1.setNumerator(10);
		int i = 10;
		try {
			i++; // executed even if exception is occurs
			f1.setDenominator(0); // In try, from the line where exception is occured, rest of the code in try
									// scope will not be executed
			i++; // Not executed if execution occurs
		} catch (ZeroDenominatorException e) { // executed
			System.out.println("There is 0 at the denominator");
		} finally {
			System.out.println("This will execute regardless if exception occurs or not");
		}
		System.out.println(i);
		// 1/3
		f1.print();
//		
		Fraction f2 = new Fraction(3, 4);
		f1.add(f2);
		f1.print();
		// f1 => 13/12
		f2.print();
		// f2 => 3/4
//		
		Fraction f3 = new Fraction(4, 5);
		f3.multiply(f2);
		f3.print();
		// f3 => 3/5
		f2.print();
		// f2 => 3/4
//		
		Fraction f4 = Fraction.add(f1, f3);
		f1.print();
		f3.print();
		f4.print();
	}

	public static void main(String[] args) throws ZeroDenominatorException {
		temp();
	}

}

/*
 * USER-DEFINED EXCEPTION: 

// A Class that represents use-defined expception
class MyException extends Exception
{
    public MyException(String s)
    {
        // Call constructor of parent Exception
        super(s);
    }
}
  
// A Class that uses above MyException
public class Main
{
    // Driver Program
    public static void main(String args[])
    {
        try
        {
            // Throw an object of user defined exception
            throw new MyException("GeeksGeeks");
        }
        catch (MyException ex)
        {
            System.out.println("Caught");
  
            // Print the message from MyException object
            System.out.println(ex.getMessage());
        }
    }
}
 */
