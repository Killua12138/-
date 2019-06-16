package test;

import java.util.HashSet;

public class TryReturn extends AbstractTest implements TestInterface{

    public static int x = 1;
    public static int test(){
        throw new RuntimeException();
        /*
        try{
            //return ++x;
        }finally {
            int k = 4;
            return k;
        }*/
    }
    public static int test(int x){
        return x;
    }
    public static void main(String[] argv){
        System.out.println(test());
    }

}
