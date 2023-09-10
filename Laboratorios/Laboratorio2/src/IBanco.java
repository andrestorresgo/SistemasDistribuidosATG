import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBanco extends Remote {
     public Factura[] Calcular(int idcliente) throws RemoteException;
     public String Pagar(Factura[] fact) throws RemoteException;
}
