package TypeInfo;

public class SweetShop {
    public static void main(String[] argv){
        System.out.println("inside main");
        new Candy();
        System.out.println("After Creating Candy");
        try{
            Class.forName("TypeInfo.Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("No Gum");
        }
        System.out.println("After Gum");
        new Cookie();
        System.out.println("After Cookie");
    }

}
class Candy{
    static {
        System.out.println("Candy");
    }
}
class Gum{
    static{
        System.out.println("Gum");
    }
}
class Cookie{
    static {
        System.out.println("Cookie");
    }
}
