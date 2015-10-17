package com.interview;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Vardhman on 7/28/2015.
 */
public class SetOfStacks {
    ArrayList<Stack> stackSet;
    int maxSizePerStack;
    int currentStackSize;
    public SetOfStacks(int maxSz){
        stackSet = new ArrayList<Stack>();
        maxSizePerStack = maxSz;
        currentStackSize = 0;
    }

    public void push(int d){
        if(stackSet != null){
            if(stackSet.size() < (currentStackSize / maxSizePerStack) + 1)
                stackSet.add(new Stack());
            stackSet.get((currentStackSize / maxSizePerStack)).push(d);
            System.out.println("This was pushed to stack " + ((currentStackSize / maxSizePerStack) +1));
            currentStackSize++;
        }
    }

    public void pop(){
        if(stackSet != null && currentStackSize > 0){
            stackSet.get((currentStackSize - 1) / maxSizePerStack).pop();
            System.out.println("This was popped from" + (((currentStackSize - 1) / maxSizePerStack) + 1));
            currentStackSize--;
        }

        else{
            System.out.println("Stack is currently empty");
        }
    }

    public void popAt(int index){
        if(((currentStackSize-1) / maxSizePerStack) < index - 1){
            System.out.println("This stack is empty");
        }
        else{
            stackSet.get(index - 1).pop();
        }
    }
}
