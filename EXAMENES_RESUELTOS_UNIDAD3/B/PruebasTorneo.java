package EXAMENES_RESUELTOS_UNIDAD3.B;

import java.util.ArrayList;

public class PruebasTorneo {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE PRUEBAS: TORNEOS RETRO ESPORTS ===\n");

        // 1. Instanciar 7 personajes con casuísticas bien variadas (Constructores mixto)
        PersonajeRPG p1 = new PersonajeRPG("ThunderBlade", PersonajeRPG.CLASE_GUERRERO, 45, 3500, 180.5, true, "Golpe crítico, Torbellino", "TitanSlayers");
        PersonajeRPG p2 = new PersonajeRPG("MysticShadow", PersonajeRPG.CLASE_MAGO, 42, 1800, 240.0, true, "Teletransporte, Bola de Fuego", "ShadowGuild");
        PersonajeRPG p3 = new PersonajeRPG("SwiftArrow", PersonajeRPG.CLASE_ARQUERO, 20, 1200, 95.0, false, "Disparo Doble, Flecha de Hielo", "TitanSlayers");
        PersonajeRPG p4 = new PersonajeRPG("Nightstalker", PersonajeRPG.CLASE_ASESINO, 48, 2100, 240.0, false, "Invisibilidad, Golpe crítico", "ShadowGuild"); // Empate daño con p2 pero mayor nivel
        PersonajeRPG p5 = new PersonajeRPG("Ragnar", PersonajeRPG.CLASE_GUERRERO, 12, 4500, 75.0, false, "Provocación", "TitanSlayers"); // Mucha vida, bajo nivel
        
        // Uso de constructores vacíos (Generación de propiedades aleatorias)
        PersonajeRPG p6 = new PersonajeRPG(); 
        p6.nombrePersonaje = "BotCampeon";
        p6.setTipoClase(PersonajeRPG.CLASE_MAGO);
        p6.setEsLegendario(true);
        p6.setHabilidades("Ventisca, Teletransporte");
        
        PersonajeRPG p7 = new PersonajeRPG();
        p7.nombrePersonaje = "NovatoErrante";
        p7.setTipoClase(PersonajeRPG.CLASE_ASESINO);
        p7.setNivel(5); // Forzar nivel bajo para pruebas de purga

        // 2. Mostrar obligatoriamente el toString() de al menos dos de ellos
        System.out.println("--- DEMOSTRACIÓN DE FORMATOS TOSTRING ---");
        System.out.println(p1);
        System.out.println();
        System.out.println(p4);
        System.out.println("\n-----------------------------------------\n");

        // Preparación de conjuntos de competidores
        ArrayList<String> habilidades = new ArrayList<>();
        ArrayList<PersonajeRPG> listaInscripcion = new ArrayList<>();
        listaInscripcion.add(p1);
        listaInscripcion.add(p2);
        listaInscripcion.add(p3);
        listaInscripcion.add(p4);
        listaInscripcion.add(p5);
        listaInscripcion.add(p6);
        listaInscripcion.add(p7);

        // Crear instancias de los torneos
        TorneoEsports torneoOficial = new TorneoEsports("T-2026-B", "Copa de Campeones de Andalucía", listaInscripcion, "EU-West", 500000, 10, true);
        TorneoEsports torneoVacio = new TorneoEsports(); // Instancia complementaria requerida

        // 3. Ejecución y testeo de todas las funciones
        System.out.println("--- EJECUTANDO BATERÍA DE PRUEBAS FUNCIONALES ---");

        // Función a) Daño Promedio de Clase
        double promGuerreros = torneoOficial.calcularDanioPromedioClase(PersonajeRPG.CLASE_GUERRERO);
        System.out.printf("a) Daño promedio de la clase GUERRERO: %.2f\n", promGuerreros);

        // Función b) Contar Legendarios con Habilidad específica (Stream check)
        String skill = "Teletransporte";
        int totalSkill = torneoOficial.contarPersonajesLegendariosConHabilidad(skill);
        System.out.println("b) [STREAMS] Personajes Legendarios que dominan '" + skill + "': " + totalSkill);

        // Función c) Extraer el top de personajes con más salud
        int nTop = 3;
        System.out.println("c) Extrayendo el Top " + nTop + " Héroes con mayor vitalidad (HP):");
        ArrayList<PersonajeRPG> topVida = torneoOficial.obtenerTopPersonajesPorVida(nTop);
        for (int i = 0; i < topVida.size(); i++) {
            PersonajeRPG p = topVida.get(i);
            System.out.println("   [" + (i+1) + "] " + p.nombrePersonaje + " -> " + p.getPuntosVida() + " HP");
        }

        // Función d) Búsqueda del campeón más fuerte en gremio específico con resolución de empates
        String gremioBuscado = "ShadowGuild";
        System.out.println("d) Buscando el baluarte del gremio '" + gremioBuscado + "' (Mayor Daño):");
        PersonajeRPG fuerte = torneoOficial.buscarPersonajeMasFuerteDeGremio(gremioBuscado);
        if (fuerte != null) {
            System.out.println("   Héroe destacado: " + fuerte.nombrePersonaje + " [Daño: " + fuerte.getPuntosDanio() + " / Nivel: " + fuerte.getNivel() + "]");
        }

        // Función e) Evolución de niveles y purga selectiva de personajes por debajo de la supervivencia
        System.out.println("\ne) Aplicando potenciador de nivel (+10) y limpiando supervivientes bajo nivel 20...");
        System.out.println("   Jugadores registrados antes de la purga: " + torneoOficial.getJugadoresRegistrados());
        boolean limpiezaEfectuada = torneoOficial.actualizarNivelesYEliminarDebiles(10, 20);
        System.out.println("   ¿Se eliminaron combatientes?: " + (limpiezaEfectuada ? "Sí" : "No"));
        System.out.println("   Jugadores registrados actualmente en el torneo: " + torneoOficial.getJugadoresRegistrados());
        
        System.out.println("\n=== FIN DEL PROTOCOLO DE PRUEBAS ===");
    }
}