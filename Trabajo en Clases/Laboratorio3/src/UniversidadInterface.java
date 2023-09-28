import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UniversidadInterface extends Remote {
    Diploma emitirDiploma(String ci, String nombres, String primerApellido, String segundoApellido, String fechaNacimiento, String carrera) throws RemoteException;
}
