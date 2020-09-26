
package chaterico;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ericoweber
 */
public class comunicator {


    public static String reciveMessage(Socket s) {
        String message = null;
        try {
            ObjectInputStream reader = new ObjectInputStream(s.getInputStream());
            message = (String) reader.readObject();
        } catch (IOException error) {
            JOptionPane.showMessageDialog(null, "Problemas para enviar a mensagem: "+error.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(comunicator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }

    public static void sendMessage(Socket s, String message) {
        try {
            ObjectOutputStream writer = new ObjectOutputStream(s.getOutputStream());
            writer.writeObject(message);
        } catch (IOException error) {
            JOptionPane.showMessageDialog(null, "Problemas para enviar a mensagem: "+error.toString());
        }
    }
}




