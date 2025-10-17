package simuladortransmilenio;

// Clase Lista Doblemente Enlazada
class ListaDobleEnlazada {
    private Nodo cabeza;
    private Nodo cola;
    private int tamano;
    
    public ListaDobleEnlazada() {
        this.cabeza = null;
        this.cola = null;
        this.tamano = 0;
    }
    
    // Insertar al final
    public void insertar(String estacion) {
        Nodo nuevoNodo = new Nodo(estacion);
        
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo;
            nuevoNodo.anterior = cola;
            cola = nuevoNodo;
        }
        tamano++;
    }
    
    // Insertar antes de una estacion especifica
    public boolean insertarAntesDe(String estacionReferencia, String nuevaEstacion) {
        if (cabeza == null) {
            System.out.println("La lista esta vacia.");
            return false;
        }
        
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.estacion.equals(estacionReferencia)) {
                Nodo nuevoNodo = new Nodo(nuevaEstacion);
                nuevoNodo.siguiente = actual;
                nuevoNodo.anterior = actual.anterior;
                
                if (actual.anterior != null) {
                    actual.anterior.siguiente = nuevoNodo;
                } else {
                    cabeza = nuevoNodo;
                }
                
                actual.anterior = nuevoNodo;
                tamano++;
                return true;
            }
            actual = actual.siguiente;
        }
        
        System.out.println("Estacion '" + estacionReferencia + "' no encontrada.");
        return false;
    }
    
    // Eliminar una estacion
    public boolean eliminar(String estacion) {
        if (cabeza == null) {
            System.out.println("La lista esta vacia.");
            return false;
        }
        
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.estacion.equals(estacion)) {
                if (actual.anterior != null) {
                    actual.anterior.siguiente = actual.siguiente;
                } else {
                    cabeza = actual.siguiente;
                }
                
                if (actual.siguiente != null) {
                    actual.siguiente.anterior = actual.anterior;
                } else {
                    cola = actual.anterior;
                }
                
                tamano--;
                return true;
            }
            actual = actual.siguiente;
        }
        
        System.out.println("Estacion '" + estacion + "' no encontrada.");
        return false;
    }
    
    // Recorrer desde una estacion hasta otra
    public void recorrer(String estacionInicio, String estacionFin) {
        Nodo inicio = buscarNodo(estacionInicio);
        Nodo fin = buscarNodo(estacionFin);
        
        if (inicio == null || fin == null) {
            System.out.println("Una o ambas estaciones no existen.");
            return;
        }
        
        System.out.println("\nRecorrido desde '" + estacionInicio + "' hasta '" + estacionFin + "':");
        Nodo actual = inicio;
        
        while (actual != null) {
            System.out.print(actual.estacion);
            if (!actual.estacion.equals(estacionFin)) {
                System.out.print(" → ");
            }
            
            if (actual.estacion.equals(estacionFin)) {
                break;
            }
            actual = actual.siguiente;
        }
        System.out.println();
    }
    
    // Recorrer en reversa desde una estacion hasta otra
    public void recorrerReversa(String estacionInicio, String estacionFin) {
        Nodo inicio = buscarNodo(estacionInicio);
        Nodo fin = buscarNodo(estacionFin);
        
        if (inicio == null || fin == null) {
            System.out.println("Una o ambas estaciones no existen.");
            return;
        }
        
        System.out.println("\nRecorrido en reversa desde '" + estacionInicio + "' hasta '" + estacionFin + "':");
        Nodo actual = inicio;
        
        while (actual != null) {
            System.out.print(actual.estacion);
            if (!actual.estacion.equals(estacionFin)) {
                System.out.print(" ← ");
            }
            
            if (actual.estacion.equals(estacionFin)) {
                break;
            }
            actual = actual.anterior;
        }
        System.out.println();
    }
    
    // Buscar un nodo por nombre de estacion
    private Nodo buscarNodo(String estacion) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.estacion.equals(estacion)) {
                return actual;
            }
            actual = actual.siguiente;
        }
        return null;
    }
    
    // Mostrar toda la ruta
    public void mostrarRuta() {
        if (cabeza == null) {
            System.out.println("La ruta esta vacia.");
            return;
        }
        
        System.out.println("\nRuta completa de la Linea B:");
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print("[" + actual.estacion + "]");
            if (actual.siguiente != null) {
                System.out.print(" ⇄ ");
            }
            actual = actual.siguiente;
        }
        System.out.println("\n");
    }
}
