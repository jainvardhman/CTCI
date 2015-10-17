package com.interview;

/**
 * Created by Vardhman on 7/28/2015.
 */
public class Queue {
    Item head = null;
    Item tail = null;
    public Queue(){}
    public Queue(int d){
        enqueue(d);
    }

    public void enqueue(int d){
        Item it = new Item(d);

        if(isEmpty()){
            head = it;
            tail = it;
            System.out.println("Queue was empty, queued item " + d + " at the beginning");
        }
        else {
            tail.next = it;
            tail = it;
            System.out.println("Queued item " + d + " at the end");
        }
    }

    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queued is empty, nothing to dequeue");
        }

        else{
            System.out.println("Dequeued item " + head.data + " from the beginning");
            head = head.next;
        }
    }

    public Item peek(){
        if(!isEmpty()){
            return head;
        }
        else {
            return  null;
        }
    }

    public Boolean isEmpty(){
        if(head == null){
            return true;
        }
        else{
            return false;
        }
    }
}

class Item{
    int data;
    Item next = null;
    public Item(){}
    public Item(int d){
        data = d;
    }
}
