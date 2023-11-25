import java.rmi.Naming;
import java.text.SimpleDateFormat;

public class Cliente {
    private ServidorReserva servidorReserva;
    private BancoCliente bancoCliente;
    private SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yy");

    public Cliente(String servidorReservaUrl, BancoCliente bancoCliente) {
        try {
            this.servidorReserva = (ServidorReserva) Naming.lookup(servidorReservaUrl);
            this.bancoCliente = bancoCliente;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void reservar(String inicio, String fin, int idCliente, String fechaCompra) {
        try {
            double precio = servidorReserva.cotizar(formatoFecha.parse(inicio), formatoFecha.parse(fin), formatoFecha.parse(fechaCompra));
            String respuesta = bancoCliente.realizarPago(idCliente, precio);
            if (respuesta.equals("exito:si")) {
                System.out.println("Compra exitosa");
            } else {
                System.out.println("Compra fallida");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        BancoCliente bancoCliente = new BancoCliente();
        Cliente cliente = new Cliente("http://localhost/ServidorReserva", bancoCliente);
        cliente.reservar("02-12-23", "06-12-23", 1, "03-12-23");
    }
}
