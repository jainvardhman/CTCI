package com.interview;

/**
 * Created by Vardhman on 7/28/2015.
 */
public class MyQueue {
    Stack primary;
    Stack helper;

    public MyQueue() {
        primary = new Stack();
        helper = new Stack();
    }

    public void enqueue(int d){
        primary.push(d);
    }

    public void dequeue() {
        if (primary.top != null) {
            while (primary.top.next != null) {
                helper.push(primary.top.data);
                primary.pop();
            }

            System.out.println("The value dequeued is " + primary.top.data);
            primary.pop();

            while (helper.top != null) {
                primary.push(helper.top.data);
                helper.pop();
            }
        }

        else {
            System.out.println("The stack is empty");
        }
    }
}
