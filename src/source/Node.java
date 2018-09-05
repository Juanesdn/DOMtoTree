package source;


import java.util.ArrayList;

public class Node {
    private String data;
    private Node parent;
    private ArrayList<Node> children;
    private int childrenQuantity;

    public Node(){

    }

    public Node(String data, Node parent){
        this.data = data;
        this.parent = parent;
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

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }




}
