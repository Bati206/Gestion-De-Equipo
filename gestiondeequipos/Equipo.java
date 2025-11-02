package gestiondeequipos;
public abstract class Equipo implements Comparable<Equipo> {
     protected String identificador;
    protected String nombre;
    protected String tipo;
    protected String fabricante;
    protected double consumoElectrico;
    protected String resumenCaracteristicas;
    
    //Constructor
    public Equipo(String identificador, String nombre, String tipo, String fabricante, double consumoElectrico, String resumenCaracteristicas) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.tipo = tipo;
        this.fabricante = fabricante;
        this.consumoElectrico = consumoElectrico;
        this.resumenCaracteristicas = resumenCaracteristicas;
    }
    
    //Getters
    public String getIdentificador() {
        return identificador;
    }

    
    public String getNombre() {
        return nombre;
    }

    
    public String getTipo() {
        return tipo;
    }

    
    public String getFabricante() {
        return fabricante;
    }

    
    public double getConsumoElectrico() {
        return consumoElectrico;
    }

    
    public String getResumenCaracteristicas() {
        return resumenCaracteristicas;
    }
    
    
        public abstract String mostrarDetalles(); //Este método ayudara a mostrar el resumen general de los equipos

        
        @Override
        public int compareTo(Equipo otro){ //Aquí compara dos equipos en base a su consumo electrico
            return Double.compare(this.consumoElectrico, otro.consumoElectrico);
        }
    
        @Override
    public String toString() { //Aquí cambio el formato en el que se hace el toString para poder imprimirlo en el listado de todos los equipos
        return String.format("[%s] %s - %.2fW", identificador, nombre, consumoElectrico);
    }
        
       @Override
    public boolean equals(Object obj) { //Compara si existe un objeto que tenga el mismo identificador, útil cuando quieran agregar nuevos equipos
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Equipo equipo = (Equipo) obj;
        return identificador.equals(equipo.identificador);
    }
    
    
    
}
