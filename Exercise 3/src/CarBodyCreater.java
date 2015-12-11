
public class CarBodyCreater implements ILineStep{

	
	public CarBodyCreater() {
		System.out.println("Билдер кузова создан");
	}

	public CarBody buildProductPart() {
		
		return new CarBody();
	}

}
