import java.util.Arrays;

public class BinaryOrder {
    public static void main(String[] args) {
        int list[] = {1, 5, 9, 2, 6, 3, 11, 15, 18, 19};
        merge(list, 0, list.length - 1);
        System.out.println(Arrays.toString(list));
    }


        public static void merge(int list[], int start, int end){
        int middle = (start + end) / 2;
        if(start < end){
            merge(list,start,middle);
            merge(list,middle+1,end);
            mergeSort(list,start,middle,end);
        }
    }

    public static void mergeSort(int list[],int start, int middle, int end) {
        int mid = (start + end) / 2 + 1;
        int startIndex = start;
        int endIndex = end;
        int index = 0;
        int middleIndex = middle;
        int[] nums = new int[end - start + 1];
        while (startIndex <= middleIndex && mid <= endIndex) {
            if (list[startIndex] < list[mid] && startIndex <= middleIndex) {
                nums[index++] = list[startIndex++];

            }
            if (list[startIndex] > list[mid] && mid <= endIndex) {
                nums[index++] = list[mid++];

            }
        }
        while (startIndex <= middleIndex) {
            nums[index++] = list[startIndex++];
        }

        //右边剩余
        while (mid <= end) {
            nums[index++] = list[mid++];
        }


        for (int i = 0; i < nums.length; i++) {
            list[i + start] = nums[i];

        }
    }

}



