package com.interview;

import java.util.Set;

/**
 * Created by Vardhman on 7/28/2015.
 */
public class SetOfStacksTester {
    public void invokeTestBasic(){
        SetOfStacks st = new SetOfStacks(3);
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.pop();
        st.push(5);
        st.push(6);
        st.push(7);
        st.popAt(1);
        st.push(8);
        st.push(9);
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
        st.pop();
        st.pop();
    }
}
