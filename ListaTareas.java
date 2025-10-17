package tareas;
public class ListaTareas {
    private Tarea cabeza;
    private Tarea cola;

    public ListaTareas() {
        cabeza = null;
        cola = null;
    }

    // Adicionar tarea al inicio
    public void adicionarCabeza(String descripcion) {
        Tarea nueva = new Tarea(descripcion);
        if (cabeza == null) {
            cabeza = cola = nueva;
        } else {
            nueva.siguiente = cabeza;
            cabeza.anterior = nueva;
            cabeza = nueva;
        }
        System.out.println("Tarea agregada al inicio: " + descripcion);
    }

    // Adicionar tarea al final
    public void adicionarCola(String descripcion) {
        Tarea nueva = new Tarea(descripcion);
        if (cola == null) {
            cabeza = cola = nueva;
        } else {
            cola.siguiente = nueva;
            nueva.anterior = cola;
            cola = nueva;
        }
        System.out.println("Tarea agregada al final: " + descripcion);
    }

    // Eliminar la primera tarea
    public void eliminarCabeza() {
        if (cabeza == null) {
            System.out.println("La lista de tareas está vacía.");
        } else {
            System.out.println("Tarea eliminada del inicio: " + cabeza.descripcion);
            cabeza = cabeza.siguiente;
            if (cabeza != null) {
                cabeza.anterior = null;
            } else {
                cola = null;
            }
        }
    }

    // Eliminar la última tarea
    public void eliminarCola() {
        if (cola == null) {
            System.out.println("La lista de tareas está vacía.");
        } else {
            System.out.println("Tarea eliminada del final: " + cola.descripcion);
            cola = cola.anterior;
            if (cola != null) {
                cola.siguiente = null;
            } else {
                cabeza = null;
            }
        }
    }

    // Mostrar todas las tareas
    public void mostrarTareas() {
        if (cabeza == null) {
            System.out.println("No hay tareas pendientes.");
        } else {
            Tarea actual = cabeza;
            System.out.println("\n--- Lista de tareas ---");
            while (actual != null) {
                System.out.println("- " + actual.descripcion);
                actual = actual.siguiente;
            }
        }
    }
}