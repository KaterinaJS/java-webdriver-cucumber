package pages;

public class Fish extends Animal {

//    public Fish(String name) {
//        this.name = name;
//    }

    public void speak() {
        System.out.println(classAndName() + " cannot speak!");
    }

    public void fly() {
        System.out.println(classAndName() + " cannot fly!");
    }

    public void walk() {
        System.out.println(classAndName() + " cannot walk!");
    }

    public void swim() {
        System.out.println(classAndName() + " is swimming!");
    }
}
