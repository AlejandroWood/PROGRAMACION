// Juan Francisco González Gómez

import java.util.ArrayList;

public class PruebasExposicion {
    public static void main(String[] args) {
        ArrayList<String> característicasZelda = new ArrayList<>();
        característicasZelda.add("Soundtrack original;".toLowerCase());
        característicasZelda.add("Manual físico;".toLowerCase());
        característicasZelda.add("Figura coleccionista;".toLowerCase());

        JuegoRetro juego0 = new JuegoRetro(
            1980, 50.0f, 9.9f, "Zelda", "SNES", característicasZelda, true, JuegoRetro.AVENTURAS
        );

        JuegoRetro juego1 = new JuegoRetro();
        JuegoRetro juego2 = new JuegoRetro();
        JuegoRetro juego3 = new JuegoRetro();
        JuegoRetro juego4 = new JuegoRetro();
        JuegoRetro juego5 = new JuegoRetro();

        System.out.println(juego0.toString());
        System.out.println(juego1.toString());

        ArrayList<JuegoRetro> juegosRetro = new ArrayList<>();
        juegosRetro.add(juego0);
        juegosRetro.add(juego1);
        juegosRetro.add(juego2);
        juegosRetro.add(juego3);
        juegosRetro.add(juego4);
        juegosRetro.add(juego5);
        
        ExposicionRetro expo = new ExposicionRetro(
            00, 89, 5f, juegosRetro, "FrikiExpo", "Sevilla", true
        );

        System.out.println("\n\nValor\n" + String.format("%.2f€", expo.calcularValorTotalColeccion()));

        System.out.println("\n\nJuegos por consola, rango y puntuación\n" + expo.buscarJuegosPorConsolaYRangoPuntuacion("SNES", 5, 10));

        System.out.println("\n\nJuegos baratos\n" + expo.cantidadJuegosBaratos(""));

        System.out.println("\n\nJuego mejor valorado\n" + expo.juegoMejorValoracionConCaracteristica("Soundtrack original;"));

        System.out.println("\n\nJuegos antes de eliminar\n" + expo.toString());

        System.out.println(expo.eliminarJuegosPorTipo(JuegoRetro.AVENTURAS));

        System.out.println("\n\nJuegos después de eliminar\n" + expo.toString());


    }
}