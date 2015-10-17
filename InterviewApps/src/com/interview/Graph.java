package com.interview;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Vardhman on 8/1/2015.
 */
public class Graph {
    HashMap<String,GraphNode> vertices;// GraphNode[] vertices;
    public Graph(){}
    public Graph(String connections){
        vertices = new HashMap<String,GraphNode>();
        String[] vertexSplit = connections.split(";");
        int ind = 0;
        //vertices = new GraphNode[vertexSplit.length];
        for (String verts:vertexSplit){
            String[] vert_con_pair = verts.split(":");
            String[] vert_connections = vert_con_pair[1].split(",");
            GraphNode current_vert = new GraphNode(vert_con_pair[0],vert_connections.length);
            int conInd = 0;
            for(String con: vert_connections){
                if(!current_vert.children.containsKey(con))
                    current_vert.children.put(con,null);// [conInd++] = new GraphNode(con);
            }
            if(!vertices.containsKey(vert_con_pair[0]));
            vertices.put(vert_con_pair[0], current_vert);
        }
    }

    public void printGraph(){
        for(String vert_key : vertices.keySet()){
            System.out.print(vertices.get(vert_key).names + ":");
            for (String child_key : vertices.get(vert_key).children.keySet()){
                System.out.print(child_key + ",");
            }
            System.out.println();
        }
    }

    public void routeBetweenNodes(String start, String destination){
        ArrayList<String> discovered = new ArrayList<String>();
        dfs(vertices.get(start),destination,discovered);
        if(!discovered.contains(destination)){
            System.out.println("Path does not exist");
        }
        else{
            System.out.println("Path exists");
        }
    }

    public void dfs(GraphNode gNode, String destination,ArrayList<String> discovered){
        if(discovered.size() < vertices.size()) {
            if (discovered.contains(gNode.names))
                return;
            else {
                discovered.add(gNode.names);
                for (String child : gNode.children.keySet()) {
                    //System.out.println("Child: " + child + " Destination: " + destination );
                    dfs(vertices.get(child), destination, discovered);
                }
            }
        }
    }

}

class GraphNode{
    String names;
    HashMap<String,GraphNode> children;
    //GraphNode[] children;
    public GraphNode(String name,int len){
        names = name;
        children = new HashMap<String,GraphNode>(len);//[len];
    }
    public GraphNode(String name){
        names = name;
    }
}
