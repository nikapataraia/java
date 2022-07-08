public class Dog extends Animal{
    public int age;

    public Dog(String name,int age) {
        super(name);
        this.age = age;
    }

    public void Animal(){
        System.out.println("Dog");
    }

}
