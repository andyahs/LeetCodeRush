package com.leetcode;

public class _028_ImplementStrstr {
    public static  int Strstr(String haystack ,String needle){
        if (needle.length()==0) return 0;
        if (needle.length() ==haystack.length() && needle ==haystack) return 0;
        if (haystack.length() <needle.length()){
            return -1;
        }
        for(int strCount= 0; strCount<=haystack.length() - needle.length();strCount++)
            if (haystack.charAt(strCount) == needle.charAt(0)) {
                if (needle.length()==1) return strCount;
                for (int subCount = 1; subCount < needle.length(); subCount++) {
                    if(haystack.charAt(strCount+subCount) != needle.charAt(subCount)){
                        break;
                    }
                    if (subCount ==needle.length()-1) return strCount;
                }

            }
        return -1;
        //leetcode某个解法 让我吐血
        //return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        String haystack  = "aaaa";
        String needle = "baaa";
        System.out.println("index:"+Strstr(haystack,needle));
    }
}
