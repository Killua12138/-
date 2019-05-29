package leetcode;

public class CanJump {
    public boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;
        int N = nums.length;
        int index = 0, sum = 0, max = 0;
        while (nums[index] != 0) {
            int temp = 0;
            boolean isChange = false;
            for (int i = index + 1, j = 0; i < N && i < index + nums[index] + 1; i++, j++) {
                sum = nums[i] + i;
                if (sum >= max) {
                    temp = i;
                    max = sum;
                    isChange = true;
                }
            }
            if (max >= N - 1)
                return true;
            if (isChange)
                index = temp;
        }
        return false;
    }

    public static void main(String[] argv) {
        CanJump test = new CanJump();
        int[] nums = {-1};
        boolean flag = test.canJump(nums);
        System.out.println(flag);
    }

}
