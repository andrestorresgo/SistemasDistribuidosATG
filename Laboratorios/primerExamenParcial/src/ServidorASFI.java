import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorASFI {
    public static void main(String[] args) {
        try {
            ASFI asfi = new ASFI();
            LocateRegistry.createRegistry(1099);
            Naming.bind("ASFI", asfi);


        } catch (RemoteException ex) {
            Logger.getLogger(ServidorASFI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(ServidorASFI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServidorASFI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
