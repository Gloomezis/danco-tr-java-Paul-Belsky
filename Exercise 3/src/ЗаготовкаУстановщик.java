
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

	
	

	@Override
	public void installFirstPart(IProductPart productPart) {
		// TODO Auto-generated method stub
		System.out.println("Кузов установлен в заготовку");
	}


	@Override
	public void installSecindPart(IProductPart productPart) {
		// TODO Auto-generated method stub
		System.out.println("Шасси установлено в заготовку");
	}


	@Override
	public void installThirdPart(IProductPart productPart) {
		// TODO Auto-generated method stub
		System.out.println("Двигатель установлен в заготовку");
	}

}
