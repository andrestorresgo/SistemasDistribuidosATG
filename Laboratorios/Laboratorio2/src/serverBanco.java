import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class serverBanco {
    public static void main(String[] args) {
        try {
            Banco banco = new Banco();
            LocateRegistry.createRegistry(1099);
            Naming.bind("Banco", banco);
        } catch (RemoteException ex) {
            Logger.getLogger(serverBanco.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(serverBanco.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(serverBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
