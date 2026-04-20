package UNIDAD2;

public class EjemploNumeroMayor {
    public static void main(String[] args) {
        int num1 = (int)(Math.random()*10000) + 1;
        int num2 = (int)(Math.random()*10000) + 1;
        int num3 = (int)(Math.random()*10000) + 1;
        int mayor = 0;

        System.out.println("Los números son " + num1 + ", " + num2 + " y " + num3);

        if (num1 >= num2 && num1 >= num3) {
            mayor = num1;
        } else if (num2 >= num3) {
            mayor = num2;
        } else {
            mayor = num3;
        }

        System.out.println("El número " + mayor + " es el mayor de todos.");
    }
}
