package com.LeeCode.Offer;

import java.util.ArrayList;
import java.util.List;

public class B087 {
    List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if(s.length()>12) return new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        dfs(stringBuilder, 0, s, 0);
        return ans;
    }

    private void dfs(StringBuilder ipv4, int idx, String s, int seq) {
        if(idx==s.length() && seq==4){
            ans.add(new String(ipv4));
            return;
        }

        for(int i = idx;i<s.length() && i < (idx+3);i++){
            if(s.charAt(idx)=='0' && i>idx) break;
            String number = s.substring(idx,i+1);
            int num = Integer.parseInt(number);
            if(num>=0 && num<=255){
                if(seq>0) ipv4.append(".");
                ipv4.append(number);

                dfs(ipv4,i+1,s,seq+1);

                ipv4.delete(ipv4.length() - (i - idx)-1, ipv4.length());
                if(seq>0) ipv4.delete(ipv4.length()-1,ipv4.length());
            }
        }

    }

}
