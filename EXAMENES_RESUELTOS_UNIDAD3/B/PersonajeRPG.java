package EXAMENES_RESUELTOS_UNIDAD3.B;

import java.util.Random;

public class PersonajeRPG {
    // Constantes estáticas para las clases de personaje
    public static final int CLASE_GUERRERO = 1;
    public static final int CLASE_MAGO = 2;
    public static final int CLASE_ARQUERO = 3;
    public static final int CLASE_ASESINO = 4;

    // Atributos
    private int idPersonaje;
    public String nombrePersonaje; // Público por requisito explícito
    private int tipoClase; // Mapeado interno de clasePersonaje
    private int nivel;
    private int puntosVida;
    private double puntosDanio;
    private boolean esLegendario;
    private String habilidades; // Guardado como String delimitado por comas
    private String guildName;

    // Constructor Vacío (Generación aleatoria)
    public PersonajeRPG() {
        Random rand = new Random();
        this.idPersonaje = rand.nextInt(90000) + 10000; // 10000 a 99999
        this.nombrePersonaje = "";
        this.tipoClase = rand.nextInt(4) + 1; // 1 a 4
        this.nivel = rand.nextInt(50) + 1; // 1 a 50
        this.puntosVida = rand.nextInt(4001) + 1000; // 1000 a 5000
        this.puntosDanio = 50.0 + (250.0 - 50.0) * rand.nextDouble(); // 50.0 a 250.0
        this.esLegendario = false;
        this.habilidades = "";
        this.guildName = "";
    }

    // Constructor Completo
    public PersonajeRPG(String nombrePersonaje, int tipoClase, int nivel, int puntosVida, 
                        double puntosDanio, boolean esLegendario, String habilidades, String guildName) {
        Random rand = new Random();
        this.idPersonaje = rand.nextInt(90000) + 10000; // Autogenerado como en el vacío
        this.nombrePersonaje = nombrePersonaje;
        this.tipoClase = tipoClase;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
        this.puntosDanio = puntosDanio;
        this.esLegendario = esLegendario;
        this.habilidades = habilidades;
        this.guildName = guildName;
    }

    // Getters y Setters
    public int getIdPersonaje() { return idPersonaje; }
    public void setIdPersonaje(int idPersonaje) { this.idPersonaje = idPersonaje; }

    public int getTipoClase() { return tipoClase; }
    public void setTipoClase(int tipoClase) { this.tipoClase = tipoClase; }

    public int getNivel() { return nivel; }
    public void setNivel(int nivel) { this.nivel = nivel; }

    public int getPuntosVida() { return puntosVida; }
    public void setPuntosVida(int puntosVida) { this.puntosVida = puntosVida; }

    public double getPuntosDanio() { return puntosDanio; }
    public void setPuntosDanio(double puntosDanio) { this.puntosDanio = puntosDanio; }

    public boolean isEsLegendario() { return esLegendario; }
    public void setEsLegendario(boolean esLegendario) { this.esLegendario = esLegendario; }

    public String getHabilidades() { return habilidades; }
    public void setHabilidades(String habilidades) { this.habilidades = habilidades; }

    public String getGuildName() { return guildName; }
    public void setGuildName(String guildName) { this.guildName = guildName; }

    private String getNombreClase() {
        switch (this.tipoClase) {
            case CLASE_GUERRERO: return "Guerrero";
            case CLASE_MAGO: return "Mago";
            case CLASE_ARQUERO: return "Arquero";
            case CLASE_ASESINO: return "Asesino";
            default: return "Desconocido";
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== PERSONAJE RPG ===\n");
        sb.append("-> ID: ").append(idPersonaje).append("\n");
        sb.append("-> Nombre: ").append(nombrePersonaje).append("\n");
        sb.append("-> Clase: ").append(getNombreClase()).append("\n");
        sb.append("-> Nivel: ").append(nivel).append("\n");
        sb.append("-> Vida: ").append(puntosVida).append(" HP\n");
        sb.append(String.format("-> Daño: %.2f\n", puntosDanio));
        sb.append("-> Legendario: ").append(esLegendario ? "Si" : "No").append("\n");
        sb.append("-> Gremio: ").append((guildName == null || guildName.trim().isEmpty()) ? "Sin gremio" : guildName).append("\n");
        sb.append("-> Habilidades: ").append(habilidades);
        return sb.toString();
    }
}