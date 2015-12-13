
public class Depository {

	Product[] depositoryProduct;
	int sum;

	public Depository(Product[] mass) {
		depositoryProduct = mass;

	}
    //if we created depository without auto product generate
	public Depository() {
		depositoryProduct = new Product[3];
	}

	public int summ() {

		for (int i = 0; i < depositoryProduct.length; i++) {
			sum = sum + depositoryProduct[i].getWeight();
			System.out.println(
					"Adding : " + depositoryProduct[i].getName() + " " + depositoryProduct[i].getWeight() + "kg.");
		}

		System.out.println("Weight of all depositoryProduct = " + sum);
		return sum;

	}
	//we adding product manually if depository was created without auto product generate
	public void addProductToDepository(int p, Product pr) {
		depositoryProduct[p] = pr;
	  System.out.println("Adding : " + depositoryProduct[p].getName() + " " + depositoryProduct[p].getWeight() + "kg.");
	}

}
