package JVM;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
    static class OOMObject{
    }
    public static void main(String[] argv){
        List<OOMObject> list = new ArrayList<OOMObject>();
        while(true){
            list.add(new OOMObject());
        }

    }

}
