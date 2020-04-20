
import java.util.Scanner;

public class MatrixChain {

    private static int n;
    private static int[] p = new int[105];
    private static int[][] m = new int[100][100];
    private static int[][] s = new int[100][100];
    private static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for(int i = 0;i <= n;i++){
            p[i] = scanner.nextInt();
            m[i][i] = 0;
        }

        for(int r =2;r <= n;r++){   //r为当前问题规模
            for(int i = 1;i <= n-r+1;i++){  //i的起点不断变化，各种r长
                int j = i+r-1;
                m[i][j] = MAX;
                for(int k = i;k <= j - 1;k++){
                    int q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
                    if(q < m[i][j]){
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
        print(1,n);
        System.out.printf(" %d",m[1][n]);
    }
    public static void print(int i,int j){
        if(i == j)
            System.out.print("A"+i);
        else{
            System.out.print("(");
            print(i,s[i][j]);
            print(s[i][j]+1,j);
            System.out.print(")");
        }
    }
}
