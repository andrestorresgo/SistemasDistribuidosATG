import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor extends UnicastRemoteObject implements InterfazRemota {
    private String cadena;

    protected Servidor() throws RemoteException {
        super();
    }

    @Override
    public boolean introducirValor(String cadena) throws RemoteException {
        this.cadena = cadena;
        return true;
    }

    @Override
    public String invertir() throws RemoteException {
        return new StringBuilder(cadena).reverse().toString();
    }

    @Override
    public String aumentarEspacios(int n) throws RemoteException {
        this.cadena += "   ";
        return this.cadena;
    }

    @Override
    public String aumentar(String cadena) throws RemoteException {
        this.cadena += cadena;
        return this.cadena;
    }

    public static void main(String[] args) {
        try {
            Servidor obj = new Servidor();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("InterfazRemota", obj);

            System.out.println("Servidor listo");
        } catch (Exception e) {
            System.err.println("Excepción del servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}
