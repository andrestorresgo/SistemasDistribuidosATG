import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IJuez extends Remote {

    public ArrayList <Cuenta> ConsultarCuentas(String ci, String nombres, String apellidos) throws RemoteException;

    public Boolean RetenerMonto(Cuenta cuenta, Double monto, String glosa) throws RemoteException;
}
