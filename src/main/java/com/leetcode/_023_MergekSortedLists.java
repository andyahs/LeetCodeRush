package com.leetcode;

import java.awt.List;
//�ϲ������������
public class _023_MergekSortedLists<AnyType> {

	public  MyList<AnyType>[] mergeKLst ( MyList<AnyType>[] lists ){
		
		if(lists.length ==0){
			return null;
		}
		int cntLen = lists.length;
		while(cntLen >1){
			int k = cntLen/2;
			for(int i=0; i<k;i++){
				MyList<AnyType> mg2Lst = new MyList<AnyType>();
				lists[i] = mg2Lst.merge2Lists(lists[i], lists[i+k]);
			}
			cntLen = k;
		}
		
		return lists;
		
	}
}
