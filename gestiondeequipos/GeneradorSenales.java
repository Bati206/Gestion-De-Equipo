package gestiondeequipos;
public class GeneradorSenales extends Equipo implements IGenerador {
    
    //Atributos
    private double frecuenciaMaxima;
    private double amplitudMaxima;
    private double potenciaMaxima;
    private String tipoGeneracion;
    private String rangoOperacion;
    
    //Constructor normalito con todos los datos y con tipo y resumen generales.
    public GeneradorSenales(String id, String nombre, String fabricante, double consumo, double frecMax, double ampMax, double potMax, String tipoGeneracion, String rangoOperacion) {
        super(id, nombre, "Equipo Generador - Señales", fabricante, consumo, "Genera señales de distintas formas de onda");
        this.frecuenciaMaxima = frecMax;
        this.amplitudMaxima = ampMax;
        this.potenciaMaxima = potMax;
        this.tipoGeneracion = tipoGeneracion;
        this.rangoOperacion = rangoOperacion;
    }
    
    
    //Getters
    @Override
    public double getPotenciaMaxima() {
        return potenciaMaxima;
    }

    @Override
    public String getTipoGeneracion() {
        return tipoGeneracion;
    }

    @Override
    public String getRangoOperacion() {
        return rangoOperacion;
    }

    public double getFrecuenciaMaxima() {
        return frecuenciaMaxima;
    }

    public double getAmplitudMaxima() {
        return amplitudMaxima;
    }
    
    
    //Da un formato y la manera correcta de imprimir los detalles
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
                + "Frecuencia Máxima: %.2f MHz\n"
                + "Amplitud Máxima: %.2f Vpp\n"
                + "Potencia Máxima: %.2f W\n"
                + "Tipo de Generación: %s\n"
                + "Rango de Operación: %s\n"
                + "========================================",
                identificador, nombre, tipo, fabricante, consumoElectrico,
                resumenCaracteristicas, frecuenciaMaxima / 1e6, amplitudMaxima,
                potenciaMaxima, tipoGeneracion, rangoOperacion
        );
    }
    
    
}
