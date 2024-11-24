
package Vista;

import Controlador.GestionLenguaje;
import Modelo.LenguajeProgramacion;
import java.util.Scanner;

public class SistemaRegistro {
    private static final GestionLenguaje gestion = new GestionLenguaje();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner lector = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n-----------Menu----------");
            System.out.println("1. Agregar lenguaje");
            System.out.println("2. Buscar lenguaje");
            System.out.println("3. Eliminar lenguaje");
            System.out.println("4. Imprimir lenguajes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = lector.nextInt();
            lector.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Anio de creacion: ");
                    int anio = lector.nextInt();
                    lector.nextLine();

                    System.out.print("Caracteristica principal: ");
                    String caracteristica = lector.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = lector.nextLine();

                    System.out.print("Utilizacion: ");
                    String utilizacion = lector.nextLine();

                    gestion.agregarLenguaje(anio, caracteristica, nombre, utilizacion);
                    System.out.println("Lenguaje agregado correctamente.");
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del lenguaje a buscar: ");
                    String nombreBuscar = lector.nextLine();
                    LenguajeProgramacion lenguaje = gestion.buscarLenguaje(nombreBuscar);
                    if (lenguaje != null) {
                        System.out.println("Lenguaje encontrado: " + lenguaje);
                    } else {
                        System.out.println("Lenguaje no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el nombre del lenguaje a eliminar: ");
                    String nombreEliminar = lector.nextLine();
                    if (gestion.eliminarLenguaje(nombreEliminar)) {
                        System.out.println("Lenguaje eliminado correctamente.");
                    } else {
                        System.out.println("Lenguaje no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Lista de lenguajes:");
                    gestion.imprimirLenguajes();
                    break;

                case 5:
                    System.out.println("Saliendo del sistema.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 5);
    }
}


