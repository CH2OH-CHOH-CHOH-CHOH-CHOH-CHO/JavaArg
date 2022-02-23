package com.LeeCode.Offer;

import java.util.Arrays;
import java.util.LinkedList;

public class A38 {
    public static void main(String[] args) {
        new A38().permutation("abc");
    }
    LinkedList<String> ans = new LinkedList<>();
    char[] charSet ;
    boolean[] isUser;
    StringBuilder nowString;
    public String[] permutation(String s) {
        this.charSet = s.toCharArray();
        Arrays.sort(charSet);
        this.isUser = new boolean[charSet.length];
        this.nowString = new StringBuilder();
        dfs();


        int size = ans.size();
        String[] recArr = new String[size];
        for (int i = 0; i < size; i++) {
            recArr[i] = ans.get(i);
        }
        return recArr;

    }

    private void dfs(){
        if(nowString.length()== isUser.length) {
            ans.add(nowString.toString());
            return;
        }

        for(int i = 0;i< isUser.length;i++){
            if(isUser[i]==true||(i > 0 && !isUser[i - 1] && charSet[i - 1] == charSet[i])) {
                continue;
            }
            nowString.append(charSet[i]);
            isUser[i] = true;
            dfs();
            nowString.deleteCharAt(nowString.length()-1);
            isUser[i] = false;

        }
    }
}
