import java.util.Arrays;

public class Sorter {

	public Sorter(String[] str) {
		System.out.println("Sorted created");
	}

	public String[] sorted(String[] str) {
		System.out.println("Start sort");
		Arrays.toString(str);
		Arrays.sort(str);
		System.out.println("Massive was sorted" + Arrays.toString(str));
		return str;

	}

}
