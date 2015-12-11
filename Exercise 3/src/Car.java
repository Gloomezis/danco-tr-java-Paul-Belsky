
public class Car implements IProduct{

	CarBody carBody;
	Chassis chassis;
	Engine engine;
	
	

	
	
	

	public Car() {
		
		System.out.println("Корпус заготовки создан");
	}


	@Override
	public void installFirstPart(IProductPart productPart) {
		this.carBody=(CarBody) productPart;
		System.out.println("Кузов установлен в заготовку");
	}


	@Override
	public void installSecindPart(IProductPart productPart) {
		this.chassis=(Chassis) productPart;
		
		System.out.println("Шасси установлено в заготовку");
	}


	@Override
	public void installThirdPart(IProductPart productPart) {
	   this.engine=(Engine) productPart ;
		System.out.println("Двигатель установлен в заготовку");
	}

	
}
