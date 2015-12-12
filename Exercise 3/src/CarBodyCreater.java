
public class CarBodyCreater implements ILineStep{

	
	public CarBodyCreater() {
		System.out.println("‘ar body builder created");
	}

	public CarBody buildProductPart() {
		
		return new CarBody();
	}

}
