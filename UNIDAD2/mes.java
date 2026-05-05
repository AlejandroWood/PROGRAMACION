package UNIDAD2;

import java.util.Scanner;

public class mes {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int mesInt = 0;
        String mesString = "";

        do {
            System.out.print("Introduce un mes (1 - 12): ");
            mesInt = teclado.nextInt();
        } while (mesInt < 1 || mesInt > 12);

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

        System.out.println("Ha seleccionado " + mesString);
        
        teclado.close();
    }
}
