package EXAMENES_RESUELTOS_UNIDAD3.FUNCIONES;

import java.util.ArrayList;

/**
 * ARCHIVO MAESTRO DE ESTUDIO: 50 FUNCIONES DE EXAMEN
 * Contiene resoluciones algorítmicas basadas en las estructuras de los exámenes A, B y C.
 */
public class FuncionesExamenMaestro {

    // =========================================================================
    // --- SECCIÓN: ALGORITMOS BASADOS EN EL EXAMEN A (Juegos y Exposiciones) ---
    // =========================================================================

    // 1. Calcula el precio medio de videojuegos físicos de una consola [Examen A - Streams obligatorio]
    public double calcularPrecioMedioFisicos(ArrayList<JuegoRetro> juegos, String consola) {
        return juegos.stream()
                .filter(j -> !j.isEsDigital() && j.getConsola().equalsIgnoreCase(consola))
                .mapToDouble(JuegoRetro::getPrecioActual)
                .average().orElse(0.0);
    }

    // 2. Filtra juegos con nota muy baja aplicando validación de rango [Examen A]
    public ArrayList<JuegoRetro> obtenerJuegosMuyCriticados(ArrayList<JuegoRetro> juegos, double notaMaxima) {
        if (notaMaxima < 0 || notaMaxima > 10) return new ArrayList<>(); // Validación obligatoria
        ArrayList<JuegoRetro> resultado = new ArrayList<>();
        for (JuegoRetro j : juegos) {
            if (j.getPuntuacionCritica() <= notaMaxima) resultado.add(j);
        }
        return resultado;
    }

    // 3. Modifica precios aplicando un descuento porcentual por año límite [Examen A]
    public boolean aplicarDescuentoAniversario(ArrayList<JuegoRetro> juegos, int anioLimite, double porcentaje) {
        boolean modificado = false;
        for (JuegoRetro j : juegos) {
            if (j.getAnioLanzamiento() < anioLimite) {
                j.setPrecioActual(j.getPrecioActual() * (1 - porcentaje));
                modificado = true;
            }
        }
        return modificado;
    }

    // 4. Busca el juego más antiguo de un tipo. Si hay empate, elige el más caro [Examen A - Algoritmo de desempate]
    public JuegoRetro buscarMasAntiguoPorTipo(ArrayList<JuegoRetro> juegos, int tipoBuscado) {
        JuegoRetro antiguo = null;
        for (JuegoRetro j : juegos) {
            if (j.getTipoJuego() == tipoBuscado) {
                if (antiguo == null || j.getAnioLanzamiento() < antiguo.getAnioLanzamiento()) {
                    antiguo = j;
                } else if (j.getAnioLanzamiento() == antiguo.getAnioLanzamiento()) {
                    if (j.getPrecioActual() > antiguo.getPrecioActual()) antiguo = j; // Criterio de desempate
                }
            }
        }
        return antiguo;
    }

    // 5. Duplica objetos que cumplan una condición de texto dentro del mismo ArrayList [Examen A]
    public int duplicarEdicionesEspeciales(ArrayList<JuegoRetro> juegos) {
        ArrayList<JuegoRetro> duplicados = new ArrayList<>();
        for (JuegoRetro j : juegos) {
            if (j.getCaracteristicasEspeciales().contains("Edicion Coleccionista")) duplicados.add(j);
        }
        juegos.addAll(duplicados);
        return duplicados.size();
    }

    // 6. Transfiere elementos filtrados de una lista de origen a una de destino [Examen A]
    public boolean transferirJuegos(ArrayList<JuegoRetro> origen, ArrayList<JuegoRetro> destino, int tipo) {
        List<JuegoRetro> filtrados = origen.stream().filter(j -> j.getTipoJuego() == tipo).collect(Collectors.toList());
        destino.addAll(filtrados);
        return origen.removeIf(j -> j.getTipoJuego() == tipo);
    }

    // 7. Cuenta elementos analizando subcadenas cortadas por un delimitador (;) [Examen A]
    public int contarJuegosMultiplesCaracteristicas(ArrayList<JuegoRetro> juegos, int min) {
        int cont = 0;
        for (JuegoRetro j : juegos) {
            if (j.getCaracteristicasEspeciales().split(";").length >= min) cont++;
        }
        return cont;
    }

    // 8. Extrae una lista de elementos de texto eliminando duplicados mediante un Set [Examen A]
    public ArrayList<String> obtenerConsolasUnicas(ArrayList<JuegoRetro> juegos) {
        HashSet<String> set = new HashSet<>();
        for (JuegoRetro j : juegos) set.add(j.getConsola());
        return new ArrayList<>(set);
    }

    // 9. Encuentra el objeto con el ratio matemático más alto (Calidad/Precio) [Examen A - Streams]
    public JuegoRetro obtenerMasEquilibrado(ArrayList<JuegoRetro> juegos) {
        return juegos.stream()
                .max(Comparator.comparingDouble(j -> j.getPuntuacionCritica() / j.getPrecioActual()))
                .orElse(null);
    }

    // 10. Purga (elimina) elementos que cumplan dos condiciones excluyentes combinadas [Examen A]
    public void purgarJuegos(ArrayList<JuegoRetro> juegos, double precioL, double notaM) {
        juegos.removeIf(j -> j.getPrecioActual() > precioL && j.getPuntuacionCritica() < notaM);
    }

    // 11. Cuenta elementos usando dos filtros lógicos simultáneos [Examen A - Streams obligatorio]
    public int contarDigitales(ArrayList<JuegoRetro> juegos, String consola) {
        return (int) juegos.stream().filter(j -> j.getConsola().equalsIgnoreCase(consola) && j.isEsDigital()).count();
    }

    // 12. Intercambia atributos entre dos objetos localizados por su código único [Examen A]
    public boolean intercambiarPrecios(ArrayList<JuegoRetro> juegos, String c1, String c2) {
        JuegoRetro j1 = null, j2 = null;
        for (JuegoRetro j : juegos) {
            if (j.getCodigoJuego().equals(c1)) j1 = j;
            if (j.getCodigoJuego().equals(c2)) j2 = j;
        }
        if (j1 != null && j2 != null) {
            double temp = j1.getPrecioActual();
            j1.setPrecioActual(j2.getPrecioActual());
            j2.setPrecioActual(temp);
            return true;
        }
        return false;
    }

    // 13. Lógica matemática de negocio aplicando descuentos condicionales por booleanos [Examen A]
    public double calcularRecaudacion(int entradas, double precio, boolean competitivo) {
        double total = entradas * precio;
        return competitivo ? total * 0.90 : total;
    }

    // 14. Extrae los 3 objetos con el atributo numérico más alto ordenados descendentemente [Examen A - Streams]
    public ArrayList<JuegoRetro> top3Caros(ArrayList<JuegoRetro> juegos) {
        return (ArrayList<JuegoRetro>) juegos.stream()
                .sorted(Comparator.comparingDouble(JuegoRetro::getPrecioActual).reversed())
                .limit(3).collect(Collectors.toList());
    }

    // 15. Modifica de forma masiva un String y devuelve el número de filas afectadas [Examen A]
    public int actualizarConsola(ArrayList<JuegoRetro> juegos, String v, String n) {
        int cont = 0;
        for (JuegoRetro j : juegos) {
            if (j.getConsola().equalsIgnoreCase(v)) { j.setConsola(n); cont++; }
        }
        return cont;
    }

    // 16. Comprueba si existe al menos un elemento que cumpla un valor exacto [Examen A - Streams match]
    public boolean hayJuegoPerfecto(ArrayList<JuegoRetro> juegos) {
        return juegos.stream().anyMatch(j -> j.getPuntuacionCritica() == 10.0);
    }

    // 17. Acumula la suma total de costes filtrando por categoría numérica [Examen A - Streams]
    public double inversionPorTipo(ArrayList<JuegoRetro> juegos, int tipo) {
        return juegos.stream().filter(j -> j.getTipoJuego() == tipo).mapToDouble(JuegoRetro::getPrecioActual).sum();
    }


    // =========================================================================
    // --- SECCIÓN: ALGORITMOS BASADOS EN EL EXAMEN B (Personajes y Torneos) ---
    // =========================================================================

    // 18. Filtra objetos que pertenezcan a varios tipos numéricos a la vez [Examen B]
    public ArrayList<PersonajeRPG> filtrarSoporte(ArrayList<PersonajeRPG> personajes) {
        return (ArrayList<PersonajeRPG>) personajes.stream()
                .filter(p -> (p.getTipoClase() == 2 || p.getTipoClase() == 3) && p.getPuntosVida() > 2500)
                .collect(Collectors.toList());
    }

    // 19. Busca registros por coincidencia exacta y los renombra masivamente [Examen B]
    public boolean fusionarGremios(ArrayList<PersonajeRPG> personajes, String ori, String des) {
        boolean mod = false;
        for (PersonajeRPG p : personajes) {
            if (p.getGuildName().equals(ori)) { p.setGuildName(des); mod = true; }
        }
        return mod;
    }

    // 20. Divide cadenas por comas (,) y acumula la longitud total de los arrays resultantes [Examen B]
    public int contarHabilidadesGremio(ArrayList<PersonajeRPG> personajes, String gremio) {
        int total = 0;
        for (PersonajeRPG p : personajes) {
            if (p.getGuildName().equals(gremio)) total += p.getHabilidades().split(",").length;
        }
        return total;
    }

    // 21. Encuentra el máximo valor. Si hay empate, prioriza el que tenga un flag activo [Examen B - Desempate por boolean]
    public PersonajeRPG encontrarTanque(ArrayList<PersonajeRPG> personajes) {
        PersonajeRPG tanque = null;
        for (PersonajeRPG p : personajes) {
            if (tanque == null || p.getPuntosVida() > tanque.getPuntosVida()) tanque = p;
            else if (p.getPuntosVida() == tanque.getPuntosVida() && p.isEsLegendario()) tanque = p;
        }
        return tanque;
    }

    // 22. Encuentra el valor flotante más alto dentro de un grupo numérico específico [Examen B - Streams]
    public double danioMaxClase(ArrayList<PersonajeRPG> personajes, int clase) {
        return personajes.stream().filter(p -> p.getTipoClase() == clase)
                .mapToDouble(PersonajeRPG::getPuntosDanio).max().orElse(0.0);
    }

    // 23. Cambia un flag booleano a falso para objetos por debajo de un umbral numérico [Examen B]
    public int degradarLegendarios(ArrayList<PersonajeRPG> personajes, int lvlMax) {
        int cont = 0;
        for (PersonajeRPG p : personajes) {
            if (p.isEsLegendario() && p.getNivel() <= lvlMax) { p.setEsLegendario(false); cont++; }
        }
        return cont;
    }

    // 24. Realiza búsquedas de texto ignorando mayúsculas con control preventivo de nulos [Examen B]
    public ArrayList<PersonajeRPG> buscarHabilidad(ArrayList<PersonajeRPG> personajes, String skill) {
        if (skill == null || skill.isEmpty()) return new ArrayList<>(); // Control de fallos
        return (ArrayList<PersonajeRPG>) personajes.stream()
                .filter(p -> p.getHabilidades().toLowerCase().contains(skill.toLowerCase()))
                .collect(Collectors.toList());
    }

    // 25. Aplica reducciones numéricas protegiendo que el atributo no baje de un suelo mínimo [Examen B]
    public boolean balancear(ArrayList<PersonajeRPG> personajes, int clase, double reduccion) {
        boolean mod = false;
        for (PersonajeRPG p : personajes) {
            if (p.getTipoClase() == clase) {
                p.setPuntosDanio(Math.max(10.0, p.getPuntosDanio() - reduccion)); // Suelo mínimo de seguridad
                mod = true;
            }
        }
        return mod;
    }

    // 26. Elimina registros vacíos del ArrayList devolviendo la diferencia de tamaño [Examen B]
    public int expulsarSinGremio(ArrayList<PersonajeRPG> personajes) {
        int inicial = personajes.size();
        personajes.removeIf(p -> p.getGuildName() == null || p.getGuildName().isEmpty());
        return inicial - personajes.size();
    }

    // 27. Saca la media aritmética de un atributo entero filtrando por estado booleano [Examen B - Streams]
    public double mediaNivelLegendarios(ArrayList<PersonajeRPG> personajes) {
        return personajes.stream().filter(PersonajeRPG::isEsLegendario)
                .mapToInt(PersonajeRPG::getNivel).average().orElse(0.0);
    }

    // 28. Busca un objeto por identificador entero y modifica su String concatenándole un prefijo [Examen B]
    public boolean promover(ArrayList<PersonajeRPG> personajes, int id) {
        for (PersonajeRPG p : personajes) {
            if (p.getIdPersonaje() == id && p.getNivel() == 50) {
                p.setHabilidades("Liderazgo, " + p.getHabilidades());
                return true;
            }
        }
        return false;
    }

    // 29. Retorna una lista condicionada por un flag de activación externo y un valor mínimo [Examen B]
    public ArrayList<PersonajeRPG> participantesValidos(ArrayList<PersonajeRPG> p, boolean ranked, int min) {
        if (!ranked) return new ArrayList<>(p);
        return (ArrayList<PersonajeRPG>) p.stream().filter(jug -> jug.getNivel() >= min).collect(Collectors.toList());
    }

    // 30. Calcula el valor absoluto de la diferencia entre dos sumatorios independientes [Examen B - Streams]
    public double diferenciaDanio(ArrayList<PersonajeRPG> personajes, int cA, int cB) {
        double d1 = personajes.stream().filter(p -> p.getTipoClase() == cA).mapToDouble(PersonajeRPG::getPuntosDanio).sum();
        double d2 = personajes.stream().filter(p -> p.getTipoClase() == cB).mapToDouble(PersonajeRPG::getPuntosDanio).sum();
        return Math.abs(d1 - d2); // Uso de Math.abs para asegurar valor positivo
    }

    // 31. Modifica en lote los atributos de un subgrupo crítico usando expresiones lambda [Examen B]
    public void resucitar(ArrayList<PersonajeRPG> personajes, int restaura) {
        personajes.stream().filter(p -> p.getPuntosVida() < 500).forEach(p -> p.setPuntosVida(p.getPuntosVida() + restaura));
    }

    // 32. Valida mediante cálculo porcentual si un grupo de texto supera la mitad de la lista [Examen B]
    public boolean esDominante(ArrayList<PersonajeRPG> personajes, String gremio) {
        long cont = personajes.stream().filter(p -> p.getGuildName().equals(gremio)).count();
        return cont > (personajes.size() / 2);
    }

    // 33. Clona un subconjunto de elementos filtrados por un entero exacto sin alterar el origen [Examen B]
    public ArrayList<PersonajeRPG> extraerCopias(ArrayList<PersonajeRPG> personajes, int lvl) {
        return (ArrayList<PersonajeRPG>) personajes.stream().filter(p -> p.getNivel() == lvl).collect(Collectors.toList());
    }


    // =========================================================================
    // --- SECCIÓN: ALGORITMOS BASADOS EN EL EXAMEN C (Librería de Ocasión) ----
    // =========================================================================

    // 34. Busca por cadena de identidad, valida un umbral numérico y aplica descuento [Examen C]
    public double descuentoDesgaste(ArrayList<LibroSegundaMano> libros, String isbn) {
        for (LibroSegundaMano l : libros) {
            if (l.getIsbn().equals(isbn) && l.getNumeroPropietariosAnteriores() >= 3) {
                l.setPrecioVenta(l.getPrecioVenta() * 0.85);
                return l.getPrecioVenta();
            }
        }
        return -1;
    }

    // 35. Cuenta cuántos objetos emparejan con una constante y superan un precio límite [Examen C - Streams]
    public int contarTapaDuraCaros(ArrayList<LibroSegundaMano> libros, double precioL) {
        return (int) libros.stream().filter(l -> l.getFormato().equals("TAPA_DURA") && l.getPrecioVenta() > precioL).count();
    }

    // 36. Agrega elementos de una lista externa controlando de forma estricta un tope máximo [Examen C]
    public boolean reponer(ArrayList<LibroSegundaMano> fondo, ArrayList<LibroSegundaMano> donados, int max) {
        for (LibroSegundaMano l : donados) {
            if (fondo.size() >= max) return false; // Freno por desbordamiento de espacio
            fondo.add(l);
        }
        return true;
    }

    // 37. Filtro avanzado de 3 niveles: igualdad de texto, flag activo y cálculo matemático [Examen C]
    public ArrayList<LibroSegundaMano> buscarJoyas(ArrayList<LibroSegundaMano> libros, String autor) {
        return (ArrayList<LibroSegundaMano>) libros.stream()
                .filter(l -> l.getAutor().equalsIgnoreCase(autor) && l.isTieneDedicatoria() && l.getPrecioVenta() < (l.getPrecioEditorial() * 0.5))
                .collect(Collectors.toList());
    }

    // 38. Reemplaza palabras dentro de una cadena de categorías y cuenta los cambios [Examen C]
    public int unificarCat(ArrayList<LibroSegundaMano> libros, String v, String n) {
        int c = 0;
        for (LibroSegundaMano l : libros) {
            if (l.getCategorias().contains(v)) { l.setCategorias(l.getCategorias().replace(v, n)); c++; }
        }
        return c;
    }

    // 39. Simula un balance contable restando sumas proporcionales basadas en un porcentaje [Examen C]
    public double margenReal(ArrayList<LibroSegundaMano> libros, double porcentaje) {
        double totalVenta = libros.stream().mapToDouble(LibroSegundaMano::getPrecioVenta).sum();
        double totalCoste = libros.stream().mapToDouble(l -> l.getPrecioEditorial() * porcentaje).sum();
        return totalVenta - totalCoste;
    }

    // 40. Busca el objeto máximo usando encadenamiento de dos comparadores numéricos [Examen C - Streams]
    public LibroSegundaMano masLeido(ArrayList<LibroSegundaMano> libros) {
        return libros.stream().max(Comparator.comparingInt(LibroSegundaMano::getNumeroPropietariosAnteriores)
                .thenComparingInt(LibroSegundaMano::getNumeroPaginas)).orElse(null);
    }

    // 41. Retorna elementos de un formato específico por debajo de una tarifa fija [Examen C]
    public ArrayList<LibroSegundaMano> bolsilloBaratos(ArrayList<LibroSegundaMano> libros) {
        return (ArrayList<LibroSegundaMano>) libros.stream()
                .filter(l -> l.getFormato().equals("BOLSILLO") && l.getPrecioVenta() < 6.0)
                .collect(Collectors.toList());
    }

    // 42. Borra los elementos situados en la primera posición (índice 0) de forma iterativa [Examen C]
    public int retirarEspacio(ArrayList<LibroSegundaMano> libros, int cant) {
        int eliminados = 0;
        while (eliminados < cant && !libros.isEmpty()) { 
            libros.remove(0); // Purgado físico frontal
            eliminados++; 
        }
        return eliminados;
    }

    // 43. Verifica si existen códigos idénticos usando la propiedad de unicidad de un HashSet [Examen C]
    public boolean hayIsbnDuplicado(ArrayList<LibroSegundaMano> libros) {
        HashSet<String> isbns = new HashSet<>();
        for (LibroSegundaMano l : libros) {
            if (!isbns.add(l.getIsbn())) return true; // Si add() devuelve false, está duplicado
        }
        return false;
    }

    // 44. Saca la media de páginas filtrando por una constante de formato literal [Examen C - Streams]
    public double mediaPaginasIlustrados(ArrayList<LibroSegundaMano> libros) {
        return libros.stream().filter(l -> l.getFormato().equals("ILUSTRADO"))
                .mapToInt(LibroSegundaMano::getNumeroPaginas).average().orElse(0.0);
    }

    // 45. Incrementa de forma generalizada un valor decimal a todos los ítems de la lista [Examen C]
    public int inflacion(ArrayList<LibroSegundaMano> libros, double extra) {
        libros.forEach(l -> l.setPrecioVenta(l.getPrecioVenta() + extra));
        return libros.size();
    }

    // 46. Filtra objetos que mantengan a cero un contador específico de uso [Examen C]
    public ArrayList<LibroSegundaMano> obtenerNuevos(ArrayList<LibroSegundaMano> libros) {
        return (ArrayList<LibroSegundaMano>) libros.stream().filter(l -> l.getNumeroPropietariosAnteriores() == 0).collect(Collectors.toList());
    }

    // 47. Verifica si el volumen actual excede el 90% de la capacidad límite permitida [Examen C]
    public boolean saturacion(ArrayList<LibroSegundaMano> libros, int max) {
        return libros.size() > (max * 0.9);
    }

    // 48. Encuentra el objeto con el precio más alto dentro de una categoría de texto [Examen C - Streams]
    public LibroSegundaMano masCaroCat(ArrayList<LibroSegundaMano> libros, String cat) {
        return libros.stream().filter(l -> l.getCategorias().contains(cat))
                .max(Comparator.comparingDouble(LibroSegundaMano::getPrecioVenta)).orElse(null);
    }

    // 49. Elimina de golpe todos los elementos pertenecientes a un autor [Examen C]
    public int vaciarAutor(ArrayList<LibroSegundaMano> libros, String autor) {
        int inicial = libros.size();
        libros.removeIf(l -> l.getAutor().equalsIgnoreCase(autor));
        return inicial - libros.size();
    }

    // 50. Fuerza un cambio masivo de tarifas a un valor fijo por liquidación total [Examen C]
    public void liquidar(ArrayList<LibroSegundaMano> libros, double p) {
        libros.forEach(l -> l.setPrecioVenta(p));
    }
}
