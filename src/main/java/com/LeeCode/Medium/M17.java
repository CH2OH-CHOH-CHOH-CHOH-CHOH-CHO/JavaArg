package com.LeeCode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M17 {
    public static void main(String[] args) {
        new M17().letterCombinations(
                "23");
    }
    List<String> strings = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();
    Map<Character, String> phoneMap ;
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0) return strings;
        int len =digits.length();
        phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        dfs(digits,len, 0);

        return strings;
    }

    private void dfs(String digits,int len,int index){
        if(len==index) {
            strings.add(new String(stringBuilder));
            return;
        }

            String s = phoneMap.get(digits.charAt(index));
            for(int j = 0;j<s.length();j++){
                stringBuilder.append(s.charAt(j));
                dfs(digits,len ,index +1);
                stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
            }
    }
}
