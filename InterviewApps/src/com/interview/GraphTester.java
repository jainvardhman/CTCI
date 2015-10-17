package com.interview;

/**
 * Created by Vardhman on 8/1/2015.
 */
public class GraphTester {
    public void invokeTestBasic(){
        String inp  = "A:B;B:C;C:A,D;D:C;E:G;F:E;G:F";
        Graph testG = new Graph(inp);
        testG.printGraph();
    }

    public void invokeTestRouteTester(){
        String inp  = "A:B;B:C;C:A,D;D:C;E:G;F:E;G:F";
        Graph testG = new Graph(inp);
        testG.routeBetweenNodes("A", "C");
        testG.routeBetweenNodes("A","F");
    }
}
