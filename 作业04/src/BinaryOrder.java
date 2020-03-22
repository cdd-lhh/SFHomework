import java.util.Arrays;

public class BinaryOrder {
    public static void main(String[] args) {
        int list[] = {1, 5, 9, 2, 6, 3, 11, 15, 18, 19};    //6, 3, 11, 15, 18, 19
        int temp[] = new int[list.length];
        merge(list, 0, list.length - 1,temp);
        System.out.println(Arrays.toString(list));
    }


        public static void merge(int list[], int start, int end, int[] temp){
        if(start < end){
            int middle = (start + end) / 2;
            merge(list,start,middle,temp);
            merge(list,middle+1,end,temp);
            mergeSort(list,start,middle,end,temp);
        }
    }

    public static void mergeSort(int[] list,int start,int middle,int end,int[] temp){
        int p = start;
        int q = middle+1;
        int index = 0;
        while(p <= middle && q <= end){
            if(list[p] <= list[q])
                temp[index++] = list[p++];
            else
                temp[index++] = list[q++];
        }
        while(p <= middle)
            temp[index++] = list[p++];
        while(q <= end)
            temp[index++] = list[q++];
        index = 0;
        while(start <= end){
            list[start++] = temp[index++];
        }
    }
}




