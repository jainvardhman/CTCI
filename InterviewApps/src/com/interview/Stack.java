package com.interview;

/**
 * Created by Vardhman on 7/28/2015.
 */
public class Stack {
    Box top = null;
    public Stack(){}
    public Stack(int d){
        push(d);
    }

    public void push(int d){
        Box b = new Box(d);
        if(top == null){
            b.min = d;
            top = b;
            System.out.println("Stack was empty, pushed " + d + " to the top");
        }
        else{
            if(d < top.min){
                b.setMin(d);
            }
            else{
                b.setMin(top.min);
            }
            b.next = top;
            top = b;
            System.out.println("Pushed " + d + " to the top");
        }
    }

    public void pop() {
        if(top == null){
            System.out.println("Stack is empty, nothing to pop here");
        }
        else{
            System.out.println("Popped " + top.data + " from the stack");
            top = top.next;
        }
    }

    public Box peek(){
        if(top == null){
            System.out.println("Stack is empty nothing to peek");
            return null;
        }
        else{
            return top;
        }
    }

    public void getMin(){
        if(top == null){
            System.out.println("Stack is empty");
        }
        else{
            System.out.println("The min value on stack is " + top.min);
        }
    }

    public void sort(){
        Stack helper = new Stack();
        while(peek() != null){
            helper.push(top.data);
            pop();
        }

        while(helper.peek() != null){
            if(peek() ==null){
                push(helper.top.data);
                helper.pop();
            }
            else{
                Box temp = helper.top;
                helper.pop();
                Box pivot = helper.top;
                while (temp.data > top.data && peek() != null){
                    helper.push(top.data);
                    pop();
                }
                push(temp.data);
                while(helper.top != pivot){
                    push(helper.top.data);
                    helper.pop();
                }
            }
        }
    }
}

class Box{
    int data;
    int min;
    Box next = null;
    public  Box() {}
    public Box(int d){
        data = d;
    }
    public void setMin(int m){
        min = m;
    }
}
