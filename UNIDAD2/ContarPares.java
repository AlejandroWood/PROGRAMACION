package UNIDAD2;

public class ContarPares {
    public static void main(String[] args) {
        int par = 0 , impar = 0 , numAleatorio = 0 , i = 1;
        String texto = "";

        for (i = 1 ; i < 21 ; i++){
            numAleatorio = (int)(Math.random() * 100) + 1;
            if ((numAleatorio % 2) == 0){
                texto = "Par";
                par++;
            } else {
                texto = "Impar";
                impar++;
            }
            System.out.println("El número " + numAleatorio + ", que está en el puesto " + i + " es: " + texto);
        }
        System.out.println("Hay " + par + " números pares y " + impar + " números impares");
        System.out.println("El porcentaje de números pares ha sido del " + (par * 100 / 20) + "%");
        System.out.println("El porcentaje de números impares ha sido del " + (impar * 100 / 20) + "%");
    }
}
