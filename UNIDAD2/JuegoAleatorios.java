package UNIDAD2;

public class JuegoAleatorios {
    public static void main(String[] args) {
        int num1Jugador1 = (int) (Math.random() * 9 + 1);
        int num2Jugador1 = (int) (Math.random() * 9 + 1);
        int num3Jugador1 = (int) (Math.random() * 9 + 1);

        int totalJugador1 = 0;
        boolean trioJugador1 = false;
        boolean parejaJugador1 = false;

        int num1Jugador2 = (int) (Math.random() * 9 + 1);
        int num2Jugador2 = (int) (Math.random() * 9 + 1);
        int num3Jugador2 = (int) (Math.random() * 9 + 1);

        int totalJugador2 = 0;
        boolean trioJugador2 = false;
        boolean parejaJugador2 = false;

        System.out.println("Jugador 1: " + num1Jugador1 + "" + num2Jugador1 + "" + num3Jugador1);
        System.out.println("Jugador 2: " + num1Jugador2 + "" + num2Jugador2 + "" + num3Jugador2);

        // Comprueba si hay números que coinciden para el Jugador 1
        if (num1Jugador1 == num2Jugador1 && num1Jugador1 == num3Jugador1) {
            trioJugador1 = true;
        } else if (num1Jugador1 == num2Jugador1 || num1Jugador1 == num3Jugador1 || num2Jugador1 == num3Jugador1) {
            parejaJugador1 = true;
            if (num1Jugador1 == num2Jugador1) {
                totalJugador1 = num1Jugador1;
            } else if (num1Jugador1 == num3Jugador1) {
                totalJugador1 = num1Jugador1;
            } else {
                totalJugador1 = num2Jugador1;
            }
        } else {
            totalJugador1 = num1Jugador1 + num2Jugador1 + num3Jugador1;
        }

        // Comprueba si hay números que coinciden para el Jugador 2
        if (num1Jugador2 == num2Jugador2 && num1Jugador2 == num3Jugador2) {
            trioJugador2 = true;
        } else if (num1Jugador2 == num2Jugador2 || num1Jugador2 == num3Jugador2 || num2Jugador2 == num3Jugador2) {
            parejaJugador2 = true;
            if (num1Jugador2 == num2Jugador2) {
                totalJugador2 = num1Jugador2;
            } else if (num1Jugador2 == num3Jugador2) {
                totalJugador2 = num1Jugador2;
            } else {
                totalJugador2 = num2Jugador2;
            }
        } else {
            totalJugador2 = num1Jugador2 + num2Jugador2 + num3Jugador2;
        }

        // Mira que jugador es el que ha ganado o si hay un empate técnico
        if (trioJugador1 && trioJugador2) {
            if (num1Jugador1 == num1Jugador2) {
                System.out.println("Empate técnico");
            } else if (num1Jugador1 > num1Jugador2) {
                System.out.println("Ha ganado el Jugador 1");
            } else {
                System.out.println("Ha ganado el Jugador 2");
            }
        } else if (trioJugador1) {
            System.out.println("Ha ganado el Jugador 1");
        } else if (trioJugador2) {
            System.out.println("Ha ganado el Jugador 2");
        } else if (parejaJugador1 && parejaJugador2) {
            if (totalJugador1 == totalJugador2) {
                System.out.println("Empate técnico");
            } else if (totalJugador1 > totalJugador2) {
                System.out.println("Ha ganado el Jugador 1");
            } else {
                System.out.println("Ha ganado el Jugador 2");
            }
        } else if (parejaJugador1) {
            System.out.println("Ha ganado el Jugador 1");
        } else if (parejaJugador2) {
            System.out.println("Ha ganado el Jugador 2");
        } else if (totalJugador1 == totalJugador2) {
            System.out.println("Empate técnico");
        } else if (totalJugador1 > totalJugador2) {
            System.out.println("Ha ganado el Jugador 1");
        } else {
            System.out.println("Ha ganado el Jugador 2");
        }
    }
}
