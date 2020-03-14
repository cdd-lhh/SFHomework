import java.util.Scanner;

public class OrderQuery {

    public OrderQuery(int[] list,int a){
        int i;
        int flag = 0;
        for(i = 0;i < list.length; i++){
            if(a == list[i]){
                flag = 1;
                break;
            }
        }
        if(flag == 1)
            System.out.println(i);
        else
            System.out.println(0);
    }

    public static void main(String[] args){
        int[] list = new int[]{1,2,5,9,7,11,13,15,16,17,18,19,23,24,25,26,28,31,32,36,39,40};
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        OrderQuery orderQuery = new OrderQuery(list,a);
    }
}
