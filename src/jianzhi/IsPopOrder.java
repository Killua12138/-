package jianzhi;

import java.util.Stack;

public class IsPopOrder {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0)
            return true;
        if (pushA.length == 1 && pushA[0] != popA[0])
            return false;
        int[] arr = new int[pushA.length];
        int index = 0, top = 0;
        arr[top] = pushA[index++];
        for (int i = 0; i < popA.length; i++) {
            while (index < pushA.length && top < pushA.length && arr[top] != popA[i]) {
                arr[++top] = pushA[index];
                index++;
            }
            if (arr[top] != popA[i]) {
                return false;
            }
            top--;
        }
        return true;
    }

    public static void main(String[] argv) {
        IsPopOrder test = new IsPopOrder();
        test.IsPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2});
    }

}
