package com.LeeCode.Medium;

import java.util.ArrayDeque;

/*根据 逆波兰表示法，求表达式的值。

        有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。

         

        说明：

        整数除法只保留整数部分。
        给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Medium150 {
    public static void main(String[] args) {
        System.out.println(new Medium150().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        String[] tokens = new String[]{"4","13","5","/","+"};
        String[] token2 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(new Medium150().evalRPN(tokens));
        System.out.println(new Medium150().evalRPN(token2));
    }
    public int evalRPN(String[] tokens) {
        ArrayDeque<String> aq = new ArrayDeque();
        for (int i = 0; i < tokens.length; ++i) {
            String s = tokens[i];
            switch (s){
                case "+":aq.offer(Integer.parseInt(aq.pollLast()) + Integer.parseInt(aq.pollLast())+"");break;
                case "-":{
                    int a=Integer.parseInt(aq.pollLast());
                    int b=Integer.parseInt(aq.pollLast());
                    aq.offer(b-a+"");
                    break;
                }
                case "*":aq.offer(Integer.parseInt(aq.pollLast()) * Integer.parseInt(aq.pollLast())+"");break;
                case "/": {
                    int a=Integer.parseInt(aq.pollLast());
                    int b=Integer.parseInt(aq.pollLast());
                    aq.offer(b/a+"");
                    break;
                }
                default:aq.offer(s);
            }
        }

        return Integer.parseInt( aq.pollLast());
    }
}
