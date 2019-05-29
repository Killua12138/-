package JVM;

public class Singleton {
    private volatile static Singleton instance;

    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    if (instance == null){
                        instance = new Singleton();
                    }
                }
            }
        }
        return null;
    }
    public static void main(String[] argv){
        Singleton.getInstance();
    }

}
