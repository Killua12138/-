package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs(list,"",0,0,n);
        return list;
    }
    public void dfs(List<String> list,String str,int l,int r,int n){
        if (str.length() == 2*n){
            list.add(str);
            return;
        }
        if (l < n)
            dfs(list,str+'(',l+1,r,n);
        if (r < l)
            dfs(list,str+')',l,r+1,n);
    }
}
