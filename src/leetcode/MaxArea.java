package leetcode;

public class MaxArea {
    public int maxArea(int[] height) {
        int max = 0;
        int l = 0,r = height.length - 1;
        while(l <= r){
            int h1 = height[l],h2 = height[r];
            int temp = Math.min(h1,h2)*(r-l);
            if (temp > max)
                max = temp;
            if (h1 <= h2)
                l++;
            else r--;
        }
        return max;
    }
}
