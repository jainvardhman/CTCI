package com.interview;

/**
 * Created by Vardhman on 8/1/2015.
 */
public class BSTTester {
    public void invokeTestMinimal(){
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        BinarySearchTree bst = new BinarySearchTree();
        bst.createMinimalTree(array);
        bst.traverse("in");
    }

    public void invokeTestLOD(){
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        BinarySearchTree bst = new BinarySearchTree();
        bst.createMinimalTree(array);
        bst.listOfDepths();
    }

    public void invokeTestBalanced(){
        //int[] array = {1,2,3,4,5,6,7,8,9,10};
        //BinarySearchTree bst = new BinarySearchTree();
        //bst.createMinimalTree(array);
        //bst.check_balanced();
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(11);
        bst.insert(9);
        bst.insert(8);
        bst.insert(7);
        bst.check_balanced();
    }
}
