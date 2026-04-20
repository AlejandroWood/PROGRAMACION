package UNIDAD2;

import java.util.Scanner;

public class Tragaperras {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int rodillo1 = 0;
        int rodillo2 = 0;
        int rodillo3 = 0;
        int totalMonedas = 100;
        int monedas = 0;
        String respuesta = "";

        System.out.println("Beinvenido/a a la máquina tragaperras.");
        System.out.print("Quiere jugar?: ");
        respuesta = teclado.next();

        while (respuesta.equalsIgnoreCase("si") && totalMonedas > 4) {
            System.out.println();
            monedas = 0;
            totalMonedas = totalMonedas - 5;

            rodillo1 = (int)(Math.random()*7) + 1;
            rodillo2 = (int)(Math.random()*7) + 1;
            rodillo3 = (int)(Math.random()*7) + 1;

            System.out.println(rodillo1 + " | " + rodillo2 + " | " + rodillo3);

            if (rodillo1 == rodillo2 && rodillo1 == rodillo3) {
                monedas = rodillo1 * 10;
                totalMonedas = totalMonedas + monedas;
                System.out.println("Ha ganado " + monedas + " monedas, tiene un total de " + totalMonedas + " monedas.");
            } else if (rodillo1 == rodillo2) {
                monedas = rodillo1 * 2;
                totalMonedas = totalMonedas + monedas;
                System.out.println("Ha ganado " + monedas + " monedas, tiene un total de " + totalMonedas + " monedas.");
            } else if (rodillo1 == rodillo3) {
                monedas = monedas + (rodillo1 * 2);
                totalMonedas = totalMonedas + monedas;
                System.out.println("Ha ganado " + monedas + " monedas, tiene un total de " + totalMonedas + " monedas.");
            } else if (rodillo2 == rodillo3) {
                monedas = rodillo2 * 2;
                totalMonedas = totalMonedas + monedas;
                System.out.println("Ha ganado " + monedas + " monedas, tiene un total de " + totalMonedas + " monedas.");
            } else {
                System.out.println("Ha perdido, tiene un total de " + totalMonedas + " monedas.");
            }

            if (totalMonedas > 4) {
                System.out.print("Quiere seguir jugando?: ");
                respuesta = teclado.next();
            } else {
                System.out.println("No tiene suficiente monedas para seguir jugando.");
            }
        }

        teclado.close();
    }
}
