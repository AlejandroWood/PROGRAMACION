package UNIDAD2;

import java.util.Scanner;

public class EjemploSieteyMedia {
    public static void main(String[] args) {
        float carta = 0;
        float sumaJugador = 0;
        float sumaBanca = 0;
        String quiereContinuar = "si";
        Scanner teclado = new Scanner(System.in);

        while (quiereContinuar.equalsIgnoreCase("si") && sumaJugador < 7.5f) {
            carta = (int)(Math.random()*10) + 1;

            if (carta > 7) {
            carta = 0.5f;
            }

            sumaJugador = sumaJugador + carta;

            System.out.println("Ha salido un " + carta + " en total llevas " + sumaJugador);

            if (sumaJugador > 7.5f) {
                System.out.println("Te has pasao bacalao, me quedo con tu pasta");
            } else {
                System.out.print("Quieres seguir jugando (Si/No): ");
                quiereContinuar = teclado.next();
            }
        }
        
        if (sumaJugador <= 7.5f) {
            while (sumaBanca < 5 && sumaBanca < 7.5f) {
                carta = (int)(Math.random()*10) + 1;

                if (carta > 7) {
                carta = 0.5f;
                }

                sumaBanca = sumaBanca + carta;

                System.out.println("Ha salido un " + carta + " en total la banca lleva " + sumaBanca);

            }
        }
        if (sumaBanca >= 7.5f) {
            System.out.println("La Banca ha perdido, espera a final de mes para cobrar");
        } else {
            if (sumaJugador <= 7.5f) {
                if (sumaJugador > sumaBanca) {
                    System.out.println("Ha ganado el jugador!!");
                    if (sumaJugador == 7.5f) {
                        System.out.println("Feliciades por sacar 7.5 te pagamos el doble");
                    }
                } else {
                    System.out.println("Ha ganao la banca");
                }
            }
        }

        teclado.close();
    }
}
