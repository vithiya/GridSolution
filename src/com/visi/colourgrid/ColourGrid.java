package com.visi.colourgrid;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ColourGrid {

    public String[][] createColourGrid(int col, int row){

        String[][] colorGrid = new String[col][row];
        for (int i = 0; i < colorGrid.length; i++) {
            for (int j = 0; j < colorGrid[i].length; j++)
                colorGrid[i][j] = generateRandomColurCode(4).toString();
        }
        return colorGrid;
    }

    public Color generateRandomColurCode(int numberOfColors){
        ArrayList<Color> colorList = new ArrayList<>();
        Random rand = new Random();
        for(int i =0; i< numberOfColors; i++){
            int r = rand.nextInt(255);
            int g = rand.nextInt(255);
            int b = rand.nextInt(255);
            Color code = new Color(r, g, b);
            colorList.add(code);
        }
        //return random from created list
        return colorList.get(rand.nextInt(colorList.size()));
    }
    public List<Node> getAllAdjacentNodes(Node node){
        ArrayList<Node> adjacentNode = new ArrayList<Node>();
        if(node.getTop()!= null){
            adjacentNode.add(node.getTop());
        }
        if(node.getBottom()!= null){
            adjacentNode.add(node.getBottom());
        }
        if(node.getLeft()!= null){
            adjacentNode.add(node.getLeft());
        }
        if(node.getRight()!= null){
            adjacentNode.add(node.getRight());
        }
        return adjacentNode;
    }

    public int traverse(Node node){
        String currentColor = node.getColourCode();
        int count =1;
        ArrayList<Node> adjacentNodes = (ArrayList<Node>) getAllAdjacentNodes(node);
        for (Node singleNode:adjacentNodes) {
            String nodeColour = singleNode.getColourCode();
            if(currentColor.equals(nodeColour)){
                count = count +1;
                traverse(singleNode);
            }
        }
        node.setVisited(true);
        return count;
    }
    public Node findMaxConnected(ArrayList<Node> nodeTree){
        int maxConnectednodes =0;
        Node startNode = null;
        for(Node node : nodeTree){
            int count =traverse(node);
            node.setMaxTraversalCount(count);
            if(count > maxConnectednodes){
                maxConnectednodes = count;
                startNode = node;
            }
        }
        return startNode;
    }

    public ArrayList<Node> createNodeTree(String colorGrid[][]){
        ArrayList<Node> nodeTree = new ArrayList<Node>();
        for (int i = 0; i < colorGrid.length; i++) {
            for (int j = 0; j < colorGrid[i].length; j++) {
                Node currentNode = new Node(colorGrid[i][j].toString());
                Node topNode = null;
                Node bottomNode = null;
                Node leftNode = null;
                Node rightNode = null;
                if(j!=0){
                    topNode = new Node(colorGrid[i][j-1].toString());
                }

                if(j!=colorGrid[i].length-1){
                    bottomNode = new Node(colorGrid[i][j+1].toString());
                }

                if(i!=0){
                    leftNode = new Node(colorGrid[i-1][j].toString());
                }
                if(i!=colorGrid.length-1){
                    rightNode = new Node(colorGrid[i+1][j].toString());
                }
                currentNode.setTop(topNode);
                currentNode.setBottom(bottomNode);
                currentNode.setLeft(leftNode);
                currentNode.setLeft(rightNode);
                nodeTree.add(currentNode);
            }
        }
        return nodeTree;
    }

    /*public Node[][] generateNodeArray(int col, int row){
        Node[][] colorGrid = new Node[col][row];
        Node node = new Node()

        Arrays.fill(colorGrid, );
        return colorGrid;
    }*/
}
