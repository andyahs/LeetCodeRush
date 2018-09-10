package com.leetcode;

/**
 * Created by Andiz
 * 2018/9/10 10:42
 * coding For love and Peace
 */
public class _160_IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lenA = getLength(headA), lenB = getLength(headB);
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; ++i) headA = headA.next;
        } else {
            for (int i = 0; i < lenB - lenA; ++i) headB = headB.next;
        }
        while (headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return (headA != null && headB != null) ? headA : null;
    }
    public int getLength(ListNode head) {
        int cnt = 0;
        while (head != null) {
            ++cnt;
            head = head.next;
        }
        return cnt;
    }


    //这道题还有一种特别巧妙的方法，虽然题目中强调了链表中不存在环，但是我们可以用环的思想来做，
    // 我们让两条链表分别从各自的开头开始往后遍历，当其中一条遍历到末尾时，我们跳到另一个条链表的开头继续遍历。
    // 两个指针最终会相等，而且只有两种情况，一种情况是在交点处相遇，另一种情况是在各自的末尾的空节点处相等。
    // 为什么一定会相等呢，因为两个指针走过的路程相同，是两个链表的长度之和，所以一定会相等。
    // 这个思路真的很巧妙，而且更重要的是代码写起来特别的简洁，参见代码如下：

    //public class Solution {
    //    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //        if (headA == null || headB == null) return null;
    //        ListNode a = headA, b = headB;
    //        while (a != b) {
    //            a = (a != null) ? a.next : headB;
    //            b = (b != null) ? b.next : headA;
    //        }
    //        return a;
    //    }
    //}

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
