package UNIDAD3.ExamenUnidad3;

import java.util.ArrayList;

public class ExposicionRetro {
    //Examen de Alejandro David Wood Rodríguez

    private int idExposicion;

    public int getidExposicion() {
        return idExposicion;
    }

    public void setidExposicion(int idExposicion) {
        this.idExposicion = idExposicion;
    }

    String nombreEvento;

    private ArrayList<JuegoRetro> juegosExhibidos;

    public ArrayList<JuegoRetro> getjuegosExhibidos() {
        return juegosExhibidos;
    }

    public void setjuegosExhibidos(ArrayList<JuegoRetro> juegosExhibidos) {
        this.juegosExhibidos = juegosExhibidos;
    }

    private String localizacion;

    public String getlocalizacion() {
        return localizacion;
    }

    public void setlocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    private int entradasVendidas;

    public int getentradasVendidas() {
        return entradasVendidas;
    }

    public void setentradasVendidas(int entradasVendidas) {
        this.entradasVendidas = entradasVendidas;
    }

    private double precioEntrada;

    public double getprecioEntrada() {
        return precioEntrada;
    }

    public void setprecioEntrada(double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    private boolean esCompetitivo;

    public boolean getesCompetitivo() {
        return esCompetitivo;
    }

    public void setesCompetitivo(boolean esCompetitivo) {
        this.esCompetitivo = esCompetitivo;
    }

    public ExposicionRetro() {
        this.idExposicion = (int)(Math.random() * 9000) + 1000;
        this.nombreEvento = "";
        this.juegosExhibidos = new ArrayList<JuegoRetro>();
        this.localizacion = "";
        this.entradasVendidas = (int)Math.random() * 5001;
        this.precioEntrada = (Math.random() * 41) + 10;
        this.esCompetitivo = false;
    }
}
