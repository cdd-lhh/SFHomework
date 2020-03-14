import java.util.Scanner;

public class BinarySearch {

    public int BinarySearch(int[] list, int a){
        int left = 0, right = list.length - 1, mid = 0;
        while(left <= right){
            mid = (left + right) / 2;
            if(list[mid] == a)
                return mid;
            else if(list[mid] < a)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] list = new int[]{1, 2, 5, 9, 7, 11, 13, 15, 16, 17, 18, 19, 23, 24, 25, 26, 28, 31, 32, 36, 39, 40};
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.BinarySearch(list,a));
    }
}
