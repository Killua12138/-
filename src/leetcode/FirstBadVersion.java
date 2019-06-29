package leetcode;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int l = 0,h = n;
        while (l <= h){
            int mid = l + (h - l) / 2;
            if (isBadVersion(mid) == false)
                h = mid;
            else
                l = mid + 1;
        }
        return h;
    }
    boolean isBadVersion(int version){
        return false;
    }

}