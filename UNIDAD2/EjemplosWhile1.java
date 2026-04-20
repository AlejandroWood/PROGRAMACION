package UNIDAD2;

public class EjemplosWhile1 {
    public static void main(String[] args) {
        int numAleatorio = (int)(Math.random() * 10) + 1;
        int num = 1;
        int resultado = 0; 

        while (num <= 10) {
            resultado = numAleatorio * num;
            System.out.println(numAleatorio + " * " + num + " = " + resultado);
            num = num + 1;
        }

        int edad = 0;
        int sumaEdad = 0;
        int i = 1;
        int personasValidas = 0;
        String mensaje = "";

        while (i <= 10) {
            edad = (int)(Math.random() * 100) + 1;

            if (edad < 18) {
                mensaje = "";
                mensaje = "Es menor de edad.";
            } else if (edad > 65) {
                mensaje = "";
                mensaje = "Está jubilada.";
            } else {
                mensaje = "";
                sumaEdad = sumaEdad + edad;
                ++personasValidas;
            }
            System.out.println("La edad de la persona " + i + " es: " + edad + ". " + mensaje);
            i++;
        }
        if (personasValidas != 0) {
            sumaEdad = sumaEdad / personasValidas;
            System.out.println("La Media es: " + sumaEdad);
        }
    }
}
