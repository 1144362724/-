package text;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class 二分查找法 {

    public static void main(String[] args) {
        int data[] = new int[]{2, 5, 1, 8, 3, 8, 4, 9, 67, 23};
        int newdata[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9,};

        Arrays.sort(newdata);
        int search = 9;
        System.out.println(binarySearch(newdata,0,newdata.length,search));
        System.out.println(initcap("s"));
    }


    public static int binarySearch(int arr[],int from,int to,int key) {
       if(from < to) {
           int mid = (from / 2) + (to / 2);//确认中间点
           if (arr[mid] == key) {
               return mid;   //取当前索引
           } else if (key < arr[mid]) {
               return binarySearch(arr, from, mid-1, key);
           } else if (key > arr[mid]) {
               return binarySearch(arr,mid+1, to, key);
           }
       }
       return -1;

    }
    private static void printArray(int trmp[]){
        for (int i = 0; i < trmp.length; i++) {
            System.out.print(trmp[i]+"、");
        }
    }
    public static String initcap (String string){
        if(string == null || "".equals(string)){
            return string;
        }if (string.length()>1){
            return  string.substring(0,1).toUpperCase() + string.substring(1);
        }else {
            return string.toUpperCase();
        }
    }

}
