package EXAMENES_RESUELTOS_UNIDAD3.A;

import java.util.ArrayList;

public class PruebasExposicion {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO PRUEBAS DE EXPOSICIÓN RETRO ===\n");

        // 1. Crear al menos 6 instancias de JuegoRetro con datos variados
        JuegoRetro j1 = new JuegoRetro("Super Mario Bros", "NES", 1985, 120.0, 9.5, JuegoRetro.PLATAFORMA, false, "Manual físico; Caja original");
        JuegoRetro j2 = new JuegoRetro("Street Fighter II", "Arcade", 1991, 350.0, 9.2, JuegoRetro.LUCHA, false, "Mueble restaurado; Soundtrack original");
        JuegoRetro j3 = new JuegoRetro("Sonic the Hedgehog", "Mega Drive", 1991, 8.50, 8.8, JuegoRetro.PLATAFORMA, false, "Manual físico"); // Barato (<10)
        JuegoRetro j4 = new JuegoRetro("The Legend of Zelda", "NES", 1986, 250.0, 9.8, JuegoRetro.AVENTURAS, false, "Mapa original; Caja dorada");
        JuegoRetro j5 = new JuegoRetro("Doom", "PC", 1993, 5.00, 9.6, JuegoRetro.SHOOTER, true, "Soundtrack original; Versión Digital"); // Barato (<10)
        JuegoRetro j6 = new JuegoRetro("Tetris", "Game Boy", 1989, 45.0, 9.0, JuegoRetro.PLATAFORMA, false, "Caja original");

        // 2. Mostrar el toString() de al menos dos juegos diferentes
        System.out.println("--- MOSTRANDO TOSTRING() DE DOS JUEGOS ---");
        System.out.println(j1);
        System.out.println();
        System.out.println(j5);
        System.out.println("\n------------------------------------------\n");

        // Preparar lista para la exposición
        ArrayList<JuegoRetro> listaJuegos = new ArrayList<>();
        listaJuegos.add(j1);
        listaJuegos.add(j2);
        listaJuegos.add(j3);
        listaJuegos.add(j4);
        listaJuegos.add(j5);
        listaJuegos.add(j6);

        // Crear instancia de ExposicionRetro
        ExposicionRetro expo = new ExposicionRetro(101, "RetroCon 2026", listaJuegos, "Cádiz", 15.0, true);

        // 3. Probar todas las funciones de ExposicionRetro.java
        System.out.println("--- PROBANDO FUNCIONES DE EXPOSICION ---");

        // Función a) Calcular valor total
        System.out.printf("a) Valor Total de la Colección: %.2f€\n", expo.calcularValorTotalColeccion());

        // Función b) Buscar juegos por consola y rango puntuación
        System.out.println("\nb) Buscando juegos de 'NES' con puntuación entre 9.0 y 10.0:");
        ArrayList<JuegoRetro> busqueda = expo.buscarJuegosPorConsolaYRangoPuntuacion("NES", 9.0, 10.0);
        for (JuegoRetro j : busqueda) {
            System.out.println("   - " + j.titulo + " (Puntuación: " + j.getPuntuacionCritica() + ")");
        }

        // Función c) Cantidad de juegos baratos (Uso de Streams)
        System.out.println("\nc) Cantidad de juegos baratos (<10€) para 'Mega Drive': " + expo.cantidadJuegosBaratos("Mega Drive"));
        System.out.println("   Cantidad de juegos baratos (<10€) para 'PC': " + expo.cantidadJuegosBaratos("PC"));

        // Función e) Juego mejor valorado con una característica específica
        String caracteristica = "Soundtrack original";
        System.out.println("\ne) Mejor juego con la característica '" + caracteristica + "':");
        JuegoRetro destacado = expo.juegoMejorValoracionConCaracteristica(caracteristica);
        if (destacado != null) {
            System.out.println("   -> " + destacado.titulo + " con un " + destacado.getPuntuacionCritica());
        } else {
            System.out.println("   -> No se encontró ningún juego.");
        }

        // Función d) Eliminar juegos por tipo (Hacer al final para no alterar las otras pruebas)
        int tipoBorrar = JuegoRetro.PLATAFORMA;
        System.out.println("\nd) Eliminando juegos de tipo PLATAFORMA...");
        int eliminados = expo.eliminarJuegosPorTipo(tipoBorrar);
        System.out.println("   Juegos eliminados: " + eliminados);
        System.out.println("   Total de juegos restantes en la exposición: " + expo.getJuegosExhibidos().size());
    }
}
