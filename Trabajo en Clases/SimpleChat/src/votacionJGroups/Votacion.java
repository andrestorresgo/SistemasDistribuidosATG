package votacionJGroups;

import org.jgroups.*;

@SuppressWarnings("all")

public class Votacion {
    private JChannel canal;
    private final String[] candidatos = {"Juan", "Pedro", "Maria"};
    private final int[] votos = new int[candidatos.length];

    public void iniciar(String nombreMesa) throws Exception {
        canal = new JChannel();
        canal.setReceiver(new ReceiverAdapter() {
            @Override
            public void receive(Message msg) {
                String candidato = msg.getObject();
                for (int i = 0; i < candidatos.length; i++) {
                    if (candidatos[i].equals(candidato)) {
                        votos[i]++;
                        break;
                    }
                }
                System.out.println("Voto recibido para " + candidato + " en la mesa " + nombreMesa + ". Total de votos: " + getVotos());
            }
        });
        canal.connect(nombreMesa);
    }

    public void votar(String candidato) throws Exception {
        Message msg = new Message(null, candidato);
        canal.send(msg);
    }

    private String getVotos() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < candidatos.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(candidatos[i]).append(": ").append(votos[i]);
        }
        return sb.toString();
    }
}
