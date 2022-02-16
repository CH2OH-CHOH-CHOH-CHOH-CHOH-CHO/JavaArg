package com.LeeCode.Medium;

public class Medium14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for(int  i = 0;i<strs.length;i++){
            minLen = Math.min(minLen,strs[i].length());
        }
        int low = 0;
        int high = minLen;
        while(low<high){
            int mid = (high-low+1)/2+low;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }

        }
        return strs[0].substring(0,low);
    }
    public boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

}
