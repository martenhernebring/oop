package se.hernebring.print;

public class HelloApp {

	public static void main(String[] args) {
		Hello hello = new Hello();
		Hello hiUser = new Hello("Mårten");
		
		hello.greet();
		hiUser.greet();
	}

}
