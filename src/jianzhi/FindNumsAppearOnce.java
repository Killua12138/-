package jianzhi;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer , Integer> map = new HashMap<>();;
        for (int i = 0; i < array.length;i++){
            if (!map.containsKey(array[i]))
                map.put(array[i],1);
            else
                map.put(array[i],2);
            System.out.println(map);
        }
        int count = 0;
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer,Integer> entry = (Map.Entry)it.next();
            int key = entry.getKey();
            int value = entry.getValue();
            if (value == 1 && count == 0) {
                num1[0] = key;
                count++;
            }
            else if(value == 1 && count == 1){
                num2[0] = key;
                count++;
            }
        }
        System.out.println(num1[0]+" "+num2[0]);
    }
    public static void main(String[] argv){
        FindNumsAppearOnce test = new FindNumsAppearOnce();
        int[] a = {2,4,3,6,3,2,5,5};
        int[] n1 = new int[1];
        int[] n2 = new int[1];
        test.FindNumsAppearOnce(a,n1,n2);
    }

}
