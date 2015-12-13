import java.util.*;

public class MassiveCreater {

	public MassiveCreater() {
		System.out.println("MassiveCreater created");
	}

	public String[] createMassive() {
		
		String[] str = new String[5];
		int i;

		for (i = 0; i < str.length; i++) {
			Random rn = new Random();
			str[i] = Integer.toString(rn.nextInt(10));
			System.out.println("Massive creating..." + Arrays.toString(str));
		}
		System.out.println("Created massive-" + Arrays.toString(str));
		return str;

	}
}
