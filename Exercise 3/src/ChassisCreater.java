
public class ChassisCreater implements ILineStep{

	
	
	public ChassisCreater() {
		System.out.println("Билдер шасси создан");
	}

	public Chassis buildProductPart() {
		return new Chassis();
		
	}

}
