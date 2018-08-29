package source;

import java.awt.BorderLayout;
public class main {

    public static Tree tree = new Tree();
    
    
    public static void main(String[] args) {
        Node root = tree.insertRoot("html", 200);
        //
        //http://www.didthanoskill.me/
        webScraper scraper = new webScraper("https://fast.com/", root);
        scraper.scrape();
        
        tree.travelTree(root);
        
        
        /*
        mainFrame mainJFrame = new mainFrame();
        Node root = tree.insertRoot("0", mainJFrame.getWidth());
        
        tree.insertNode(root, "1", "0");
        tree.insertNode(root, "2", "0");
        tree.insertNode(root, "3", "0");
        tree.insertNode(root, "4", "0");
        tree.insertNode(root, "5", "0");
        tree.insertNode(root, "2.1", "2");
        tree.insertNode(root, "2.2", "2");
      
        Canvas canvas = new Canvas();
        mainJFrame.setLocationRelativeTo(null);
        mainJFrame.setLayout(new BorderLayout());
        mainJFrame.add(canvas, BorderLayout.CENTER);
        mainJFrame.setSize(1200,750);
        mainJFrame.setVisible(true);
        */
        
        
    }
    
}
