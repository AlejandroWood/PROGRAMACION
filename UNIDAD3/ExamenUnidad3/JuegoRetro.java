package UNIDAD3.ExamenUnidad3;

import java.util.ArrayList;

public class JuegoRetro {
    //Examen de Alejandro David Wood Rodríguez

    public static final int PLATAFORMAS = 1;
    public static final int LUCHA = 2;
    public static final int AVENTURAS = 3;
    public static final int SHOOTER = 4;

    private int codigoJuego;

    public int getcodigoJuego() {
        return codigoJuego;
    }

    public void setcodigoJuego(int codigoJuego) {
        this.codigoJuego = codigoJuego;
    }

    public String titulo;

    private String consola;

    public String getconsola() {
        return consola;
    }

    public void setconsola(String consola) {
        this.consola = consola;
    }

    private int anioLanzamiento;

    public int getanioLanzamiento() {
        return anioLanzamiento;
    }

    public void setanioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    private double precioActual;

    public double getprecioActual() {
        return precioActual;
    }

    public void setprecioActual(double precioActual) {
        this.precioActual = precioActual;
    }

    private double puntuacionCritica;

    public double getpuntuacionCritica() {
        return puntuacionCritica;
    }

    public void setpuntuacionCritica(double puntuacionCritica) {
        this.puntuacionCritica = puntuacionCritica;
    }

    private int tipoJuego;

    public int gettipoJuego() {
        return tipoJuego;
    }

    public void settipoJuego(int tipoJuego) {
        this.tipoJuego = tipoJuego;
    }

    private boolean esDigital;

    public boolean getesDigital() {
        return esDigital;
    }

    public void setesDigital(boolean esDigital) {
        this.esDigital = esDigital;
    }

    private ArrayList<JuegoRetro> caracteristicasEspeciales;

    public ArrayList<JuegoRetro> getcaracteristicasEspeciales() {
        return caracteristicasEspeciales;
    }

    public void setcaracteristicasEspeciales(ArrayList<JuegoRetro> caracteristicasEspeciales) {
        this.caracteristicasEspeciales = caracteristicasEspeciales;
    }

    public JuegoRetro() {
        this.titulo = "";
        this.codigoJuego = (int)(Math.random() * 899) + 101;
        this.consola = "";
        this.anioLanzamiento = (int)(Math.random() * 31) + 1970;
        this.precioActual = Math.random() * 481 + 20;
        this.puntuacionCritica = (Math.random() * 6) + 5;
        this.tipoJuego = (int) (Math.random() * 4) + 1;
        this.caracteristicasEspeciales = new ArrayList<JuegoRetro>();
        this.esDigital = false;
    }

    @Override
    public String toString() {
        String tipoJuegoString = null;
        String codigoJuegoString;
        String esDigitalString;

        // Convertir el número del tipoJuego a texto
        switch (tipoJuego) {
            case PLATAFORMAS:
                tipoJuegoString = "Plataformas";
                break;
            case LUCHA:
                tipoJuegoString = "Lucha";
                break;
            case AVENTURAS:
                tipoJuegoString = "Aventuras";
                break;
            case SHOOTER:
                tipoJuegoString = "Shooter";
                break;
        }

        if (consola == "NES") {
            codigoJuegoString = "NES";
        } else if (consola == "Arcade") {
            codigoJuegoString = "ARC";
        } else {
            codigoJuegoString = "MEG";
        }

        if (esDigital) {
            esDigitalString = "Sí";
        } else {
            esDigitalString = "No";
        }

        codigoJuegoString = codigoJuegoString + codigoJuego;

        return "Juego Retro:\n" +
                "<-\n" +
                "** Código: " + codigoJuegoString + "\n" +
                "** Título: " + titulo + "\n" +
                "** Consola: " + consola + " - Año: " + anioLanzamiento + "\n" +
                "** Precio: " + precioActual + "€\n" +
                "** Puntuación: " + puntuacionCritica + "/10\n" +
                "** Tipo: " + tipoJuegoString + "\n" +
                "** Digital: " + esDigitalString + "\n" +
                "** Características: " + caracteristicasEspeciales + "\n" +
                "\n" +
                "->";
    }
}
