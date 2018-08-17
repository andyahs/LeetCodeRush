package com.leetcode.www;

import java.util.HashMap;

public class _030_FindAllSubstring {
    public static int[] findSubstr(String aStr,String [] words){
        if (aStr.isEmpty() || words.length ==0)
        {
            int [] x ={-1};
            return    x ;
        }
        int[] res= new int[words.length] ;
        int n = aStr.length();
        int cnt = words.length;
        int len = words[0].length();
        HashMap<String, Integer> m1=new HashMap<String, Integer>();
        for (String w : words) m1.put(w,-1);
        for (int i = 0; i < len; ++i) {
            int left = i, count = 0;
            HashMap<String, Integer> m2 = new HashMap<String, Integer>();
            for (int j = i; j <= n - len; j += len) {
                String t = aStr.substring(j, len);
                if (m1.containsKey(t)) {
                    m2.put(t,++j);
                    if (m2.get(t) <= m1.get(t)) {
                        ++count;
                    } else {
                        while (m2.get(t) > m1.get(t)) {
                            String t1 = aStr.substring(left, len);
                            m2.put(t1,--j);
                            if (m2.get(t1) < m1.get(t1)) --count;
                            left += len;
                        }
                    }
                    if (count == cnt) {
                        res[i]=left;
                        m2.put(aStr.substring(left, len),left);
                        --count;
                        left += len;
                    }
                } else {
                    m2.clear();
                    count = 0;
                    left = j + len;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String [] words = {"foo", "bar"};
        int [] res = findSubstr(s,words);
        for(int i:res){
            System.out.println(i);
        }

    }
}
