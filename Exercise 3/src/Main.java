

public class Main {

	
	
	
	
	public static void main(String[] args) {
		
CarBodyCreater carBodyCreater=new CarBodyCreater();
ChassisCreater chassisCreater = new ChassisCreater();
EngineCreater engineCreater = new EngineCreater();

IAssemblyLineImpl iAssemblyLineImpl=new IAssemblyLineImpl(carBodyCreater, chassisCreater, engineCreater);

Car car=new Car();

Car finishedCar=(Car) iAssemblyLineImpl.assembleProduct(car);


	}

}
