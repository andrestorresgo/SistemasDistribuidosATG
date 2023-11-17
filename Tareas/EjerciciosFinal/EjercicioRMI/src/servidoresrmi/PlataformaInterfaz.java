package servidoresrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PlataformaInterfaz extends Remote {
    void realizarTransferencia(Cuenta origen, Cuenta destino, double monto, Banco banco) throws RemoteException;
}
