public class Dijkstra {

    static int m = Integer.MAX_VALUE;

    static class Entity {
        int[][] matrix;
        char[] nodes;
        boolean[] visited = new boolean[100005];
        int dis[] = new int[10005];

        public Entity(char[] nodes, int[][] matrix) {
            this.nodes = nodes;
            this.matrix = matrix;
        }

        public void Impl() {
//            //初始化点与点之间的初始距离
            int[][] distance = new int[nodes.length][nodes.length];
            for (int i = 0; i < nodes.length; i++) {
                for (int j = 0; j < nodes.length; j++) {
                    distance[i][j] = matrix[i][j];
                }
            }
            for (int i = 0; i < nodes.length; i++) {
                dis[i] = distance[0][i];
            }
            visited[0] = true;
            for (int i = 0; i < nodes.length; i++) {
                int min = m;
                int index = -1;
                for(int j = 0; j < nodes.length; j++){
                    if(visited[j] == false){
                        if(dis[j] < min){
                            index = j;
                            min = dis[j];
                        }
                    }
                }
                if(index != -1)
                    visited[index] = true;
                //更新
                for(int k = 0; k < nodes.length; k++){
                    if(visited[k] == false){
                        if(distance[index][k] != m  && (min + distance[index][k] < dis[k])){
                            dis[k] = min + distance[index][k];
                        }
                    }
                }
            }
            for(int i = 0;i < nodes.length; i++){
                System.out.println("a到"+ nodes[i]+ "的距离是：" +dis[i]);
            }
        }
    }
        public static void main(String[] args) {
        char nodes[] = {'a', 'b', 'c', 'd', 'e', 'f','g','h'};
            int matrix[][] = new int[][]{
                         /*a b  c  d  e  f  g  h*/
                    /*a*/{0, 1, m, m, m, m, m, m},
                    /*b*/{m, 0, m, 2, m, m, m, m},
                    /*c*/{2, m, 0, m, m, m, m, m},
                    /*d*/{m, m, 1, 0, m, 8, m, m},
                    /*e*/{m, m, m, 2, 0, m, 2, m},
                    /*f*/{m, m, m, m, 2, 0, m, m},
                    /*g*/{m, m, m, m, m, 3, 0, 3},
                    /*h*/{m, m, m, m, m, 2, m, 0}
            };
            Entity entity = new Entity(nodes, matrix);
            entity.Impl();
        }
}