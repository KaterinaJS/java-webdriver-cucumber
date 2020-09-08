package pages;

public class Cat extends Animal {

    public Cat(String name) {
        this.name = name;
    }

    public void speak() {
        System.out.println(classAndName() + " is meowing!");
    }

    public void fly() {
        System.out.println(classAndName() + " can not fly");
    }

    public void walk() {
        System.out.println(classAndName() + " is walking!");
    }

}