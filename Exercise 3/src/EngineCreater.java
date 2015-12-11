
public class EngineCreater implements ILineStep {

	
	
	public EngineCreater() {
		System.out.println("Билдер двигателя создан");
	}

	public Engine buildProductPart() {
		 return new Engine();
		
	}

}
