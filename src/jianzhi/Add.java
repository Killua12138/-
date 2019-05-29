package jianzhi;

public class Add {
    public int Add(int num1,int num2) {
        int res = num1 ^ num2;
        int xor = num1 ^ num2;
        int forward = (num1 & num2) << 1;
        if (forward != 0)
            res = Add(xor,forward);
        else
            return res;
        return res;
    }
    public static void main(String[] argv){
        Add test = new Add();
        int sum = test.Add(789,456);
        System.out.println(sum);
    }

}
