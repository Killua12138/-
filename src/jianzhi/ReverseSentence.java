package jianzhi;

public class ReverseSentence {
    public String ReverseSentence(String str) {
        if (str.length() == 0||str.length() == 1)
            return " ";
        String[] strs = str.split(" ");
        String res = "";
        int n = strs.length;
        while (n-- > 1) {
            System.out.println(strs[n]);
            res += strs[n] + " ";
        }
        res += strs[0];
        return res;
    }
    public static void main(String[] argv){
        ReverseSentence test = new ReverseSentence();
        String str = test.ReverseSentence(" ");
        System.out.println(str+"1");
    }

}
