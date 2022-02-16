package com.LeeCode.Medium;

/*给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。

        回文字符串 是正着读和倒过来读一样的字符串。

        子字符串 是字符串中的由连续字符组成的一个序列。

        具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/palindromic-substrings
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Medium647 {
    public static void main(String[] args) {
        System.out.println(new Medium647().countSubstrings("fdsklf"));
    }
    public int countSubstrings(String s) {

        boolean[][] dp =new boolean[s.length()][s.length()];
        for (int len = 0; len < s.length(); ++len) {
            for (int i = 0; i < s.length()-len; ++i) {
                int j = i + len;
                if (len==0) dp[i][j] = true;
                else if (len==1 ){
                    if(s.charAt(i) == s.charAt(j)) dp[i][j] = true;
                    continue;
                }
                else if (dp[i + 1][j - 1] &&s.charAt(i) == s.charAt(j)) dp[i][j] = true;

            }
        }
        int sum=0;
        for(int i = 0;i<s.length();++i){
            for(int j =i;j<s.length();++j){
                if(dp[i][j]) ++sum;
            }
        }
        return sum ;
    }
}
