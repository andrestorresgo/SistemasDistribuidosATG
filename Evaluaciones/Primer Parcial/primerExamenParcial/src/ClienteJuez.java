import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteJuez {

    public static void main(String[] args) {
        try {

            Juez juez = new Juez();

            IASFI asfi;
            asfi = (IASFI) Naming.lookup("rmi://localhost/ASFI");

            var sc = new Scanner(System.in);
            boolean salir = false;

            while (!salir) {
                System.out.println("Elija una opcion: ");
                System.out.println("1. Consultar Cuentas");
                //System.out.println("2. Retener monto");
                System.out.println("Salir");
                String numero = sc.next();
                if (numero.equals("Salir")) {
                    salir = true;
                    System.out.println("Se termino");
                } else {
                    //llamar a ConsultarCuentas
                    //System.out.println(asfi.ListaCuentas("11021654","Juan Perez","Segovia"));
                    juez.ConsultarCuentas("11021654", "Juan Perez", "Segovia");
                    System.out.println("Elija una opcion: ");
                    System.out.println("1. Retener Monto");
                    juez.RetenerMonto(new Cuenta( Banco.BCP,"657654", "11021654", "Juan Perez", "Segovia", 100.0), 50.0, "retencion");
                }
            }



        } catch (NotBoundException ex) {
            Logger.getLogger(ClienteJuez.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClienteJuez.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteJuez.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}