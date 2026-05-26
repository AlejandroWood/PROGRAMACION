package UNIDAD2;

import java.util.Scanner;

public class ConversorMonedas {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double moneda = 0;
        double monedaConvertida = 0;
        int respuesta1 = 0;
        int respuesta2 = 0;

        do {
            System.out.println("Introduzca la moneda origen");
            System.out.print("(EURO = 1 | DOLAR = 2 | YEN = 3): ");
            respuesta1 = teclado.nextInt();
        } while (respuesta1 < 1 | respuesta1 > 3);

        System.out.println();

        do {
            if (respuesta1 == 1) {
                System.out.print("Introduzca la cántidad de euros que desea convertir: ");
            } else if (respuesta1 == 2) {
                System.out.print("Introduzca la cántidad de dolares que desea convertir: ");
            }else {
                System.out.print("Introduzca la cántidad de yenes que desea convertir: ");
            }
            moneda = teclado.nextDouble();
        } while (moneda <= 0);

        System.out.println();

        do {
            System.out.println("Introduzca la moneda destino");
            System.out.print("(EURO = 1 | DOLAR = 2 | YEN = 3): ");
            respuesta2 = teclado.nextInt();
        } while (respuesta2 < 1 | respuesta2 > 3);

        System.out.println();

        if (respuesta1 == respuesta2) {
            System.out.println("La moneda se ha quedado en " + moneda + " al ser el origen el mismo que el destino.");
        } else if (respuesta1 == 1 && respuesta2 == 2) {
            monedaConvertida = moneda * 1.16;
            System.out.println(moneda + " euros son " + monedaConvertida + " dolares.");
        } else if (respuesta1 == 1 && respuesta2 == 3) {
            monedaConvertida = moneda * 185;
            System.out.println(moneda + " euros son " + monedaConvertida + " yenes.");
        } else if (respuesta1 == 2 && respuesta2 == 1) {
            monedaConvertida = moneda / 1.16;
            System.out.println(moneda + " dolares son " + monedaConvertida + " euros.");
        } else if (respuesta1 == 2 && respuesta2 == 3) {
            monedaConvertida = moneda * 159;
            System.out.println(moneda + " dolares son " + monedaConvertida + " yenes.");
        } else if (respuesta1 == 3 && respuesta2 == 1) {
            monedaConvertida = moneda / 185;
            System.out.println(moneda + " yenes son " + monedaConvertida + " euros.");
        } else if (respuesta1 == 3 && respuesta2 == 2) {
            monedaConvertida = moneda / 159;
            System.out.println(moneda + " yenes son " + monedaConvertida + " dolares.");
        }

        teclado.close();
    }
}
