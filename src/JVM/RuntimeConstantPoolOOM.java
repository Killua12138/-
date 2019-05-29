package JVM;

public class RuntimeConstantPoolOOM {
    public static void main(String[] argv){
        String str1 = new StringBuilder("郑宇豪").append("虹虹").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);

    }

}
