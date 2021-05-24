package com.visi.colourgrid;

import java.util.ArrayList;

public class ColourGridTest {

    public static void main(String[] args) {
        ColourGrid colourGrid = new ColourGrid();
        String[][] colorGridArray = colourGrid.createColourGrid(5,5);
        for (int i = 0; i < colorGridArray.length; i++) {
            for (int j = 0; j < colorGridArray[i].length; j++) {
                System.out.print(""+colorGridArray[i][j]);
            }
            System.out.println();
        }
        ArrayList<Node> nodeTree = colourGrid.createNodeTree(colorGridArray);
        Node node = colourGrid.findMaxConnected(nodeTree);
        System.out.println("Long connected grid : color " + node.getColourCode() + " countOfNodes : " + node.getMaxTraversalCount());


    }

   /* public void findLargeConnectedGrid(String colorGrid[][]){
        for (int i = 0; i < colorGrid.length; i++) {
            for (int j = 0; j < colorGrid[i].length; j++) {
                    Node currentNode = new Node();
            }
        }
    }*/


}
