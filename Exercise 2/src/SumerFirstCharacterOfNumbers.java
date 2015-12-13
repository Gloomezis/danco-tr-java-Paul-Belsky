
public class SumerFirstCharacterOfNumbers {

	
	
	
	public SumerFirstCharacterOfNumbers() {
		System.out.println("SumerFirstCharacterOfNumbers was created");
	}

	public int sumFirstCharacterOfNumbers(int a,int b,int c){
		System.out.println("Summing firts characters of three numbers");
		String a1=a+"";
		String b1=b+"";
		String c1=c+"";
		
		int sum=Integer.parseInt(a1.trim()+Integer.parseInt(b1.trim())+Integer.parseInt(c1.trim()));
		System.out.println("Summ first characters of three nimbers is:"+sum);
		return sum;
		
	}
}
