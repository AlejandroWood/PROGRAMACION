package UNIDAD2;

import java.util.Scanner;

public class precio {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        double precioBase = 12.0;

        System.out.print("Edad: ");
        int edad = teclado.nextInt();

        System.out.print("¿Es estudiante con carnet? (true/false): ");
        boolean esEstudiante = teclado.nextBoolean();

        System.out.print("¿Es festivo? (true/false): ");
        boolean esFestivo = teclado.nextBoolean();

        System.out.print("Día de la semana (lunes/martes/miércoles/jueves/viernes/sábado/domingo): ");
        String diaSemana = teclado.next().toLowerCase();

        System.out.print("Número de entradas: ");
        int numEntradas = teclado.nextInt();

        System.out.print("¿Tiene discapacidad acreditada? (true/false): ");
        boolean tieneDiscapacidad = teclado.nextBoolean();


        if (tieneDiscapacidad) {
            System.out.println("Entrada gratuita por discapacidad.");
            System.out.println("Total: 0,00 euros");
        } else if (esFestivo) {
            double total = precioBase * numEntradas;
            System.out.println("Día festivo, no hay descuento aplicable.");
            System.out.println("Total: " + total);
        } else {
            double descuentoPrincipal = 0.0;

            if (diaSemana == "miércoles" && edad < 25) {
                descuentoPrincipal = descuentoPrincipal + 0.20;
            }

            if (edad > 60 || esEstudiante) {
                descuentoPrincipal = descuentoPrincipal + 0.15;
            }

            if (numEntradas >= 2 && (diaSemana == "sábado" || diaSemana == "domingo")) {
                precioBase = precioBase * 0.10;
            }
        double precioConDescuento = precioBase * descuentoPrincipal;

        double totalFinal = precioConDescuento * numEntradas;
        totalFinal = precioBase - totalFinal;

        System.out.println("Total a pagar: " + totalFinal + " euros.");
        }

        teclado.close();
    }
}
