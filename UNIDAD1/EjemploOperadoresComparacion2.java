package UNIDAD1;

import javax.swing.JOptionPane;

public class EjemploOperadoresComparacion2 {
    public static void main(String[] args) {

        int numNiveles=0, edadRecomendada=0, numNivelesJuego=5;
        String nombreJuego = "Mario Brus", txtedadRecomendada = "", txtnumNiveles = "", txtnivelDificultad = "";
        char nivelDificultad = 'A';

        numNiveles = 19;

        /*
         * Usamos un inputDialog para leer datos, de la libreria visual de java Swing
         * El problema es que solo lee de tipo String
         * Si pasamos con el raton por encima de una función me sale
         * para que es cada parametro y lo que hace
         */
        txtedadRecomendada = JOptionPane .showInputDialog(
            null, "Introduzca la Edad Recomendada",
            "Edad Del Juego",
        JOptionPane.QUESTION_MESSAGE);

        /*
         * Supongamos que necesitamos convertir a numero la edadRecomendada
         * para convertir tipos en java lo más común es usar
         * las funciones parse y valueOf
         */

        edadRecomendada = Integer.valueOf(txtedadRecomendada);

        //System.out.println("La edad recomendada es: " + edadRecomendada);

        //Leemos el nombre del juego
        nombreJuego = JOptionPane .showInputDialog(
            null, "Introduzca el nombre del juego",
            "Nombre Del Juego",
        JOptionPane.QUESTION_MESSAGE);

        //if (edadRecomendada >= 18)
        //{
            //String mensaje = "Cuidado que es para mayores de edad.";

            //Para unir (concatenar) cadenas de texto usamos el +
            //Cómo si fuese un número
            //mensaje = mensaje + " Ten cuidado!!";

            //Es más rápido usando la función concat
            //mensaje.concat(" Y no la lies!!");

            //System.out.println(mensaje);
        //}
        //Para comparar String no se usa el operador == sino la funcion equals
        //if (nombreJuego.equals("Mario Bross"))
        //{
            //System.out.println("El juego " + nombreJuego + " es el más guay de nintendo y es para mayores de " + edadRecomendada + " años");
        //}

        //Saca el nombre del juego si cumple que su edad 
        //recomendada está entre 5 y 10 años y además cumple una
        //las dos siguientes condiciones, que tiene los niveles que leemos por pantalla
        //o que su nivel de dificultad es C

        txtnumNiveles = JOptionPane .showInputDialog(
            null, "Introduzca cuantos niveles tiene el juego",
            "Niveles Del Juego",
        JOptionPane.QUESTION_MESSAGE);

        numNiveles = Integer.valueOf(txtnumNiveles);

        txtnivelDificultad = JOptionPane .showInputDialog(
            null, "Introduzca el nivel de dificultad que tiene el juego",
            "Niveles De Dificultad",
        JOptionPane.QUESTION_MESSAGE);

        nivelDificultad = txtnivelDificultad.charAt(0);
        
        if ((edadRecomendada >= 5 && edadRecomendada <=10) && (numNivelesJuego == numNiveles || nivelDificultad == 'C'))
        {
        System.out.println("El nombre del juego es: " + nombreJuego);
        }
    }

}
