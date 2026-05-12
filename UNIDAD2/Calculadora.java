package UNIDAD2;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double x = 0;
        double y = 0;
        int eleccion = 0;
        double solucion = 0;

        System.out.print("Introduzca el primer número: ");
        x = teclado.nextDouble();

        System.out.println();

        System.out.print("Introduzca el segundo número: ");
        y = teclado.nextDouble();

        System.out.println();

        System.out.println(
        "¿Qué operación desear realizar \n" +
        "1. Suma \n" +
        "2. Resta \n" +
        "3. Multiplicación \n" +
        "4. División \n" +
        "5. Resto \n" +
        "6. Raíz Cuadrada \n" +
        "7. Potencia de 2"
        );
        System.out.print("Haga su seleccion: ");
        eleccion = teclado.nextInt();

        System.out.println();

        switch (eleccion) {
            case 1:
                solucion = x + y;
                System.out.println(x + " + " + y + " = " + solucion);
                break;
            
            case 2:
            solucion = x - y;
            System.out.println(x + " - " + y + " = " + solucion);
            break;
            
            case 3:
            solucion = x * y;
            System.out.println(x + " * " + y + " = " + solucion);
            break;
            
            case 4:
            solucion = x / y;
            System.out.println(x + " / " + y + " = " + solucion);
            break;
            
            case 5:
            solucion = x % y;
            System.out.println(x + " % " + y + " = " + solucion);
            break;
            
            case 6:
            solucion = Math.sqrt(x);
            System.out.println("Raíz Cuadrada de " + x + " = " + solucion);
            solucion = Math.sqrt(y);
            System.out.println("Raíz Cuadrada de " + y + " = " + solucion);
            break;
            
            case 7:
            solucion = x * x;
            System.out.println("Potencia 2 de " + x + " = " + solucion);
            solucion = y * y;
            System.out.println("Potencia 2 de " + y + " = " + solucion);
            break;
            
            default:
                System.out.println("Ha introducido una operación indefinida");
                break;
        }
        teclado.close();
    }
}
