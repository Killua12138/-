package leetcode;

import edu.princeton.cs.algs4.Stack;

public class IsValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                char c1 = stack.pop();
                if (c == '(' && c1 != ')')
                    return false;
                if (c == '[' && c1 != ']')
                    return false;
                if (c == '{' && c1 != '}')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
