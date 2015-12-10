
public class Starter {

	public static void main(String[] args) {
		
	Starter start=new Starter();	
	start.createClasses();
		
	}
		
	public void createClasses()	{
		
	People pavel = new People();
	StandartCard pavelStandartCard= new StandartCard();
	VipCard pavelVipCard=new VipCard();
	PhysicAccount pavelPhysicAccount=new PhysicAccount(pavelVipCard);
	IpAccount pavelIpAccount=new IpAccount(pavelStandartCard);
    //	Account pavelAccount = new Account(pavelVipCard);      ненужен так как класс предок
	Client pavelClient=new Client(pavelIpAccount,pavel);
	
	}

}
