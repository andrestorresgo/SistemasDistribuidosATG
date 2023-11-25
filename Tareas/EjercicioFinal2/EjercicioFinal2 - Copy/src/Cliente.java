import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Date;

public class Cliente {
    private ServidorReserva servidorReserva;
    private BancoCliente bancoCliente;

    public Cliente(String servidorReservaUrl, BancoCliente bancoCliente) {
        try {
            this.servidorReserva = (ServidorReserva) Naming.lookup(servidorReservaUrl);
            this.bancoCliente = bancoCliente;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void reservar(Date inicio, Date fin, int idCliente, Date fechaCompra) {
        try {
            double precio = servidorReserva.cotizar(inicio, fin, fechaCompra);
            String respuesta = bancoCliente.realizarPago(idCliente, precio);
            if (respuesta.equals("exito:si")) {
                System.out.println("Compra exitosa");
            } else {
                System.out.println("Compra fallida");
            }
        } catch (RemoteException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}