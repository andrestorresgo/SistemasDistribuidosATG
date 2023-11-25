import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class BancoCentral {
    private static final int PORT = 1234;
    private Map<String, Double> cotizaciones;
    private SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yy");

    public BancoCentral() {
        cotizaciones = new HashMap<>();
        cotizaciones.put("02-12-23", 6.90);
        cotizaciones.put("03-12-23", 6.91);
        cotizaciones.put("04-12-23", 6.93);
        cotizaciones.put("05-12-23", 6.92);
        cotizaciones.put("06-11-23", 6.96);
    }

    public double obtenerCotizacionDolar(String fecha) {
        return cotizaciones.getOrDefault(formatoFecha.format(fecha), -1.0);
    }

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            BancoCentral bancoCentral = new BancoCentral();
            byte[] buffer = new byte[256];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String fecha = new String(packet.getData(), 0, packet.getLength());
                double cotizacion = bancoCentral.obtenerCotizacionDolar(fecha);

                String respuesta = cotizacion != -1 ? "exito:" + cotizacion : "error:no se encontro la cotizacion";
                byte[] respuestaBytes = respuesta.getBytes();

                DatagramPacket respuestaPacket = new DatagramPacket(respuestaBytes, respuestaBytes.length, packet.getAddress(), packet.getPort());
                socket.send(respuestaPacket);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}