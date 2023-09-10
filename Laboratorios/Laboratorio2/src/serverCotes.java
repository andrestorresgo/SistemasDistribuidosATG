import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class serverCotes {
    public static void main(String[] args) {
        try {
            Cotes cotes = new Cotes();
            Naming.bind("Cotes", cotes);
        } catch (RemoteException e) {
            Logger.getLogger(serverCotes.class.getName()).log(Level.SEVERE, null, e);
        } catch (AlreadyBoundException e) {
            Logger.getLogger(serverCotes.class.getName()).log(Level.SEVERE, null, e);
        } catch (MalformedURLException e) {
            Logger.getLogger(serverCotes.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
