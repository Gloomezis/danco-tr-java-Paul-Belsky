
public class EngineCreater implements ILineStep {

	
	
	public EngineCreater() {
		System.out.println("������ ��������� ������");
	}

	public Engine buildProductPart() {
		 return new Engine();
		
	}

}
