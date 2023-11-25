import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ServidorReservaImpl extends UnicastRemoteObject implements ServidorReserva {
    private BancoCentral bancoCentral;
    private Map<Date, Reserva> reservas;

    protected ServidorReservaImpl(BancoCentral bancoCentral) throws RemoteException {
        this.bancoCentral = bancoCentral;
        this.reservas = new HashMap<>();
    }

    @Override
    public double cotizar(Date inicio, Date fin, Date fechaCotizacion) throws RemoteException {
        double precioEnDolares = calcularPrecioEnDolares(inicio, fin);
        double cotizacionDolar = bancoCentral.obtenerCotizacionDolar(String.valueOf(fechaCotizacion));
        return precioEnDolares * cotizacionDolar;
    }

    @Override
    public boolean reservar(Date inicio, Date fin, int idCliente) throws RemoteException {
        // Comprueba si las fechas ya están reservadas
        for (Date date = inicio; date.before(fin) || date.equals(fin); date = new Date(date.getTime() + (1000 * 60 * 60 * 24))) {
            if (reservas.containsKey(date)) {
                return false;
            }
        }

        // Si las fechas no están reservadas, crea una nueva reserva y la añade al mapa
        Reserva reserva = new Reserva(inicio, fin, idCliente);
        for (Date date = inicio; date.before(fin) || date.equals(fin); date = new Date(date.getTime() + (1000 * 60 * 60 * 24))) {
            reservas.put(date, reserva);
        }

        return true;
    }

    private double calcularPrecioEnDolares(Date inicio, Date fin) {
        // Aquí iría la lógica para calcular el precio en dólares basado en las fechas
        return 0;
    }

    public static void main(String[] args) {
        try {
            BancoCentral bancoCentral = new BancoCentral(); // Aquí deberías inicializar tu objeto BancoCentral
            ServidorReservaImpl obj = new ServidorReservaImpl(bancoCentral);
            Naming.rebind("http://localhost/ServidorReserva", obj);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}