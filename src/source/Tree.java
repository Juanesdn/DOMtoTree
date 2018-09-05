package source;

import java.util.ArrayList;


public class Tree {

    private Node root;

    public Tree(){

    }

    public Node insertRoot(String data){
        root = new Node(data, null);
        return root;
    }

    public void insertNode(Node node, String data, String parent){


        // Checks if the parent is the root
        if(node.getData().equals(parent)){
            Node newChild = new Node(data, node);
            node.addChild(newChild);
        }else {
            // Searchs for the node in all the parents
            for (int i = 0; i < node.getChildrenQuantity(); i++) {
                if(node.getChildren().get(i).getData().equals(parent)){
                    Node newChild = new Node(data, node.getChildren().get(i));
                    node.getChildren().get(i).addChild(newChild);
                }else{
                    insertNode(node.getChildren().get(i), data, parent);
                }
            }
        }
    }

    public Node getParent(Node node){
        return node.getParent();
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
