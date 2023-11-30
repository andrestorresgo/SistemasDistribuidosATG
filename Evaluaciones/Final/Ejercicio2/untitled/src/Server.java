import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Servidor iniciado, esperando al cliente...");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Cliente conectado");
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        List<Integer> numbers = new ArrayList<>();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            if (inputLine.equals("resultado")) {
                out.println(Collections.max(numbers));
            } else {
                String[] parts = inputLine.split(":");
                int number = Integer.parseInt(parts[0]);
                String letter = parts[1];
                if (letter.equals("a") || letter.equals("b") || letter.equals("c")) {
                    numbers.add(number);
                    out.println("ok");
                }
            }
        }
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}
