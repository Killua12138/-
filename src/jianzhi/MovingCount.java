package jianzhi;

public class MovingCount {
    private static int count;
    public int movingCount(int threshold, int rows, int cols) {
        count = 0;
        int[][] arr = new int[rows][cols];
        back(threshold,arr,rows,cols,0,0);
        return count;
    }
    public void back(int k,int[][] arr,int row,int cols,int x,int y){
        if (x >= row || y >= cols || y < 0 || x < 0)
            return;
        if (getSum(x,y) > k)
            return;
        if (arr[x][y] != 1){
            arr[x][y] = 1;
            count++;
        }
        else
            return;
        back(k,arr,row,cols,x+1,y);
        back(k,arr,row,cols,x-1,y);
        back(k,arr,row,cols,x,y+1);
        back(k,arr,row,cols,x,y-1);
    }
    public static int getSum(int x,int y){
        int sum = 0;
        while (x != 0){
            sum = x % 10 + sum;
            x = x / 10;
        }
        while (y != 0){
            sum = y % 10 + sum;
            y = y / 10;
        }
        return sum;
    }
    public static void main(String[] argv){
        MovingCount test = new MovingCount();
        System.out.println(test.movingCount(10,1,100));
    }

}
