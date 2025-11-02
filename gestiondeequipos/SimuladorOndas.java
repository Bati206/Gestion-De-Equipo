package gestiondeequipos;

public class SimuladorOndas extends Equipo implements Simulador {
    
    //Atributos
    private String versionSoftware;
    private String tipoSimulacion;
    private String plataforma;
    private String resolucionGrafica;
    
    
    //Constructor
    public SimuladorOndas(String id, String nombre, String fabricante, double consumo, String version, String tipoSimulacion, String plataforma, String resolucion) {
        super(id, nombre, "Simulador - Ondas y Fenómenos Ondulatorios", fabricante, consumo,"Simula propagación, interferencia y difracción de ondas");
        this.versionSoftware = version;
        this.tipoSimulacion = tipoSimulacion;
        this.plataforma = plataforma;
        this.resolucionGrafica = resolucion;
    }
    
    
    //getters y setters
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
    
    public String getResolucionGrafica() {
        return resolucionGrafica;
    }
    
    
    
    //FORmato de los detalles a mostrar
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
            "Resolución Gráfica: %s\n" +
            "========================================",
            identificador, nombre, tipo, fabricante, consumoElectrico,
            resumenCaracteristicas, versionSoftware, tipoSimulacion,
            plataforma, resolucionGrafica
        );
    }
    
    
    
}