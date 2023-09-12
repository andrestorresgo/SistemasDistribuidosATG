package votacionJGroups;

import org.jgroups.*;

@SuppressWarnings("all")

public class Contador {
    private JChannel canal;
    private final String[] candidatos = {"Juan", "Pedro", "Maria"};
    private final int[] votos = new int[candidatos.length];

    public void iniciar() throws Exception {
        canal = new JChannel();
        canal.setReceiver(new ReceiverAdapter() {
            @Override
            public void receive(Message msg) {
                String voto = msg.getObject();
                String candidato = voto.substring(0, voto.indexOf(","));
                int cantidad = Integer.parseInt(voto.substring(voto.indexOf(",") + 1));
                for (int i = 0; i < candidatos.length; i++) {
                    if (candidatos[i].equals(candidato)) {
                        votos[i] += cantidad;
                        break;
                    }
                }
                System.out.println("Voto recibido. Total de votos: " + getVotos());
            }
        });
        canal.connect("ContadorCluster");
    }

    private String getVotos() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < candidatos.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(candidatos[i]).append(": ").append(votos[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        Contador contador = new Contador();
        contador.iniciar();
    }
}
