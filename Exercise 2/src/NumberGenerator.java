import java.util.Random;

public class NumberGenerator {
private int a,b,c;



public NumberGenerator() {
	System.out.println("NumberGenerator was created");
}



public void generateNumbers(){
	System.out.println("Creating three numbers");
	Random rd = new Random();	
	int a=rd.nextInt(100);
	int b=rd.nextInt(100);
	int c=rd.nextInt(100);
	setA(a);
	setB(b);
	setC(c);
	System.out.println("Numbers was created:"+a+" "+b+" "+c+" ");
}



public int getA() {
	return a;
}

public void setA(int a) {
	this.a = a;
}

public int getB() {
	return b;
}

public void setB(int b) {
	this.b = b;
}

public int getC() {
	return c;
}

public void setC(int c) {
	this.c = c;
}



}
