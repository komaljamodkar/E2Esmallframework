package threadconcept;


//When we develop a class in such a way that it can have only instance at any time, is called Singleton design pattern. It is very useful when you need to use same object of a class across all classes or framework. Singleton class must return the same instance again, if it is instantiated again.
//
//To create a singleton class, we need to do following steps:
//
//Declare constructor of class as private so that no one instantiate class outside of it.
//Declare a static reference variable of class. Static is needed to make it available globally.
//Declare a static method with return type as object of class which should check if class is already instantiated once.

public class SingletoneClassExample {
	
	//declare instace to null value
	private static SingletoneClassExample instanceSingletoneClassExample=null;
	
	//private constructor created not accessible to outside the class
	private SingletoneClassExample() {
		System.out.println("object created");
	}
	
	// static method to create instance of class SingletonClassExample
	public static SingletoneClassExample getInstanceSingletoneClassExample() {
		if(instanceSingletoneClassExample==null) {
			instanceSingletoneClassExample=new SingletoneClassExample();
		}
		
		return instanceSingletoneClassExample;
	}

	public static void main(String[] args) {
		SingletoneClassExample f=SingletoneClassExample.getInstanceSingletoneClassExample();
		SingletoneClassExample t=SingletoneClassExample.getInstanceSingletoneClassExample();

	}

}
