package point;

interface Action {
    void greeting();
    void speaking();
}
public class Person implements Action {
    private String name;
    private int age;
    private int height;
    private int weight;
    public Person(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public void greeting() {
        System.out.println("Hello!");
    }

    @Override
    public void speaking() {
        System.out.println("I am " + this.name);
    }
    public String toString() {
        return String.format("I am %s, this is my information [%d : %d : %d]", this.name, this.age, this.height, this.weight);
    }
}
