package test;

public class TryReturn {
    public static int x = 1;
    public static int test(){
        try{
            return ++x;
        }finally {
            int k = 4;
            return k;
        }
    }
    public static void main(String[] argv){

    }

}
