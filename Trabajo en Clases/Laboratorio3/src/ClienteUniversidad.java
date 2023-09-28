import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClienteUniversidad {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            UniversidadInterface stub = (UniversidadInterface) registry.lookup("Universidad");
            Diploma diploma = stub.emitirDiploma(ci, nombres, primerApellido, segundoApellido, fechaNacimiento, carrera);
            System.out.println(diploma);
        } catch (Exception e) {
            System.err.println("ClienteUniversidad exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
