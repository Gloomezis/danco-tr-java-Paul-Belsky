

public class Main {

	public static void main(String[] args) {
		
—оздатель узова создатель узова1=new —оздатель узова();
—оздательЎасси создательЎасси1 = new —оздательЎасси();
Cоздательƒвигател€ создательƒвигател€1 = new Cоздательƒвигател€();

IProductPart кузов=создатель узова1.buildProductPart();
IProductPart шасси=создательЎасси1.buildProductPart();
IProductPart двигатель=создательƒвигател€1.buildProductPart();


IAssemblyLineImpl iAssemblyLineImpl=new IAssemblyLineImpl(создатель узова1, создательЎасси1, создательƒвигател€1);

«аготовка”становщик заготовка”становщик = new «аготовка”становщик(кузов,шасси,двигатель);

iAssemblyLineImpl.assembleProduct(заготовка”становщик);








	}

}
