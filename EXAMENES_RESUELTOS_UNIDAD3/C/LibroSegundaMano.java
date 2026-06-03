package EXAMENES_RESUELTOS_UNIDAD3.C;

import java.util.Random;

public class LibroSegundaMano {
    // Constantes estáticas para el formato del libro
    public static final String FORMATO_TAPA_DURA = "TAPA_DURA";
    public static final String FORMATO_BOLSILLO = "BOLSILLO";
    public static final String FORMATO_ILUSTRADO = "ILUSTRADO";

    // Atributos
    private String isbn;
    public String autor; // Público por requisito explícito
    private String titulo;
    private int numeroPaginas;
    private String formato;
    private double precioEditorial;
    private double precioVenta;
    private int numeroPropietariosAnteriores;
    private boolean tieneDedicatoria;
    private String categorias; // Guardado como String delimitado por comas

    // Constructor Vacío (Generación aleatoria)
    public LibroSegundaMano() {
        Random rand = new Random();
        this.isbn = "ISBN-" + (rand.nextInt(90000) + 10000); // 10000 a 99999
        this.autor = "";
        this.titulo = "";
        this.numeroPaginas = rand.nextInt(801) + 100; // 100 a 900
        
        // Formato aleatorio entre las constantes
        String[] formatos = {FORMATO_TAPA_DURA, FORMATO_BOLSILLO, FORMATO_ILUSTRADO};
        this.formato = formatos[rand.nextInt(formatos.length)];
        
        this.precioEditorial = 8.0 + (60.0 - 8.0) * rand.nextDouble(); // 8.0 a 60.0
        this.precioVenta = 1.0 + (40.0 - 1.0) * rand.nextDouble(); // 1.0 a 40.0
        this.numeroPropietariosAnteriores = rand.nextInt(6); // 0 a 5
        this.tieneDedicatoria = false;
        this.categorias = "";
    }

    // Constructor Completo
    public LibroSegundaMano(String autor, String titulo, int numeroPaginas, String formato, 
                            double precioEditorial, double precioVenta, int numeroPropietariosAnteriores, 
                            boolean tieneDedicatoria, String categorias) {
        Random rand = new Random();
        this.isbn = "ISBN-" + (rand.nextInt(90000) + 10000); // Autogenerado igual que en el vacío
        this.autor = autor;
        this.titulo = titulo;
        this.numeroPaginas = numeroPaginas;
        this.formato = formato;
        this.precioEditorial = precioEditorial;
        this.precioVenta = precioVenta;
        this.numeroPropietariosAnteriores = numeroPropietariosAnteriores;
        this.tieneDedicatoria = tieneDedicatoria;
        this.categorias = categorias;
    }

    // Getters y Setters
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getNumeroPaginas() { return numeroPaginas; }
    public void setNumeroPaginas(int numeroPaginas) { this.numeroPaginas = numeroPaginas; }

    public String getFormato() { return formato; }
    public void setFormato(String formato) { this.formato = formato; }

    public double getPrecioEditorial() { return precioEditorial; }
    public void setPrecioEditorial(double precioEditorial) { this.precioEditorial = precioEditorial; }

    public double getPrecioVenta() { return precioVenta; }
    public void setPrecioVenta(double precioVenta) { this.precioVenta = precioVenta; }

    public int getNumeroPropietariosAnteriores() { return numeroPropietariosAnteriores; }
    public void setNumeroPropietariosAnteriores(int numeroPropietariosAnteriores) { this.numeroPropietariosAnteriores = numeroPropietariosAnteriores; }

    public boolean isTieneDedicatoria() { return tieneDedicatoria; }
    public void setTieneDedicatoria(boolean tieneDedicatoria) { this.tieneDedicatoria = tieneDedicatoria; }

    public String getCategorias() { return categorias; }
    public void setCategorias(String categorias) { this.categorias = categorias; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Libro de Segunda Mano:<-\n");
        sb.append("** ISBN: ").append(isbn).append("\n");
        sb.append("** Autor: ").append(autor).append("\n");
        sb.append("** Titulo: ").append(titulo).append("\n");
        sb.append("** Paginas: ").append(numeroPaginas).append(" | Formato: ").append(formato).append("\n");
        sb.append(String.format("** Precio editorial: %.2f EUR | Venta: %.2f EUR\n", precioEditorial, precioVenta));
        sb.append("** Propietarios anteriores: ").append(numeroPropietariosAnteriores).append("\n");
        sb.append("** Dedicatoria: ").append(tieneDedicatoria ? "Si" : "No").append("\n");
        sb.append("** Categorias: ").append(categorias).append("->");
        return sb.toString();
    }
}