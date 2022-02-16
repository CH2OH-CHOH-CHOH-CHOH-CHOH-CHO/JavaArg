package com.LeeCode.Offer;

import java.util.ArrayList;
import java.util.List;

public class b087 {
    List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        char[] ori = s.toCharArray();
        if (ori.length < 4) return ans;
        dfs(ori, 0, new String(), 0);
        return ans;
    }

    private void dfs(char[] ori, int idx, String s, int seq) {
        if (idx == s.length() && seq == 4) {//Δ
            ans.add(s);
            return;
        }
        if (idx == s.length() || seq == 4) return;//Δ
        int curSum = 0;
        for (int i = idx; i < ori.length; i++) {
            curSum += ori[i] - '0'; //Δ
            if(i -idx >0 && ori[idx]=='0'){
                break;
            }
            if (curSum > 255) break;
            //假设已经满足一段
            dfs(ori,i+1,s+curSum+".",seq+1);
            //回溯回来，无论以上dfs是否成功
            curSum*=10;
        }

    }

}
