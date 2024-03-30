package Handlying_Files;

public class CarObj {
	
	public static void main(String[] args) {
		
		Car bmw = new Car();
		
		bmw.wheels = 2;
		bmw.sherring = 2;
		bmw.color = "white";
		bmw.model = 2525.25;
		
		bmw.start();
		System.out.println();
		bmw.stop();
		
		
	}

}
