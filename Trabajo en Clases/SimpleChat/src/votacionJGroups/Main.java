package votacionJGroups;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import org.jgroups.util.Util;

import java.io.*;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

@SuppressWarnings("all")

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el nombre de la mesa:");
        String nombreMesa = scanner.nextLine();

        Mesa mesa = new Mesa();
        mesa.iniciar(nombreMesa);

        while (true) {
            System.out.println("Introduce el nombre del candidato para votar (o 'salir' para terminar):");
            String candidato = scanner.nextLine();

            if ("salir".equalsIgnoreCase(candidato)) {
                break;
            }

            mesa.votar(candidato);
        }

        scanner.close();
    }
}
