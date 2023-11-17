import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Juez implements IJuez{
    public Juez() throws RemoteException {
        super();
    }

    @Override
    public ArrayList<Cuenta> ConsultarCuentas(String ci, String nombres, String apellidos) throws RemoteException {
        try {
            IASFI asfi;

            asfi = (IASFI) Naming.lookup("rmi://localhost/ASFI");
            System.out.println(asfi.ListaCuentas(ci, nombres, apellidos));
        } catch (NotBoundException ex) {
            Logger.getLogger(ClienteJuez.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClienteJuez.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteJuez.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Boolean RetenerMonto(Cuenta cuenta, Double monto, String glosa) throws RemoteException {
        try {
            IASFI asfi;

            asfi = (IASFI) Naming.lookup("rmi://localhost/ASFI");
            System.out.println(asfi.RetenerMonto(cuenta, monto));
        } catch (NotBoundException ex) {
            Logger.getLogger(ClienteJuez.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClienteJuez.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteJuez.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
