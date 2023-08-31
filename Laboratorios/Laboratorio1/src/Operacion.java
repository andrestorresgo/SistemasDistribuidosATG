public class Operacion {
    public static int analizar(String cadena) {
        String[] numeros = cadena.split("-");
        String operacion = numeros[0];
        int a = Integer.parseInt(numeros[1]);
        int b = Integer.parseInt(numeros[2]);
        int c = Integer.parseInt(numeros[3]);

        if (operacion.equals("mayor")) {
            return Math.max(Math.max(a, b), c);
        } else if (operacion.equals("menor")) {
            return Math.min(Math.min(a, b), c);
        } else {
            throw new IllegalArgumentException("Operación no válida");
        }
    }
}
