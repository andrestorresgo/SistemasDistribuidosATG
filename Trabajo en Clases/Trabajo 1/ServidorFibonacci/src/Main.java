import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        int port = 5003;
        ServerSocket server;
        try {
            server = new ServerSocket(port);
            System.out.println("Server iniciado");
            Socket client;
            PrintStream toClient;
            client = server.accept();
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println("Cliente conectado");
            String cadena = fromClient.readLine();
            int n = Integer.parseInt(cadena);
            int f = Operacion.fibonacci(n);
            toClient = new PrintStream(client.getOutputStream());
            toClient.println(f);
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}