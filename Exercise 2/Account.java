
public class Account {
int id;
double balance;
String createDate;
BankCard bankCard;


public Account(BankCard bankCard) {
	super();
	this.bankCard = bankCard;
	System.out.println("Acount created or parents class Account constructor used");
}
public void windraw() {

}
public void deposite() {
		
}
public void deleteAccount() {	
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public String getCreateDate() {
	return createDate;
}
public void setCreateDate(String createDate) {
	this.createDate = createDate;
}
public BankCard getBankCard() {
	return bankCard;
}
public void setBankCard(BankCard bankCard) {
	this.bankCard = bankCard;
}

}
