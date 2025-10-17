package tareas;
public class Tarea {
    String descripcion;
    Tarea anterior;
    Tarea siguiente;

    public Tarea(String descripcion) {
        this.descripcion = descripcion;
        this.anterior = null;
        this.siguiente = null;
    }
}