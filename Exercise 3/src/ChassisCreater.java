
public class ChassisCreater implements ILineStep{

	
	
	public ChassisCreater() {
		System.out.println("Shasses builder was created");
	}

	public Chassis buildProductPart() {
		return new Chassis();
		
	}

}
