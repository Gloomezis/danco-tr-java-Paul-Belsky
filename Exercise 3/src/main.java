
public class main {

	public static void main(String[] args) {
		
		ProductGenerator pg = new ProductGenerator();
		Depository dp = new Depository(pg.generate());
		int sumAllDepProduct = dp.summ();
		
		Depository dp1= new Depository();
		dp1.addProductToDepository(0, pg.createProduct("Sport bike", 8));
		dp1.addProductToDepository(1, pg.createProduct("Mountain bike", 10));
		dp1.addProductToDepository(2, pg.createProduct("Fixed Gear bike", 7));
		int sumAllDepProduct1 = dp1.summ();

	}

}
