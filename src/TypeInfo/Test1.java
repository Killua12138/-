package TypeInfo;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test1 {
    public static void test1() throws IllegalAccessException, InstantiationException, NoSuchMethodException {
        Class<?> c = MethodClass.class;
        Object obj = c.newInstance();
        Method[] methods = c.getMethods();
        Method[] declaredMethos = c.getDeclaredMethods();
        Method method = c.getMethod("add",int.class,int.class);
        System.out.println(method);
        System.out.println("getMethods:");
        for (Method m : methods)
            System.out.println(m);
        System.out.println("getDeclaredMethods:");
        for (Method m : declaredMethos)
            System.out.println(m);
    }
    public static void test2() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> klass = MethodClass.class;
        Object obj = klass.newInstance();
        Method m = klass.getMethod("add",int.class,int.class);
        Object res = m.invoke(obj,1,2);
        System.out.println(res);
    }
    public static void test3() throws ClassNotFoundException {
        Class<?> cls = Class.forName("java.lang.String");
        Object arrays = Array.newInstance(cls,25);
        Array.set(arrays,0,"ASD");
        Array.set(arrays,1,"zxc");
        Array.set(arrays,2,"asdasdasdasdas");
        System.out.println(Array.get(arrays,1));
    }
    public static void main(String[] argv) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        test3();
    }

}
class MethodClass{
    public final int fuck = 3;
    public int add(int a,int b){
        return a + b;
    }
    public int sub(int a,int b){
        return a - b;
    }
}
