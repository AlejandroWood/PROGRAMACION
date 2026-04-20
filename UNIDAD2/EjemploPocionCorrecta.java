package UNIDAD2;

import java.util.Scanner;

public class EjemploPocionCorrecta {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        boolean salvacion = false;

        while (salvacion == false) {
            System.out.println("¿Cuál es el destino final de los humano?");
            System.out.print("(1 = Muerte || 2 = Extinción || 3 = Salvación || 4 = Explosión): ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    salvacion = false;
                    break;
                case 2:
                    salvacion = false;
                    break;
                case 3:
                    salvacion = true;
                    break;
                case 4:
                    salvacion = false;
                    break;
            }
            
            System.out.println();

            if (salvacion) {
                System.out.println("Has salvado nuestro destino!");
            } else {
                System.out.println("Cataclismo Zombie!! Try Again!!");
                System.out.println();
                System.out.println();
            }

        }

        teclado.close();
    }
}
