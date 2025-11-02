package gestiondeequipos;

public class AnalizadorEspectro extends Equipo implements Analizador {

    
    //Atributos
    private double rangoFrecuenciaMin;
    private double rangoFrecuenciaMax;
    private String resolucion;
    private String capacidadAnalisis;
    private String tipoAnalisis;

    
    //constructor
    public AnalizadorEspectro(String id, String nombre, String fabricante, double consumo, double freqMin, double freqMax, String resolucion, String capacidadAnalisis, String tipoAnalisis) {
        super(id, nombre, "Equipo Analizador - Espectro de Frecuencias", fabricante, consumo,"Analiza componentes espectrales de señales");
        this.rangoFrecuenciaMin = freqMin;
        this.rangoFrecuenciaMax = freqMax;
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

    public double getRangoFrecuenciaMin() {
        return rangoFrecuenciaMin;
    }

    public double getRangoFrecuenciaMax() {
        return rangoFrecuenciaMax;
    }

    
    //Los detalles a mostrar
    @Override
    public String mostrarDetalles() {
        return String.format( //Formato para mostrar los detalles
                "========================================\n"
                + "ID: %s\n"
                + "Nombre: %s\n"
                + "Tipo: %s\n"
                + "Fabricante: %s\n"
                + "Consumo Eléctrico: %.2f W\n"
                + "Características: %s\n"
                + "--- Características Específicas ---\n"
                + "Rango de Frecuencia: %.0f Hz - %.2f GHz\n"
                + "Resolución: %s\n"
                + "Capacidad de Análisis: %s\n"
                + "Tipo de Análisis: %s\n"
                + "========================================",
                identificador, nombre, tipo, fabricante, consumoElectrico,
                resumenCaracteristicas, rangoFrecuenciaMin,
                rangoFrecuenciaMax / 1e9, resolucion, capacidadAnalisis, tipoAnalisis
        );
    }
    
    
    
    
}
