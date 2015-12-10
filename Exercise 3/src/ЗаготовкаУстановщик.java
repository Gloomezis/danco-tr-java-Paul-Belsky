
public class ЗаготовкаУстановщик implements IProduct{

	Кузов кузов;
	Шасси шасси;
	Двигатель двигатель;
	

	public ЗаготовкаУстановщик(IProductPart кузов2, IProductPart шасси2, IProductPart двигатель2) {
		this.кузов=(Кузов) кузов2;
		this.шасси=(Шасси) шасси2;
		this.двигатель=(Двигатель) двигатель2;
		System.out.println("Сборщик заготовки создан");
	}

	
	public void installFirstPart() {
		
		
		System.out.println("Кузов установлен в заготовку");
	}

	
	public void installSecindPart() {
		
		
		System.out.println("Шасси установлено в заготовку");
	}

	
	public void installThirdPart() {
		
		
		System.out.println("Двигатель установлен в заготовку");
	}

}
