
public class ������������������� implements IProduct{

	����� �����;
	����� �����;
	��������� ���������;
	

	public �������������������(IProductPart �����2, IProductPart �����2, IProductPart ���������2) {
		this.�����=(�����) �����2;
		this.�����=(�����) �����2;
		this.���������=(���������) ���������2;
		System.out.println("������� ��������� ������");
	}

	
	

	@Override
	public void installFirstPart(IProductPart productPart) {
		// TODO Auto-generated method stub
		System.out.println("����� ���������� � ���������");
	}


	@Override
	public void installSecindPart(IProductPart productPart) {
		// TODO Auto-generated method stub
		System.out.println("����� ����������� � ���������");
	}


	@Override
	public void installThirdPart(IProductPart productPart) {
		// TODO Auto-generated method stub
		System.out.println("��������� ���������� � ���������");
	}

}
