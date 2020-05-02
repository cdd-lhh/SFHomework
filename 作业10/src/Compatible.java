import java.util.Arrays;

import java.util.Comparator;
import java.util.Scanner;

public class Compatible{
    static class Action{
        int start;
        int end;
        Action(int start,int end){
            this.start = start;
            this.end = end;
        }
    }

    static int select(Action[] action,boolean[] A){
        int n = action.length;
        A[0] = true;
        int j = 0;
        int count = 1;
        for(int i = 1;i < n;i++){
            if(action[i].start >= action[j].end){
                A[i] = true;
                j = i;
                count++;
            }else{
                A[i] = false;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        //int s[] = new int[20];
        int start;
        int end;
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入活动的数量：");
        int n = scanner.nextInt();
        Action[] action = new Action[n];
        for(int i = 0;i < n;i++){
            start = scanner.nextInt();
            end = scanner.nextInt();
            action[i] = new Action(start,end);
            //action[i].end = scanner.nextInt();
            //System.out.println(action[i].start);
        }
        Arrays.sort(action, new Comparator<Action>() {
            @Override
            public int compare(Action o1, Action o2) {
                if(o1.end < o2.end) return -1;
                if(o1.end > o2.end) return 1;
                return 0;
            }
        });
        boolean[] A = new boolean[action.length];
        int count = select(action,A);
        System.out.println("最多可以安排的活动数为"+count);
//        for(int i = 0;i < n;i++){
//            System.out.println("活动："+action[i].start+" "+action[i].end);
//        }
        for(int i = 0;i < n;i++){
            if(A[i]){
                System.out.println("第"+(i+1)+"活动被选中，其开始时间为："+action[i].start+"，结束时间为："+action[i].end);
            }
        }
    }
}
