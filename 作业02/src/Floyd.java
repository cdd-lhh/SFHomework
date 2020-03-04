public class Floyd {

    static class Entity {
        int[][] matrix;
        char[] nodes;

        public Entity(char[] nodes, int[][] matrix) {
            this.nodes = nodes;
            this.matrix = matrix;
        }

        public void Impl() {
            int m = Integer.MAX_VALUE;
            //初始化点与点之间的初始距离
            int[][] distance = new int[nodes.length][nodes.length];
            for (int i = 0; i < nodes.length; i++) {
                for (int j = 0; j < nodes.length; j++) {
                    distance[i][j] = matrix[i][j];
                }
            }
            //依次插入点
            for (int k = 0; k < nodes.length; k++) {
                for (int i = 0; i < nodes.length; i++) {
                    for (int j = 0; j < nodes.length; j++) {
                        int temp = (distance[i][k] == m || distance[k][j] == m) ? m:distance[i][k] + distance[k][j];
                        if(temp < distance[i][j]){
                            distance[i][j] = temp;
                        }
                    }
                }
            }
            //输出各个顶点之间的距离
            for (int i = 0; i < nodes.length; i++) {
                for (int j = 0; j < nodes.length; j++) {
                    System.out.println(nodes[i] + "到" + nodes[j] + "的最短距离是：" + distance[i][j]);
                }
            }
        }
    }


    public static void main(String[] args){
        /**
         *   1.用矩阵保存点与点之间的距离
         *   2.用for循环一个一个点进行试探
         */
        char nodes[] = {'1','2','3','4'};
        int m = Integer.MAX_VALUE;
        int matrix[][] = new int[][]{
                {0, 2, 6, 4},
                {m, 0, 3, m},
                {7, m, 0, 1},
                {5, m, 12, 0}
        };
        Entity floyd = new Entity(nodes, matrix);
        floyd.Impl();
    }
}


/**
 *  //初始化点与点之间的距离
 *  for(起点){
 *      for(终点){
 *          distance[][] = matrix[][]
 *      }
 *  }
 *  //循环把各个点插入到两点之间，如果插入点之后的距离小于原来的距离，则替换
 *  for(插入的点){
 *      for(起点){
 *          for(终点){
 *              if(new < old){
 *                  distance[i][j] = distance[i][k] + distance[k][j];
 *              }
 *          }
 *      }
 *  }
 *
 */

