package JVM;

import java.lang.ref.SoftReference;

public class TestSoftReference {
    public static void main(String[] argv){
        Object obj = new Object();
        SoftReference<Object> test = new SoftReference<>(obj);
        obj = null;
    }

}
