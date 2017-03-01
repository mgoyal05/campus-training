package Animal;

public class TestAnimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cat cat1 = new cat();
		cat1.greeting();
	    Dog dog1 = new Dog();
	    dog1.greeting();
	    Bigdog Bigdog1 = new Bigdog();
	    Bigdog1.greeting();
	     
	    // Using Polymorphism
	    Animal animal1 = new Cat();
	    animal1.greeting();
	    Animal animal2 = new Dog();
	    animal2.greeting();
	    Animal animal3 = new Bigdog();
	    animal3.greeting();
	    Animal animal4 = new Animal();
	    
	    // Downcast
	    Dog dog2 = (Dog)animal2;
	    Bigdog Bigdog2 = (Bigdog)animal3;
	    Dog dog3 = (Dog)animal3;
	    Cat cat2 = (Cat)animal2;
	    dog2.greeting(dog3);
	    dog3.greeting(dog2);
	    dog2.greeting(Bigdog2);
	    Bigdog2.greeting(dog2);
	    Bigdog2.greeting(Bigdog1);

}

}
