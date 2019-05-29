package leetcode;

import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {
    //O(2n)
    int lengthOfLongestSubstring(String s) {
        int max = 0;
        int i = 0,j = 0;
        Set<Character> window = new HashSet<>();
        while (i < s.length()) {
            if (!window.contains(s.charAt(i))) {
                window.add(s.charAt(i));
                i++;
            }
            else{
                window.remove(s.charAt(j));
                j++;
            }
            if (i - j > max)
                max = i - j;
        }
        return max;
    }
    //O(n)
    int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 1;
        for (int i = 0, j = 0; j < s.length(); j++){
            if (map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)),i);
            }
            max = Math.max(max,j - i);
            map.put(s.charAt(j),j);
        }
        return max;
    }
}
