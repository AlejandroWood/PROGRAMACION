// Juan Francisco González Gómez

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.Iterator;

public class ExposicionRetro {
    // Atributos miembro
    private int idExposicion;
    public String nombreEvento;
    private ArrayList<JuegoRetro> juegosExhibidos;
    private String localizacion;
    private int entradasVendidas;
    private float precioEntrada;
    private boolean esCompetitivo;

    // Getters & Setters
    public int getIdExposicion() {
        return idExposicion;
    }
    public ArrayList<JuegoRetro> getJuegosExhibidos() {
        return juegosExhibidos;
    }
    public String getLocalizacion() {
        return localizacion;
    }
    public int getEntradasVendidas() {
        return entradasVendidas;
    }
    public float getPrecioEntrada() {
        return precioEntrada;
    }
    public boolean getEsCompetitivo() {
        return esCompetitivo;
    }

    public void setIdExposicion(int idExposicion) {
        this.idExposicion = idExposicion;
    }
    public void setJuegosExhibidos(ArrayList<JuegoRetro> juegosExhibidos) {
        this.juegosExhibidos = juegosExhibidos;
    }
    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }
    public void setEntradasVendidas(int entradasVendidas) {
        this.entradasVendidas = entradasVendidas;
    }
    public void setPrecioEntrada(float precioEntrada) {
        this.precioEntrada = precioEntrada;
    }
    public void setEsCompetitivo(boolean esCompetitivo) {
        this.esCompetitivo = esCompetitivo;
    }

    // Constructores
    public ExposicionRetro() {
        this.idExposicion = (int)(Math.random()*9000)+1000;
        this.entradasVendidas = (int)(Math.random()*5001);
        this.precioEntrada = (float)(Math.random()*41)+10f;
        this.juegosExhibidos = new ArrayList<>();
        this.nombreEvento = "";
        this.localizacion = "";
        this.esCompetitivo = false;
    }

    public ExposicionRetro(
        int idExposicion, int entradasVendidas, float precioEntrada, ArrayList<JuegoRetro> juegosExhibidos,
        String nombreEvento, String localizacion, boolean esCompetitivo
    ) {
        this.idExposicion = idExposicion;
        this.entradasVendidas = entradasVendidas;
        this.precioEntrada = precioEntrada;
        this.juegosExhibidos = juegosExhibidos;
        this.nombreEvento = nombreEvento;
        this.localizacion = localizacion;
        this.esCompetitivo = esCompetitivo;
    }

    // toString
    public String toString() {
        return "Exposición Retro:\n" +
            "<-\n" +
            String.format(
                "** ID: %d\n" +
                "** Entradas vendidas: %d\n" +
                "** Precio entrada: %.2f€ - Localización: %s\n" +
                "** Nombre: %s\n" +
                "** Torneos: %s\n" +
                "** Juegos Exhibidos: %s\n",
                this.idExposicion,
                this.entradasVendidas,
                this.precioEntrada,
                this.localizacion,
                this.nombreEvento,
                (esCompetitivo)?"Sí":"No",
                this.juegosExhibidos.toString()
            ) +
            "->";

    }

    // Otros métodos
    public double calcularValorTotalColeccion() {
        if (this.juegosExhibidos.isEmpty()) return 0.0;
        return this.juegosExhibidos.stream().mapToDouble(JuegoRetro::getPrecioActual).sum();
    }

    public ArrayList<JuegoRetro> buscarJuegosPorConsolaYRangoPuntuacion(
        String consola, double minPuntuacion, double maxPuntuacion
    ) {
        if (minPuntuacion < 0 || maxPuntuacion > 10 || maxPuntuacion < minPuntuacion) return new ArrayList<JuegoRetro>();
        return this.juegosExhibidos
                .stream()
                .filter(
                    j -> j.getConsola().equals(consola) &&
                    j.getPuntuacionCritica() >= minPuntuacion &&
                    j.getPuntuacionCritica() <= maxPuntuacion
                )
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public int cantidadJuegosBaratos(String consola) {
        return (int) this.juegosExhibidos
                .stream()
                .filter(
                    j -> j.getConsola().equals(consola) &&
                    j.getPrecioActual() > 10
                )
                .count();
    }

    public int eliminarJuegosPorTipo(int tipoEliminar) {
        Iterator<JuegoRetro> juegosIt = juegosExhibidos.iterator();
        int juegosEliminados = 0;
        while (juegosIt.hasNext()) {
            JuegoRetro juego = juegosIt.next();
            if (juego.getTipoJuego() == tipoEliminar) {
                juegosIt.remove();
                juegosEliminados++;
            }
        }
        return juegosEliminados;
    }

    public JuegoRetro juegoMejorValoracionConCaracteristica(String caracteristicaBuscada) {
        if (
            juegosExhibidos
                .stream()
                .filter(j -> j.getCaracteristicasEspeciales().contains(caracteristicaBuscada.toLowerCase()))
                .count() == 0
        ) {
            return null;
        } else {
            return juegosExhibidos
                .stream()
                .filter(j -> j.getCaracteristicasEspeciales().contains(caracteristicaBuscada.toLowerCase()))
                .sorted(Comparator.comparing(JuegoRetro::getPuntuacionCritica))
                .collect(Collectors.toCollection(ArrayList::new))
                .get(0);
        }   
    }
}