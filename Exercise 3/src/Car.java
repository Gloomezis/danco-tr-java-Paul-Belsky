
public class Car implements IProduct{

	CarBody carBody;
	Chassis chassis;
	Engine engine;
	
	

	
	
	

	public Car() {
		
		System.out.println("������ ��������� ������");
	}


	@Override
	public void installFirstPart(IProductPart productPart) {
		this.carBody=(CarBody) productPart;
		System.out.println("����� ���������� � ���������");
	}


	@Override
	public void installSecindPart(IProductPart productPart) {
		this.chassis=(Chassis) productPart;
		
		System.out.println("����� ����������� � ���������");
	}


	@Override
	public void installThirdPart(IProductPart productPart) {
	   this.engine=(Engine) productPart ;
		System.out.println("��������� ���������� � ���������");
	}

	
}
