package UNIDAD1;

import java.util.Scanner;

public class PRACTICAR {
    public static void main(String[] args) {
        int num = 0;
        
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce tu nota: ");
        num = teclado.nextInt();

        if (num >= 5 && num <= 10) {
            if (num >= 9) {
                System.out.println("Tu resultado es sobresaliente");
            } else if (num >= 7) {
                System.out.println("Tu resultado es notable");
            } else {
                System.out.println("Tu resultado es aprobado");
            }
        }
        else {
            System.out.println("Tu resultado es suspenso");
        }

        teclado.close();
    }
}
