package com.LeeCode.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。

        注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/word-break
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
/*
* 使用HashSet判断是否重复，注意new HashSet(wordDict)的API
* 把单词以i拆分为前后两段，判断前后两端是否都是单词或者单词组成的串。
* 对于前端，使用动态规划保留以往计算的结果。
*
* */
public class Medium139 {
    public static void main(String[] args) {
        ArrayList<String> ss=new ArrayList<>();
        ss.add("leet");
        ss.add("code");

        System.out.println(new Medium139().wordBreak("leetcode", ss));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        int len = s.length();
        boolean[] dp=new boolean[len+1];
        dp[0]=true;
        for(int i =1;i<len+1;i++){
            for(int j=0;j<i;j++)
                //j每次都必须从0开始，因为新加入一个字母，可能是的从0到i是一个单词
            if(dp[j] && wordDictSet.contains(s.substring(i,len))) {
                dp[i]=true;
                //只要他是一个单词组就结束
                break;

            }
        }
        return dp[len];
    }

}
