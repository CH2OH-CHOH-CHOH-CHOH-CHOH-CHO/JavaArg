package com.DataStructure;

public class Heap{
    public Heap() {

    }

    private final int DEFAULT_LENGTH = 20;
    private int size = 0;
    private Integer arr[] =new Integer[DEFAULT_LENGTH];
    private Integer root = arr[1];



    public void insert(Integer x){
        if(size>=arr.length-1)  ;//enlarge the array

        arr[++size] = x;
        this.percolUp(size);
    }

    public int deleteMin(){
        int min = arr[1];
        arr[1]=arr[--size];
        percolDown();
        return min;

    }

    private void percolDown(){
        percolDown(1);
    }

    private void percolDown(int hole){
        arr[0] = arr[hole];
        int child;
        for(;hole*2<=size-1;hole=child){
            child = hole * 2;
            if(child!=size-1 && arr[child +1]<arr[child]) child++;
            if(arr[0]>arr[child]) arr[hole] = arr[child];
            else break;
        }
        arr[hole]= arr[0] ;
    }

    private void percolUp(int hole){
        for(arr[0]=arr[hole];arr[hole/2]>arr[hole];hole/=2){
            arr[hole]=arr[hole/2];
        }
        arr[hole]=arr[0];
    }

    public int size(){
        return size;
    }

    public void showFirst(){
        showFirst(1);
    }


    public void showFirst(int i){

        displaySpace(getDepth(i));
        System.out.println(arr[i]);

        if(i*2<size) showFirst(i*2);
        if(i+1<size && i%2==0) showFirst(i+1);

    }

    public void showLast(){

    }

    public void showMiddle(){

    }

    private static int getDepth(int i){
        return (int) (Math.log(i) / Math.log(2));
    }

    private void displaySpace(int depth){
        while(depth-->0) System.out.print("  ");
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(60);
        heap.insert(34);
        heap.insert(23);
        heap.insert(43);
        heap.insert(50);
        heap.insert(35);
        heap.insert(96);
        heap.insert(46);
        heap.insert(79);
        heap.insert(47);
        heap.insert(76);

        heap.showFirst();
        System.out.println();
        System.out.println();
        System.out.println(heap.deleteMin());
        System.out.println();
        System.out.println();
        heap.showFirst();
    }

}
