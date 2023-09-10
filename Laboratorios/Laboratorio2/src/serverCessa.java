import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class serverCessa {
    public static void main(String[] args) {
        try {
            Cessa cessa = new Cessa();
            Naming.bind("Cessa", cessa);
        } catch (RemoteException e) {
            Logger.getLogger(serverCessa.class.getName()).log(Level.SEVERE, null, e);
        } catch (AlreadyBoundException e) {
            Logger.getLogger(serverCessa.class.getName()).log(Level.SEVERE, null, e);
        } catch (MalformedURLException e) {
            Logger.getLogger(serverCessa.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}