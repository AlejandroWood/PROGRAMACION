package UNIDAD2;

import java.util.Scanner;

public class ExamenRecuperacion {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int pocionesRegistradas = 0;

        //Le pide al usuario que introduzca la cantidad de pociones a registrar
        System.out.println("Introduzca la cántidad de pociones que desea registrar.");
        System.out.print("(Mínimo 3 pociones y máximo 50 pociones): ");
        pocionesRegistradas = teclado.nextInt();

        System.out.println();
    
        //Si la cantidad de pociones introducidas no está en el rango permitido
        //le pedirá que introduzca un valor hasta que ponga el correcto
        while (pocionesRegistradas < 3 || pocionesRegistradas > 50) {
            System.out.println("Introduzca un valor correcto");
            System.out.print("(Mínimo 3 pociones y máximo 50 pociones): ");
            pocionesRegistradas = teclado.nextInt();
            System.out.println();
        }

        //Se registran en cada uno de los datos cuantas pociones se registran
        String[] nombre = new String[pocionesRegistradas];
        String[] ingredientePrincipal = new String[pocionesRegistradas];
        String[] clase = new String[pocionesRegistradas];
        double[] precio = new double[pocionesRegistradas];
        int[] stock = new int[pocionesRegistradas];
        int[] reabastecimientoUrgente = new int[pocionesRegistradas];
        int[] nivelPureza = new int[pocionesRegistradas];
        String[] estabilidad = new String[pocionesRegistradas];

        //Se repetirá está condición hasta que se hayan registrado todas las pociones
        for (int i = 0; i < pocionesRegistradas; i++) {
            System.out.println("Poción " + (i + 1) + ":");
            //Le pide al usuario que introduzca el nombre de la poción
            //y la guarda en su respectiva posición
            System.out.print("Introduzca el nombre de la poción: ");
            nombre[i] = teclado.next();

            System.out.println();

            //Le pide al usuario que introduzca el ingrediente principal de la poción
            //y la guarda en su respectiva posición
            System.out.print("Introduzca el ingrediente principal de la poción: ");
            ingredientePrincipal[i] = teclado.next();

            System.out.println();

            //Le pide al usuario que introduzca la clase de la pocion
            System.out.println("Introduzca la clase de la poción");
            System.out.print("(Curativa | Veneno | Encantamiento): ");
            clase[i] = teclado.next();

            System.out.println();

            //Si la clase de la pocion introducida no está entre las clases permitidas
            //le pedirá que introduzca un valor hasta que ponga el correcto
            while (!(clase[i].equals("Curativa") || clase[i].equals("Veneno") || clase[i].equals("Encantamiento"))) {
                System.out.println("Introduzca una clase válida");
                System.out.print("(Curativa | Veneno | Encantamiento): ");
                clase[i] = teclado.next();
                System.out.println();
            }

            //Le pide al usuario que introduzca el precio por frasco
            //y la guarda en su respectiva posición
            System.out.print("Introduzca el precio por frasco: ");
            precio[i] = teclado.nextDouble();

            System.out.println();

            //Si el precio de la pocion es menor o igual que 0
            //le pedirá que introduzca un valor hasta que ponga el correcto
            while(precio[i] <= 0) {
                System.out.print("Introduzca un precio positivo: ");
                precio[i] = teclado.nextDouble();
                System.out.println();
            }

            //Le pide al usuario que introduzca la cántidad de esta poción que hay en stock
            //y la guarda en su respectiva posición
            System.out.print("Introduzca la cántidad de esta poción que hay en stock: ");
            stock[i] = teclado.nextInt();

            System.out.println();

            //Si el stock de la pocion es negativo
            //le pedirá que introduzca un valor hasta que ponga el correcto
            while (stock[i] < 0) {
                System.out.print("El stock no puede ser negativo, introduzcalo otra vez: ");
                stock[i] = teclado.nextInt();
                System.out.println();
            }

            //Si el stock es inferior a 3 el valor se que se guarda es 1, de lo contrarío se guardará un 0
            if (stock[i] < 3) {
                reabastecimientoUrgente[i] = 1;
            } else {
                reabastecimientoUrgente[i] = 0;
            }

            //Le pide al usuario que introduzca el nivel de pureza de esta poción
            //y la guarda en su respectiva posición
            System.out.println("Introduzca el nivel de pureza de la poción");
            System.out.print("(25 | 50 | 75 | 90 | 100): ");
            nivelPureza[i] = teclado.nextInt();

            System.out.println();

            //Si el nivel de pureza no es válido
            //le pedirá que introduzca un valor hasta que ponga el correcto
            while (!(nivelPureza[i] == 25 || nivelPureza[i] == 50 || nivelPureza[i] == 75 || nivelPureza[i] == 90 || nivelPureza[i] == 100)) {
                System.out.println("Introduzca un nivel de pureza válido");
                System.out.print("(25 | 50 | 75 | 90 | 100): ");
                nivelPureza[i] = teclado.nextInt();
                System.out.println();
            }

            //Le pide al usuario que introduzca la estabilidad de esta poción
            //y la guarda en su respectiva posición
            System.out.println("Introduzca la estabilidad de la poción");
            System.out.print("(Estable | Inestable): ");
            estabilidad[i] = teclado.next();

            System.out.println();

            //Si la etabilidad no es válida
            //le pedirá que introduzca un valor hasta que ponga el correcto
            while (!(estabilidad[i].equals("Estable") || estabilidad[i].equals("Inestable"))) {
                System.out.println("Introduzca una estabilidad correcta");
                System.out.print("(Estable | Inestable): ");
                estabilidad[i] = teclado.next();
                System.out.println();
            }
        }

        //Hasta que el usuario no diga que ha terminado seguirán haciendose operaciones
        boolean terminado = true;
        int stockTotal = 0;
        int stockEstables = 0;
        int stockInestables = 0;
        int operacion = 0;
        int curativa = 0;
        int veneno = 0;
        double precioMax = 0;
        String nombreMax = "";
        String ingredienteMax = "";
        String nombreMayorNivelPureza = "";
        int mayorNivelPureza = 0;
        int encantamiento = 0;
        double precioMedioCurativa = 0;
        double precioMedioVeneno = 0;
        double precioMedioEncantamiento = 0;
        while (terminado) {
            stockTotal = 0;
            stockEstables = 0;
            stockInestables = 0;
            precioMax = 0;
            nombreMax = "";
            ingredienteMax = "";
            curativa = 0;
            veneno = 0;
            encantamiento = 0;
            precioMedioCurativa = 0;
            precioMedioVeneno = 0;
            precioMedioEncantamiento = 0;
            //Enseña todas las operaciónes que se pueden hacer
            System.out.println("¿Qué operación desea realizar?");
            System.out.println("1. Listar el nombre e ingrediente principal de todas las pociones que sean Inestables, con una Pureza >= 90 o las que tengan un precio superior a 50 monedas y mas de 10 unidades.");
            System.out.println("2. Mostrar cuántas pociones hay de cada Clase (Curativa, Veneno, Encantamiento) y cuál es el precio medio de cada una de esas clases.");
            System.out.println("3. Enseñar una lista de reabastecimiento urgente.");
            System.out.println("4. Del conjunto de pociones de clase Veneno enseñar la más cara y la que tiene mayor Nivel de Pureza.");
            System.out.println("5. Mostrar qué porcentaje del inventario total (en número de frascos/unidades, no tipos de poción) corresponde a pociones Estables frente a Inestables.");
            System.out.println("6. Terminar el exámen.");
            System.out.print("Operación: ");
            operacion = teclado.nextInt();

            //Si la operación que ha introducido el usuario no está en el rango válido se le pedirá que vuelva a introducirlo
            while (operacion < 1 || operacion > 6) {
                System.out.print("Introduce una operación correcta: ");
                operacion = teclado.nextInt();
            }

            System.out.println();

            switch (operacion) {
                case 1:
                    //Se encarga de que todos los datos sean comprobados segun los requisitos
                    for (int i = 0; i < pocionesRegistradas; i++) {
                        //Mira si la poción es Inestable y con un nivel de pureza mayor o igual a 90 o que el precio sea
                        //de más de 50 monedas y que hayan más de 10 unidades 
                        if ((estabilidad[i].equals("Inestable") && nivelPureza[i] >= 90) || (precio[i] > 50 && stock[i] > 10)){
                            System.out.println("Nombre: " + nombre[i]);
                            System.out.println("Ingrediente principal: " + ingredientePrincipal[i]);
                        }
                    }
                    break;
                case 2:
                    //Se encarga de que todos los datos sean comprobados segun los requisitos
                    for (int i = 0; i < pocionesRegistradas; i++) {
                        //Cuentan cuantas pociones hay de cada clase y se van sumando los precios de cada poción de su respectiva clase
                        if (clase[i].equals("Curativa")) {
                            curativa++;
                            precioMedioCurativa = precioMedioCurativa + precio[i];
                        } else if (clase[i].equals("Veneno")) {
                            veneno++;
                            precioMedioVeneno = precioMedioVeneno + precio[i];
                        } else {
                            encantamiento++;
                            precioMedioEncantamiento = precioMedioEncantamiento + precio[i];
                        }
                    }

                    //Se hace la media de los precios de cada clase
                    precioMedioCurativa = precioMedioCurativa / curativa;
                    precioMedioVeneno = precioMedioVeneno / veneno;
                    precioMedioEncantamiento = precioMedioEncantamiento / encantamiento;

                    //Muestra los datos
                    System.out.println("Hay " + curativa + " pociones curativas con un precio medio de " + precioMedioCurativa + " monedas.");
                    System.out.println("Hay " + veneno + " pociones de veneno con un precio medio de " + precioMedioVeneno + " monedas.");
                    System.out.println("Hay " + encantamiento + " pociones de encantamiento con un precio medio de " + precioMedioEncantamiento + " monedas.");
                    break;
                case 3:
                    System.out.println("Lista de todas las pociones con stock crítico:");
                    //Se encarga de que todos los datos sean comprobados segun los requisitos
                    for (int i = 0; i < pocionesRegistradas; i++) {
                        //Si el reabastecimientoUrgente es igual a 1 significa que el stock de esa poción está en estado crítico
                        if (reabastecimientoUrgente[i] == 1) {
                            System.out.println(nombre[i] + ".");
                        }
                    }
                    break;
                case 4:
                    //Se encarga de que todos los datos sean comprobados segun los requisitos
                    for (int i = 0; i < pocionesRegistradas; i++) {
                        //Guarda los datos si el precio es mayor al que está guardado y si la clase es veneno
                        if (precioMax < precio[i] && clase[i].equals("Veneno")) {
                            precioMax = precio[i];
                            nombreMax = nombre[i];
                            ingredienteMax = ingredientePrincipal[i];
                        }
                        //Guarda los datos si el nivel de pureza es mayor al que está guardado y si la clase es veneno
                        if (mayorNivelPureza < nivelPureza[i] && clase[i].equals("Veneno")) {
                            mayorNivelPureza = nivelPureza[i];
                            nombreMayorNivelPureza = nombre[i];
                        }

                    }
                        
                    //Muestra los datos
                    System.out.println("La poción de veneno más cara se llama " + nombreMax + ", su ingrediente principal es " + ingredienteMax + " y su precio es de " + precioMax + " monedas.");
                    System.out.println("La poción de veneno con mayor nivel de pureza se llama " + nombreMayorNivelPureza);

                    break;
                case 5:
                    //Se encarga de que todos los datos sean comprobados segun los requisitos
                    for (int i = 0; i < pocionesRegistradas; i++) {
                        //Suma todo el stock
                        stockTotal = stockTotal + stock[i];

                        //Si la estabilidad es estable se le sumará al total de estable y de lo contrario se sumará al total de inestables
                        if (estabilidad[i].equals("Estable")) {
                            stockEstables = stockEstables + stock[i];
                        } else {
                            stockInestables = stockInestables + stock[i];
                        }
                    }

                    //La operación siguiente es para que se muestre en porcentajes
                    stockEstables = (stockEstables * 100) / stockTotal;
                    stockInestables = (stockInestables * 100) / stockTotal;

                    System.out.println("Stock total: " + stockTotal);
                    System.out.println("Estables: " + stockEstables + "%");
                    System.out.println("Inestables: " + stockInestables + "%");
                    break;
                case 6:
                    terminado = false;
                    break;
            }
            System.out.println();
        }
        System.out.println("Hasta luego!");
        teclado.close();
    }
    
}
