package com.LeeCode.Medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/*给定一个经过编码的字符串，返回它解码后的字符串。

        编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

        你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

        此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/decode-string
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Medium394 {
    public String decodeString(String s) {

        StringBuilder ans = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        char[] numberChar = null;


        int charSize= 0;
        for(int i =0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                if(numberChar==null)  numberChar=new char[3];
                numberChar[charSize++]=s.charAt(i);
            }
            if(s.charAt(i)=='['){
                char[] arr = new char[charSize];
                for(int j = 0;j<charSize;j++){
                    arr[j] = numberChar[j];
                }
                int times = Integer.parseInt(new String(arr));
                stack.offer((char)(times | 0x8000));
                stack.offer('[');
                numberChar=null;
                charSize=0;
            }
            if(Character.isLetter(s.charAt(i))){
                stack.offer(s.charAt(i));
            }
            if(s.charAt(i)==']'){
                StringBuilder temp =new StringBuilder();
                while(stack.peekLast()!='[') temp.append(stack.pollLast());
                stack.pollLast();
                int time = stack.pollLast() & 0x7fff;
                String ss= temp.reverse().toString();
                for(int j=0;j<time-1;j++){
                    temp.append(ss);
                }
                int len = temp.length();
                for(int j = 0;j<len;j++){
                    stack.offer(temp.charAt(j));
                }
            }
        }

        while(stack.peekLast()!=null) ans.append(stack.pollLast());

        return ans.reverse().toString();
    }

}
