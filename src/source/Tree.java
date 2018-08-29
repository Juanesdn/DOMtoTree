package source;

import java.util.ArrayList;


public class Tree {
    
    private Node root;
    
    public Tree(){
        this.root = null;
    }
    
    public Node insertRoot(String data, int width){
        root = new Node(data);
        root.setX(200);
        root.setY(130);
        return root;
    }
    
    public void insertNode(Node node, String data, String parent){
        Node newChild = new Node(data);
        
        // Checks if the parent is the root
        if(node.getData().equals(parent)){
            node.addChild(newChild);
        }else {
            // Searchs for the node in all the parents
            for (int i = 0; i < node.getChildrenQuantity(); i++) {
                if(node.getChildren().get(i).getData().equals(parent)){
                    node.getChildren().get(i).addChild(newChild);
                }else{
                    insertNode(node.getChildren().get(i), data, parent);
                }
            }
        }
    }
    
    
    public void travelTree(Node root){
        System.out.println("[" + root.getData() + "]");
        for (int i = 0; i < root.getChildrenQuantity(); i++) {
            travelTree(root.getChildren().get(i));
        }
    }
    
    public ArrayList getNodes(Node root){
        return root.getChildren();
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
    
    
    
    
}
