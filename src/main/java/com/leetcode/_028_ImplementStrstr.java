package com.leetcode.www;

public class _028_ImplementStrstr {
    public static  int Strstr(String aString ,String needle){
        if (needle.isEmpty() ||aString.length() <needle.length()){
            return -1;
        }
        for(int strCount= 0; strCount<=aString.length() - needle.length();strCount++)
            if (aString.charAt(strCount) == needle.charAt(0)) {
                for (int subCount = 1; subCount < needle.length(); subCount++) {
                    if(aString.charAt(strCount+subCount) != needle.charAt(subCount)){
                        break;
                    }
                }
                return strCount;
            }
        return -1;
    }

    public static void main(String[] args) {
        String aString  = "abc123456789";
        String needle = "789";
        System.out.println("index:"+Strstr(aString,needle));
    }
}
