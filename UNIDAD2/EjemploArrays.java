package UNIDAD2;

public class EjemploArrays {
    public static void main(String[] args) {
        String[] calcetines = {"marron","rojo","verde","negro","rojo","verde"};

        System.out.println("El calcetin que esta en quinta posicion es " + calcetines[4]);

        System.out.println("Hay " + calcetines.length + " calcetines.");

        //Sobreeescribimos el calcetin de la posición 5
        calcetines[4] = "negro";

        System.out.println("El calcetin que esta en quinta posicion es " + calcetines[4]);

        //Creamos un array de numeros aleatorios y calculamos sus estadisticas
        int[] numeros = new int[10];

        //Recorremos todas las posiciones del array y lo rellenamos de numeros como al pavo de navidad
        for (int i=0;i<numeros.length;i++) {
            numeros[i] = (int) (Math.random() * 100) + 1;
            System.out.println("El número aleatorio en la posición " + (i + 1) + " es " + numeros[i]);
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        /*
         * Estructura for específica para recorrer arrays
         * para cada elemento del array, repite el codigo de dentro
         * y guarda el valor de la posición actual en la variable numero
         */
        for (int numero : numeros){
            //Vamos sumando todos los numeros en sum
            //Al final del bucle tendremos la suma de todos
            sum = sum + numero;

            //Para el maximo tenemos que comprobar si el numero actual es el mayor que el máximo
            if (numero > max) {
                max = numero;
            }

            if (min > numero) {
                min = numero;
            }
        }
        System.out.println("La suma de los números es: " + sum);
        System.out.println("La media de los números es: " + (sum / (numeros.length)));
        System.out.println("El número más grande es: " + max);
        System.out.println("El número más pequeño es: " + min);
        System.out.println("El numero total de elementos es: " + numeros.length);
    }
}
