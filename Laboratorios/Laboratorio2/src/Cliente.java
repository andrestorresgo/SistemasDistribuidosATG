import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
    public static void main(String[] args) {
        IBanco banco;
        try {
            banco = (IBanco) Naming.lookup("rmi://localhost/Banco");

            Factura[] factura1 = banco.Calcular(1);
            for (Factura factura:factura1){
                System.out.println(factura);
            }

            Factura[] factura2 = banco.Calcular(2);
            for (Factura factura:factura2){
                System.out.println(factura);
            }
        } catch (NotBoundException e) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, e);
        } catch (MalformedURLException e) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, e);
        } catch (RemoteException e) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
