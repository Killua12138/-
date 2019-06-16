package test;

public class CloneTest implements Cloneable{
    private int a = 1;
    private int b = 2;
    static {
        System.out.println(123);
    }
    public StringBuffer s = new StringBuffer("asd");
    @Override
    public CloneTest clone() throws CloneNotSupportedException {
        return (CloneTest) super.clone();
    }
    public String toString(){
        return a + " " + b + " " + s;
    }
    private void setA(int a){
        this.a = a;
    }
    public static void main(String[] argv){
       /* CloneTest clone = new CloneTest();
        CloneTest clone1 = new CloneTest();
        CloneTest clone2 = null;
        try {
            clone2 = clone.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        clone2.s = clone.s.append("qwe");
        System.out.println(clone);
        System.out.println(clone2);*/
    }

}
