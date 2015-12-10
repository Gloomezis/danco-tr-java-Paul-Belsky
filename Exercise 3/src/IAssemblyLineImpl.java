
public class IAssemblyLineImpl implements IAssemblyLine{

	
	
	—оздатель узова создатель узоваЌаЋинии;
	—оздательЎасси создательЎассиЌаЋинии;
	Cоздательƒвигател€ создательƒвигател€ЌаЋинии;
    IProductPart firstProduct;
    IProductPart secondProduct;
    IProductPart threerdProduct;

    

	
	public IAssemblyLineImpl(—оздатель узова создатель узова1, —оздательЎасси создательЎасси1, Cоздательƒвигател€ создательƒвигател€1) {
		this.создатель узоваЌаЋинии =  создатель узова1;
		this.создательЎассиЌаЋинии = создательЎасси1;
		this.создательƒвигател€ЌаЋинии = создательƒвигател€1;
		
	}



	public IProduct assembleProduct(IProduct iproduct) {
		
		«аготовка”становщик заготовщик=(«аготовка”становщик) iproduct;
		заготовщик.installFirstPart(firstProduct);
		заготовщик.installSecindPart(secondProduct);
		заготовщик.installThirdPart(threerdProduct);
		
		System.out.println("Ќачало сборки");
		System.out.println("ѕродукт собран");
		return iproduct;
		
	}
	public void productCreating(){
		firstProduct=(IProductPart) создатель узоваЌаЋинии.buildProductPart();
		secondProduct =(IProductPart) создательЎассиЌаЋинии.buildProductPart();
		threerdProduct= (IProductPart) создательƒвигател€ЌаЋинии.buildProductPart();
		
	}

}




