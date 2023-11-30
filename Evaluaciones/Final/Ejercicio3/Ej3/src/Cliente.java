import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
    private Cliente() {}

    public static void main(String[] args) {
        String host = "localhost";
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            InterfazRemota stub = (InterfazRemota) registry.lookup("InterfazRemota");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. Introducir valor");
                System.out.println("2. Invertir");
                System.out.println("3. Aumentar espacios");
                System.out.println("4. Aumentar");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.print("Introduce una cadena: ");
                        String cadena = scanner.next();
                        stub.introducirValor(cadena);
                        break;
                    case 2:
                        System.out.println("Cadena invertida: " + stub.invertir());
                        break;
                    case 3:
                        System.out.println("Cadena con espacios aumentados: " + stub.aumentarEspacios(3));
                        break;
                    case 4:
                        System.out.print("Introduce una cadena para aumentar: ");
                        String cadenaAumentar = scanner.next();
                        System.out.println("Cadena aumentada: " + stub.aumentar(cadenaAumentar));
                        break;
                    case 5:
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            System.err.println("Excepción del cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}
