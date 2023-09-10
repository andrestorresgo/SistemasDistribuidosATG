import java.io.Serializable;

public class Empresa implements Serializable {
    private String nombre;
    private Long NIT;

    public Empresa(String nombre, Long NIT) {
        this.nombre = nombre;
        this.NIT = NIT;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getNIT() {
        return NIT;
    }

    public void setNIT(Long NIT) {
        this.NIT = NIT;
    }



}