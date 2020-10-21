package se.hernebring.print;

public class Hello {
    private String hello;
    
    public Hello() {
    	hello = "Hello!";
    }
    
    public Hello(String name) {
    	hello = "Hello "+name;
    }
    
    public void greet() {
    	System.out.println(hello);	
    }
}
