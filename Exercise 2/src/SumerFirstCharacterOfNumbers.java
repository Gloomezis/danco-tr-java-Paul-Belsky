
public class SumerFirstCharacterOfNumbers {

	
	
	
	public SumerFirstCharacterOfNumbers() {
		System.out.println("SumerFirstCharacterOfNumbers was created");
	}

	public int sumFirstCharacterOfNumbers(int a,int b,int c){
		System.out.println("Summing firts characters of three numbers");
		String a1=a+"";
		String b1=b+"";
		String c1=c+"";
		char a2=a1.charAt(0);
		char b2=b1.charAt(0);
		char c2=c1.charAt(0);
		a1=a2+"";
		b1=b2+"";
		c1=c2+"";
		
	
		int sum = Integer.parseInt(a1)+Integer.parseInt(b1)+Integer.parseInt(c1);
		System.out.println("Summ first characters of three numbers is:"+sum);
		return sum;
		
	}
}
