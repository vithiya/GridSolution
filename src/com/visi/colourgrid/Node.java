package com.visi.colourgrid;

public class Node {
    private Node top;
    private Node bottom;
    private Node left;
    private Node right;
    private String colourCode;
    private boolean visited;
    private int maxTraversalCount;

    public Node(String colourCode) {
        this.colourCode = colourCode;
        this.visited=false;
    }

    public Node(Node top, Node bottom, Node left, Node right, String colourCode) {
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
        this.colourCode = colourCode;
        this.visited=false;
    }

    public Node getTop() {
        return top;
    }

    public void setTop(Node top) {
        this.top = top;
    }

    public Node getBottom() {
        return bottom;
    }

    public void setBottom(Node bottom) {
        this.bottom = bottom;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public String getColourCode() {
        return colourCode;
    }

    public void setColourCode(String colourCode) {
        this.colourCode = colourCode;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getMaxTraversalCount() {
        return maxTraversalCount;
    }

    public void setMaxTraversalCount(int maxTraversalCount) {
        this.maxTraversalCount = maxTraversalCount;
    }
}
