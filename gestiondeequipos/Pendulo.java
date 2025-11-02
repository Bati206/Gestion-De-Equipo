package gestiondeequipos;
public class Pendulo extends Equipo implements IMedidor {

    private double longitudCuerda;
    private double masaBob;
    private double precision;
    private String rangoMedicion;
    private String tipoMedicion;
            
            public Pendulo(String id, String nombre, String fabricante, double consumo, double longitud, double masa, double precision, String rangoMedicion, String tipoMedicion) {  //Con los datos recopilados se crea una instancia del objeto
        super(id, nombre, "Equipo de Medición - Péndulo", fabricante, consumo, "Mide periodo y frecuencia de oscilación"); //Se coloca un  resumen de caracteristicas básicos
        this.longitudCuerda = longitud;
        this.masaBob = masa;
        this.precision = precision;
        this.rangoMedicion = rangoMedicion;
        this.tipoMedicion = tipoMedicion;
    }
            
            
      // Getters      
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
    
    public double getLongitudCuerda() {
        return longitudCuerda;
    }

    public double getMasaBob() {
        return masaBob;
    }
    
    
    @Override
    public String mostrarDetalles() { 
        return String.format( //Aquí volví a implementar el format para que los datos siempre se ingresen con el formato correcto y todo se vea ordenado
                "========================================\n"
                + "ID: %s\n"
                + "Nombre: %s\n"
                + "Tipo: %s\n"
                + "Fabricante: %s\n"
                + "Consumo Eléctrico: %.2f W\n"
                + "Características: %s\n"
                + "--- Características Específicas ---\n"
                + "Longitud de Cuerda: %.2f m\n"
                + "Masa del Bob: %.3f kg\n"
                + "Precisión: ±%.4f s\n"
                + "Rango de Medición: %s\n"
                + "Tipo de Medición: %s\n"
                + "========================================",
                //Aquí van los datos que se van a presentar al mostrar los detalles
                identificador, nombre, tipo, fabricante, consumoElectrico,
                resumenCaracteristicas, longitudCuerda, masaBob, precision,
                rangoMedicion, tipoMedicion
        );
    }
            
}
