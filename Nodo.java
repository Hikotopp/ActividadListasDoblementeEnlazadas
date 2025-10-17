package simuladortransmilenio;

class Nodo {
    String estacion;
    Nodo anterior;
    Nodo siguiente;
    
    public Nodo(String estacion) {
        this.estacion = estacion;
        this.anterior = null;
        this.siguiente = null;
    }
}