
public class ChassisCreater implements ILineStep{

	
	
	public ChassisCreater() {
		System.out.println("������ ����� ������");
	}

	public Chassis buildProductPart() {
		return new Chassis();
		
	}

}
