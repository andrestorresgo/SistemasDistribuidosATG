import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorBCP {
    public static void main(String[] args) {
        Cuenta cuenta1 = new Cuenta(Banco.BCP, "657654", "11021654", "Juan Perez", "Segovia", 100.0);
        int port = 5002;
        ServerSocket server;
        try {
            server = new ServerSocket(port);
            System.out.println("Se inicio el servidor con éxito");
            Socket client;
            PrintStream toClient;
            client = server.accept(); //conexion
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
            System.out.println("Cliente se conecto");
            System.out.println(fromClient.readLine());
            toClient = new PrintStream(client.getOutputStream());
            String[] comando = fromClient.readLine().split(":");
            String Orden = comando[1];
            if (Orden.equals("Buscar")){
                String c = comando[2];
                if (c.equals("11021654-Juan Perez-Segovia")){
                    toClient.println("SI");
                } else {
                    toClient.println("NO");
                }
            } else {
                //TODO logica de Congelar
                int monto = 0;
                cuenta1.setSaldo(cuenta1.getSaldo() - monto);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
