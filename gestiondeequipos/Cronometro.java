package gestiondeequipos;

public class Cronometro extends Equipo implements IAnalizador {
    
    //Atributos
    private double resolucionTemporal;
    private int numeroCanales;
    private String resolucion;
    private String capacidadAnalisis;
    private String tipoAnalisis;    
    
    //Constructor
    public Cronometro(String id, String nombre, String fabricante, double consumo, double resTemp, int canales, String resolucion, String capacidadAnalisis, String tipoAnalisis) {
        super(id, nombre, "Equipo Analizador - Cronometraje Digital", fabricante, consumo,"Medición precisa de intervalos de tiempo");
        this.resolucionTemporal = resTemp;
        this.numeroCanales = canales;
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
    
    public double getResolucionTemporal() {
        return resolucionTemporal;
    }
    
    public int getNumeroCanales() {
        return numeroCanales;
    }
    
    
    
    //Detalles del equipo
    @Override
    public String mostrarDetalles() {
        return String.format(
            "========================================\n" +
            "ID: %s\n" +
            "Nombre: %s\n" +
            "Tipo: %s\n" +
            "Fabricante: %s\n" +
            "Consumo Eléctrico: %.2f W\n" +
            "Características: %s\n" +
            "--- Características Específicas ---\n" +
            "Resolución Temporal: %.4f s\n" +
            "Número de Canales: %d\n" +
            "Resolución: %s\n" +
            "Capacidad de Análisis: %s\n" +
            "Tipo de Análisis: %s\n" +
            "========================================",
            identificador, nombre, tipo, fabricante, consumoElectrico,
            resumenCaracteristicas, resolucionTemporal, numeroCanales,
            resolucion, capacidadAnalisis, tipoAnalisis
        );
    }
}