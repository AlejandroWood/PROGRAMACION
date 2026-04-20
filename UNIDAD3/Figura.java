package UNIDAD3;

// Esta clase es abstracta, esto implica que no puedo crear objetos de ella
// Su objetivo es que sus clases hijas se implementen
abstract class Figura {
    public String color;

    public Figura(String color) {
        this.color = color;
    }

    // Al definir como abstracta una funcion, obligo a sus clases hijas a que implementen esta función
    abstract public double calcularArea();

    abstract public double calcularPerimetro();

    public void mostrarColor() {
        System.out.println("El color de esta figura es: " + this.color);
    }
}
