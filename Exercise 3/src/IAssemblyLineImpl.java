
public class IAssemblyLineImpl implements IAssemblyLine{

	
	
	��������������� ����������������������;
	�������������� ���������������������;
	C����������������� �������������������������;
	


	
	public IAssemblyLineImpl(��������������� ���������������1, �������������� ��������������1, C����������������� ������������������1) {
		this.���������������������� =  ���������������1;
		this.��������������������� = ��������������1;
		this.������������������������� = ������������������1;
		
	}



	public IProduct assembleProduct(IProduct iproduct) {
		
		������������������� ����������=(�������������������) iproduct;
		����������.installFirstPart();
		����������.installSecindPart();
		����������.installThirdPart();
		
		System.out.println("������ ������");
		System.out.println("������� ������");
		return iproduct;
		
	}

}
