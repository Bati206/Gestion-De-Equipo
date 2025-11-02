package gestiondeequipos;

public class SimuladorMovimiento extends Equipo implements ISimulador {

  private String versionSoftware;
    private String tipoSimulacion;
    private String plataforma;
    private int numeroPaquetes;
    
    public SimuladorMovimiento(String id, String nombre, String fabricante, double consumo, String version, String tipoSimulacion, String plataforma, int paquetes) {
        super(id, nombre, "Simulador - Movimiento y Cinemática", fabricante, consumo, "Simula diferentes tipos de movimiento físico");
        this.versionSoftware = version;
        this.tipoSimulacion = tipoSimulacion;
        this.plataforma = plataforma;
        this.numeroPaquetes = paquetes;
    }
    
    
    //Getters
    @Override
    public String getVersionSoftware() {
        return versionSoftware;
    }
    
    @Override
    public String getTipoSimulacion() {
        return tipoSimulacion;
    }
    
    @Override
    public String getPlataforma() {
        return plataforma;
    }
    
    public int getNumeroPaquetes() {
        return numeroPaquetes;
    }
    
    
    
    //Muestra el resumen general
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
            "Versión Software: %s\n" +
            "Tipo de Simulación: %s\n" +
            "Plataforma: %s\n" +
            "Paquetes de Simulación: %d\n" +
            "========================================",
            identificador, nombre, tipo, fabricante, consumoElectrico,
            resumenCaracteristicas, versionSoftware, tipoSimulacion,
            plataforma, numeroPaquetes
        );
    }
    
    
    
}