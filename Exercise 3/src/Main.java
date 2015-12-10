

public class Main {

	public static void main(String[] args) {
		
—оздатель узова создатель узова2=new —оздатель узова();
—оздательЎасси создательЎасси2 = new —оздательЎасси();
Cоздательƒвигател€ создательƒвигател€2 = new Cоздательƒвигател€();




IAssemblyLineImpl iAssemblyLineImpl=new IAssemblyLineImpl(создатель узова2, создательЎасси2, создательƒвигател€2);
iAssemblyLineImpl.productCreating();
«аготовка”становщик заготовка”становщик = new «аготовка”становщик(iAssemblyLineImpl.firstProduct,iAssemblyLineImpl.secondProduct,iAssemblyLineImpl.threerdProduct);

iAssemblyLineImpl.assembleProduct(заготовка”становщик);








	}

}
