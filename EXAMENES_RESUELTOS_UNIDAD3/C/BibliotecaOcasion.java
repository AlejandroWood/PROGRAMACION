package EXAMENES_RESUELTOS_UNIDAD3.C;

import java.util.ArrayList;
import java.util.Random;

public class BibliotecaOcasion {
    // Atributos
    private String codigoBiblioteca;
    public String nombreLocal; // Público por requisito explícito
    private ArrayList<LibroSegundaMano> fondoLibros;
    private String localidad;
    private int espacioMaximoLibros;
    private double porcentajeBeneficio;
    private boolean aceptaDonaciones;

    // Constructor Vacío
    public BibliotecaOcasion() {
        Random rand = new Random();
        this.codigoBiblioteca = "BIB-" + (rand.nextInt(900) + 100); // 100 a 999
        this.nombreLocal = "";
        this.fondoLibros = new ArrayList<>();
        this.localidad = "";
        this.espacioMaximoLibros = rand.nextInt(451) + 50; // 50 a 500
        this.porcentajeBeneficio = 0.10 + (0.50 - 0.10) * rand.nextDouble(); // 0.10 a 0.50
        this.aceptaDonaciones = false;
    }

    // Constructor Completo
    public BibliotecaOcasion(String codigoBiblioteca, String nombreLocal, ArrayList<LibroSegundaMano> fondoLibros, 
                             String localidad, double porcentajeBeneficio, boolean aceptaDonaciones) {
        this.codigoBiblioteca = codigoBiblioteca;
        this.nombreLocal = nombreLocal;
        this.fondoLibros = fondoLibros != null ? fondoLibros : new ArrayList<>();
        this.localidad = localidad;
        this.porcentajeBeneficio = porcentajeBeneficio;
        this.aceptaDonaciones = aceptaDonaciones;
        // Calculado automáticamente como el doble del tamaño del ArrayList recibido
        this.espacioMaximoLibros = this.fondoLibros.size() * 2;
    }

    // Getters y Setters
    public String getCodigoBiblioteca() { return codigoBiblioteca; }
    public void setCodigoBiblioteca(String codigoBiblioteca) { this.codigoBiblioteca = codigoBiblioteca; }

    public ArrayList<LibroSegundaMano> getFondoLibros() { return fondoLibros; }
    public void setFondoLibros(ArrayList<LibroSegundaMano> fondoLibros) { this.fondoLibros = fondoLibros; }

    public String getLocalidad() { return localidad; }
    public void setLocalidad(String localidad) { this.localidad = localidad; }

    public int getEspacioMaximoLibros() { return espacioMaximoLibros; }
    public void setEspacioMaximoLibros(int espacioMaximoLibros) { this.espacioMaximoLibros = espacioMaximoLibros; }

    public double getPorcentajeBeneficio() { return porcentajeBeneficio; }
    public void setPorcentajeBeneficio(double porcentajeBeneficio) { this.porcentajeBeneficio = porcentajeBeneficio; }

    public boolean isAceptaDonaciones() { return aceptaDonaciones; }
    public void setAceptaDonaciones(boolean aceptaDonaciones) { this.aceptaDonaciones = aceptaDonaciones; }


    // --- FUNCIONES OBLIGATORIAS ---

    // a) Calcular ingresos totales potenciales (+ bonus dedicatoria)
    public double calcularIngresosTotalesPotenciales() {
        if (fondoLibros.isEmpty()) {
            return 0.0;
        }
        double total = 0.0;
        for (LibroSegundaMano libro : fondoLibros) {
            total += libro.getPrecioVenta();
            if (libro.isTieneDedicatoria()) {
                total += 2.0; // Bonus por dedicatoria manuscrita
            }
        }
        return total;
    }

    // b) Buscar libros por categoría y propietarios máximos
    public ArrayList<LibroSegundaMano> buscarLibrosPorCategoriaYPropietarios(String categoria, int maxPropietarios) {
        ArrayList<LibroSegundaMano> filtrados = new ArrayList<>();
        
        // Validación requerida
        if (maxPropietarios < 0) {
            return filtrados; // Devuelve ArrayList vacío, nunca null
        }

        for (LibroSegundaMano libro : fondoLibros) {
            if (libro.getCategorias().toLowerCase().contains(categoria.toLowerCase()) && 
                libro.getNumeroPropietariosAnteriores() <= maxPropietarios) {
                filtrados.add(libro);
            }
        }
        return filtrados;
    }

    // c) Calcular precio medio de venta por formato (OBLIGATORIO USAR STREAMS)
    public double calcularPrecioMedioLibrosPorFormato(String formato) {
        return fondoLibros.stream()
                .filter(libro -> libro.getFormato().equalsIgnoreCase(formato))
                .mapToDouble(LibroSegundaMano::getPrecioVenta)
                .average()
                .orElse(0.0); // Devuelve 0.0 si no hay libros que cumplan el filtro
    }

    // d) Ingresar lote de donación (Filtrado por espacio y condiciones)
    public int ingresarLoteDonacion(ArrayList<LibroSegundaMano> lote) {
        if (!aceptaDonaciones) {
            return -1;
        }

        int agregados = 0;
        for (LibroSegundaMano libro : lote) {
            // Verificar si el libro no es nuevo y si queda espacio en el local
            if (libro.getNumeroPropietariosAnteriores() > 0 && fondoLibros.size() < espacioMaximoLibros) {
                fondoLibros.add(libro);
                agregados++;
            }
        }
        return agregados;
    }

    // e) Libro más barato por autor
    public LibroSegundaMano libroMasBaratoPorAutor(String autor) {
        LibroSegundaMano masBarato = null;

        for (LibroSegundaMano libro : fondoLibros) {
            if (libro.autor.equalsIgnoreCase(autor)) {
                if (masBarato == null || libro.getPrecioVenta() < masBarato.getPrecioVenta()) {
                    masBarato = libro; // En caso de empate, al usar '<' se mantiene el primero
                }
            }
        }
        return masBarato; // Devuelve null si no hay coincidencias
    }

    // f) Retirar libros saturados (Por propietarios mínimos y formato)
    public int retirarLibrosSaturados(int propietariosMinimo, String formato) {
        if (propietariosMinimo < 0 || formato == null || formato.trim().isEmpty()) {
            return 0;
        }

        int tamañoInicial = fondoLibros.size();
        fondoLibros.removeIf(libro -> libro.getNumeroPropietariosAnteriores() >= propietariosMinimo && 
                                      libro.getFormato().equalsIgnoreCase(formato));
        
        return tamañoInicial - fondoLibros.size();
    }
}