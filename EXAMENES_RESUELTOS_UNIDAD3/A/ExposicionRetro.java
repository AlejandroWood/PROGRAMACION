package EXAMENES_RESUELTOS_UNIDAD3.A;

import java.util.ArrayList;
import java.util.Random;

public class ExposicionRetro {
    // Atributos
    private int idExposicion;
    public String nombreEvento; // Público por requisito explicito
    private ArrayList<JuegoRetro> juegosExhibidos;
    private String localizacion;
    private int entradasVendidas;
    private double precioEntrada;
    private boolean esCompetitivo;

    // Constructor Vacío
    public ExposicionRetro() {
        Random rand = new Random();
        this.idExposicion = rand.nextInt(9000) + 1000; // 1000 a 9999
        this.nombreEvento = "";
        this.juegosExhibidos = new ArrayList<>();
        this.localizacion = "";
        this.entradasVendidas = rand.nextInt(5001); // 0 a 5000
        this.precioEntrada = 10.0 + (50.0 - 10.0) * rand.nextDouble(); // 10.0 a 50.0
        this.esCompetitivo = false;
    }

    // Constructor Completo
    public ExposicionRetro(int idExposicion, String nombreEvento, ArrayList<JuegoRetro> juegosExhibidos, 
                           String localizacion, double precioEntrada, boolean esCompetitivo) {
        this.idExposicion = idExposicion;
        this.nombreEvento = nombreEvento;
        this.juegosExhibidos = juegosExhibidos != null ? juegosExhibidos : new ArrayList<>();
        this.localizacion = localizacion;
        this.precioEntrada = precioEntrada;
        this.esCompetitivo = esCompetitivo;
        // Se calcula automáticamente según el tamaño del ArrayList recibido
        this.entradasVendidas = this.juegosExhibidos.size(); 
    }

    // Getters y Setters
    public int getIdExposicion() { return idExposicion; }
    public void setIdExposicion(int idExposicion) { this.idExposicion = idExposicion; }

    public ArrayList<JuegoRetro> getJuegosExhibidos() { return juegosExhibidos; }
    public void setJuegosExhibidos(ArrayList<JuegoRetro> juegosExhibidos) { this.juegosExhibidos = juegosExhibidos; }

    public String getLocalizacion() { return localizacion; }
    public void setLocalizacion(String localizacion) { this.localizacion = localizacion; }

    public int getEntradasVendidas() { return entradasVendidas; }
    public void setEntradasVendidas(int entradasVendidas) { this.entradasVendidas = entradasVendidas; }

    public double getPrecioEntrada() { return precioEntrada; }
    public void setPrecioEntrada(double precioEntrada) { this.precioEntrada = precioEntrada; }

    public boolean isEsCompetitivo() { return esCompetitivo; }
    public void setEsCompetitivo(boolean esCompetitivo) { this.esCompetitivo = esCompetitivo; }


    // --- FUNCIONES OBLIGATORIAS ---

    // a) Calcular valor total de la colección
    public double calcularValorTotalColeccion() {
        double total = 0.0;
        for (JuegoRetro juego : juegosExhibidos) {
            total += juego.getPrecioActual();
        }
        return total;
    }

    // b) Buscar juegos por consola y rango de puntuación (Con validaciones)
    public ArrayList<JuegoRetro> buscarJuegosPorConsolaYRangoPuntuacion(String consola, double minPuntuacion, double maxPuntuacion) {
        ArrayList<JuegoRetro> filtrados = new ArrayList<>();
        
        // Validaciones requeridas
        if (minPuntuacion < 0 || maxPuntuacion > 10 || maxPuntuacion < minPuntuacion) {
            return filtrados; // Devuelve lista vacía, nunca null
        }

        for (JuegoRetro juego : juegosExhibidos) {
            if (juego.getConsola().equalsIgnoreCase(consola) && 
                juego.getPuntuacionCritica() >= minPuntuacion && 
                juego.getPuntuacionCritica() <= maxPuntuacion) {
                filtrados.add(juego);
            }
        }
        return filtrados;
    }

    // c) Cantidad de juegos baratos (Uso obligatorio de STREAMS)
    public int cantidadJuegosBaratos(String consola) {
        return (int) juegosExhibidos.stream()
                .filter(juego -> juego.getConsola().equalsIgnoreCase(consola))
                .filter(juego -> juego.getPrecioActual() < 10.0)
                .count();
    }

    // d) Eliminar juegos por tipo
    public int eliminarJuegosPorTipo(int tipoEliminar) {
        int inicial = juegosExhibidos.size();
        juegosExhibidos.removeIf(juego -> juego.getTipoJuego() == tipoEliminar);
        return inicial - juegosExhibidos.size();
    }

    // e) Juego mejor valoracion con característica
    public JuegoRetro juegoMejorValoracionConCaracteristica(String caracteristicaBuscada) {
        JuegoRetro mejorJuego = null;
        double maxPunt = -1.0;

        for (JuegoRetro juego : juegosExhibidos) {
            if (juego.getCaracteristicasEspeciales().toLowerCase().contains(caracteristicaBuscada.toLowerCase())) {
                if (juego.getPuntuacionCritica() > maxPunt) {
                    maxPunt = juego.getPuntuacionCritica();
                    mejorJuego = juego;
                }
            }
        }
        return mejorJuego; // Si no hay coincidencias devuelve null
    }
}