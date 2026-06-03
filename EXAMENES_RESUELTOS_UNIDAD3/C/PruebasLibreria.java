package EXAMENES_RESUELTOS_UNIDAD3.C;

import java.util.ArrayList;

public class PruebasLibreria {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO PRUEBAS DE BIBLIOTECA DE OCASIÓN ===\n");

        // 1. Crear al menos 7 instancias de LibroSegundaMano con datos variados
        LibroSegundaMano l1 = new LibroSegundaMano("Gabriel Garcia Marquez", "Cien anos de soledad", 496, LibroSegundaMano.FORMATO_TAPA_DURA, 25.0, 15.0, 2, true, "Novela,Realismo,Magico,Clasico");
        LibroSegundaMano l2 = new LibroSegundaMano("Gabriel Garcia Marquez", "El coronel no tiene quien le escriba", 110, LibroSegundaMano.FORMATO_BOLSILLO, 12.0, 5.0, 1, false, "Novela,Drama,Clasico");
        LibroSegundaMano l3 = new LibroSegundaMano("J.K. Rowling", "Harry Potter y la piedra filosofal", 320, LibroSegundaMano.FORMATO_ILUSTRADO, 40.0, 30.0, 3, false, "Fantasia,Juvenil,Aventura");
        LibroSegundaMano l4 = new LibroSegundaMano("George Orwell", "1984", 328, LibroSegundaMano.FORMATO_BOLSILLO, 10.0, 4.5, 4, false, "Novela,Distopia,Ficcion");
        LibroSegundaMano l5 = new LibroSegundaMano("George Orwell", "Rebelion en la granja", 144, LibroSegundaMano.FORMATO_TAPA_DURA, 15.0, 8.0, 1, true, "Satira,Ficcion,Clasico");
        
        // Usando constructor vacío (Genera propiedades aleatorias)
        LibroSegundaMano l6 = new LibroSegundaMano();
        l6.autor = "Miguel de Cervantes";
        l6.setTitulo("Don Quijote de la Mancha");
        l6.setFormato(LibroSegundaMano.FORMATO_TAPA_DURA);
        l6.setPrecioVenta(20.0);
        l6.setNumeroPropietariosAnteriores(0); // Libro nuevo para probar que no entra en donaciones
        l6.setCategorias("Clasico,Aventura");

        LibroSegundaMano l7 = new LibroSegundaMano();
        l7.autor = "Desconocido";
        l7.setTitulo("Libro Misterioso");
        l7.setFormato(LibroSegundaMano.FORMATO_BOLSILLO);
        l7.setPrecioVenta(3.50);
        l7.setNumeroPropietariosAnteriores(5); // Muy usado
        l7.setCategorias("Misterio");

        // 2. Mostrar el toString() de al menos dos libros diferentes
        System.out.println("--- MOSTRANDO TOSTRING() DE DOS LIBROS ---");
        System.out.println(l1);
        System.out.println();
        System.out.println(l4);
        System.out.println("\n------------------------------------------\n");

        // Preparar fondo inicial para la biblioteca 1
        ArrayList<LibroSegundaMano> listaInicial = new ArrayList<>();
        listaInicial.add(l1);
        listaInicial.add(l2);
        listaInicial.add(l3);
        listaInicial.add(l4);

        // 3. Crear al menos 2 instancias de BibliotecaOcasion
        BibliotecaOcasion bibliotecaPrincipal = new BibliotecaOcasion("BIB-001", "El Libro Dormido", listaInicial, "Cadiz", 0.30, true);
        BibliotecaOcasion bibliotecaVacia = new BibliotecaOcasion(); // Segunda instancia usando constructor vacío

        System.out.println("--- PROBANDO FUNCIONES DE BIBLIOTECAOCASION ---");

        // Función a) Calcular ingresos totales potenciales
        System.out.printf("a) Ingresos Totales Potenciales (Incluye Bonus Dedicatorias): %.2f EUR\n", bibliotecaPrincipal.calcularIngresosTotalesPotenciales());

        // Función b) Buscar libros por categoría y propietarios máximos
        String catBuscar = "Clasico";
        int maxProp = 2;
        System.out.println("\nb) Buscando libros con categoria '" + catBuscar + "' y maximo " + maxProp + " propietarios:");
        ArrayList<LibroSegundaMano> resultadoBusqueda = bibliotecaPrincipal.buscarLibrosPorCategoriaYPropietarios(catBuscar, maxProp);
        for (LibroSegundaMano libro : resultadoBusqueda) {
            System.out.println("   - " + libro.getTitulo() + " (Propietarios: " + libro.getNumeroPropietariosAnteriores() + ")");
        }

        // Función c) Calcular precio medio por formato (Uso de Streams obligatorio)
        String formatoBuscar = LibroSegundaMano.FORMATO_BOLSILLO;
        System.out.printf("\nc) [STREAMS] Precio medio de venta para el formato %s: %.2f EUR\n", formatoBuscar, bibliotecaPrincipal.calcularPrecioMedioLibrosPorFormato(formatoBuscar));

        // Función d) Ingresar lote de donación
        ArrayList<LibroSegundaMano> loteDonacion = new ArrayList<>();
        loteDonacion.add(l5); // Propietarios = 1 (Aceptado)
        loteDonacion.add(l6); // Propietarios = 0 (Rechazado por ser nuevo)
        loteDonacion.add(l7); // Propietarios = 5 (Aceptado)

        System.out.println("\nd) Espacio maximo antes de donacion: " + bibliotecaPrincipal.getEspacioMaximoLibros() + " | Libros en catalogo: " + bibliotecaPrincipal.getFondoLibros().size());
        int librosAceptados = bibliotecaPrincipal.ingresarLoteDonacion(loteDonacion);
        System.out.println("   Libros efectivamente aceptados del lote de donacion: " + librosAceptados);
        System.out.println("   Libros totales en catalogo ahora: " + bibliotecaPrincipal.getFondoLibros().size());

        // Función e) Libro más barato por autor
        String autorBuscar = "Gabriel Garcia Marquez";
        System.out.println("\ne) Buscando el libro mas barato de '" + autorBuscar + "':");
        LibroSegundaMano masBarato = bibliotecaPrincipal.libroMasBaratoPorAutor(autorBuscar);
        if (masBarato != null) {
            System.out.println("   -> " + masBarato.getTitulo() + " | Precio Venta: " + masBarato.getPrecioVenta() + " EUR");
        }

        // Función f) Retirar libros saturados (Hacer al final para no alterar las colecciones de arriba)
        int minPropRetirar = 3;
        String formatoRetirar = LibroSegundaMano.FORMATO_BOLSILLO;
        System.out.println("\nf) Retirando libros con " + minPropRetirar + " o mas propietarios en formato " + formatoRetirar + "...");
        int retirados = bibliotecaPrincipal.retirarLibrosSaturados(minPropRetirar, formatoRetirar);
        System.out.println("   Libros retirados: " + retirados);
        System.out.println("   Fondo final de libros restantes en el local: " + bibliotecaPrincipal.getFondoLibros().size());
        
        System.out.println("\n=== FIN DE LAS PRUEBAS ===");
    }
}