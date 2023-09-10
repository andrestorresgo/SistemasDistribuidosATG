import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Banco extends UnicastRemoteObject implements IBanco {
    public Banco() throws RemoteException {
        super();
    }

    @Override
    public Factura[] Calcular(int idcliente) throws RemoteException {
        System.out.println(idcliente);
        try {
            IEmpresa cessa, cotes;

            cessa = (IEmpresa) Naming.lookup("rmi://localhost/Cessa");
            Factura[] facturasCessa = cessa.pendientes(idcliente);
            cotes = (IEmpresa) Naming.lookup("rmi://localhost/Cotes");
            Factura[] facturasCotes = cotes.pendientes(idcliente);

            Factura[] aux = new Factura[facturasCessa.length + facturasCotes.length];
            int i = 0;
            for (Factura factura:facturasCessa){
                aux[i] = factura;
                i++;
            }
            for (Factura factura:facturasCotes){
                aux[i] = factura;
                i++;
            }
            return aux;
        } catch (NotBoundException e) {
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, e);
        } catch (MalformedURLException e) {
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public String Pagar(Factura[] facturas) throws RemoteException {
        String respuesta = "";

        try {
            IEmpresa cessa, cotes;
            cessa = (IEmpresa) Naming.lookup("rmi://localhost/Cessa");
            cotes = (IEmpresa) Naming.lookup("rmi://localhost/Cotes");

            for (Factura factura:facturas) {
                if (factura.getEmpresa().getNombre().equals("CESSA")){

                }
            }
        } catch (NotBoundException e) {
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, e);
        } catch (MalformedURLException e) {
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

}



