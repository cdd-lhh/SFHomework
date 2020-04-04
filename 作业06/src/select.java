
import java.util.Arrays;
import java.util.Scanner;

public class select {

    public static void main(String[] args) {
        int[] A = {5,6,2,5,1,9,2,6,11,25,64,18,96,14,52,35,65,15};
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入K值：");
        int K = scanner.nextInt();
        int findK = selectK(A, 0, A.length - 1, K);
        System.out.println("第" + K + "小的数是：" + findK);
    }
    public static int selectK(int[] A, int low, int high, int K) {

        // 设置阈值
        int p = high - low + 1; //p=18  //p=3
        if (p <= 5) {

            // 这里要注意新分配的空间 q+1造成干扰，不能直接Sort(A)
            Arrays.sort(A, low, p);
            return A[K - 1];
        } else {

            // 分为五段
            int q = p / 5;  //q=3
            int remainder = p - q * 5;  //剩余18-3*5=3

            // 每段排序并把中项存入mid
            int[] mid = new int[q + 1];     //int[4],分为4个数组
            for (int i = 0; i < q; i++) {
                Arrays.sort(A, 5 * i, (i + 1) * 5);
                mid[i] = A[i * 5 + 2]; // low
            }

            // 除不尽5之后的分为一段并找出中项存入mid
            if (remainder > 0) {
                Arrays.sort(A, 5 * q, 5 * q + remainder);
                mid[q] = A[q * 5 + (remainder + 1) / 2 - 1];
            }

            // 中项集合的中项
            int mm = selectK(mid, 0, q - 1, (q + 1) / 2);    //q=3 mm=9

            int[] A1 = new int[p];
            int[] A2 = new int[p];
            int[] A3 = new int[p];
            int lenA1 = 0, lenA2 = 0, lenA3 = 0;

            // 分别与中项比较，分为新的三段
            for (int i = low; i <= high; i++) { //low=0,high=17
                if (A[i] < mm) {
                    A1[lenA1++] = A[i];
                } else if (A[i] == mm) {
                    A2[lenA2++] = A[i];
                } else if (A[i] > mm) {
                    A3[lenA3++] = A[i];
                }
            }

            // 将三段的长度与K比较判断K的位置并递归
            int find = 0;
            if (lenA1 >= K) {
                find = selectK(A1, 0, lenA1 - 1, K);
            } else if (lenA2 + lenA1 < K) {
                find = selectK(A3, 0, lenA3 - 1, K - lenA1
                        - lenA2);
            } else if (lenA1 + lenA2 >= K) {
                find = mm;
            }
            return find;
        }

    }
}
