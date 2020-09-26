/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chaterico;
import java.net.Socket;
import javax.swing.JOptionPane;
/**
 *
 * @author ericoweber
 */
public class reciverThread extends Thread {
 
    private Socket socket;

    public reciverThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            while (true) {
                String mensagem = comunicator.reciveMessage(socket); //recebe uma string enviada pela rede
                if (mensagem == null) {
                    System.exit(0);
                }
                System.out.println("Mensagem recebida: " + mensagem);
            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Problemas com a thread receptora das mensagens: "+error.toString());
            error.printStackTrace();
        }

    }
}
