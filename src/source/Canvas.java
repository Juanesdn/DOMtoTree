/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Juanes
 */
public class Canvas extends javax.swing.JPanel {

    
    public Canvas() {
        initComponents();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Node root = main.tree.getRoot();
                
        paintTree(g, root);
        
    }
    
    public void paintTree(Graphics g, Node root){
        g.drawString(root.getData(), root.getX(), root.getY());
        for (int i = 0; i < root.getChildrenQuantity(); i++) {
            paintTree(g, root.getChildren().get(i));
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        draw_btn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(658, 512));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        draw_btn.setText("jButton1");
        draw_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                draw_btnActionPerformed(evt);
            }
        });
        add(draw_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 30, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void draw_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_draw_btnActionPerformed
        repaint();
    }//GEN-LAST:event_draw_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton draw_btn;
    // End of variables declaration//GEN-END:variables
}
