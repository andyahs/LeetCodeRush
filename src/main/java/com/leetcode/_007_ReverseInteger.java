package com.leetcode;

//颠倒整数 注意超过int范围则直接返回0
public class _007_ReverseInteger {
	public static int reverseInteger(int x){
//		int res = 0;
//		while (x != 0) {
//			int t = res * 10 + x % 10;
//			if (t / 10 != res) return 0;
//			res = t;
//			x /= 10;
//		}
//		return res;
	//leetcode提供的解法如下
	int next = x;
	/*
     pop:反转数——余数
      */
	int pop = 0;
	int result = 0;
        do {
		pop = next % 10;
		next /= 10;
		// 判断是否溢出

		// MIN: -2147483648
		if (result < Integer.MIN_VALUE / 10 || result * 10 == Integer.MAX_VALUE && pop < -8) {
			return 0;
		}
		// MAX:  2147483647
		if (result > Integer.MAX_VALUE /10 || result * 10 == Integer.MAX_VALUE && pop > 7) {
			return 0;
		}
		result = result * 10 + pop;
	}while (next != 0);
        return result;
	}
	
	public static void main(String[] args) {
		int x = -1423643369;
		System.out.println(x);
		System.out.println("res:"+reverseInteger(x));
	}
}
