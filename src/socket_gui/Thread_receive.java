/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket_gui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import javax.swing.JTextArea;

/**
 *
 * @author MASTER
 */
public class Thread_receive extends Thread {
    
    private JTextArea Field;
    private boolean isRunning = true, isServer = false;
    BufferedReader stream_toReceive;
    private Socket s_receive;
    private ServerSocket socket_receive;
    
    public Thread_receive(JTextArea Field, ServerSocket socket_receive){
        this.Field = Field;
        this.socket_receive = socket_receive;
        isServer = true;
    }
    
    public Thread_receive(JTextArea Field, Socket s_receive){
        this.Field = Field;
        this.s_receive = s_receive;
    }
    
    public void run(){
        try{
            Field.setText("Waiting for connection...");
            Field.setEditable(false);
            if (isServer)
                s_receive = socket_receive.accept();
            Field.setText("");
            stream_toReceive = new BufferedReader(new InputStreamReader(s_receive.getInputStream(),"utf8"));
            while (isRunning){
                    Field.setText(Field.getText() + stream_toReceive.readLine() + "\r\n");
            }
        } catch (SocketException e){ System.exit(0);}
        catch (Exception e) {System.out.println("Exception: " + e.getMessage());}
    }
    
    public void stopThread(){
        isRunning = false;
    }

}
