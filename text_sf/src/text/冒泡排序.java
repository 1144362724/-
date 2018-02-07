package text;

import java.util.Arrays;

public class 冒泡排序 {

    public static void main(String[] args) {
        int data[] = new int[]{2, 5, 1, 8, 3, 8, 4, 9, 67, 23};
        Arrays.sort(data);
//        sort(data);
        printArray(data);

    }

    public static void sort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    private static void printArray(int trmp[]){
        for (int i = 0; i < trmp.length; i++) {
            System.out.print(trmp[i]+"、");
        }
    }
}
