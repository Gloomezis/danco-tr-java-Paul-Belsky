
public class Car implements IProduct{

	CarBody carBody;
	Chassis chassis;
	Engine engine;
	
	

	
	
	

	public Car() {
		
		System.out.println("Car core was created");
	}


	@Override
	public void installFirstPart(IProductPart productPart) {
		this.carBody=(CarBody) productPart;
		System.out.println("Car body was installed in car core");
	}


	@Override
	public void installSecindPart(IProductPart productPart) {
		this.chassis=(Chassis) productPart;
		
		System.out.println("Shasses was installed in car core");
	}


	@Override
	public void installThirdPart(IProductPart productPart) {
	   this.engine=(Engine) productPart ;
		System.out.println("Engine was installed in car core");
	}

	
}
