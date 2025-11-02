package gestiondeequipos;
    
    import java.util.ArrayList;
    import java.util.Scanner;

public class InterfazUsuario {
    
    private Scanner scanner; //El scanner que va a leer los datos introducidos por el usuario
    
    public InterfazUsuario() { //Constructor que solamente instancia un nuevo scanner
        this.scanner = new Scanner(System.in);
    }
    
    // Lee una opción del menú
    public int leerOpcion() {
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

    // Lee texto del usuario
    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    //Lee un decimal
    public double leerDouble(String mensaje) {
        System.out.print(mensaje);
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }

    //Para leer enteros
    public int leerInt(String mensaje) {
        System.out.print(mensaje);
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }

    // Sirve para leer los datos que va a enviar el usuario utilizando los métodos de leer.
    public String getIdentificador() {
        return leerTexto("ID: ");
    }

    public String getNombre() {
        return leerTexto("Nombre: ");
    }

    public String getTipo() {
        return leerTexto("Tipo: ");
    }

    public String getFabricante() {
        return leerTexto("Fabricante: ");
    }

    public double getConsumoElectrico() {
        return leerDouble("Consumo eléctrico (W): ");
    }

    public String getResumenCaracteristicas() {
        return leerTexto("Resumen de características: ");
    }


    // Método para mostrar una lista de equipos
    public void mostrarListaEquipos(ArrayList<Equipo> equipos) {
        System.out.println("\nTotal de equipos: " + equipos.size());
        System.out.println("---------------------------------------------------------------------------");

        for (int i = 0; i < equipos.size(); i++) {
            System.out.println((i + 1) + ". " + equipos.get(i).toString());
        }
    }

    // Método principal que ejecuta el sistema
    public void ejecutar(ControladorGestionador controlador) {
        int opcion = -1;

        while (opcion != 0) {
            mostrarMenu();
            opcion = leerOpcion();

            if (opcion == 1) {
                opcionListarEquipos(controlador);
            } else if (opcion == 2) {
                opcionBuscarPorIdentificador(controlador);
            } else if (opcion == 3) {
                opcionBuscarPorNombre(controlador);
            } else if (opcion == 4) {
                opcionOrdenarPorConsumo(controlador);
            } else if (opcion == 5) {
                opcionAgregarEquipo(controlador);
            } else if (opcion == 0) {
                System.out.println("\n¡Gracias por usar el sistema! Hasta pronto.");
            } else {
                System.out.println("Opción inválida. Por favor intente de nuevo.");
            }

            //Me di cuenta que esto es completamente necesario porque si no lo que pediste queda impreso atrás del menú y ni cuenta te das que se imprimió algo antes del menú
            if (opcion != 0) {
                System.out.println("\nPresione ENTER para continuar..."); 
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    // Muestra el menú principal
    private void mostrarMenu() {
        System.out.println("\n" + "*****************************************************************************");
        System.out.println("   SISTEMA DE GESTIÓN DE EQUIPOS DE LABORATORIO");
        System.out.println("*****************************************************************************");
        System.out.println("1. Listar todos los equipos");
        System.out.println("2. Buscar equipo por identificador");
        System.out.println("3. Buscar equipos por nombre");
        System.out.println("4. Ordenar equipos por consumo eléctrico");
        System.out.println("5. Agregar nuevo equipo");
        System.out.println("0. Salir");
        System.out.println("---------------------------------------------------------------------------");
        System.out.print("Seleccione una opción: ");
    }

    // Opción 1: Listar todos los equipos
    private void opcionListarEquipos(ControladorGestionador controlador) {
        System.out.println("\n" + "---------------------------------------------------------------------------");
        System.out.println("           LISTADO DE TODOS LOS EQUIPOS");
        System.out.println("---------------------------------------------------------------------------");

        ArrayList<Equipo> equipos = controlador.listarEquipos();

        if (equipos.isEmpty()) {
            System.out.println("No hay equipos registrados en el sistema.");
        } else {
            mostrarListaEquipos(equipos);
        }
    }

    // Opción 2: Buscar por identificador
    private void opcionBuscarPorIdentificador(ControladorGestionador controlador) {
        System.out.println("\n" + "---------------------------------------------------------------------------");
        System.out.println("         BUSCAR EQUIPO POR IDENTIFICADOR");
        System.out.println("---------------------------------------------------------------------------");

        String id = leerTexto("Ingrese el identificador del equipo: ");
        Equipo equipo = controlador.buscarEquipo(id);

        if (equipo == null) {
            System.out.println("No se encontró ningún equipo con el identificador: " + id);
        } else {
            System.out.println("\n¡Equipo encontrado!");
            System.out.println(equipo.mostrarDetalles());
        }
    }

    // Opción 3: Buscar por nombre
    private void opcionBuscarPorNombre(ControladorGestionador controlador) {
        System.out.println("\n" + "---------------------------------------------------------------------------");
        System.out.println("           BUSCAR EQUIPOS POR NOMBRE");
        System.out.println("---------------------------------------------------------------------------");

        String nombre = leerTexto("Ingrese el nombre (o parte del nombre) del equipo: ");
        ArrayList<Equipo> resultados = controlador.buscarEquipo(nombre, true);

        if (resultados.isEmpty()) {
            System.out.println("No se encontraron equipos con el nombre: " + nombre);
        } else {
            System.out.println("\nSe encontraron " + resultados.size() + " equipo(s):");
            mostrarListaEquipos(resultados);
        }
    }

    // Opción 4: Ordenar por consumo
    private void opcionOrdenarPorConsumo(ControladorGestionador controlador) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("      EQUIPOS ORDENADOS POR CONSUMO ELÉCTRICO");
        System.out.println("---------------------------------------------------------------------------");

        controlador.ordenarPorConsumo();
        ArrayList<Equipo> equiposOrdenados = controlador.listarEquipos();

        if (equiposOrdenados.isEmpty()) {
            System.out.println("No hay equipos para ordenar.");
        } else {
            mostrarListaEquipos(equiposOrdenados);
        }
    }

    // Opción 5: Agregar nuevo equipo
    private void opcionAgregarEquipo(ControladorGestionador controlador) {
        System.out.println("\n" + "---------------------------------------------------------------------------");
        System.out.println("            AGREGAR NUEVO EQUIPO");
        System.out.println("---------------------------------------------------------------------------");

        System.out.println("\nSeleccione el tipo de equipo a agregar:");
        System.out.println("1. Péndulo");
        System.out.println("2. Osciloscopio");
        System.out.println("3. Generador de Señales");
        System.out.println("4. Fuente de Poder");
        System.out.println("5. Simulador de Movimiento");
        System.out.println("6. Simulador de Circuitos");
        System.out.println("7. Simulador de Ondas");
        System.out.println("8. Analizador de Espectro");
        System.out.println("9. Analizador de Datos");
        System.out.println("10. Cronómetro");
        System.out.println("0. Cancelar");

        int tipo = leerOpcion();

        if (tipo == 0) {
            System.out.println("Operación cancelada.");
            return;
        }

        Equipo nuevoEquipo = null;
        
        //Según el tipo de equipo deseado crea un equipo de ese tipo
        if (tipo == 1) {
            nuevoEquipo = crearPendulo();
        } else if (tipo == 2) {
            nuevoEquipo = crearOsciloscopio();
        } else if (tipo == 3) {
            nuevoEquipo = crearGeneradorSenales();
        } else if (tipo == 4) {
            nuevoEquipo = crearFuentePoder();
        } else if (tipo == 5) {
            nuevoEquipo = crearSimuladorMovimiento();
        } else if (tipo == 6) {
            nuevoEquipo = crearSimuladorCircuitos();
        } else if (tipo == 7) {
            nuevoEquipo = crearSimuladorOndas();
        } else if (tipo == 8) {
            nuevoEquipo = crearAnalizadorEspectro();
        } else if (tipo == 9) {
            nuevoEquipo = crearAnalizadorDatos();
        } else if (tipo == 10) {
            nuevoEquipo = crearCronometro();
        } else {
            System.out.println("Tipo de equipo inválido.");
            return;
        }

        if (nuevoEquipo != null) {
            boolean agregado = controlador.agregarEquipo(nuevoEquipo);
            if (agregado) {
                System.out.println("\n¡Equipo agregado exitosamente!");
                System.out.println("\nDetalles del equipo agregado:");
                System.out.println(nuevoEquipo.mostrarDetalles());
            } else {
                System.out.println("Ya existe un equipo con ese identificador.");
            }
        }
    }

    

// Métodos que se utilizan para crear los nuevos objetos de equipo  separados del método principal para que no sea enorme el método.
    
    
    private Pendulo crearPendulo() {
        System.out.println("\n--- Datos del Péndulo ---");
        String id = leerTexto("ID: ");
        String nombre = leerTexto("Nombre: ");
        String fabricante = leerTexto("Fabricante: ");
        double consumo = leerDouble("Consumo eléctrico (W): ");
        double longitud = leerDouble("Longitud de cuerda (m): ");
        double masa = leerDouble("Masa del bob (kg): ");
        double precision = leerDouble("Precisión (s): ");
        String rango = leerTexto("Rango de medición: ");
        String tipoMed = leerTexto("Tipo de medición: ");

        return new Pendulo(id, nombre, fabricante, consumo, longitud, masa, precision, rango, tipoMed);
    }

    private Osciloscopio crearOsciloscopio() {
        System.out.println("\n--- Datos del Osciloscopio ---");
        String id = leerTexto("ID: ");
        String nombre = leerTexto("Nombre: ");
        String fabricante = leerTexto("Fabricante: ");
        double consumo = leerDouble("Consumo eléctrico (W): ");
        int canales = leerInt("Número de canales: ");
        double banda = leerDouble("Ancho de banda (MHz): ");
        double precision = leerDouble("Precisión (%): ");
        String rango = leerTexto("Rango de medición: ");
        String tipoMed = leerTexto("Tipo de medición: ");

        return new Osciloscopio(id, nombre, fabricante, consumo, canales, banda, precision, rango, tipoMed);
    }

    private GeneradorSenales crearGeneradorSenales() {
        System.out.println("\n--- Datos del Generador de Señales ---");
        String id = leerTexto("ID: ");
        String nombre = leerTexto("Nombre: ");
        String fabricante = leerTexto("Fabricante: ");
        double consumo = leerDouble("Consumo eléctrico (W): ");
        double frecMax = leerDouble("Frecuencia máxima (Hz): ");
        double ampMax = leerDouble("Amplitud máxima (Vpp): ");
        double potMax = leerDouble("Potencia máxima (W): ");
        String tipoGen = leerTexto("Tipo de generación: ");
        String rango = leerTexto("Rango de operación: ");

        return new GeneradorSenales(id, nombre, fabricante, consumo, frecMax, ampMax, potMax, tipoGen, rango);
    }

    private FuentePoder crearFuentePoder() {
        System.out.println("\n--- Datos de la Fuente de Poder ---");
        String id = leerTexto("ID: ");
        String nombre = leerTexto("Nombre: ");
        String fabricante = leerTexto("Fabricante: ");
        double consumo = leerDouble("Consumo eléctrico (W): ");
        double voltMax = leerDouble("Voltaje máximo (V): ");
        double corrMax = leerDouble("Corriente máxima (A): ");
        String tipoGen = leerTexto("Tipo de generación: ");
        String rango = leerTexto("Rango de operación: ");

        return new FuentePoder(id, nombre, fabricante, consumo, voltMax, corrMax, tipoGen, rango);
    }

    private SimuladorMovimiento crearSimuladorMovimiento() {
        System.out.println("\n--- Datos del Simulador de Movimiento ---");
        String id = leerTexto("ID: ");
        String nombre = leerTexto("Nombre: ");
        String fabricante = leerTexto("Fabricante: ");
        double consumo = leerDouble("Consumo eléctrico (W): ");
        String version = leerTexto("Versión de software: ");
        String tipoSim = leerTexto("Tipo de simulación: ");
        String plataforma = leerTexto("Plataforma: ");
        int paquetes = leerInt("Número de paquetes: ");

        return new SimuladorMovimiento(id, nombre, fabricante, consumo, version, tipoSim, plataforma, paquetes);
    }

    private SimuladorCircuitos crearSimuladorCircuitos() {
        System.out.println("\n--- Datos del Simulador de Circuitos ---");
        String id = leerTexto("ID: ");
        String nombre = leerTexto("Nombre: ");
        String fabricante = leerTexto("Fabricante: ");
        double consumo = leerDouble("Consumo eléctrico (W): ");
        String version = leerTexto("Versión de software: ");
        String tipoSim = leerTexto("Tipo de simulación: ");
        String plataforma = leerTexto("Plataforma: ");
        int componentes = leerInt("Número de componentes: ");

        return new SimuladorCircuitos(id, nombre, fabricante, consumo, version, tipoSim, plataforma, componentes);
    }

    private SimuladorOndas crearSimuladorOndas() {
        System.out.println("\n--- Datos del Simulador de Ondas ---");
        String id = leerTexto("ID: ");
        String nombre = leerTexto("Nombre: ");
        String fabricante = leerTexto("Fabricante: ");
        double consumo = leerDouble("Consumo eléctrico (W): ");
        String version = leerTexto("Versión de software: ");
        String tipoSim = leerTexto("Tipo de simulación: ");
        String plataforma = leerTexto("Plataforma: ");
        String resolucion = leerTexto("Resolución gráfica: ");

        return new SimuladorOndas(id, nombre, fabricante, consumo, version, tipoSim, plataforma, resolucion);
    }

    private AnalizadorEspectro crearAnalizadorEspectro() {
        System.out.println("\n--- Datos del Analizador de Espectro ---");
        String id = leerTexto("ID: ");
        String nombre = leerTexto("Nombre: ");
        String fabricante = leerTexto("Fabricante: ");
        double consumo = leerDouble("Consumo eléctrico (W): ");
        double freqMin = leerDouble("Frecuencia mínima (Hz): ");
        double freqMax = leerDouble("Frecuencia máxima (Hz): ");
        String resolucion = leerTexto("Resolución: ");
        String capacidad = leerTexto("Capacidad de análisis: ");
        String tipoAnal = leerTexto("Tipo de análisis: ");

        return new AnalizadorEspectro(id, nombre, fabricante, consumo, freqMin, freqMax, resolucion, capacidad, tipoAnal);
    }

    private AnalizadorDatos crearAnalizadorDatos() {
        System.out.println("\n--- Datos del Analizador de Datos ---");
        String id = leerTexto("ID: ");
        String nombre = leerTexto("Nombre: ");
        String fabricante = leerTexto("Fabricante: ");
        double consumo = leerDouble("Consumo eléctrico (W): ");
        String software = leerTexto("Software base: ");
        int capacidad = leerInt("Capacidad de datos (puntos): ");
        String resolucion = leerTexto("Resolución: ");
        String capacidadAnal = leerTexto("Capacidad de análisis: ");
        String tipoAnal = leerTexto("Tipo de análisis: ");

        return new AnalizadorDatos(id, nombre, fabricante, consumo, software, capacidad, resolucion, capacidadAnal, tipoAnal);
    }

    private Cronometro crearCronometro() {
        System.out.println("\n--- Datos del Cronómetro ---");
        String id = leerTexto("ID: ");
        String nombre = leerTexto("Nombre: ");
        String fabricante = leerTexto("Fabricante: ");
        double consumo = leerDouble("Consumo eléctrico (W): ");
        double resTemp = leerDouble("Resolución temporal (s): ");
        int canales = leerInt("Número de canales: ");
        String resolucion = leerTexto("Resolución: ");
        String capacidad = leerTexto("Capacidad de análisis: ");
        String tipoAnal = leerTexto("Tipo de análisis: ");

        return new Cronometro(id, nombre, fabricante, consumo, resTemp, canales, resolucion, capacidad, tipoAnal);
    }
    
    
}
