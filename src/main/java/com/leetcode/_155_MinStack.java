package com.leetcode;

/**
 * Created by Andiz
 * 2018/9/4 9:40
 * coding For love and Peace
 */

import java.util.Stack;

/**实现一个最小栈
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *     push(x) -- Push element x onto stack.
 *     pop() -- Removes the element on top of the stack.
 *     top() -- Get the top element.
 *     getMin() -- Retrieve the minimum element in the stack.
 *
 */
public class _155_MinStack {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public _155_MinStack() {
    }

    //1、看了一下  还有另外一种骚操作，每次压栈比较后压进去最小值（x或者minVal）和（x或者minVal），
    //取出来时候每次pop两次，取出原pop，再把最小值给Min_Val;
    //2、还有包装一个类Pair包含val和min，Stack<Pair>每次压栈Pair类，每次弹出取值val,并把下一个的peek的min给最小值存储器;
    public void push(int x){
        stack1.push(x);
        if (stack2.isEmpty() ||stack2.peek() >=x) stack2.push(x);

    }
    public void pop(){
        int x = stack1.pop();
        if (stack2.peek() == x) stack2.pop();
    }
    public int top(){
        return stack1.peek();
    }
    public int getMin(){
        return stack2.peek();
    }
}
