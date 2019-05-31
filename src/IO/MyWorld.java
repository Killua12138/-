package IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyWorld {
    public static void main(String[] argv) throws IOException, ClassNotFoundException {
        House house = new House();
        List<Animal> animals =new ArrayList<>();
        animals.add(new Animal("Bosco the dog", house));
        animals.add(new Animal("Ralphh the hamster",house));
        animals.add(new Animal("Molly the cat",house));
        System.out.println("animals: " + animals);
        ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
        ObjectOutputStream o1 = new ObjectOutputStream(buf1);
        o1.writeObject(animals);
        o1.writeObject(animals);
        ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
        ObjectOutputStream o2 = new ObjectOutputStream(buf2);
        o2.writeObject(animals);
        ObjectInputStream in1 = new ObjectInputStream(
                new ByteArrayInputStream(buf1.toByteArray())
        );
        ObjectInputStream in2 = new ObjectInputStream(
                new ByteArrayInputStream(buf2.toByteArray())
        );
        List a1 = (List) in1.readObject(),
                a2 = (List) in1.readObject(),
                a3 = (List) in2.readObject();
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
    }

}
class House implements Serializable{}
class Animal implements Serializable{
    private String name;
    private House preferredHouse;
    Animal(String nm, House in){
        name = nm;
        preferredHouse = in;
    }
    public String toString(){
        return name + "[" + super.toString() +"], " + preferredHouse + "\n";
    }
}
