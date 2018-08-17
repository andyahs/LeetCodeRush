package com.leetcode;
//1 to 3999
public class _012_IntegerToRoman {
	public static String intToRoman(int num){
		String res="";
		int [] val = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String[] str = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		for(int i= 0; i<val.length;i++){
			while(num >=val[i]){
				num -= val[i];
				res += str[i];
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int num =3987;
		System.out.println(intToRoman(num));
	}
}
