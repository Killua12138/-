package jianzhi;

public class FindGreatestSumOfSubArray {
    //{6,-3,-2,7,-15,1,2,2}
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0)
            return 0;
        int max = array[0],sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
            if (sum > max){
                max = sum;
            }
            if (sum < 0)
                sum = 0;
        }
        return max;
    }
}
