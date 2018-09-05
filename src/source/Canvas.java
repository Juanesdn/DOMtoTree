package source;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;


public class Canvas extends JPanel {

    private int radio = 20;
    private int verticalSpace = 50;
    private Tree tree;
    private HashMap<Node,Point> coordinates;


    public Canvas(Tree tree) {
        this.tree = tree;
        this.coordinates = new HashMap<>();
        setPreferredSize(new Dimension(2000, 900));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        paintTree(g, main.tree.getRoot(), getWidth()/2 - 200, 30, getWidth()/5);

    }

    public void paintTree(Graphics g, Node root, int x, int y, int horizontalSpace){
        g.drawOval(x-radio,y-radio,2*radio,2*radio);
        String [] text = root.getData().split("/");
        g.drawString(text[0] + "", x - 8, y + 4);

        ArrayList<Node> children = root.getChildren();

        coordinates.put(root, new Point(x, y));

        for (Node child : children) {
            Point point = coordinates.get(tree.getParent(child));
            drawLine(g, x-horizontalSpace, y+verticalSpace, point.x, point.y);
            paintTree(g,child, x-horizontalSpace, y+verticalSpace, horizontalSpace/children.size() + radio);
            x += horizontalSpace;
        }
    }

    public void drawLine(Graphics g, int x1, int y1, int x2, int y2){

        double d = Math.sqrt(verticalSpace*verticalSpace+(x2-x1)*(x2-x1));
        int pos_x1 = (int)(x1-radio*(x1-x2)/d);
        int pos_y1 = (int)(y1-radio*(y1-y2)/d);
        int pos_x2 = (int)(x2+radio*(x1-x2)/d);
        int pos_y2 = (int)(y2+radio*(y1-y2)/d);

        g.drawLine(pos_x1,pos_y1,pos_x2,pos_y2);
    }
}
