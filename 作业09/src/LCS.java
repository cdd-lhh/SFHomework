import java.util.Scanner;
import java.util.Stack;

public class LCS {
    static String x = null;
    static String y = null;
    static String lcs = null;
    int n,m;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("X:");
        x = scanner.next();
        System.out.print("Y:");
        y = scanner.next();

        getLcsLength(x,y);
    }
    static void getLcsLength(String x,String y){
        /*
        *  求子序列的长度
        **/
        int[][] C = new int[x.length()+1][y.length()+1];
        int[][] flag = new int[x.length()+1][y.length()+1];
        for(int j = 0; j <= y.length();j++){
            C[0][j] = 0;    //初始化第0行j列全为0
        }
        for(int i = 0; i <= x.length();i++){
            C[i][0] = 0;    //初始化第i行0列为0
        }
        for(int i = 1;i <= x.length();i++){
            for(int j = 1; j <= y.length();j++){
                if(x.charAt(i-1) == y.charAt(j-1)){
                    C[i][j] = C[i-1][j-1]+1;
                    flag[i][j] = 2;
                }else{
                    if(C[i-1][j] >= C[i][j-1]){
                        C[i][j] = C[i-1][j];
                        flag[i][j] = 0;
                    }
                    else{
                        C[i][j] = C[i][j-1];
                        flag[i][j] = 1;
                    }
//                    C[i][j] = Math.max(C[i-1][j],C[i][j-1]);
//                    if(C[i][j] == C[i-1][j])
//                        flag[i][j] = 0;
//                    else if(C[i][j] == C[i][j-1])
//                        flag[i][j] = 1;
                }
            }
        }
        /*
         *  求最长子序列的内容
         * */
        int n,m;
        n = x.length();
        m = y.length();
        Stack stack = new Stack();
        while(n != 0 && m != 0){

            if(flag[n][m] == 0)
                n--;
            else if(flag[n][m] == 1)
                m--;
            else if(flag[n][m] == 2){
                stack.push(x.charAt(n-1));
                n--;
                m--;
            }

        }
        System.out.print("最长子序列:");
        while(!stack.empty())
            System.out.print(stack.pop());
        System.out.println();

        System.out.println("长度为："+C[x.length()][y.length()]);
    }

}
