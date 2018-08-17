package com.leetcode.www;
/*
 * str ="0123456789ABCDEF"
 * n=4
 * ���
 * 0     6	   c
 * 1  5  7  B  D
 * 2  4  8  A  E
 * 3     9     F
 */

//�����ⷨ
public class _006_ZigZagConversion {
	public static char [][]  ZigZagConversion(String s,int n){
		char [] sArr = s.toCharArray();
		int lenFlag=0;
		char [][] zigZagArr = new char[n][n+1];
		for(int i = 0; i <= n;i++){
			if(i%2 == 0){
				for(int j = 0; j<n ;j++){
					zigZagArr[j][i]=sArr[lenFlag];
					++lenFlag;
				}
			}
			if(i%2 !=0){
				for(int j = 0; j<n ;j++){
					if(!(j==0||j==n-1)){
						zigZagArr[n-1-j][i]=' ';
					}else{
						zigZagArr[n-1-j][i]=sArr[lenFlag];
						++lenFlag;
					}
				}
			}
			if(lenFlag >= s.length()){
				break;
			}
		}
		
		return zigZagArr;
	}
	
	public static void main(String[] args) {
		String str1= "0123456789ABCDEF";
		char [][] strArr = ZigZagConversion(str1, 4);
		for(int i=0;i<strArr.length;i++){
			for(int j=0 ; j<strArr[0].length;j++){
				System.out.print(strArr[i][j]);
			}
			System.out.println();
		}
	}
}
