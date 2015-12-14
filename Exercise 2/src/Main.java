
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NumberGenerator ng= new NumberGenerator();
		ng.generateNumbers();
		
		SumerFirstCharacterOfNumbers summer= new SumerFirstCharacterOfNumbers();
		int sum=summer.sumFirstCharacterOfNumbers(ng.getA(),ng.getB(),ng.getC());
		
		
	}

}
