
public class CarBodyCreater implements ILineStep{

	
	public CarBodyCreater() {
		System.out.println("������ ������ ������");
	}

	public CarBody buildProductPart() {
		
		return new CarBody();
	}

}
