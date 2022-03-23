package fileProcessing;

public class MyFileUtils {
	public int substract10FromLargeNumber(int number) throws Exception {
		if(number < 10) {
			throw new Exception("The number passed was smaller than 10");
		}
		return -10;
	}
	
	public int add10WithLargNumber(int number) throws FooRuntimeException {
		if(number > 10) {
			throw new FooRuntimeException("The number passed was bigger than 10");
		}
		return 10;
	}
}
