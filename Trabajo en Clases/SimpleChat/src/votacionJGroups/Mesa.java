package votacionJGroups;

import org.jgroups.*;

@SuppressWarnings("all")

public class Mesa {
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
                System.out.println("Voto recibido para " + candidato + " en la mesa " + nombreMesa);
            }
        });
        canal.connect(nombreMesa + "Cluster"); // Aquí se establece el identificador del cluster
    }

    public void votar(String candidato) throws Exception {
        Message msg = new Message(null, candidato);
        canal.send(msg);

        // Enviar el resultado al contador
        JChannel contadorCanal = new JChannel();
        contadorCanal.connect("ContadorCluster");
        Message contadorMsg = new Message(null, candidato + "," + votos[getIndex(candidato)]);
        contadorCanal.send(contadorMsg);
    }

    private int getIndex(String candidato) {
        for (int i = 0; i < candidatos.length; i++) {
            if (candidatos[i].equals(candidato)) {
                return i;
            }
        }
        return -1;
    }
}
