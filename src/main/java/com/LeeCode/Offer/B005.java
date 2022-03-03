package com.LeeCode.Offer;

public class B005 {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] ints = new int[len];
        for(int i = 0;i<len;i++){
            for (int j = 0;j<words[i].length();j++){
                ints[i] |=(1<<words[i].charAt(j)-'a');
            }
        }

        int max = 0;
        for(int i = 0;i<len;i++){
            for(int j = i+1;j<len;j++){
                if((ints[i] & ints[j])==0)  {
                    max = Math.max(max,words[i].length()*words[j].length());
                }
            }
        }

        return max;
    }
}
