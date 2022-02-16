package com.LeeCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class Medium1282 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,3,3,3,3,1,3};
        new Medium1282().groupThePeople(arr);
    }
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = groupSizes.length;

        List<Integer>[] count = new List[len+1];
        //将数据装入桶中,from 0 to len-1
        for(int i=0;i<len;i++){
            if(count[groupSizes[i]]==null) count[groupSizes[i]] = new ArrayList<>();
            count[groupSizes[i]].add(i);
        }

        //从桶中取出数据,from 1 to len，因为每组最少1人，每组最多len人
        for(int i=1;i<len+1;i++){
            if(count[i]==null) continue;
            int size = count[i].size();
            int cycle = 0;
            while (cycle!=size){
                List<Integer> list=  new ArrayList<>();
                for (int j=0+cycle;j<i+cycle;j++){
                    list.add(count[i].get(j));

                }
                cycle = cycle +i;

                ans.add(list);
            }
        }




        return ans;
    }
}
