import java.util.Map;

public class Investment {
    static int MAX = 200;
    static int F[][] = new int[MAX][MAX];
    static int f[][] = new int[MAX][MAX];   //在某投资额下可以获取的最大利润
    public static void main(String[] args){
        int n = 4,m = 5;    //4个项目，5万资金

        //System.out.println(F[0][0]);
        F[1][0]=0;F[1][1]=11;F[1][2]=12;F[1][3]=13;F[1][4]=14;F[1][5]=15;
        F[2][0]=0;F[2][1]=0;F[2][2]=5;F[2][3]=10;F[2][4]=15;F[2][5]=20;
        F[3][0]=0;F[3][1]=2;F[3][2]=10;F[3][3]=30;F[3][4]=32;F[3][5]=40;
        F[4][0]=0;F[4][1]=20;F[4][2]=21;F[4][3]=22;F[4][4]=23;F[4][5]=24;
        int maxInves = Inves(n,m);
        System.out.println("Max:"+maxInves);
    }
    public static int Inves(int n,int m){
        for(int k = 1;k <= n; k++){ //第i个项目
            for(int x = 1;x <= m;x++){  //i个项目共分配j万元
                for(int xk = 0;xk <= x;xk++){  //第i个项目分配k万元
                    f[k][x] = Math.max(f[k][x],F[k][xk]+f[k-1][x-xk]);
                }
            }
        }
        return f[n][m];
    }
}
