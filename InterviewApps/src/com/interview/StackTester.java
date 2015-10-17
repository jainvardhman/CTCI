package com.interview;

/**
 * Created by Vardhman on 7/28/2015.
 */
public class StackTester {

    public void invokeTestBasic(){
        Stack st = new Stack(18);
        st.push(1);
        st.push(2);
        st.push(3);
        st.pop();
        st.pop();
        st.push(4);
        st.push(5);
        st.push(6);
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();

    }

    public void invokeTestMin(){
        Stack st = new Stack(18);
        st.getMin();
        st.push(3);
        st.getMin();
        st.push(2);
        st.getMin();
        st.push(1);
        st.getMin();
        st.pop();
        st.getMin();
        st.pop();
        st.getMin();
        st.push(6);
        st.getMin();
        st.push(5);
        st.getMin();
        st.push(4);
        st.getMin();
        st.pop();
        st.getMin();
        st.pop();
        st.getMin();
        st.pop();
        st.getMin();
        st.pop();
        st.getMin();
        st.pop();
        st.getMin();
        st.pop();
        st.getMin();
        st.pop();
        st.getMin();
        st.pop();
        st.getMin();
        st.pop();
        st.getMin();
        st.pop();

    }

    public void invokeTestSort(){
        Stack st = new Stack(5);
        st.push(1);
        st.push(4);
        st.push(2);
        st.push(3);
        st.sort();
        System.out.println("Final popping begins");
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
    }
}
