package JVM;

public class ReferenceCountingGC {
    public Object instance = null;
    public static void main(String[] argv){
        ReferenceCountingGC test1 = new ReferenceCountingGC();
        ReferenceCountingGC test2 = new ReferenceCountingGC();
        test1.instance = test2;
        test2.instance = test1;
        System.gc();
    }

}
