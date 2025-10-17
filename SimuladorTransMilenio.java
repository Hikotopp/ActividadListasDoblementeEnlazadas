package simuladortransmilenio;

public class SimuladorTransMilenio {
    public static void main(String[] args) {
        // Crear la lista con las estaciones iniciales
        ListaDobleEnlazada lineaB = new ListaDobleEnlazada();
        
        // Agregar estaciones iniciales
        lineaB.insertar("Las Aguas");
        lineaB.insertar("Museo del Oro");
        lineaB.insertar("Av. Jimenez");
        lineaB.insertar("San Victorino");
        lineaB.insertar("Tercer Milenio");
        
        System.out.println("=== SIMULADOR DE TRANSMILENIO - LINEA B ===");
        System.out.println("\n1. Ruta inicial:");
        lineaB.mostrarRuta();
        
        // Operacion 1: Insertar "Universidades" antes de "Las Aguas"
        System.out.println("\n2. Insertando 'Universidades' antes de 'Las Aguas':");
        lineaB.insertarAntesDe("Las Aguas", "Universidades");
        lineaB.mostrarRuta();
        
        // Operacion 2: Eliminar "San Victorino"
        System.out.println("\n3. Eliminando 'San Victorino':");
        lineaB.eliminar("San Victorino");
        lineaB.mostrarRuta();
        
        // Operacion 3: Recorrer desde "Universidades" hasta "Tercer Milenio"
        System.out.println("\n4. Recorriendo desde 'Universidades' hasta 'Tercer Milenio':");
        lineaB.recorrer("Universidades", "Tercer Milenio");
        
        // Operacion 4: Recorrer en reversa desde "Tercer Milenio" hasta "Universidades"
        System.out.println("\n5. Recorriendo en reversa desde 'Tercer Milenio' hasta 'Universidades':");
        lineaB.recorrerReversa("Tercer Milenio", "Universidades");
        
        System.out.println("\n=== SIMULACION COMPLETADA ===");
    }
}
