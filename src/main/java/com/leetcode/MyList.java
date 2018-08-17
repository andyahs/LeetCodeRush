package com.leetcode.www;

import java.util.LinkedList;

public class MyList<AnyType> {
	private class Node<AnyType>{
		public Node<AnyType> pre;
		public Node<AnyType> next;
		public AnyType data;
		public Node(AnyType d ,Node<AnyType> p ,Node<AnyType> n){
			this.data = d;
			this.pre  = p;
			this.next = n;
		};
		public Node(){
			this.data = null;
			this.pre = null;
			this.next = null;
		};
		
		
	}
	
	public MyList(){
		int Size = 0;
		Header = new Node<AnyType>(null, null, null);
		Tail  = new Node<AnyType>(null, Header, null);
		Header.next = Tail;
	}
	
	private int theSize;
	private Node<AnyType> Header;

	private Node<AnyType> Tail;
	public void add(AnyType item){
		Node<AnyType> aNode = new Node<AnyType>(item, null, null);
		Tail.pre.next = aNode;
		aNode.next = Tail;
		aNode.pre =Tail.pre;
		Tail.pre = aNode;
		theSize++;
	};
	public boolean isEmpty(){
		return theSize == 0;
	};
	public int size(){
		return theSize;
	};
	public AnyType get(int idx){
		if(idx > theSize -1 || idx<0)
			throw new IndexOutOfBoundsException();
		Node<AnyType> current = new Node<AnyType>(null, Header, null);
		for(int i =0;i<idx;i++){
			current = current.next;
		}
		return current.data;
			
	};
	public void print(){
		Node<AnyType> current = Header.next;
		while(current.next != null){
			System.out.print(current.data.toString()+" ");
			current = current.next;
		}
	};
	public  void RemNthNodeFromEnd(MyList<AnyType> aList,int n){
		MyList<AnyType> theList= aList;
		Node<AnyType> curNode = aList.Header;
		Node<AnyType> serchNode = aList.Header;
		int countFlag = 0;
		while(curNode.next != null){
			curNode = curNode.next;
			countFlag++;
			if(countFlag >n){
				serchNode = serchNode.next;		
			}
		}

		if(countFlag <n){
			System.out.println("not enough");
		}else{
			System.out.println("nthFromEnd:"+serchNode.data);
			serchNode.pre.next = serchNode.next;
			serchNode.next.pre = serchNode.pre;
			theSize --;
		}
	}
	
	public MyList<AnyType> merge2Lists(MyList<AnyType>l1,MyList<AnyType>l2){
		MyList<AnyType> theLst = new MyList<AnyType>();
		Node<AnyType> cur = theLst.Header;
		Node<AnyType> cur1 = l1.Header;
		Node<AnyType> cur2 = l2.Header;
		while(l1!=null&&l2 !=null){
			if((Integer)cur1.data<=(Integer)cur2.data){
				cur.data = cur1.data;
				cur1= cur1.next;
			}else{
				cur.data= cur2.data;
				cur2 = cur2.next;
			}
			cur =cur.next;
		}
		if(cur1 != null) cur.next=  cur1;
		if(cur2 != null) cur.next= cur2;
		
		return theLst; 
	}

	public MyList<AnyType> switchPairsInit(MyList<AnyType> theList){
		switchPairs(theList.Header);
		return theList;
	}
	
	public Node<AnyType> switchPairs(Node<AnyType> head){
		if(head == null ||head.next==null) return head;
		Node<AnyType> t= head.next;
		head.next = switchPairs(head.next.next);
		t.next = head;
		return t;
		
	}
	
	//25ÿk�������ڵ�
    public MyList reverseKGroup(MyList list, int k) {
    	Node head = list.Header;
        MyList dummy = new MyList<AnyType>(); 
        Node pre = dummy.Header, cur = pre;
        dummy.Header.next = head;
        int num = 0;
        while (cur.next != null){
        	cur = cur.next ;
        	++num;
        }
        while (num >= k) {
            cur = pre.next;
            for (int i = 1; i < k; ++i) {
                Node t = cur.next;
                cur.next = t.next;
                t.next = pre.next;
                pre.next = t;
            }
            pre = cur;
            num -= k;
        }
        return dummy;
    };
	
}
