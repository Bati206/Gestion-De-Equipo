package gestiondeequipos;

public class FuentePoder extends Equipo implements IGenerador {
    
    
     private double voltajeMaximo;
    private double corrienteMaxima;
    private double potenciaMaxima;
    private String tipoGeneracion;
    private String rangoOperacion;
    
    public FuentePoder(String id, String nombre, String fabricante, double consumo, double voltMax, double corrMax, String tipoGeneracion, String rangoOperacion) {
        super(id, nombre, "Equipo Generador - Fuente de Poder", fabricante, consumo,  "Suministra voltaje y corriente DC regulados");
        this.voltajeMaximo = voltMax;
        this.corrienteMaxima = corrMax;
        this.potenciaMaxima = voltMax * corrMax; //La potencia es el producto entre la corriente y el voltaje
        this.tipoGeneracion = tipoGeneracion;
        this.rangoOperacion = rangoOperacion;
    }
    
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
    
    public double getVoltajeMaximo() {
        return voltajeMaximo;
    }
    
    public double getCorrienteMaxima() {
        return corrienteMaxima;
    }
    
    @Override
    public String mostrarDetalles() {
        return String.format( //Le da un formato ordenadito a los detalles completos del equipo
            "========================================\n" +
            "ID: %s\n" +
            "Nombre: %s\n" +
            "Tipo: %s\n" +
            "Fabricante: %s\n" +
            "Consumo Eléctrico: %.2f W\n" +
            "Características: %s\n" +
            "--- Características Específicas ---\n" +
            "Voltaje Máximo: %.1f V\n" +
            "Corriente Máxima: %.2f A\n" +
            "Potencia Máxima: %.1f W\n" +
            "Tipo de Generación: %s\n" +
            "Rango de Operación: %s\n" +
            "========================================",
                //ARgumentos que se ingresaran en el resumen
            identificador, nombre, tipo, fabricante, consumoElectrico,
            resumenCaracteristicas, voltajeMaximo, corrienteMaxima,
            potenciaMaxima, tipoGeneracion, rangoOperacion
        );
    }
    
}
