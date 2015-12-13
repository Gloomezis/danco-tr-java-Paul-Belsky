
public class ProductGenerator {

	public ProductGenerator() {
		System.out.println("Product generator was created");
	}

	public Product[] generate() {
		System.out.println("Start generating product");
		Product[] mass = new Product[5];
		mass[0] = new Product("Sport bike", 8);
		mass[1] = new Product("Mountain bike", 10);
		mass[2] = new Product("Fixed Gear bike", 7);
		mass[3] = new Product("Kids bike", 5);
		mass[4] = new Product("Fat bike", 15);
		System.out.println("Products was generated");
		return mass;

	}

	// if we adding product manually without generating
	public Product createProduct(String name, int weigth) {
		Product pd = new Product(name, weigth);
		System.out.println("Product was creating");
		return pd;

	}

}
