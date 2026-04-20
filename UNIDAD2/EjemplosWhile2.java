package UNIDAD2;

public class EjemplosWhile2 {
    public static void main(String[] args) {
        
        /*
         * Primero vamos a hacer un programa que haga una cuenta atras de un cohete
         * Contara desde 10 hasta 1 y despues dira ignicion, cuando sea 3 ademas
         * mostrara el mensaje "preparados" cuando sea 2 "listos" y cuando sea uno "rezad mucho"
         */

        int tiempo = 10;

        while (tiempo > 0){
            if (tiempo == 3){
                System.out.println("Quedan " + tiempo +" --- preparados");
            } else if (tiempo == 2){
                System.out.println("Quedan " + tiempo +" --- listossss");
            } else if (tiempo == 1){
                System.out.println("Quedan " + tiempo +" --- rezad todo lo que sepais, inconscientes");
            } else {
                System.out.println(tiempo);
            }
            tiempo--;
        }
        System.out.println(tiempo + " Ignicion!!!");
    }
}