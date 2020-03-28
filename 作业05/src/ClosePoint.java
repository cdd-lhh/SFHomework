import java.util.*;

import static java.lang.Math.*;

public class ClosePoint {

    static class Point{
        double x,y;

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public Point(double x, double y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n>0){
            Point[] ps = new Point[n];
            for(int i = 0;i < n;i++){
                double x = scanner.nextDouble();
                double y = scanner.nextDouble();
                ps[i] = new Point(x,y);
            }
            //对x进行升序
            Arrays.sort(ps, new Comparator<Point>() {   //Arrays对数组进行排序
                @Override
                public int compare(Point o1, Point o2) {
                    if(o1.x < o2.x) return -1;  //-1不交换
                    if(o1.x > o2.x) return 1;   //1交换
//                    if(o1.y < o2.y) return -1;
//                    if(o1.y > o2.y) return 1;
                    return 0;
                }
            });
            double minDis = minDistance(ps,0,n-1);
            System.out.println(minDis);
        }
    }

    public static double minDistance(Point[] ps,int left, int right){
        if(left == right)   return Double.MAX_VALUE;
        if(left+1 == right) return distance(ps[left],ps[right]);
        int center = (left + right) / 2;
        double dis1 = minDistance(ps,left,center);
        double dis2 = minDistance(ps,center+1,right);
        double minDis = min(dis1,dis2);
        ArrayList<Point> nearPoints = new ArrayList<>();
        //选出距离中间线小于minDis的点
        for (Point p : ps) {
            if(abs(ps[center].x - p.x) <= minDis){
                nearPoints.add(p);
            }
        }
        Collections.sort(nearPoints, new Comparator<Point>() {      //Collections对List<T>排序
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.y < o2.y) return -1;
                if (o1.y > o2.y) return 1;
//                if (o1.x < o2.x) return -1;
//                if (o1.x > o2.x) return 1;
                return 0;
            }
        });
        for(int i = 0;i < nearPoints.size();i++){
            for(int j = i + 1;j < nearPoints.size();j++){
                if(nearPoints.get(j).y - nearPoints.get(i).y > minDis)
                    break;
                double d = distance(nearPoints.get(j), nearPoints.get(i));
                if (d < minDis) {
                    minDis = d;
                }
            }

        }
        return minDis;
    }

    public static double distance(Point p1, Point p2){
        if(p1 == p2)    return 0;
        return sqrt(pow(p1.x - p2.x,2)+ pow(p1.y - p2.y,2));
    }
}
