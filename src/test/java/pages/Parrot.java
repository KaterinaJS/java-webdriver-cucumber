package pages;

public class Parrot extends Animal {
    public Parrot(String name) {
        this.name = name;
    }

    public void speak() {
        System.out.println(classAndName() + " is chirping!");
    }

    public void fly() {
        System.out.println(classAndName() + " is flying!");
    }

    public void walk() {
        System.out.println(classAndName() + " is walking!");
    }

    public void swim() {
        System.out.println(classAndName() + " cannot swim!");
    }
}
