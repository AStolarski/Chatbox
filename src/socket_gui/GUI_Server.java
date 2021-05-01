/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket_gui;

import java.net.*;
import javax.swing.JTextField;

/**
 *
 * @author A.S.
 */
public class GUI_Server extends javax.swing.JFrame {
    
    private ServerSocket socket_send, socket_receive;
    private Thread_send thr_send;
    private Thread_receive thr_receive;

    /**
     * Creates new form GUI_Server
     */
    public GUI_Server() {
        initComponents();
        createServerSockets();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Label_port_send = new javax.swing.JLabel();
        Label_port_receive = new javax.swing.JLabel();
        Field_port_send = new javax.swing.JTextField();
        Field_port_receive = new javax.swing.JTextField();
        Label_Data_received = new javax.swing.JLabel();
        Label_data_toSend = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Field_received = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        Field_to_send = new javax.swing.JTextArea();
        Button_send = new javax.swing.JButton();
        Button_exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server");

        Label_port_send.setText("Sending port:");

        Label_port_receive.setText("Receiving port:");

        Field_port_send.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Field_port_send.setEnabled(false);

        Field_port_receive.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Field_port_receive.setEnabled(false);

        Label_Data_received.setText("Data received:");

        Label_data_toSend.setText("Data to send:");

        Field_received.setColumns(20);
        Field_received.setRows(5);
        Field_received.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(Field_received);

        Field_to_send.setColumns(20);
        Field_to_send.setRows(5);
        jScrollPane2.setViewportView(Field_to_send);

        Button_send.setText("Send");
        Button_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_sendActionPerformed(evt);
            }
        });

        Button_exit.setText("Exit");
        Button_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(Label_data_toSend)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(Label_Data_received)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Label_port_receive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Label_port_send, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Field_port_send)
                            .addComponent(Field_port_receive)
                            .addComponent(Button_send, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Button_exit)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_port_send)
                    .addComponent(Label_Data_received))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Field_port_send, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Label_port_receive)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Field_port_receive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Label_data_toSend)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_send))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Button_exit)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_exitActionPerformed
        try{
            thr_send.stopThread();
            thr_receive.stopThread();
            socket_send.close();
            socket_receive.close();
        } catch (Exception e) {System.out.println("Exception: "+ e.getMessage());}
        finally{
            System.exit(0);
        }
    }//GEN-LAST:event_Button_exitActionPerformed

    private void Button_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_sendActionPerformed
        thr_send.send();
    }//GEN-LAST:event_Button_sendActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Server().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_exit;
    private javax.swing.JButton Button_send;
    private javax.swing.JTextField Field_port_receive;
    private javax.swing.JTextField Field_port_send;
    private javax.swing.JTextArea Field_received;
    private javax.swing.JTextArea Field_to_send;
    private javax.swing.JLabel Label_Data_received;
    private javax.swing.JLabel Label_data_toSend;
    private javax.swing.JLabel Label_port_receive;
    private javax.swing.JLabel Label_port_send;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    public void createServerSockets(){
        try{
        socket_send = new ServerSocket(0);
        socket_receive = new ServerSocket(0);
        Field_port_send.setText(String.valueOf(socket_send.getLocalPort()));
        Field_port_receive.setText(String.valueOf(socket_receive.getLocalPort()));
        thr_send = new Thread_send(Field_to_send, socket_send);
        thr_receive = new Thread_receive(Field_received, socket_receive);
        thr_send.start();
        thr_receive.start();
        } catch(Exception e) {System.out.println("Exception: "+e.getMessage());}
        
    }
}
