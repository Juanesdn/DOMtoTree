package source;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class webScraper {
    
    private String url;
    private Node root;
    
    public webScraper(String url, Node root){
        this.url = url;
        this.root = root;
    }
    
    void scrape(){
        try {
            Document document;
            document = Jsoup.connect(url).get();
            Element head = document.selectFirst("head");
            Element body = document.selectFirst("body");
            main.tree.insertNode(this.root, head.nodeName() + "/" + head.className(), "html");
            main.tree.insertNode(this.root, body.nodeName() + "/" + body.className(), "html");
            generateTree(this.root, head);
            generateTree(this.root, body);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    Node generateTree(Node root, Element element){
        Elements children = element.children();
        
        if(children.size() == 0){
            return root;
        }
        
        for (Element child : children) {
            String childName = child.nodeName() + "/" +  child.className();
            String parentName = element.nodeName() + "/" + element.className();
            main.tree.insertNode(root, childName, parentName);
            generateTree(root, child);
        }
        
        return root;
    }
    
    
}

