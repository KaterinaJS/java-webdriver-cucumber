package pages;

public class Cat {

    private String name;

    public Cat(String name){
        this.name = name;
    }

    public void walk(){
        System.out.println(getClass() + " " + name + " is walking");
    }

    public void sleep(){
        System.out.println(getClass() + " " + name + " is sleeping");
    }

    public void speak(){
        System.out.println(getClass() + " " + name + " is speaking");
    }

    public void eat(String  what){
        System.out.println(getClass() + " " + name + " is eating " + what);
    }
}
