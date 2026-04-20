package UNIDAD2;

import java.util.Scanner;

public class EjemploSwitch {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        int codPostal = 0;
        String comunidad = "";

        System.out.println("Introduce los dos primeros dígitos del código postal de tu ciudad y te digo la comunidad autonoma");
        //Leemos el código postal
        codPostal = teclado.nextInt();

        switch (codPostal) {
            case 8:
                comunidad = "Barcelona";
                break;
            case 28:
                comunidad = "Madrid";
                break;
            case 51:
                comunidad = "Ceuta";
                break;
            case 52:
                comunidad = "Melilla";
                break;
            case 1:
                comunidad = "Alava";
                break;
            case 50:
                comunidad = "Zaragoza";
                break;
            case 11:
                comunidad = "Cadiz";
                break;
            default:
                comunidad = "ninguna parte";
                break;
        }

        System.out.println("Eres de " + comunidad);

        int diaSemana = (int)(Math.random() * 7) + 1;
        String dia = "";
        boolean finde = false;

        switch (diaSemana) {
            case 1:
                dia = "Lunes";
                break;
            case 2:
                dia = "Martes";
                break;
            case 3:
                dia = "Miércoles";
                break;
            case 4:
                dia = "Jueves";
                break;
            case 5:
                dia = "Viernes";
                break;
            case 6:
                dia = "Sábado";
                finde = true;
                break;
            case 7:
                dia = "Domingo";
                finde = true;
                break;
        }

        System.out.println("Hoy es " + dia + ".");
        if (finde) {
            System.out.println("Es fin de semana.");
        }
        teclado.close();
    }
}
