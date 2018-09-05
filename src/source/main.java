package source;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;


public class main {
    
    public static String[] columnNames = {"Tag", "Quantity"};
    public static Object [][] data = {};
    public static Tree tree = new Tree();
    public static JTable table = new JTable(new DefaultTableModel(data, columnNames));

    public static void main(String[] args) {


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 900);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        GridBagConstraints c = new GridBagConstraints();


        // Canvas w/ scrollpane
        Canvas canvas = new Canvas(tree);

        JScrollPane scroller = new JScrollPane(canvas);
        scroller.setPreferredSize(new Dimension(1000, 700));

        JPanel graphicsPanel = new JPanel();
        graphicsPanel.add(scroller);
        graphicsPanel.setVisible(false);
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.gridwidth = 3;
        panel.add(graphicsPanel, c);


        // JTable

        JPanel tablePanel = new JPanel();
        tablePanel.add(new JScrollPane(table));
        tablePanel.setVisible(false);
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.gridwidth = 3;
        panel.add(tablePanel, c);


        // URL TextField
        JTextField url = new JTextField();
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 10, 0, 10);
        panel.add(url, c);


        // Graphics Button
        JButton button = new JButton("Generar arbol Graphics");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Node root = tree.insertRoot("html");
                canvas.removeAll();
                canvas.updateUI();
                webScraper scraper = new webScraper(url.getText(), root);
                scraper.scrape(frame);
                graphicsPanel.setVisible(true);
                tablePanel.setVisible(false);

                HashMap<String, Integer> map = scraper.getTypes();
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);
                Object rowData[] = new Object[2];
                ArrayList temp = new ArrayList();

                for(String key : map.keySet()){
                    temp.add(key);
                }

                for (int i = 0; i < temp.size() ; i++) {
                    rowData[0] = temp.get(i);
                    rowData[1] = map.get(temp.get(i));
                    model.addRow(rowData);
                }
                table.setModel(model);


            }
        });
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 10, 0, 10);
        c.weightx = 1;
        panel.add(button, c);


        // JPanel button
        JButton button_table = new JButton("Mostrar tabla con cantidades");

        button_table.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablePanel.setVisible(true);
                graphicsPanel.setVisible(false);

            }
        });

        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = new Insets(0, 10, 0, 0);
        panel.add(button_table, c);

        frame.setVisible(true);




    }

    public JTree generateJTree(Node root, DefaultMutableTreeNode parentNode){

        ArrayList<Node> children = root.getChildren();

        for (Node child : children) {
            DefaultMutableTreeNode temp = AddNode(child.getData(), parentNode);
            generateJTree(child, temp);
        }

        return new JTree(parentNode);
    }

    public DefaultMutableTreeNode AddNode (String nodeName, DefaultMutableTreeNode parentNode){

        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(nodeName);
        parentNode.add(newNode);

        return newNode;
    }

}
