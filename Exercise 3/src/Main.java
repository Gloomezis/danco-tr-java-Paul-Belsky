

public class Main {

	public static void main(String[] args) {
		
��������������� ���������������1=new ���������������();
�������������� ��������������1 = new ��������������();
C����������������� ������������������1 = new C�����������������();

IProductPart �����=���������������1.buildProductPart();
IProductPart �����=��������������1.buildProductPart();
IProductPart ���������=������������������1.buildProductPart();


IAssemblyLineImpl iAssemblyLineImpl=new IAssemblyLineImpl(���������������1, ��������������1, ������������������1);

������������������� ������������������� = new �������������������(�����,�����,���������);

iAssemblyLineImpl.assembleProduct(�������������������);








	}

}
