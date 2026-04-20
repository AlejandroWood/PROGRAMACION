// Juan Francisco González Gómez
import java.util.ArrayList;

public class JuegoRetro{
    // Constantes
    public final static int PLATAFORMAS = 1;
    public final static int LUCHA = 2;
    public final static int AVENTURAS = 3;
    public final static int SHOOTER = 4;

    // Atributos miembro
    private String codigoJuego;
    public String titulo;
    private String consola;
    private int anioLanzamiento;
    private float precioActual;
    private float puntuacionCritica;
    private int tipoJuego;
    private boolean esDigital;
    private ArrayList<String> caracteristicasEspeciales;

    // Getters & Setters
    public String getCodigoJuego() {
        return this.codigoJuego;
    }   
    public String getConsola() {
        return this.consola;
    }   
    public int getAnioLanzamiento() {
        return this.anioLanzamiento;
    }   
    public float getPrecioActual() {
        return this.precioActual;
    }   
    public float getPuntuacionCritica() {
        return this.puntuacionCritica;
    }     
    public int getTipoJuego() {
        return this.tipoJuego;
    }       
    public boolean getEsDigital() {
        return this.esDigital;
    }       
    public ArrayList<String> getCaracteristicasEspeciales() {
        return this.caracteristicasEspeciales;
    }

    public void setCodigoJuego(String codigoJuego) {
        this.codigoJuego = codigoJuego;
    }
    public void setConsola(String consola) {
        this.consola = consola;
    }
    public void setAnioLanamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }
    public void setPrecioActual(float precioActual) {
        this.precioActual = precioActual;
    }
    public void setPuntuacionCritica(float puntuacionCritica) {
        this.puntuacionCritica = puntuacionCritica;
    }
    public void setTipoJuego(int tipoJuego) {
        this.tipoJuego = tipoJuego;
    }
    public void setEsDigital(boolean esDigital) {
        this.esDigital = esDigital;
    }    
    public void setCaracteristicasEspeciales(ArrayList<String> caracteristicasEspeciales) {
        this.caracteristicasEspeciales = caracteristicasEspeciales;
    }

    // Constructores
    public JuegoRetro() {
        this.codigoJuego = "RET-" + Integer.toString((int)(Math.random() * 800 + 100));
        this.anioLanzamiento = (int)(Math.random() * 20) + 1980;
        this.precioActual = (float)Math.random() * 480 + 20;
        this.puntuacionCritica = (float)Math.random() * 5 + 5;
        this.titulo = "";
        this.consola = "";
        this.caracteristicasEspeciales = new ArrayList<String>();
        this.esDigital = false;
        this.tipoJuego = (int)(Math.random() * 4) + 1;
    }

    public JuegoRetro(
        int anioLanzamiento, float precioActual, float puntuacionCritica, String titulo,
        String consola, ArrayList<String> caracteristicasEspeciales, boolean esDigital, int tipoJuego
    ) {
        this.codigoJuego = "RET-" + Integer.toString((int)(Math.random() * 800 + 100));
        this.anioLanzamiento = anioLanzamiento;
        this.precioActual = precioActual;
        this.puntuacionCritica = puntuacionCritica;
        this.titulo = titulo;
        this.consola = consola;
        this.caracteristicasEspeciales = caracteristicasEspeciales;
        this.esDigital = esDigital;
        this.tipoJuego = tipoJuego;
    }   

    // toString
    public String toString() {
        String tipoJuego = "";
        switch (this.tipoJuego) {
            case JuegoRetro.PLATAFORMAS:
                tipoJuego = "Plataformas";
                break;
            case JuegoRetro.LUCHA:
                tipoJuego = "Lucha";
                break;
            case JuegoRetro.AVENTURAS:
                tipoJuego = "Aventuras";
                break;
            case JuegoRetro.SHOOTER:
                tipoJuego = "Shooter";
                break;
        }
        return "Juego Retro:\n" +
            "<-\n" +
            String.format(
                "** Código: %s\n" +
                "** Título: %s\n" +
                "** Consola: %s - Año: %d\n" +
                "** Precio: %.2f€\n" +
                "** Puntuación: %.1f/10\n" +
                "** Tipo: %s\n" +
                "** Digital: %s\n" +
                "** Características: %s\n",
                this.codigoJuego,
                this.titulo,
                this.consola,
                this.anioLanzamiento,
                this.precioActual,
                this.puntuacionCritica,
                tipoJuego,
                (esDigital)?"Sí":"No",
                this.caracteristicasEspeciales.toString()
            ) +
            "->";

    }       
}