package UNIDAD2;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

public class mes {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int mesInt = 0;
        LocalDate fechaActual = LocalDate.now();
        int mesActual = fechaActual.getMonthValue();
        int anio = YearMonth.now().getYear();
        String mesString = "";

        do {
            System.out.print("Introduce un mes (1 - 12): ");
            mesInt = teclado.nextInt();
        } while (mesInt < 1 || mesInt > 12);

        YearMonth yearMonth = YearMonth.of(anio, mesInt);
        int dias = yearMonth.lengthOfMonth();

        switch (mesInt) {
            case 1:
                mesString = "Enero";
                break;
            case 2:
                mesString = "Febrero";
                break;
            case 3:
                mesString = "Marzo";
                break;
            case 4:
                mesString = "Abril";
                break;
            case 5:
                mesString = "Mayo";
                break;
            case 6:
                mesString = "Junio";
                break;
            case 7:
                mesString = "Julio";
                break;
            case 8:
                mesString = "Agosto";
                break;
            case 9:
                mesString = "Septiembre";
                break;
            case 10:
                mesString = "Octubre";
                break;
            case 11:
                mesString = "Noviembre";
                break;
            case 12:
                mesString = "Diciembre";
                break;
        }

        if (mesActual == mesInt) {
            System.out.println("¡Estamos en " + mesString + "!");
        } else if (mesActual > mesInt) {
            System.out.println(mesString + " fue hace " + (mesActual - mesInt) + " meses.");
        } else {
            System.out.println("Faltan " + (mesInt - mesActual) + " meses para " + mesString);
        }
        
        System.out.println(mesString + " tiene " + dias + " días.");
        
        teclado.close();
    }
}
