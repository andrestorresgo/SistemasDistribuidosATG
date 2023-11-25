import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class BancoCliente {
    private static final int PORT = 1234;
    private Map<Integer, Double> saldos;

    public BancoCliente() {
        saldos = new HashMap<>();
        saldos.put(1, 455.0);
        saldos.put(2, 300.0);
        saldos.put(3, 1500.0);
    }

    public String realizarPago(int idCliente, double monto) {
        Double saldo = saldos.get(idCliente);
        if (saldo != null && saldo >= monto) {
            saldos.put(idCliente, saldo - monto);
            return "exito:si";
        } else {
            return "exito:no";
        }
    }

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            BancoCliente bancoCliente = new BancoCliente();

            while (true) {
                Socket socket = serverSocket.accept();
                try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                    String[] request = in.readLine().split(":");
                    int idCliente = Integer.parseInt(request[0]);
                    double monto = Double.parseDouble(request[1]);

                    String respuesta = bancoCliente.realizarPago(idCliente, monto);
                    out.println(respuesta);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}