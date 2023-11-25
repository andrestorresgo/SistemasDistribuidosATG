import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BancoCliente {
    private static final String HOST = "localhost";
    private static final int PORT = 1234;

    public String realizarPago(int idCliente, double monto) {
        try (Socket socket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println(idCliente + ":" + monto);
            return in.readLine();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return "exito:no";
        }
    }

    private double obtenerSaldo(int idCliente) {
        double saldo = -1;

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nombre_base_de_datos", "usuario", "contraseña")) {
            PreparedStatement statement = connection.prepareStatement("SELECT saldo FROM saldos WHERE idcliente = ?");
            statement.setInt(1, idCliente);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                saldo = resultSet.getDouble("saldo");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return saldo;
    }
}