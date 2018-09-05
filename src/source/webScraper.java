package source;

import java.io.IOException;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class webScraper {

    private String url;
    private Node root;
    private HashMap<String, Integer> types;

    public webScraper(String url, Node root){
        this.url = url;
        this.root = root;
        this.types = new HashMap<>();
    }

    void scrape(JFrame frame){
        try {
            Document document;
            document = Jsoup.connect(url).get();
            Element head = document.selectFirst("head");
            Element body = document.selectFirst("body");
            types.put("html", 1);
            types.put("head", 1);
            types.put("body", 1);
            main.tree.insertNode(this.root, head.nodeName() + "/" + head.className(), "html");
            main.tree.insertNode(this.root, body.nodeName() + "/" + body.className(), "html");
            generateTree(this.root, head);
            generateTree(this.root, body);

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(frame, "Ingrese un URL valido");
        } catch (IOException ex){
            JOptionPane.showMessageDialog(frame, "No se pudo ingresar al URL");
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
            if(!types.containsKey(child.nodeName())){
                types.put(child.nodeName(), 1);
            }else{
                types.put(child.nodeName(), types.get(child.nodeName()).intValue() + 1);
            }
            generateTree(root, child);
        }

        return root;
    }

    public HashMap<String, Integer> getTypes() {
        return types;
    }
}

