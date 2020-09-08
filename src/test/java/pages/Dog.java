package pages;

public class Dog extends Animal {

    public void speak() {
        System.out.println(classAndName() + " is barking");
    }

    public void fly() {
        System.out.println(classAndName() + " can not fly");
    }

}