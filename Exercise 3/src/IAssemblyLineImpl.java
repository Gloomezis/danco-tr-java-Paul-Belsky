
public class IAssemblyLineImpl implements IAssemblyLine{

	
	
	CarBodyCreater carBodyCreater;
	ChassisCreater chassisCreater;
	EngineCreater engineCreater;
    

    

	
	public IAssemblyLineImpl(CarBodyCreater carBodyCreater, ChassisCreater chassisCreater, EngineCreater engineCreater) {
		this.carBodyCreater =  carBodyCreater;
		this.chassisCreater = chassisCreater;
		this.engineCreater = engineCreater;
		
	}



	@Override
	public IProduct assembleProduct(IProduct car) {
		car.installFirstPart(carBodyCreater.buildProductPart());
		car.installSecindPart(chassisCreater.buildProductPart());
		car.installThirdPart(engineCreater.buildProductPart());
		return car;
	}




	}



	






