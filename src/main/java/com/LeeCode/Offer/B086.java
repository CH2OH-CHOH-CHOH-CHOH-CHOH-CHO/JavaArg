package com.LeeCode.Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B086 {
    public static void main(String[] args) {
        new B086().partition("aab");
    }
    List<String[]> lists = new ArrayList<>();
    List<String> strings = new ArrayList<>();

    public String[][] partition(String s) {
        boolean[][] isS = new boolean[s.length()][s.length()];
        for(int len = 0;len<s.length();len++){
            for (int i = 0;i<s.length()-len;i++){
                if(len==0) isS[i][i+len]=true;
                else if(len==1) isS[i][i+len]=s.charAt(i)==s.charAt(i+len);
                else {
                    isS[i][i+len]=s.charAt(i)==s.charAt(i+len) && isS[i+1][i+len-1];
                }
            }
        }

        backtrack(s,isS,0);

        String[][] strings = new String[lists.size()][];
        for(int i = 0;i<lists.size();i++){
            strings[i] = lists.get(i);
        }

        return strings;
    }

    private void backtrack(String s,boolean[][] isS,int index){
        if(index == isS.length) {
            String[] copy =  new String[strings.size()];
            for(int i = 0;i<strings.size();i++){
                copy[i] = strings.get(i);
            }
            lists.add(copy);
            return;
        }

        for(int i = index;i<isS.length;i++){
            if(isS[index][i]==true) {
                strings.add(s.substring(index, i + 1));
                backtrack(s,isS,i+1);
                strings.remove(strings.size()-1);
            }
        }

    }
}
