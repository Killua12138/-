package jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Permutation {
    public ArrayList<String> Permutation(String str) {
        if (str == null || str.equals(""))
            return new ArrayList<>();
        char[] ch = str.toCharArray();
        ArrayList<String> strs = new ArrayList<>();
        Arrays.sort(ch);
        permutation(ch,strs,0);
        Collections.sort(strs);
        return strs;
    }
    private void permutation(char[] ch,ArrayList<String> strs,int index){
        for (int i = index; i < ch.length; i++){
            swap(ch,i,index);
            System.out.println(ch);
            strs.add(String.valueOf(ch));
            permutation(ch,strs,index + 1);
            swap(ch,i,index);
        }
    }
    private void swap(char[] ch,int i,int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
    public static void main(String[] argv){
        Permutation test = new Permutation();
        String str = "abc";
        System.out.println(test.Permutation(str));
    }

}
