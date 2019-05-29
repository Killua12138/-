package jianzhi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReOrderArray {
    public void reOrderArray(int [] array) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < array.length; i++){
            if (array[i] % 2==0)
                list2.add(array[i]);
            else
                list1.add(array[i]);
        }
        int count = 0;
        for(int i : list1)
            array[count++] = i;
        for(int i : list2)
            array[count++] = i;
    }
    public static void main(String[] argv){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"abc");
        map.put(2,"zxc");
        System.out.println(map);
        map.put(1,"qwe");
        System.out.println(map);
    }

}
