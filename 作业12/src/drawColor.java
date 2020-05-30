import java.util.Scanner;

public class drawColor {
    static int n,m;    //n顶点数，m颜色数
    static int[][] graph = new int[20][20];
    static int[] color = new int[20];


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a,b;    //表示两个点的关系
        n = scanner.nextInt();
        m = scanner.nextInt();
        while(true){
            a = scanner.nextInt();
            b = scanner.nextInt();
            if(a == 0 && b == 0)
                break;
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        back(1);
    }
    static void back(int cur){
        if(cur > n){
            for(int i = 1;i <= n;i++){
                System.out.print(color[i]+" ");
            }
            cur++;
            System.out.println();
        }
        else{
            for(int i = 1;i <= m;i++){
                color[cur] = i;
                if(godown(cur)){
                    back(cur+1);
                }
                color[cur] = 0;
            }
        }
    }
    static boolean godown(int c){
        for(int i = 1;i <= n;i++){
            if(graph[c][i]==1 && color[c]==color[i]){
                return false;
            }
        }
        return true;
    }

}
