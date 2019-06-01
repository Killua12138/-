package leetcode;

public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;
        int n = obstacleGrid.length,m = obstacleGrid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (i == 0 && j == 0)
                    obstacleGrid[i][j] = 1;
                else if (obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = 0;
                else if (i == 0)
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                else if (j == 0)
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                else
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
            }
        }
        return obstacleGrid[n - 1][m - 1];
    }
    public static void main(String[] argv){
        int[][] a = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        UniquePathsWithObstacles test = new UniquePathsWithObstacles();
        int count = test.uniquePathsWithObstacles(a);
        System.out.println(count);
    }

}
