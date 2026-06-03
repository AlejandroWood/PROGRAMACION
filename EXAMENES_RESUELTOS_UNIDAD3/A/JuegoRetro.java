package EXAMENES_RESUELTOS_UNIDAD3.A;

import java.util.Random;

public class JuegoRetro {
    // Constantes estáticas para el tipo de juego
    public static final int PLATAFORMA = 1; // Ajustado sutilmente de PLATAFORMAS para legibilidad
    public static final int LUCHA = 2;
    public static final int AVENTURAS = 3;
    public static final int SHOOTER = 4;

    // Atributos
    private String codigoJuego;
    public String titulo; // Público por requisito explícito
    private String consola;
    private int anioLanzamiento;
    private double precioActual;
    private double puntuacionCritica;
    private int tipoJuego;
    private boolean esDigital;
    private String caracteristicasEspeciales; // Guardado como String delimitado por ';'

    // Constructor Vacío (Generación aleatoria)
    public JuegoRetro() {
        Random rand = new Random();
        this.codigoJuego = "RET-" + (rand.nextInt(900) + 100); // 100 a 999
        this.titulo = "";
        this.consola = "";
        this.anioLanzamiento = rand.nextInt(20) + 1980; // 1980 a 1999
        this.precioActual = 20.0 + (500.0 - 20.0) * rand.nextDouble(); // 20.0 a 500.0
        this.puntuacionCritica = 5.0 + (10.0 - 5.0) * rand.nextDouble(); // 5.0 a 10.0
        this.tipoJuego = rand.nextInt(4) + 1; // 1 a 4
        this.esDigital = false;
        this.caracteristicasEspeciales = "";
    }

    // Constructor Completo
    public JuegoRetro(String titulo, String consola, int anioLanzamiento, double precioActual, 
                      double puntuacionCritica, int tipoJuego, boolean esDigital, String caracteristicasEspeciales) {
        Random rand = new Random();
        this.codigoJuego = "RET-" + (rand.nextInt(900) + 100);
        this.titulo = titulo;
        this.consola = consola;
        this.anioLanzamiento = anioLanzamiento;
        this.precioActual = precioActual;
        this.puntuacionCritica = puntuacionCritica;
        this.tipoJuego = tipoJuego;
        this.esDigital = esDigital;
        this.caracteristicasEspeciales = caracteristicasEspeciales;
    }

    // Getters y Setters
    public String getCodigoJuego() { return codigoJuego; }
    public void setCodigoJuego(String codigoJuego) { this.codigoJuego = codigoJuego; }

    public String getConsola() { return consola; }
    public void setConsola(String consola) { this.consola = consola; }

    public int getAnioLanzamiento() { return anioLanzamiento; }
    public void setAnioLanzamiento(int anioLanzamiento) { this.anioLanzamiento = anioLanzamiento; }

    public double getPrecioActual() { return precioActual; }
    public void setPrecioActual(double precioActual) { this.precioActual = precioActual; }

    public double getPuntuacionCritica() { return puntuacionCritica; }
    public void setPuntuacionCritica(double puntuacionCritica) { this.puntuacionCritica = puntuacionCritica; }

    public int getTipoJuego() { return tipoJuego; }
    public void setTipoJuego(int tipoJuego) { this.tipoJuego = tipoJuego; }

    public boolean isEsDigital() { return esDigital; }
    public void setEsDigital(boolean esDigital) { this.esDigital = esDigital; }

    public String getCaracteristicasEspeciales() { return caracteristicasEspeciales; }
    public void setCaracteristicasEspeciales(String caracteristicasEspeciales) { this.caracteristicasEspeciales = caracteristicasEspeciales; }

    private String getNombreTipo() {
        switch (this.tipoJuego) {
            case PLATAFORMA: return "Plataformas";
            case LUCHA: return "Lucha";
            case AVENTURAS: return "Aventuras";
            case SHOOTER: return "Shooter";
            default: return "Desconocido";
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Juego Retro:\n<-\n");
        sb.append("** Código: ").append(codigoJuego).append("\n");
        sb.append("** Título: ").append(titulo).append("\n");
        sb.append("** Consola: ").append(consola).append(" Año: ").append(anioLanzamiento).append("\n");
        sb.append(String.format("** Precio: %.2f€\n", precioActual));
        sb.append(String.format("** Puntuación: %.1f/10\n", puntuacionCritica));
        sb.append("** Tipo: ").append(getNombreTipo()).append("\n");
        sb.append("** Digital: ").append(esDigital ? "Sí" : "No").append("\n");
        sb.append("** Características: ").append(caracteristicasEspeciales).append("\n->");
        return sb.toString();
    }
}
