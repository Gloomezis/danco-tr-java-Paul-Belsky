
public class IAssemblyLineImpl implements IAssemblyLine{

	
	
	��������������� ����������������������;
	�������������� ���������������������;
	C����������������� �������������������������;
    IProductPart firstProduct;
    IProductPart secondProduct;
    IProductPart threerdProduct;

    

	
	public IAssemblyLineImpl(��������������� ���������������1, �������������� ��������������1, C����������������� ������������������1) {
		this.���������������������� =  ���������������1;
		this.��������������������� = ��������������1;
		this.������������������������� = ������������������1;
		
	}



	public IProduct assembleProduct(IProduct iproduct) {
		
		������������������� ����������=(�������������������) iproduct;
		����������.installFirstPart(firstProduct);
		����������.installSecindPart(secondProduct);
		����������.installThirdPart(threerdProduct);
		
		System.out.println("������ ������");
		System.out.println("������� ������");
		return iproduct;
		
	}
	public void productCreating(){
		firstProduct=(IProductPart) ����������������������.buildProductPart();
		secondProduct =(IProductPart) ���������������������.buildProductPart();
		threerdProduct= (IProductPart) �������������������������.buildProductPart();
		
	}

}




