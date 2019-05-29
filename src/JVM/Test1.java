package JVM;

public class Test1 {
    static class Parent{
        public static int A = 1;
        static {
            A = 2;
        }
    }
    static class Sub extends Parent{
        public static int B = A;
    }

    public static void main(String[] argv){
        System.out.println(Sub.A);
    }

}
