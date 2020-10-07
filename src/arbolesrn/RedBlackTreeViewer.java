
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesrn;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Administrador
 */
public class RedBlackTreeViewer extends javax.swing.JFrame {

    static int i = 90;

    /**
     * Creates new form RedBlackTreeViewer
     */
    public RedBlackTreeViewer() {
        initComponents();
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        g.drawString("hola", 0, 0);
        g.drawLine(20, 30,30 , 40);
    }

    public static int dis() {
        i += 18;
        return i;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RedBlackTreeViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RedBlackTreeViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RedBlackTreeViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RedBlackTreeViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
 /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RedBlackTreeViewer().setVisible(true);
            }
        });*/
        Rojinegros arbol = new Rojinegros();

        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(entrada);

        arbol.inicializar();
        String aux;
        //int v;
        
        final JFrame frame = new JFrame("Test");
        frame.setLayout(new GridLayout(0, 1));
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);
        //int i = 90;
        JButton insertar = new JButton("Insertar");
        JButton eliminar = new JButton("Eliminar");
        JButton dibujar = new JButton("Dibujar");
        JTextField numInserta = new JTextField();
        JTextField nameInsert = new JTextField();
        
        JTextField imprimirOrden = new JTextField();
        JButton btnPreorden = new JButton("Preorden");
        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int v;
                String name;
                name = nameInsert.getText();
                v = Integer.parseInt(numInserta.getText());
                arbol.insertar(v,name);
                arbol.num = 0;
                /*
                System.out.println("si");
                JLabel a = new JLabel("si");
                int j;
                j = dis();
                a.setBounds(j,10,20,20);
                panel.add(a);
                panel.updateUI();
                panel.repaint();*/
            }

        });
        
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int v;
                v = Integer.parseInt(numInserta.getText());
                arbol.eliminar(arbol.Raiz(), v);
                arbol.num = 0;
                
                System.out.println("si");
                /*
                JLabel a = new JLabel("si");
                int j;
                j = dis();
                a.setBounds(j,10,20,20);
                panel.add(a);
                panel.updateUI();
                panel.repaint();*/
            }

        });
        
        btnPreorden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arbol.preorden(arbol.Raiz());
                String preOrdenPuntos = String.valueOf(arbol.preordenData);
                imprimirOrden.setText(preOrdenPuntos);
            }
        });
        
        dibujar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arbol.inorden(arbol.Raiz(), 0, "a");
                System.out.println("array");
                //JPanel panelDibujo = new JPanel();
                //panelDibujo.setBounds(0,90,200,200);
                //JLabel ps = new JLabel("dddd");
                //ps.setBounds(30,30,50,50);
                //panelDibujo.add(ps);
                //panel.add(panelDibujo);
                panel.removeAll();
                panel.add(insertar);
                panel.add(numInserta);
                panel.add(nameInsert);
                panel.add(eliminar);
                panel.add(dibujar);

                panel.add(imprimirOrden);
                panel.add(btnPreorden);
                
                pintar(arbol.num, arbol.data(), panel);
                /*for (int i = 2; i < arbol.inordenData.size(); i++) {
                    String[] parts = arbol.inordenData.get(i).split(".");
                    System.out.print(" " + arbol.inordenData.get(i));
                }*/
                panel.updateUI();
                panel.repaint();
               // panelDibujo.updateUI();
               // panelDibujo.repaint();
                
                arbol.cleanData();
            }

        });
        insertar.setBounds(100, 0, 80, 25);
        dibujar.setBounds(100, 30, 80, 25);
        numInserta.setBounds(0, 0, 90, 25);
        eliminar.setBounds(200, 0, 80, 25);
        nameInsert.setBounds(0, 30, 90, 25);
        
        imprimirOrden.setBounds(300, 0, 200, 25);
        btnPreorden.setBounds(300, 30, 80, 25);
        
        panel.add(insertar);
        panel.add(numInserta);
        panel.add(nameInsert);

        panel.add(dibujar);
        panel.add(eliminar);
        
        panel.add(imprimirOrden);
        panel.add(btnPreorden);
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 300);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        });

    }

 static void pintar(int size, ArrayList<String> nodo, JPanel panel) {

        List<Integer> posIniciales = new ArrayList<Integer>(size);
        List<Integer> saltos = new ArrayList<Integer>(size);

        int val = 0;
        int anterior = 15;
        for (int j = 0; j < size; j++) {
            posIniciales.add(j, val);
            val = val + anterior;
            anterior = anterior * 2;
            saltos.add(j, anterior);
        }

        for (int i = 2; i < nodo.size(); i++) {

            String nodoPuntos = nodo.get(i);
            String[] parts = nodoPuntos.split("-");
            JLabel a = new JLabel(parts[0]);
            JLabel b = new JLabel(parts[4]);
            if ("R".equals(parts[1])) {
                a.setForeground(Color.red);
                b.setForeground(Color.red);
            } else {
                a.setForeground(Color.black);
                b.setForeground(Color.black);
            }
            int position = size - Integer.parseInt(parts[2]);
            
            if (position >= 0) {
                a.setBounds((int) posIniciales.get(position), (size - position) * 45, 30, 30);
                b.setBounds((int) posIniciales.get(position), ((size - position) * 45)+10, 30, 30);

                posIniciales.set(position, posIniciales.get(position) + saltos.get(position));
            }
            
            panel.add(a);
            panel.add(b);

            System.out.print(" " + nodo.get(i));
        }
        //panel.updateUI();
        //panel.repaint();
        System.out.println("a");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}