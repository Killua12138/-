package jianzhi;

public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0)
            return true;
        return judge(sequence, 0, sequence.length - 1);
    }

    private boolean judge(int[] sequence, int lo, int hi) {
        if (hi <= lo + 1)
            return true;
        int i = lo, j = hi - 1, val = sequence[hi];
        while (i <= hi && sequence[i] < val) i++;
        while (j >= lo && sequence[j] > val) j--;
        if (j != i - 1) {
            return false;
        }
        return judge(sequence, lo, j) && judge(sequence, i, hi - 1);
    }

    public static void main(String[] argv) {
        VerifySquenceOfBST test = new VerifySquenceOfBST();
        int[] a = {5, 4, 3, 2, 1};
        System.out.println(test.VerifySquenceOfBST(a));
    }

}
