import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ASFI extends UnicastRemoteObject implements IASFI {
    public ASFI() throws RemoteException{
        super();
    }

    @Override
    public ArrayList<Cuenta> ListaCuentas(String ci, String nombres, String apellidos) throws RemoteException {

        // llamada a Mercantil UDP
        int puerto =  6789;

        try {
            String comando = "Buscar:" + ci + "-" + nombres + "-" + apellidos;
            String ip = "localhost";
            DatagramSocket socketUDP = new DatagramSocket();
            byte[] mensaje = comando.getBytes();
            InetAddress hostServidor = InetAddress.getByName(ip);

            // Construimos un datagrama para enviar el mensaje al servidor
            DatagramPacket peticion
                    = new DatagramPacket(mensaje, comando.length(), hostServidor,
                    puerto);

            // Enviamos el datagrama
            socketUDP.send(peticion);

            // Construimos el DatagramPacket que contendrá la respuesta
            byte[] buffer = new byte[1000];
            DatagramPacket respuesta
                    = new DatagramPacket(buffer, buffer.length);
            socketUDP.receive(respuesta);

            // Enviamos la respuesta del servidor a la salida estandar
            String repuestaMercantil = new String(respuesta.getData());
            
            socketUDP.close();

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }

        //Llamar a BCP

        int port = 5002;

        try {
            Socket client = new Socket("localhost", port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            toServer.println("Buscar:" + ci + "-" + nombres + "-" + apellidos);
            String result = fromServer.readLine();
            System.out.println("cadena devuelta es: " + result);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
         return null;
    }

    @Override
    public Boolean RetenerMonto(Cuenta cuenta, Double monto) throws RemoteException {
        // llamada a Mercantil UDP
        int puerto =  6789;

        try {
            String comando = "Congelar:" + cuenta + "-" + monto;
            String ip = "localhost";
            DatagramSocket socketUDP = new DatagramSocket();
            byte[] mensaje = comando.getBytes();
            InetAddress hostServidor = InetAddress.getByName(ip);

            // Construimos un datagrama para enviar el mensaje al servidor
            DatagramPacket peticion
                    = new DatagramPacket(mensaje, comando.length(), hostServidor,
                    puerto);

            // Enviamos el datagrama
            socketUDP.send(peticion);

            // Construimos el DatagramPacket que contendrá la respuesta
            byte[] buffer = new byte[1000];
            DatagramPacket respuesta
                    = new DatagramPacket(buffer, buffer.length);
            socketUDP.receive(respuesta);

            // Enviamos la respuesta del servidor a la salida estandar
            String repuestaMercantil = new String(respuesta.getData());

            socketUDP.close();

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }

        //Llamar a BCP

        int port = 5002;

        try {
            Socket client = new Socket("localhost", port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            toServer.println("Congelar" + ":" + cuenta + "-" + monto);
            String result = fromServer.readLine();
            System.out.println("cadena devuelta es: " + result);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

}
