
public class EngineCreater implements ILineStep {

	
	
	public EngineCreater() {
		System.out.println("Engine builder was created");
	}

	public Engine buildProductPart() {
		 return new Engine();
		
	}

}
