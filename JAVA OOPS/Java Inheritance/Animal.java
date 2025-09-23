class Animal {
    String name;
    int age;
    void makeSound() {}
}

class Dog extends Animal {
    void makeSound() { System.out.println("Woof"); }
}

class Cat extends Animal {
    void makeSound() { System.out.println("Meow"); }
}

class Bird extends Animal {
    void makeSound() { System.out.println("Chirp"); }
}

public class Main {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();
        Animal a3 = new Bird();
        a1.makeSound();
        a2.makeSound();
        a3.makeSound();
    }
}
