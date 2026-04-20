package UNIDAD2;

import java.util.Scanner;

public class EjemploCuadrado {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int alto = 0;
        int ancho = 0;
        int i = 0;
        int j = 0;

        System.out.print("Introduzca el ancho: ");
        ancho = teclado.nextInt();
        System.out.print("Introduzca la altura: ");
        alto = teclado.nextInt();

        for (i = 0; i < alto; i++) {
            for (j = 0; j < ancho; j++) {
                if (i == 0 || (i + 1) == alto || j == 0 || (j + 1) == ancho) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        teclado.close();
    }
}
