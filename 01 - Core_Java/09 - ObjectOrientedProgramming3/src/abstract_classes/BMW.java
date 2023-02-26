package abstract_classes;

public class BMW extends Car{

	@Override
	public String getCompany() { // last abstract class in Vehicle that was inherited to BMW vis Car is defined
		return "BMW";
	}

}
