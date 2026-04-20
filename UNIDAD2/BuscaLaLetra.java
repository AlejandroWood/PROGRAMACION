package UNIDAD2;

public class BuscaLaLetra {
    public static void main(String[] args) {
        /*
         * Sacar por pantalla el sumatorio de todos los número desde 1 hasta 10,
         * siguiendo el siguiente patron
         * suma hasta 1 = 1
         * suma hasta 2 = 1 + 2 = 3
         * suma hasta 3 = 1 + 2 + 3 = 6
         * ...
         */

        String texto = "";
        int i = 1;
        int suma = 0;

        for (i = 1 ; i < 11 ; i++ ) {
            if (i == 1) {
                texto = Integer.toString(i);
            } else {
                texto = texto + " + " + Integer.toString(i);
            }
            suma = suma + i;
            System.out.println("suma hasta " + i + " = " + texto + " = " + suma);
        }
    }
}
