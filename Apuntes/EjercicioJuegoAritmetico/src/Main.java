import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        int port = 5003;
        ServerSocket server;
        PreguntasRespuestas preguntasRespuestas = new PreguntasRespuestas();
        try {
            while (true) {
                server = new ServerSocket(port);
                System.out.println("Server iniciado");
                Socket client;
                PrintStream toClient;
                client = server.accept();
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                System.out.println("Cliente conectado");
                String cadena = fromClient.readLine();
                toClient = new PrintStream(client.getOutputStream());

                if (cadena.equals("iniciar")) {
                    preguntasRespuestas.iniciar();
                    toClient.println("Juego iniciado");
                } else if (cadena.equals("pregunta")) {
                    toClient.println(preguntasRespuestas.getPregunta(Integer.parseInt(fromClient.readLine())));
                } else if (cadena.equals("respuesta")) {
                    toClient.println(preguntasRespuestas.verificarRespuesta(Integer.parseInt(fromClient.readLine()), Double.parseDouble(fromClient.readLine())));
                } else if (cadena.equals("respuestaCorrecta")) {
                    toClient.println(preguntasRespuestas.getRespuesta(Integer.parseInt(fromClient.readLine())));
                } else if (cadena.equals("respuestasCorrectas")) {
                    toClient.println(preguntasRespuestas.getRespuestasCorrectas());
                } else if (cadena.equals("salir")) {
                    toClient.println("Saliendo");
                    server.close();
                    break;
                } else {
                    toClient.println("Comando no reconocido");
                }
            }
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}