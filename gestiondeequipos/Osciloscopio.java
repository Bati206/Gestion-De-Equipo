package gestiondeequipos;
public class Osciloscopio extends Equipo implements IMedidor {
    
    private int numeroCanales;
    private double anchoBanda;
    private double precision;
    private String rangoMedicion;
    private String tipoMedicion;
    
    //La misma idea, pide todos los datos expecto el tipo (ya que obviamente es un osciloscopio) y el resumen de caracteristicas que es general para cada tipo de equipo.
    public Osciloscopio(String id, String nombre, String fabricante, double consumo, int canales, double banda, double precision, String rangoMedicion, String tipoMedicion) {
        super(id, nombre, "Equipo de Medición - Osciloscopio", fabricante, consumo, "Visualiza y mide señales eléctricas");
        this.numeroCanales = canales;
        this.anchoBanda = banda;
        this.precision = precision;
        this.rangoMedicion = rangoMedicion;
        this.tipoMedicion = tipoMedicion;
    }

    
    //Getters
    @Override
    public double getPrecision() {
        return precision;
    }

    @Override
    public String getRangoMedicion() {
        return rangoMedicion;
    }

    @Override
    public String getTipoMedicion() {
        return tipoMedicion;
    }

    public int getNumeroCanales() {
        return numeroCanales;
    }

    public double getAnchoBanda() {
        return anchoBanda;
    }
    
    @Override
    public String mostrarDetalles() { //Le da un formato un nuevo formato para que se vea ordenado
        return String.format(
            "========================================\n" +
            "ID: %s\n" +
            "Nombre: %s\n" +
            "Tipo: %s\n" +
            "Fabricante: %s\n" +
            "Consumo Eléctrico: %.2f W\n" +
            "Características: %s\n" +
            "--- Características Específicas ---\n" +
            "Número de Canales: %d\n" +
            "Ancho de Banda: %.0f MHz\n" +
            "Precisión: ±%.2f%%\n" +
            "Rango de Medición: %s\n" +
            "Tipo de Medición: %s\n" +
            "========================================",
                //Aquí están los argumentos que se utilizarán en orden
            identificador, nombre, tipo, fabricante, consumoElectrico,
            resumenCaracteristicas, numeroCanales, anchoBanda, precision,
            rangoMedicion, tipoMedicion
        );
    }
}
    
