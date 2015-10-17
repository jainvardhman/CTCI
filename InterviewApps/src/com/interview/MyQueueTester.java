package com.interview;

/**
 * Created by Vardhman on 7/28/2015.
 */
public class MyQueueTester {

    public void invokeTestBasic(){
        MyQueue mq = new MyQueue();
        mq.enqueue(1);
        mq.enqueue(2);
        mq.enqueue(3);
        mq.enqueue(4);
        mq.enqueue(5);
        mq.dequeue();
        mq.dequeue();
        mq.enqueue(4);
        mq.enqueue(5);
        mq.dequeue();
        mq.dequeue();
        mq.dequeue();
        mq.dequeue();
        mq.dequeue();
        mq.dequeue();
        mq.dequeue();
        mq.dequeue();
    }
}
