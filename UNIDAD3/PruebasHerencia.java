package UNIDAD3;

public class PruebasHerencia {
    public static void main(String[] args) {
        Animal hormiga = new Animal();
        Perro aura = new Perro();

        aura.nombre = "Aura";

        hormiga.cagar();
        aura.ladrar();

        aura.cagar();

        
    }
}
