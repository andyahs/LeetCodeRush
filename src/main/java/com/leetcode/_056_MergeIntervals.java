package com.leetcode;

import java.util.*;

/**
 * Created by Andiz
 * 2018/9/25 23:00
 * coding For love and Peace
 * 056合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class _056_MergeIntervals {
     public class Interval {
       int start;
       int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

     }
    public List<Interval> merge(List<Interval> intervals) {
         if (null ==intervals ||intervals.isEmpty()) return intervals;
        List<Interval> sortlist = new ArrayList<>();
        Iterator<Interval> itor = intervals.iterator();
        while (itor.hasNext()){
            sortlist.add(itor.next());
        }
        Collections.sort(sortlist, new SortByStart());
        List<Interval> res = new ArrayList<>();
        int curStart = sortlist.get(0).start;
        int curEnd = sortlist.get(0).end;
        for (Interval itVal:sortlist ){
            System.out.println("cs "+curStart+" ce "+curEnd);
            if (curEnd<itVal.start){
                res.add(new Interval(curStart,curEnd));
                curStart = itVal.start;
                curEnd = itVal.end;
            }
            if (curEnd <=itVal.end){
                curEnd = itVal.end;
            }
        }
        res.add(new Interval(curStart,curEnd));
        return res;
    }

    class SortByStart implements Comparator {
        public int compare(Object o1, Object o2) {
            Interval s1 = (Interval) o1;
            Interval s2 = (Interval) o2;
            if (s1.start < s2.start) {
                return 1;
            }
            return -1;
        }
    }

    //LeetCode提供
    //    public List<Interval> merge(List<Interval> intervals) {
    //        int n=intervals.size();
    //        int[] starts=new int[n];
    //        int[] ends=new int[n];
    //        for(int i=0;i<n;i++){
    //            starts[i]=intervals.get(i).start;
    //            ends[i]=intervals.get(i).end;
    //        }
    //        Arrays.sort(starts);
    //        Arrays.sort(ends);
    //        List<Interval> res=new ArrayList<Interval>();
    //        for(int i=0,j=0;i<n;i++){
    //            if(i==n-1||starts[i+1]>ends[i]){
    //                res.add(new Interval(starts[j],ends[i]));
    //                j=i+1;
    //            }
    //        }
    //        return res;
    //    }



    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        System.out.println("----------add-----------");
        list.add("图书一");		list.add("图书二");		list.add("图书三");
//            for循环遍历
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);			System.out.println(str);
        }
        System.out.println("-----------------update-----------");
        list.set(0, "bookx");
//             iterator迭代器遍历
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String str = it.next();
            System.out.println(str);
        }
        System.out.println("-------------delete-------------------");
        list.remove(1);		//foreach循环
        for (Object o : list) {
            System.out.println(list);
        }
    }


}
