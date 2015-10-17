package com.interview;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkedListTester llt = new LinkedListTester();
        StackTester stt = new StackTester();
        QueueTester qt = new QueueTester();
        SetOfStacksTester setStacksT = new SetOfStacksTester();
        MyQueueTester mqTester = new MyQueueTester();
        AnimalShelterTester asTester = new AnimalShelterTester();
        GraphTester gTester = new GraphTester();
        BSTTester bstTester = new BSTTester();
        //llt.invokeTestBasic();
        //llt.invokeTestRemoveDups();
        //llt.invokeTestKthToLast(5);
        //llt.invokeTestDeleteMiddle();
        //llt.invokeTestPartition(5);
        //llt.invokeTestAddLL();
        //llt.invokeTestPalin();
        //llt.invokeTestLoopDetect();
        //llt.invokeTestIntersection();
        //stt.invokeTestBasic();
        //stt.invokeTestMin();
        //qt.invokeTestBasic();
        //setStacksT.invokeTestBasic();
        //mqTester.invokeTestBasic();
        //stt.invokeTestSort();
        //asTester.invokeTestBasic();
        //gTester.invokeTestBasic();
        //gTester.invokeTestRouteTester();
        //bstTester.invokeTestMinimal();
        //bstTester.invokeTestLOD();
        //bstTester.invokeTestBalanced();
        Misc m = new Misc();
        //int [] B = {2,9,8,7};
        //m.getMax(B,4);
        //System.out.println(m.getMax(B, 4, 0));
        //int [][] pBox = new int[][]{{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        //int [][] pExists = new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        //m.findAndPrintPath(pBox,2,3,pExists);
        //int [] B = {-10,-5,2,2,2,3,4,7,9,12,13};
        //m.magicIndex(B);
        //m.mult(78,198);
        //m.towers_of_hanoi(64);
        //m.paren(6);
        //m.represent_cents(5);
        /*Hashtable<Integer,ArrayList<Integer>> inp = new Hashtable<Integer,ArrayList<Integer>>();
        inp.put(1,new ArrayList<Integer>(){{add(1);add(5);}});
        inp.put(2,new ArrayList<Integer>(){{add(1);add(4);}});
        inp.put(3,new ArrayList<Integer>(){{add(2);add(5);}});
        inp.put(4,new ArrayList<Integer>(){{add(3);add(4);}});
        inp.put(5,new ArrayList<Integer>(){{add(3);add(3);}});
        inp.put(6,new ArrayList<Integer>(){{add(4);add(5);}});
        inp.put(7,new ArrayList<Integer>(){{add(1);add(3);}});
        inp.put(8,new ArrayList<Integer>(){{add(1);add(5);}});
        inp.put(9,new ArrayList<Integer>(){{add(2);add(3);}});
        inp.put(10,new ArrayList<Integer>(){{add(5);add(5);}});
        inp.put(11,new ArrayList<Integer>(){{add(1);add(1);}});
        inp.put(12,new ArrayList<Integer>(){{add(1);add(2);}});
        m.living_people(inp,1,5);*/
        //m.diving_board(2);
        //System.out.println(m.power(2, 10));
        m.coin_change(30, new ArrayList<Integer>(){{add(1);add(5);add(10);add(25);}});
    }


    public void max_drop(int[] arr){
        int start = 0;
        int end = arr.length;
        max_drop_rec(arr,start,end);
    }

    public void max_drop_rec(int[] arr, int start, int end){

    }
}
