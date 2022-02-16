package com.LeeCode.Medium;
/*给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。*/
public class Medium670 {
    public static void main(String[] args) {
        System.out.println(new Medium670().maximumSwap(
                98368));
    }
    public int maximumSwap(int num) {
        StringBuffer s = new StringBuffer(String.valueOf(num));


        needChange(s,0);

        return Integer.valueOf(s.toString());

    }

    private void sChange(StringBuffer stringBuffer,int i,int j){
        char temp= stringBuffer.charAt(i);
        stringBuffer.setCharAt(i,stringBuffer.charAt(j));
        stringBuffer.setCharAt(j,temp);
    }

    private void needChange(StringBuffer s,int m ){
        int max=0;
        int index = 0;
        for(int i =m;i<s.length();++i){
            if(s.charAt(i)>=max) {
                index = i;
                max = s.charAt(i);
            }
        }
        if (s.charAt(m)<s.charAt(index)) sChange(s,m,index);
        else if(s.length()-m>2) needChange(s,m+1);
    }
}
