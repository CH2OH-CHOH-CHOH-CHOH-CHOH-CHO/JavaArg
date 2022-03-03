package com.LeeCode.Offer;

import java.util.ArrayList;
import java.util.List;

public class B085 {
    List<String> stringList = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();
    public List<String> generateParenthesis(int n) {

        backtrack(n,n);
        return stringList;
    }
    private void backtrack(int left,int right){
        if(left ==0 && right ==0){
            StringBuilder copy =  new StringBuilder(stringBuilder);
            stringList.add(copy.toString());
            return;
        }

        if(left==right) {
            stringBuilder.append('(');
            backtrack(left-1,right);
            stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
        }
        else  if(left<right){
            if(left>0) {
                stringBuilder.append('(');
                backtrack(left-1,right);
                stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
            }

            stringBuilder.append(')');
            backtrack(left,right-1);
            stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
        }

    }
}
