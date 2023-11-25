import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BancoCentral {
    private static final int PORT = 1234;

    public static double obtenerCotizacionDolar(String fecha) {
        double cotizacion = -1;

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nombre_base_de_datos", "usuario", "contraseña")) {
            PreparedStatement statement = connection.prepareStatement("SELECT cotizacion FROM cotizaciones WHERE fecha = ?");
            statement.setString(1, fecha.toString());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                cotizacion = resultSet.getDouble("cotizacion");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return cotizacion;
    }

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            byte[] buffer = new byte[256];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String fecha = new String(packet.getData(), 0, packet.getLength());
                double cotizacion = obtenerCotizacionDolar(fecha);

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