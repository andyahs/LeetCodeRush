package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andiz
 * 2018/10/8 22:33
 * coding For love and Peace
 *171Excel表列序号
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 *
 * 示例 1:
 * 输入: "A"
 * 输出: 1
 *
 * 示例 2:
 * 输入: "AB"
 * 输出: 28
 *
 * 示例 3:
 * 输入: "ZY"
 * 输出: 701
 * 可以用count=count*26+curChar-'A'+1;来做 用查表法有点暴力
 */
public class _171_ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if (null == s||s.length()<=0) return 0;
        Map<Character,Integer> letterMap  =new HashMap<>();
        letterMap.put('A',1);letterMap.put('B',2);letterMap.put('C',3);letterMap.put('D',4);letterMap.put('E',5);
        letterMap.put('F',6);letterMap.put('G',7);letterMap.put('H',8);letterMap.put('I',9);letterMap.put('J',10);
        letterMap.put('K',11);letterMap.put('L',12);letterMap.put('M',13);letterMap.put('N',14);letterMap.put('O',15);
        letterMap.put('P',16);letterMap.put('Q',17);letterMap.put('R',18);letterMap.put('S',19);letterMap.put('T',20);
        letterMap.put('U',21);letterMap.put('V',22);letterMap.put('W',23);letterMap.put('X',24);letterMap.put('Y',25);
        letterMap.put('Z',26);
        int count=letterMap.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            count = count*26+letterMap.get(s.charAt(i));
        }
        return count;
    }
}
