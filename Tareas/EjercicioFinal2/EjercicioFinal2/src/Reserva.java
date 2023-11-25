import java.util.Date;

public class Reserva {
    private Date inicio;
    private Date fin;
    private int idCliente;

    public Reserva(Date inicio, Date fin, int idCliente) {
        this.inicio = inicio;
        this.fin = fin;
        this.idCliente = idCliente;
    }

    // Aquí podrías añadir getters y setters para los campos si los necesitas
}