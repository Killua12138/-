package Generic;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    public T data;
    public Node(T data) { this.data = data; }
    public void setData(T data) {
        System.out.println("Node.setData");
        this.data = data;
    }
    public static void main(String[] argv){
        MyNode mn = new MyNode(5);
        Node n = mn; // A raw type - compiler throws an unchecked warning
        n.setData("Hello"); // Causes a ClassCastException to be thrown.
        System.out.println(n.data);
        //Integer x = mn.data;
    }

}
class MyNode extends Node {
    public MyNode(Integer data) { super(data); }
    public void setData(Integer data) {
        System.out.println("MyNode.setData");
        super.setData(data);
    }
}
