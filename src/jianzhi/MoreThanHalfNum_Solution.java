package jianzhi;

public class MoreThanHalfNum_Solution {
    //[1,2,3,2,4,2,5,2,3]
    public int MoreThanHalfNum_Solution(int[] array) {
        int m = array[0], count = 1;
        for (int i = 1; i < array.length; i++) {
            count = m == array[i] ? count + 1 : count - 1;
            if (count == 0) {
                m = array[i];
                count = 1;
            }
        }
        count = 0;
        for (int i : array)
            if (i == m)
                count++;
        System.out.println(count);
        return count > array.length/2 ? m : 0;
    }

    public static void main(String[] argv) {
        MoreThanHalfNum_Solution test = new MoreThanHalfNum_Solution();
        System.out.println(test.MoreThanHalfNum_Solution(new int[]{1, 2, 3, 2, 4, 2, 5, 2, 3}));
    }

}
