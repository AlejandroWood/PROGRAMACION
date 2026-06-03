package EXAMENES_RESUELTOS_UNIDAD3.B;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class TorneoEsports {
    // Atributos
    private String codigoTorneo;
    public String nombreTorneo; // Público por requisito explícito
    private int jugadoresRegistrados;
    private ArrayList<PersonajeRPG> listaJugadores;
    private String servidorRegion;
    private double poolPremios;
    private int requiereNivelMinimo;
    private boolean esRanked;

    // Constructor Vacío
    public TorneoEsports() {
        Random rand = new Random();
        this.codigoTorneo = "";
        this.nombreTorneo = "";
        this.jugadoresRegistrados = rand.nextInt(101); // 0 a 100
        this.listaJugadores = new ArrayList<>();
        this.servidorRegion = "";
        this.poolPremios = 0.0;
        this.requiereNivelMinimo = 1;
        this.esRanked = false;
    }

    // Constructor Completo
    public TorneoEsports(String codigoTorneo, String nombreTorneo, ArrayList<PersonajeRPG> listaJugadores, 
                         String servidorRegion, double poolPremios, int requiereNivelMinimo, boolean esRanked) {
        this.codigoTorneo = codigoTorneo;
        this.nombreTorneo = nombreTorneo;
        this.listaJugadores = listaJugadores != null ? listaJugadores : new ArrayList<>();
        this.servidorRegion = servidorRegion;
        this.poolPremios = poolPremios;
        this.requiereNivelMinimo = requiereNivelMinimo;
        this.esRanked = esRanked;
        // Calculado dinámicamente a partir del tamaño del array recibido
        this.jugadoresRegistrados = this.listaJugadores.size(); 
    }

    // Getters y Setters
    public String getCodigoTorneo() { return codigoTorneo; }
    public void setCodigoTorneo(String codigoTorneo) { this.codigoTorneo = codigoTorneo; }

    public int getJugadoresRegistrados() { return jugadoresRegistrados; }
    public void setJugadoresRegistrados(int jugadoresRegistrados) { this.jugadoresRegistrados = jugadoresRegistrados; }

    public ArrayList<PersonajeRPG> getListaJugadores() { return listaJugadores; }
    public void setListaJugadores(ArrayList<PersonajeRPG> listaJugadores) { this.listaJugadores = listaJugadores; }

    public String getServidorRegion() { return servidorRegion; }
    public void setServidorRegion(String servidorRegion) { this.servidorRegion = servidorRegion; }

    public double getPoolPremios() { return poolPremios; }
    public void setPoolPremios(double poolPremios) { this.poolPremios = poolPremios; }

    public int getRequiereNivelMinimo() { return requiereNivelMinimo; }
    public void setRequiereNivelMinimo(int requiereNivelMinimo) { this.requiereNivelMinimo = requiereNivelMinimo; }

    public boolean isEsRanked() { return esRanked; }
    public void setEsRanked(boolean esRanked) { this.esRanked = esRanked; }


    // --- LOGICA DE EXAMEN: FUNCIONES ---

    // a) Calcular Daño Promedio de una Clase Específica
    public double calcularDanioPromedioClase(int claseFiltro) {
        if (listaJugadores == null || listaJugadores.isEmpty()) {
            return 0.0;
        }
        double sumaDanio = 0.0;
        int contador = 0;

        for (PersonajeRPG p : listaJugadores) {
            if (p.getTipoClase() == claseFiltro) {
                sumaDanio += p.getPuntosDanio();
                contador++;
            }
        }
        return contador == 0 ? 0.0 : sumaDanio / contador;
    }

    // b) Contar Personajes Legendarios Con Habilidad [OBLIGATORIO: STREAMS]
    public int contarPersonajesLegendariosConHabilidad(String habilidadBuscada) {
        if (listaJugadores == null) return 0;
        return (int) listaJugadores.stream()
                .filter(PersonajeRPG::isEsLegendario)
                .filter(p -> p.getHabilidades().toLowerCase().contains(habilidadBuscada.toLowerCase()))
                .count();
    }

    // c) Obtener Top N Personajes por Vida (Orden Mayor a Menor)
    public ArrayList<PersonajeRPG> obtenerTopPersonajesPorVida(int topN) {
        ArrayList<PersonajeRPG> resultado = new ArrayList<>();
        if (topN <= 0 || listaJugadores == null || listaJugadores.isEmpty()) {
            return resultado; // Devuelve lista vacía
        }

        // Duplicamos la lista original para no desordenar el torneo base
        ArrayList<PersonajeRPG> clonLista = new ArrayList<>(listaJugadores);
        
        // Ordenamos descendentemente por puntos de vida usando un comparador
        Collections.sort(clonLista, new Comparator<PersonajeRPG>() {
            @Override
            public int compare(PersonajeRPG p1, PersonajeRPG p2) {
                return Integer.compare(p2.getPuntosVida(), p1.getPuntosVida());
            }
        });

        // Extraer los topN (o todos si topN supera el total)
        int limite = Math.min(topN, clonLista.size());
        for (int i = 0; i < limite; i++) {
            resultado.add(clonLista.get(i));
        }
        return resultado;
    }

    // d) Buscar Personaje Más Fuerte de un Gremio (Exacto y Desempate)
    public PersonajeRPG buscarPersonajeMasFuerteDeGremio(String nombreGremio) {
        if (listaJugadores == null || nombreGremio == null) return null;
        
        PersonajeRPG candidato = null;

        for (PersonajeRPG p : listaJugadores) {
            if (p.getGuildName().equals(nombreGremio)) { // Búsqueda exacta (case-sensitive)
                if (candidato == null) {
                    candidato = p;
                } else {
                    if (p.getPuntosDanio() > candidato.getPuntosDanio()) {
                        candidato = p;
                    } else if (p.getPuntosDanio() == candidato.getPuntosDanio()) {
                        // Criterio de desempate: mayor nivel
                        if (p.getNivel() > candidato.getNivel()) {
                            candidato = p;
                        }
                    }
                }
            }
        }
        return candidato;
    }

    // e) Actualizar Niveles y Eliminar Débiles de la Competición
    public boolean actualizarNivelesYEliminarDebiles(int incrementoNivel, int nivelMinimoSupervivencia) {
        if (listaJugadores == null || listaJugadores.isEmpty()) return false;

        // 1. Incrementar el nivel capado a 100
        for (PersonajeRPG p : listaJugadores) {
            int nuevoNivel = p.getNivel() + incrementoNivel;
            if (nuevoNivel > 100) {
                nuevoNivel = 100;
            }
            p.setNivel(nuevoNivel);
        }

        // 2. Filtrar y eliminar los que estén por debajo del mínimo de supervivencia
        int tamañoInicial = listaJugadores.size();
        listaJugadores.removeIf(p -> p.getNivel() < nivelMinimoSupervivencia);
        
        // 3. Reajustar contador oficial de registrados
        this.jugadoresRegistrados = listaJugadores.size();

        // Si el tamaño varió, significa que se purgó algún personaje
        return listaJugadores.size() < tamañoInicial;
    }
}
