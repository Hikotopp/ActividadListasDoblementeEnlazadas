package tareas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaTareas lista = new ListaTareas();
        int opcion;
        String descripcion;

        do {
            System.out.println("MENÚ DE TAREAS ");
            System.out.println("1. Adicionar tarea al inicio");
            System.out.println("2. Adicionar tarea al final");
            System.out.println("3. Eliminar tarea del inicio");
            System.out.println("4. Eliminar tarea del final");
            System.out.println("5. Ver todas las tareas");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la descripción de la tarea: ");
                    descripcion = sc.nextLine();
                    lista.adicionarCabeza(descripcion);
                    break;
                case 2:
                    System.out.print("Ingrese la descripción de la tarea: ");
                    descripcion = sc.nextLine();
                    lista.adicionarCola(descripcion);
                    break;
                case 3:
                    lista.eliminarCabeza();
                    break;
                case 4:
                    lista.eliminarCola();
                    break;
                case 5:
                    lista.mostrarTareas();
                    break;
                case 6:
                    System.out.println("Saliendo del gestor de tareas...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 6);

        sc.close();
    }
}