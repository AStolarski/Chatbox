/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket_gui;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import javax.swing.JTextArea;
import java.net.*;

/**
 *
 * @author A.S.
 */
public class Thread_send extends Thread {
    private JTextArea Field;
    private boolean isSent = false, isConnected = false, isRunning = true, isServer = false;
    private BufferedWriter stream_toSend;
    private Socket s_send;
    private ServerSocket socket_send;
    
    public Thread_send(JTextArea Field, ServerSocket socket_send){
        this.Field = Field;
        this.socket_send = socket_send;
        isServer = true;
    }
    
    public Thread_send(JTextArea Field, Socket s_send){
        this.Field = Field;
        this.s_send = s_send;
    }
    
    public void run(){
            try{
                Field.setText("Waiting for connection...");
                Field.setEditable(false);
                if(isServer)
                    s_send = socket_send.accept();
                isConnected = true;
                Field.setEditable(true);
                Field.setText("");
                stream_toSend = new BufferedWriter(new OutputStreamWriter(s_send.getOutputStream(),"utf8"));
                while (isRunning){
                    if (isSent){
                        stream_toSend.write(Field.getText() + "\n");
                        stream_toSend.flush();
                        Field.setText("");
                        isSent = false;
                    }
                    
                    System.out.println("Bound : " + s_send.isBound());
                    System.out.println("Closed : " + s_send.isClosed());
                    System.out.println("Input Closed : " + s_send.isInputShutdown());
                    System.out.println("Output closed : " + s_send.isOutputShutdown());
                    
                    if (isServer)
                        if (s_send.isInputShutdown()){
                            Field.setText("Waiting for connection...");
                            s_send = socket_send.accept();
                        }
                        
                    Thread.sleep(1000);
                }
            } catch (Exception e) {System.out.println("Exception: " + e.getMessage());}
    }
    public void send(){
        if (isConnected)
            isSent = true;
    }
    
    public void stopThread(){
        isRunning = false;
        isConnected = false;
    }
}
