package com.Sort;

import java.util.Random;

public class Sort {
    public static void main(String[] args) {
        final int NUM_LENGTH = 1000;
        Random random = new Random();
        int[] a = new int[NUM_LENGTH];
        for (int i = 0; i < NUM_LENGTH; i++) {
            a[i] = random.nextInt(NUM_LENGTH);
        }
        Long timeStart = System.nanoTime();


//        bubbleSort(a);
//        selectionSort(a);
//        insertSort(a);
//        shellSort(a);

//        int[] b = {1,2,3,4,5,6,7,8,0,1,2,2,3,5};
//        int[] c = new int[b.length];
//        merge(b,c,0,7,b.length-1);

        quickSort(a);

        Long timeEnd = System.nanoTime();

        show(a);

        System.out.println("time: "+ (timeEnd - timeStart));
    }
    //k是最
    public static void radixSort(int[] a,int k){
        int[] count  = new int[10];
        int[][] buckets= new int[10][k];
        int rem = 0;
        for (int m = 0;m<3;m++) {

            for (int i = 0; i < a.length; i++) {
                rem = (int) ((a[i]/Math.pow(10,m)) % 10);
                buckets[rem][count[rem]] = a[i];
                count[rem]++;
            }
            for (int i = 0; i < a.length; ) {
                for (int j = 0; j < 10; j++) {
                    int n = 0;
                    while (n <count[j]) {
                        a[i++] = buckets[j][n];
                        n++;
                    }
                    count[j] = 0;
                }
            }
        }
    }

    //k是最大值，0-k
    public static void bucketSort(int[] a,int k){
        int[] count  = new int[k];
        for(int i=0;i<a.length;i++){
            count[a[i]] ++;
        }
        int j  =0;
        for(int i=0;i<a.length;){
            if(count[j]>0){
                a[i++] =j;
                count[j]--;
            }
            else j++;
        }
    }

    public static void quickSort(int[] a){

        quickSort(a,0,a.length-1);
    }

    public static void quickSort(int[] a,int left,int right ){

        if(right-left>3) {
            int center = median3(a,left,right);
            int i = left, j = right-1;


            while (true) {
                while ((a[i] <= center)) i++;
                while ((a[j] >= center)) j--;
                if(i<j) swap(a, i, j);
                else break;
            }
            swap(a, i, right);
            //center是中值而非中值的下标，i才是最后位于中间的值的下标
            quickSort(a,left,i-1);
            quickSort(a,i,right);
        }
        else {
            //插入排序
            int j ;
            for (int i = left; i < right; i++) {
                j = i + 1;
                while (j > left) {
                    if (a[j] < a[j - 1]) swap(a, j - 1, j);
                    j--;
                }
            }
        }
    }

    public static void mergeSort(int[] a) {
        int[] temp = new int[a.length];
        mergeSort(a, temp, 0, a.length-1);
    }

    public static void mergeSort(int[] a, int[] b, int leftPos, int rightPos) {
        int centerPos = leftPos + (rightPos - leftPos) / 2;
        if (leftPos < rightPos) {
            mergeSort(a, b, leftPos, centerPos);
            mergeSort(a, b, centerPos+1, rightPos);
            merge(a, b, leftPos, centerPos, rightPos);
        }
    }

    public static void shellSort(int[] a) {
        int j = 0;
        for (int gap = a.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < a.length; i++) {
                j = i;
                while (j - gap > 0) {
                    if (a[j] < a[j - gap]) swap(a, j - gap, j);
                    j = j - gap;
                }
            }

        }
    }

    public static void insertSort(int[] a) {
        int j;
        for (int i = 0; i < a.length - 1; i++) {
            j = i + 1;
            while (j > 0) {
                if (a[j] < a[j - 1]) swap(a, j - 1, j);
                j--;
            }
        }
    }

    public static void selectionSort(int[] a) {
        int minIndex = 0;
        for (int i = 0; i < a.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) minIndex = j;
            }
            swap(a, i, minIndex);
        }
    }

    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) swap(a, j, j + 1);
            }
        }
    }

    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void merge(int[] a, int[] b, int start, int center, int end) {
        int ls = start;
        int le = center;
        int rs = center+1;
        int re = end;
        int i = start;

        while (ls <= le && rs <= re) {
            if (a[ls] <= a[rs]) b[i++] = a[ls++];
            else b[i++] = a[rs++];
        }

        while (ls <= le) b[i++] = a[ls++];
        while (rs <= re) b[i++] = a[rs++];


        for (int j = start; j <= end; j++) {
            a[j] = b[j];
        }

    }

    public static int median3(int[] arr,int left,int right){
        int center = (left+right)/2;
        //把大值放在右边
        //三值排序算法
        if(arr[left]>arr[center])  swap(arr,left,center);
        if(arr[left]>arr[right])   swap(arr,left,right);
        if(arr[center]>arr[right]) swap(arr,center,right);
        swap(arr,center,right);
        return arr[right];
    }

}
