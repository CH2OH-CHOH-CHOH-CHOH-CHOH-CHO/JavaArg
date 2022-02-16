package com.LeeCode.Simple;
/*小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。

        如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。

        请你计算 最多 能喝到多少瓶酒。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/water-bottles
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
/*
* 此方法是一次换多个瓶子
* 余数的英文单词是remainde
* 商的英文单词是quotient
*
* */
public class Simple1518 {
    public static void main(String[] args) {
        System.out.println(new Simple1518().numWaterBottles(11,3));
    }
    public int numWaterBottles(int numBottles, int numExchange) {
        int nums=0;
        int shang=numBottles;
        int yu=0;
        while ((yu+shang)>=numExchange){
            int temp = 0;
            temp = (yu+shang)/numExchange;
            yu = (yu+shang)%numExchange;

            shang =temp;
            nums = nums + shang * numExchange;
        }

        return nums+yu+shang;
    }

}
