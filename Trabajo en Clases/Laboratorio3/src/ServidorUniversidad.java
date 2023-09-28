import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServidorUniversidad implements UniversidadInterface {
    public Diploma emitirDiploma(String ci, String nombres, String primerApellido, String segundoApellido, String fechaNacimiento, String carrera) {
        // Implementa la lógica para emitir el diploma
    }

    public static void main(String args[]) {
        try {
            ServidorUniversidad obj = new ServidorUniversidad();
            UniversidadInterface stub = (UniversidadInterface) UnicastRemoteObject.exportObject(obj, 0);

            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Universidad", stub);

            System.err.println("Servidor listo");
        } catch (Exception e) {
            System.err.println("Servidor exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
