package UNIDAD2;

import java.util.Scanner;

public class num {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int mayor = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;
        int num = 0;
        int i = 0;
        int contador = 0;

        for (i = 1; i <= 5; i++) {
            System.out.print("Introduce el número " + i + " : ");
            num = teclado.nextInt();

            if (num > mayor) {
                mayor = num;
            }
            
            if (num < menor) {
                menor = num;
            }
        }

        System.out.println("Mayor: " + mayor);
        System.out.println("Menor: " + menor);
        
        for (i = 1; i <= 3; i++) {
            System.out.print("Introduce el número " + i + " : ");
            num = teclado.nextInt();

            if (num % 2 == 0 && num > 10) {
                contador++;
            }
        }

        System.out.println("Cantidad de números pares y mayores que 10: " + contador);

        teclado.close();
    }
}
