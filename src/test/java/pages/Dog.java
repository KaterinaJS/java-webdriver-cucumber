package pages;

public class Dog extends Animal {

    public Dog(String name) {
        this.name = name;
    }

    public void speak() {
        System.out.println(classAndName() + " is barking!");
    }

    public void fly() {
        System.out.println(classAndName() + " cannot fly!");
    }

    public void walk() {
        System.out.println(classAndName() + " is walking!");
    }

    public void swim() {
        System.out.println(classAndName() + " is swimming!");
    }

}