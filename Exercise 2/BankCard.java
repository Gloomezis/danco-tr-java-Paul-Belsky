
public abstract class BankCard {
int cardNumber;
String dateOfRecieve;
String dateOfEnds;
int percentOfTakingCash;

public BankCard() {
	System.out.println("abstract class BankCard constructor used");
		
	}


public abstract void calculetePercentOfTakingCash() ;

public int getCardNumber() {
	return cardNumber;
}
public void setCardNumber(int cardNumber) {
	this.cardNumber = cardNumber;
}
public String getDateOfRecieve() {
	return dateOfRecieve;
}
public void setDateOfRecieve(String dateOfRecieve) {
	this.dateOfRecieve = dateOfRecieve;
}
public String getDateOfEnds() {
	return dateOfEnds;
}
public void setDateOfEnds(String dateOfEnds) {
	this.dateOfEnds = dateOfEnds;
}
public int getPercentOfTakingCash() {
	return percentOfTakingCash;
}
public void setPercentOfTakingCash(int percentOfTakingCash) {
	this.percentOfTakingCash = percentOfTakingCash;
}


}
