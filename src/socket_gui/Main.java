/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket_gui;

/**
 *
 * @author A.S.
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length != 0 && args[0].equals("-s"))
            new GUI_Server().setVisible(true);              // Starting server
        else
            new GUI_client_startup().setVisible(true);      // Starting Client
    }
    
}
