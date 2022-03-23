package fileProcessing;

class MyClass implements AutoCloseable {
	@Override
	public void close() throws Exception {
		System.out.println("Closing!");
	}
}

public class Application2 {

	public static void main(String[] args) {
		try(MyClass m = new MyClass();) {
			// m automatically closes
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
