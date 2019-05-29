package jianzhi;

import java.util.HashMap;

public class Duplicate {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        duplication[0] = -1;
        if (numbers == null)
            return false;
        if (numbers.length == 0 || numbers.length == 1)
            return false;
        if (numbers.length != length)
            return false;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : numbers){
            if (map.containsKey(i)){
                duplication[0] = i;
                return true;
            }
            else
                map.put(i,1);
        }
        return false;
    }
}
