package gestiondeequipos;

public class SimuladorCircuitos extends Equipo implements ISimulador {
    
    //Los atributos 
    private String versionSoftware;
    private String tipoSimulacion;
    private String plataforma;
    private int numeroComponentes;
    
    
    //Constructor
    public SimuladorCircuitos(String id, String nombre, String fabricante, double consumo, String version, String tipoSimulacion, String plataforma, int componentes) {
        super(id, nombre, "Simulador - Circuitos Eléctricos", fabricante, consumo,
              "Diseña y simula circuitos eléctricos y electrónicos");
        this.versionSoftware = version;
        this.tipoSimulacion = tipoSimulacion;
        this.plataforma = plataforma;
        this.numeroComponentes = componentes;
    }
    
    
    //getters
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
    
    public int getNumeroComponentes() {
        return numeroComponentes;
    }
    
    
    //Muestra los detalles en un formato ordenado
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
            "Componentes Disponibles: %d\n" +
            "========================================",
            identificador, nombre, tipo, fabricante, consumoElectrico,
            resumenCaracteristicas, versionSoftware, tipoSimulacion,
            plataforma, numeroComponentes
        );
    }
    
    
    
}