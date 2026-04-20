package UNIDAD2;

import java.util.Scanner;

public class EjemploTriangulo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int baseTriangulo = 0;
        int i = 0;
        int j = 0;

        System.out.print("Introduca la base de su triangulo: ");
        baseTriangulo = teclado.nextInt();

        i = 0;
        j = 0;
        int Espacio = 0;
        int EspacioResta = 0;
        int otroLado = 1;


        for (i = 0; i < baseTriangulo; i++) {
            EspacioResta = 0;
            Espacio++;
            j = Espacio;
            otroLado = Espacio;
            while (EspacioResta < (Espacio - 1)) {
                System.out.print(" ");
                EspacioResta++;
            }
            while ((baseTriangulo + 1) > j) {
                System.out.print("*");
                j++;
            }
            while (baseTriangulo > otroLado) {
                System.out.print("*");
                otroLado++;
            }

            System.out.println();
        }

        for (i = 0; i < baseTriangulo; i++) {
            for (j = 0; j < (i + 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        i = 0;
        j = 0;

        for (i = 0; i < baseTriangulo; i++) {
            for (j = baseTriangulo; j > i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }

        i = 0;
        j = 0;
        Espacio = 0;
        EspacioResta = 0;
        otroLado = 0;

        for (i = 0; i < baseTriangulo; i++) {
            EspacioResta = baseTriangulo - (j + 1);
            for (Espacio = 0; Espacio < EspacioResta; Espacio++) {
                System.out.print(" ");
            }
            for (j = 0; j < (i + 1); j++) {
                System.out.print("*");
            }
            for (otroLado = 0; otroLado < i; otroLado++) {
                System.out.print("*");
            }
            System.out.println();
        }

        teclado.close();
    }
}
