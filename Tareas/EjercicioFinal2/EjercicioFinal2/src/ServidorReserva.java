import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface ServidorReserva extends Remote {
    double cotizar(Date inicio, Date fin, Date fechaCotizacion) throws RemoteException;
    boolean reservar(Date inicio, Date fin, int idCliente) throws RemoteException;
}