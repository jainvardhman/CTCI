package com.interview;

/**
 * Created by Vardhman on 7/26/2015.
 */
public class LinkedListTester {

    public void invokeTestBasic(){
        LinkedList ll = new LinkedList(18);
        ll.create(4);
        ll.insert(5);
        ll.insert(9);
        ll.insert(13);
        ll.insert(20);
        ll.insert(22);
        ll.insert(45);
        ll.delete(22);
        ll.delete(13);
        ll.search(20);
        ll.delete(9);
        ll.delete(4);
        ll.search(4);
        ll.print();
    }

    public void invokeTestRemoveDups(){
        LinkedList ll = new LinkedList(18);
        ll.create(4);
        //ll.insert(5);
        //ll.insert(9);
        //ll.insert(5);
        //ll.insert(9);
        ll.insert(4);
        ll.insert(18);
        ll.removeDups();
        ll.print();
    }

    public void invokeTestKthToLast(int k){
        LinkedList ll = new LinkedList(18);
        ll.create(4);
        ll.insert(5);
        ll.insert(9);
        ll.insert(13);
        ll.insert(20);
        ll.insert(22);
        ll.insert(45);
        int val = ll.kthToLast(k);
        if(val == -9999999)
            System.out.println("Element not found");
        else
            System.out.println(k + "th element from end is " + val);
    }

    public void invokeTestDeleteMiddle(){
        LinkedList ll = new LinkedList(18);
        ll.insert(5);
        ll.insert(9);
        ll.insert(13);
        ll.insert(20);
        ll.deleteMiddle();
        ll.print();
    }

    public void invokeTestPartition(int p){
        /*LinkedList ll = new LinkedList(3);
        ll.insert(5);
        ll.insert(8);
        ll.insert(5);
        ll.insert(10);
        ll.insert(2);
        ll.insert(1);*/
        LinkedList ll = new LinkedList(3);
        ll.insert(8);
        ll.insert(5);
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(2);
        ll.partition(p);
        ll.print();
    }

    public void invokeTestAddLL(){
        LinkedList ll1 = new LinkedList();
        LinkedList ll2 = new LinkedList();
        LinkedList ll3 = new LinkedList();
        ll1.insert(7);
        ll1.insert(1);
        ll1.insert(6);
        ll2.insert(6);
        //ll2.insert(9);
        //ll2.insert(2);
        ll3.addTwoLLNumbers(ll1, ll2);
        ll3.print();
    }

    public void invokeTestPalin(){
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(1);
        ll.insert(2);
        ll.insert(1);
        ll.findPalindrome();
    }

    public void invokeTestLoopDetect(){
        LinkedList ll = new LinkedList();
        Node n = new Node(5);
        ll.insert(1);
        ll.insert(2);
        ll.insert(n);
        ll.insert(3);
        ll.insert(4);
        ll.insert(n);
        ll.detectLoop();
    }

    public void invokeTestIntersection(){
        LinkedList ll1 = new LinkedList();
        LinkedList ll2 = new LinkedList();
        Node n = new Node(5);
        ll1.insert(1);
        //ll1.insert(2);
        ll1.insert(n);
        ll2.insert(n);
        ll1.insert(3);
        ll1.insert(4);
        //ll2.insert(n);
        //ll2.insert(6);
        //ll2.insert(7);
        ll1.intersection(ll2);
    }
}
