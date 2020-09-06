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
}
