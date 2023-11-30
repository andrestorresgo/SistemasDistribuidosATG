import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfazRemota extends Remote {
    boolean introducirValor(String cadena) throws RemoteException;
    String invertir() throws RemoteException;
    String aumentarEspacios(int n) throws RemoteException;
    String aumentar(String cadena) throws RemoteException;
}
