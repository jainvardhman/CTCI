package com.interview;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;

/**
 * Created by Vardhman on 8/1/2015.
 */
public class BinarySearchTree {
    public TreeNode head = null;
    public BinarySearchTree(){}
    public BinarySearchTree(int d){
        head = new TreeNode(d);
    }

    public void insert(int d){
        if(head == null) {
            head = new TreeNode(d);
            head.data = d;
            System.out.println("Inserted " + d + " to the head");
            head.left = null;
            head.right = null;
        }
        else{
            insert_rec(head, d);
        }
    }

    public void insert_rec(TreeNode current , int d){
        if(current != null) {
            if (d < current.data) {
                if(current.left == null) {
                    TreeNode newN = new TreeNode(d);
                    current.left = newN;
                    System.out.println("Inserted " + d +  " to left of " + current.data);
                }
                else {
                    insert_rec(current.left,d);
                }
            } else if (d > current.data) {
                if(current.right == null) {
                    TreeNode newN = new TreeNode(d);
                    current.right = newN;
                    System.out.println("Inserted " + d + " to right of " + current.data);
                }
                else {
                    insert_rec(current.right,d);
                }
            }
            else {
                System.out.println("Something went wrong");
            }
        }
    }

    /*public void delete(int d){
        TreeNode nodeFound = iterate(head,d);
        delete_rec(nodeFound,d);
    }

    public void delete_rec(TreeNode nodeFound, int d){
        if(nodeFound != null){
            if(nodeFound.left == null && nodeFound.right == null){
                nodeFound = null;
            }

            else {
                if(nodeFound.right == null){
                    nodeFound.data = nodeFound.
                }
            }

            else if(nodeFound.left == null || nodeFound.right == null){
                if(nodeFound.left == null){
                    nodeFound = nodeFound.right;
                    while (nodeFound != null)
                        nodeFound = nodeFound.left;
                }
                else{
                    nodeFound.data = nodeFound.left.data;
                    nodeFound.left = null;
                }
            }

            else {

            }
        }
        else {
            System.out.println("Node with data " + d + " not found in the tree");
        }
    }*/

    public void search(int d){
        TreeNode foundNode = iterate(head,d);
        if(foundNode !=null){
            System.out.println("Node with data " + d + "found in the tree");
        }
    }



    public TreeNode iterate(TreeNode current, int d){
        if(current != null) {
            if (current.data == d)
                return current;
            else if (d < current.data)
                return iterate(current.left, d);
            else if (d > current.data)
                return iterate(current.right, d);
            else
                return  null;
        }
        else
            return null;
    }

    public void traverse(String type){
        traverse_rec(head,type);
    }

    public void traverse_rec(TreeNode current, String type){
            //System.out.println("in in");
            if(current != null && type.equals("in")) {
                traverse_rec(current.left, type);
                visit(current);
                traverse_rec(current.right, type);
            }
            //System.out.println("in pre");
            else if(current != null && type.equals("pre")) {
                visit(current);
                traverse_rec(current.left, type);
                traverse_rec(current.right, type);
            }
            else if(current != null && type.equals("post")) {
                //System.out.println("in post");
                traverse_rec(current.left, type);
                traverse_rec(current.right, type);
                visit(current);
            }
        }

    public void visit(TreeNode node){
        if(node != null)
            System.out.println("The value at the current node is " + node.data);
        else
            System.out.println("Reached end of tree");
    }

    public void createMinimalTree(int[] elems){
        int start = 0;
        int end = elems.length - 1;
        createMinimalTreeRec(start,end,elems);
    }

    public void createMinimalTreeRec(int start, int end,int[] elems){
        int mid = ((start + end) / 2);
        //System.out.println("Inserting " + elems[mid]);
        insert(elems[mid]);
        if(mid != start)
            createMinimalTreeRec(start, mid - 1, elems);
        if(mid != end)
            createMinimalTreeRec(mid + 1, end, elems);
    }

    public void listOfDepths(){
        ArrayList<LinkedList> listOfD = new ArrayList<LinkedList>();
        listOfDepths_rec(listOfD, head, 1);
        for(LinkedList ll: listOfD){
            ll.print();
        }
    }

    public void listOfDepths_rec(ArrayList<LinkedList> listOfD, TreeNode current,int level){
        if(current != null){
            if(listOfD.size() < level)
                listOfD.add(new LinkedList());
            listOfD.get(level - 1).insert(current.data);
            listOfDepths_rec(listOfD,current.left,level +1);
            listOfDepths_rec(listOfD,current.right,level+1);
        }
    }

    public void check_balanced(){
       if(Math.abs(getDepth(head.left) - getDepth(head.right)) > 1)
           System.out.println("Unbalanced tree");
        else
           System.out.println("Balanced tree");
    }

    /*public void validateBST(){
        boolean isValid = bool_Valid(head);
    }

    public boolean bool_Valid(TreeNode node){

        if((node.left !=null && node.left.data < node.data || node.left == null) &
                (node.right !=null && node.right.data > node.data || node.right == null)){
            bool_Valid(node.left);
        }


        if(bool_Valid(node.left) && bool_Valid(node.right))
            return true;
        else
            return false;

    }

    public check_Child*/

    /*public int check_balanced_rec(TreeNode node){
        int lDepth = 0;
        int rDepth = 0;
        if (node.left == null)
            lDepth = 0;
        else
            lDepth = 1 + check_balanced_rec(node.left);
        if (node.right == null)
            rDepth = 0;
        else
            lDepth = 1 + check_balanced_rec(node.right);

        if(Math.abs(lDepth - rDepth))

    }*/

    public int getDepth(TreeNode node){
        int lDepth = 0;
        int rDepth = 0;
        if (node.left == null)
            lDepth = 0;
        else
            lDepth = 1 + getDepth(node.left);
        if (node.right == null)
            rDepth = 0;
        else
            lDepth = 1 + getDepth(node.right);
        return (Math.max(lDepth,rDepth));
    }
}

class TreeNode{
    int data;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode parent = null;
    public TreeNode(){}
    public TreeNode(int d){
        data = d;
    }
}
