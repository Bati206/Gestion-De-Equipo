package gestiondeequipos;

public class AnalizadorDatos extends Equipo implements Analizador {

    
    //Atributos
    private String softwareBase;
    private int capacidadDatos;
    private String resolucion;
    private String capacidadAnalisis;
    private String tipoAnalisis;

    
    
    
    //Constructor
    public AnalizadorDatos(String id, String nombre, String fabricante, double consumo, String software, int capacidad, String resolucion, String capacidadAnalisis, String tipoAnalisis) {
        super(id, nombre, "Equipo Analizador - Procesamiento de Datos", fabricante, consumo,"Software para análisis estadístico y procesamiento de datos");
        this.softwareBase = software;
        this.capacidadDatos = capacidad;
        this.resolucion = resolucion;
        this.capacidadAnalisis = capacidadAnalisis;
        this.tipoAnalisis = tipoAnalisis;
    }

    
    
    //Getters
    @Override
    public String getResolucion() {
        return resolucion;
    }

    @Override
    public String getCapacidadAnalisis() {
        return capacidadAnalisis;
    }

    @Override
    public String getTipoAnalisis() {
        return tipoAnalisis;
    }

    public String getSoftwareBase() {
        return softwareBase;
    }

    public int getCapacidadDatos() {
        return capacidadDatos;
    }

    
    
    
    
    //Muestra todos los detalles
    @Override
    public String mostrarDetalles() {
        return String.format(
                "========================================\n"
                + "ID: %s\n"
                + "Nombre: %s\n"
                + "Tipo: %s\n"
                + "Fabricante: %s\n"
                + "Consumo Eléctrico: %.2f W\n"
                + "Características: %s\n"
                + "--- Características Específicas ---\n"
                + "Software Base: %s\n"
                + "Capacidad de Datos: %d puntos\n"
                + "Resolución: %s\n"
                + "Capacidad de Análisis: %s\n"
                + "Tipo de Análisis: %s\n"
                + "========================================",
                identificador, nombre, tipo, fabricante, consumoElectrico,
                resumenCaracteristicas, softwareBase, capacidadDatos,
                resolucion, capacidadAnalisis, tipoAnalisis
        );
    }
    
    
    
    
}
