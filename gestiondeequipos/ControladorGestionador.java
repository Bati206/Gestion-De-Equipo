package gestiondeequipos;

import java.util.ArrayList;
import java.util.Collections;

public class ControladorGestionador {
    
    
    
    //Atributos
    private ArrayList<Equipo> equipos; //Lista unica en donde estarán todos los equipos
    private InterfazUsuario interfaz;
    private int opcion;
    
    //Constructor en donde se agregan de una vez algunos equipos (disculpe los nombres de los fabricantes pero estaba aburrido jajajaja)
    public ControladorGestionador(){
        this.equipos = new ArrayList<>();
        this.interfaz = new InterfazUsuario();
        
        //Instancia de algunos equipos
        
        //MEDIDORES
        this.equipos.add(new Pendulo(
                "PEN-001",
                "Péndulo Simple",
                "PASCOLabs",
                5.0,
                1.2,
                0.5,
                0.001,
                "0° - 180°",
                "Periodo y Amplitud"
        ));

        this.equipos.add(new Osciloscopio(
                "OSC-001",
                "Osciloscopio Digital",
                "FisicaLabs",
                75.0,
                4,
                100.0,
                0.01,
                "±50V DC-100MHz",
                "Señales Eléctricas"
        ));

        // GENERADORES
        this.equipos.add(new GeneradorSenales(
                "GEN-001",
                "Generador de Funciones",
                "FisiquinesUVG",
                50.0,
                20000000.0,
                10.0,
                20.0,
                "Senoidal/Cuadrada/Triangular",
                "1mHz - 20MHz"
        ));

        this.equipos.add(new FuentePoder(
                "FUE-001",
                "Fuente DC Regulada",
                "MateCracksgt",
                100.0,
                30.0,
                5.0,
                "Voltaje DC Regulado",
                "0-30V / 0-5A"
        ));

        // SIMULADORES
        this.equipos.add(new SimuladorMovimiento(
                "SIM-001",
                "Simulador Físico",
                "PASCOLabs",
                80.0,
                "v3.2",
                "Mecánica Clásica",
                "Windows/Mac/Linux",
                5
        ));

        this.equipos.add(new SimuladorCircuitos(
                "SIM-002",
                "CircuitLab Pro",
                "Newtonianos",
                60.0,
                "v2.5",
                "SPICE/Digital",
                "Windows",
                500
        ));

        this.equipos.add(new SimuladorOndas(
                "SIM-003",
                "WaveSim 3D",
                "FisiquinesUVG",
                90.0,
                "v4.0",
                "Ondas Electromagnéticas",
                "Windows/Linux",
                "4K UHD"
        ));

        //ANALIZADORES
        this.equipos.add(new AnalizadorEspectro(
                "ANA-001",
                "Analizador de Espectro",
                "IngeprosGuate",
                120.0,
                0.0,
                6000000000.0,
                "1 Hz",
                "FFT 1024 puntos",
                "Espectral RF"
        ));

        this.equipos.add(new AnalizadorDatos(
                "ANA-002",
                "DataAnalyzer Pro",
                "Gigachadsgt",
                45.0,
                "MATLAB R2023",
                1000000,
                "32-bit",
                "Procesamiento Paralelo",
                "Estadístico/ML"
        ));

        this.equipos.add(new Cronometro(
                "ANA-003",
                "Cronómetro Digital",
                "PASCOLabs",
                15.0,
                0.0001,
                8,
                "0.1 ms",
                "Multi-evento",
                "Temporal"
        ));
    }
    
    
    // Ejecuta la interfaz para iniciar el programa
    public void iniciar() {
        interfaz.ejecutar(this);
    }
    
    // Busca equipo por el identificador
    public Equipo buscarEquipo(String identificador) {
        for (int i = 0; i < equipos.size(); i++) {
            if (equipos.get(i).getIdentificador().equalsIgnoreCase(identificador)) {
                return equipos.get(i);
            }
        }
        return null;
    }
    
    // busca equipos por nombre de equipo
    public ArrayList<Equipo> buscarEquipo(String nombre, boolean porNombre) {
        ArrayList<Equipo> resultados = new ArrayList<>();
        if (porNombre) {
            for (int i = 0; i < equipos.size(); i++) {
                if (equipos.get(i).getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                    resultados.add(equipos.get(i));
                }
            }
        }
        return resultados;
    }
    
    //agrega un equipo nuevo
    public boolean agregarEquipo(Equipo nuevoEquipo) {
        // Verifica si ya existe un equipo con ese identificador
        for (int i = 0; i < equipos.size(); i++) {
            if (equipos.get(i).getIdentificador().equals(nuevoEquipo.getIdentificador())) {
                return false;
            }
        }
        equipos.add(nuevoEquipo);
        return true;
    }
    
    // Retorna la lista completa
    public ArrayList<Equipo> listarEquipos() {
        return new ArrayList<>(equipos);
    }
    
    // Utilizando el método sort ordena la lista de los equipos
    public void ordenarPorConsumo() {
        Collections.sort(equipos);
    }
    
    
}
