import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IEmpresa extends Remote {
    public Factura[] pendientes(int idcliente) throws RemoteException;
    public String pagar(Factura[] facturas) throws RemoteException;
}
