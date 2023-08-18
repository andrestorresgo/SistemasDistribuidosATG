import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteFibonacci {
    public static void main(String[] args) {
        int port = 5003;
        var sc = new Scanner(System.in);
        String host = "localhost";
        Socket client;
        PrintStream toServer;
        BufferedReader fromServer;
        try {
            client = new Socket(host, port);
            System.out.println("Cliente conectado");
            do {
                toServer = new PrintStream(client.getOutputStream());
                System.out.println("Introduzca un número: ");
                int n = sc.nextInt();
                toServer.println(n);
                fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
                System.out.println(fromServer.readLine());
            } while (true);
            }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
