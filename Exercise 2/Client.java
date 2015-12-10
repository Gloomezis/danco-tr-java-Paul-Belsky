
public class Client {
Account account;
People people;

public Client(Account account, People people) {
	super();
	this.account = account;
	this.people = people;
	System.out.println("Client created");
}

public Account getAccount() {
	return account;
}
public void setAccount(Account account) {
	this.account = account;
}
public People getPeople() {
	return people;
}
public void setPeople(People people) {
	this.people = people;
}





}
