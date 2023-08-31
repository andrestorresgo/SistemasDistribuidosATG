public class Operacion {
    public static int analizar(String cadena) {
        String[] partes = cadena.split("-");
        String operacion = partes[0];
        int a = Integer.parseInt(partes[1]);
        int b = Integer.parseInt(partes[2]);
        int c = Integer.parseInt(partes[3]);

        if (operacion.equals("mayor")) {
            return Math.max(Math.max(a, b), c);
        } else if (operacion.equals("menor")) {
            return Math.min(Math.min(a, b), c);
        } else {
            throw new IllegalArgumentException("Operación no válida");
        }
    }
}
