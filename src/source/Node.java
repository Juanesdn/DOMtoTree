package source;

import java.util.ArrayList;

public class Node {
    private String data;
    private ArrayList<Node> children;
    private int childrenQuantity;
    private int x;
    private int y;
    
    public Node(String data){
        this.data = data;
        this.childrenQuantity = 0;
        this.children = new ArrayList<>();
    }   

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void addChild(Node childNode) {
        children.add(childNode);
        childrenQuantity = children.size();
    }

    public int getChildrenQuantity() {
        return childrenQuantity;
    }

    public void setChildrenQuantity(int childrenQuantity) {
        this.childrenQuantity = childrenQuantity;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
    
}
