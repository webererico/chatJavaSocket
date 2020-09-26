/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chaterico;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author ericoweber
 */
public class senderThread {
    
    private Socket socket;

    public senderThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            System.out.println("Digite: ");
            while (true) {
                String message = new String();
                comunicator.sendMessage(socket, message); //envia uma mensagem pela rede
            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Erro na thread enviadora: "+error.toString());
            error.printStackTrace();
        }
    }

}
