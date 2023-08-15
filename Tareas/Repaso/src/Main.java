import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        while (true) {
            System.out.println("Menu:");
            System.out.println("a. Ingresar n");
            System.out.println("b. Calcular Fibonacci");
            System.out.println("c. Calcular Factorial");
            System.out.println("d. Salir");
            String option = scanner.nextLine();
            switch (option) {
                case "a":
                    System.out.print("Ingresar n: ");
                    n = scanner.nextInt();
                    scanner.nextLine();
                    break;
                case "b":
                    System.out.println(fibonacci(n));
                    break;
                case "c":
                    System.out.println(factorial(n));
                    break;
                case "d":
                    return;
                default:
                    System.out.println("Opcion Invalida");
            }
        }
    }

    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }
}


