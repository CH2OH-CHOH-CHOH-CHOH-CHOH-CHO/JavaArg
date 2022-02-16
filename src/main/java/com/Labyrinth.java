package com;

public class Labyrinth {
    public static void main(String[] args) {
        int[][] a = new int[8][7];
        Labyrinth.showA(a);
        for (int i = 0; i < 7; i++) {
            a[0][i] = 1;
            a[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            a[i][0] = 1;
            a[i][6] = 1;
        }

        a[3][1] = 1;
        a[3][2] = 1;
        System.out.println();
        Labyrinth.showA(a);

        Labyrinth.setWat(a,1,1);
        System.out.println();
        Labyrinth.showA(a);
    }
        //a[6][5]位置
    private static boolean setWat(int[][] a ,int i,int j){

        if(a[6][5]==2) return true;
        else if(a[i][j]==0){
            a[i][j]=2;
            if(setWat(a,i+1,j)) return true;
            else if(setWat(a,i,j+1)) return true;
            else if(setWat(a,i-1,j)) return true;
            else if(setWat(a,i,j-1)) return true;
            else {
                a[i][j]=1;
                return false;
            }
        }
        else return false;
    }
    private static void showA(int[][] a) {
//        for(int i = 0;i<8;i++){
//            for(int j =0;j<7;j++){
//                System.out.print(a[i][j]+" ");
//            }
//            System.out.println();
//        }
        for (int[] b : a
        ) {
            for (int i : b
            ) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
