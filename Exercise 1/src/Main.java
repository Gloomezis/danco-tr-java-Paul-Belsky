
public class Main {

	public static void main(String[] args) {
		Main main = new Main();
        main.createAndSortMassive();
	}
	
	
	
	
	
public void createAndSortMassive(){
	MassiveCreater massiveCreater = new MassiveCreater();
	String[] createdMassive = massiveCreater.createMassive();

	Sorter sorter = new Sorter(createdMassive);
	String[] sortedMassive = sorter.sorted(createdMassive);
}
}
