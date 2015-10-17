package com.interview;

import sun.awt.image.ImageWatched;

/**
 * Created by Vardhman on 7/26/2015.
 */
public class LinkedList {
    Node head = null;

    public LinkedList() {}

    public LinkedList(int d) {
        create(d);
    }

    public void create(int d) {
        if (head == null) {
            head = new Node(d);
            System.out.println("Value " + d + " added to the head");
        }

        else{
            System.out.println("Linked list already created - inserting instead");
            insert(d);
        }
    }

    public void insert(int d) {
        if (head == null) {
            create(d);
        } else {
            Node last = new Node(d);
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = last;
            System.out.println("Value " + d + " added to the end");
        }
    }

    public void insert(Node last) {
        if (head == null) {
            head = last;
        } else {
            //Node last = new Node(d);
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = last;
            System.out.println("Node - value " + last.data + " added to the end");
        }
    }

    public void insertBeginning(int d){
        Node n = new Node(d);
        n.next = head;
        head = n;
    }

    public void delete(int d) {
        Node n = head;
        if (n != null) {
            if (n.data == d) {
                head = head.next;
                System.out.println("Head " + d + " removed");
                return;
            } else {
                while (n.next != null) {
                    if (n.next.data == d) {
                        n.next = n.next.next;
                        System.out.println("Value " + d + " removed from the list");
                        return;
                    }
                    n=n.next;
                }
                System.out.println("Value " + d + " not found");
            }
        }
    }

    public void search(int d){
        Node n = head;
        int index = 0;
        while(n!=null){
            if(n.data == d){
                System.out.println("Value " + d + " found at index " + index);
                return;
            }
            else{
                n = n.next;
                index++;
            }
        }
        System.out.println("Value " + d + " not found");
    }

    public void print(){
        Node n = head;
        int index = 0;
        while(n!= null){
            System.out.println("Element at index " + index + " = " + n.data);
            n = n.next;
            index++;
        }
    }

    public void removeDups() {
        Node slow = head;
        if (slow != null) {
            while (slow != null) {
                Node fast = slow;
                while (fast.next != null) {
                    if (slow.data == fast.next.data) {
                        fast.next = fast.next.next;
                        System.out.println("Duplicate data " + slow.data + " removed");
                    }
                    else {
                        fast = fast.next;
                    }
                }
                slow = slow.next;
            }
        }
    }

    public int totalElements(){
        Node n = head;
        int elems = 0;
        while(n!=null){
            elems++;
            n = n.next;
        }
        return elems;
    }

    public int kthToLast(int k){
        int totalElems = totalElements();
        System.out.println("Total Elements = " + totalElems);
        if(totalElems < k)
            return -9999999;
        else{
            Node n = head;
            for (int i=1 ; i< totalElems - k + 1 ; i++){
                n =n.next;
            }
            return n.data;
        }
    }

    public void deleteMiddle(){
        Node slow = head;
        Node fast = head;
        Node prev = head;
        while(slow != null){
            if(fast.next !=null && fast.next.next !=null){
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            else if (slow == head){
                head = head.next;
                System.out.println("Element deleted at head = " + slow.data);
                return;
            }

            else{
                prev.next = prev.next.next;
                System.out.println("Element deleted = " + slow.data);
                return;
            }
        }
    }

    public void partition(int pVal){
        Node first = head;
        Node part = head;
        Node curr = head;
        Node prev = head;
        int indexPart = 0;
        int indexCurrent = 0;
        int itr = 0;
        while(part.next != null && part.data != pVal){
            //System.out.println(part.data);
            part = part.next;
            indexPart++;
        }
        //System.out.println("The partition found at index " + indexPart);
        while (curr != null){
            System.out.println("In iteration number" + itr++);
            Node tempFrom;
            Node tempTo;
            if (curr.data >= pVal && indexCurrent < indexPart){
                System.out.println("Value " + curr.data + " > part before part");
                tempTo = part.next;
                tempFrom = curr.next;
                part.next = curr;
                part.next.next = tempTo;
                if(curr == head){
                    head = tempFrom;
                    curr = head;
                    prev = head;
                    System.out.println("Head element");
                }
                else {
                    prev.next = tempFrom;
                    curr = prev.next;
                    System.out.println("In between first and part");
                }
                //indexCurrent++;
                indexPart--;
                first = head;

                System.out.println("Now current " + curr.data);
            }

            else if (curr.data <= pVal && indexCurrent > indexPart){
                System.out.println("Value " + curr.data + " < part after part");
                tempTo = first.next;
                tempFrom = curr.next;
                first.next = curr;
                first.next.next = tempTo;
                prev.next = tempFrom;
                curr = prev.next;
                indexCurrent++;
                indexPart++;
            }

            else{
                System.out.println("Normal increase " + curr.data);
                prev = curr;
                curr = curr.next;
                indexCurrent++;
            }
        }
    }

    public void addTwoLLNumbers(LinkedList ll1, LinkedList ll2){
        Node currL1 = ll1.head;
        Node currL2 = ll2.head;
        Node n = new Node();
        int sumThis = 0;
        int carry = 0;
        while(currL1 != null || currL2 != null){
            if(currL1.next != null && currL2.next == null){
                Node padNode = new Node(0);
                currL2.next = padNode;
            }

            else if(currL2.next != null && currL1.next == null){
                Node padNode = new Node(0);
                currL1.next = padNode;
            }

            if(currL1 != null && currL2 != null){
                sumThis = currL1.data + currL2.data + carry;
                currL1 = currL1.next;
                currL2 = currL2.next;
            }
            else if(currL1 == null){
                sumThis = currL2.data + carry;
                currL2 = currL2.next;
            }
            else{
                sumThis = currL1.data + carry;
                currL1 = currL1.next;
            }

            if (sumThis >= 10){
                sumThis %= 10;
                carry= 1;
            }
            else{
                carry = 0;
            }
            insert(sumThis);
        }
    }

    public void findPalindrome(){
        LinkedList rev = new LinkedList();
        Node curr = head;
        while(curr != null){
            rev.insertBeginning(curr.data);
            curr = curr.next;
        }

        Node thisCurr = head;
        Node revCurr = rev.head;

        while(thisCurr != null && revCurr !=null){
            if(thisCurr.data == revCurr.data) {
                thisCurr = thisCurr.next;
                revCurr = revCurr.next;
            }
            else {
                System.out.println("Palindrome negative");
                return;
            }
        }

        System.out.println("Palindrome positive");
    }

    public void detectLoop(){
        Node slow = head;
        Node fast = head;
        boolean first = true;
        while(fast != null && fast.next != null){
            if(slow == fast && !first){
                System.out.println("Breaking at " + slow.data);
                break;
            }

            else{
                slow = slow.next;
                fast = fast.next.next;
            }
            if (first)
                first = false;
        }

        if(fast == null || fast.next == null)
            System.out.println("No cycles");
        else{
            slow = head;
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }

            System.out.println("Cycle found at " + slow.data);
        }
    }

    public void intersection(LinkedList list){
        int lenThis = 0;
        int lenList = 0;
        Node currThis = head;
        Node currList = list.head;

        while(currList != null || currThis != null){
            if(currThis != null){
                currThis = currThis.next;
                lenThis++;
            }

            if(currList != null){
                currList= currList.next;
                lenList++;
            }
        }

        currThis = head;
        currList = list.head;
        //System.out.println("Lenthis , Lenlist = " + lenThis + " , " + lenList);

        while (currList !=null && currThis != null){
            if(lenThis > lenList || lenList > lenThis){
                while(lenThis != lenList){
                    if(lenList > lenThis){
                        currList = currList.next;
                        lenList--;
                    }
                    else{
                        currThis = currThis.next;
                        lenThis--;
                    }
                }
            }
            if(currList == currThis) {
                System.out.println("Found intersection at " + currList.data);
                return;
            }
            else{
                currList = currList.next;
                currThis = currThis.next;
            }
        }

        System.out.println("No intersection found");
    }
    /*public LinkedList recPalin(Node current){
        if(current.next != null){
            Node n = new Node();
            return recPalin(current.next);
        }

        else {
            return (new LinkedList(current.data));
        }
    }*/
}

class Node{
    int data;
    Node next = null;
    public Node() {
    }
    public Node(int d) {
        data = d;
    }
}
