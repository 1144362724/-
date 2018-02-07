package text;

import java.util.Arrays;

public class 数组转置 {
    public static void main(String [] args){
        int data[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        reverse(data);
        printArray(data);
        int dataTwo[][] = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        reverseTwo(dataTwo);
        printArray(dataTwo);
    }
    //一维数组
    public static void reverse(int arr[]){
        int center = arr.length/2;
        int head = 0;
        int tail = arr.length-1;
        for (int i = 0; i < center; i++) {
            int temp = arr[head];
            arr[head] = arr[tail];
            arr[tail] = temp;
            head++;
            tail--;
        }
    }
    //二维数组
    public static void reverseTwo(int arr[][]){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr[i].length; j++) {
                if (i != j) {
                    int temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
                }

            }
        }
    }



    private static void printArray(int trmp[]){
        for (int i = 0; i < trmp.length; i++) {
            System.out.print(trmp[i]+"、");
        }
        System.out.println();
    }
    private static void printArray(int trmp[][]){
        for (int i = 0; i < trmp.length; i++) {
            for (int j = 0; j < trmp[i].length; j++) {
                System.out.print(trmp[i][j]+"、");
            }
            System.out.println();
        }
    }
}
