
package Controlador;

import Modelo.LenguajeProgramacion;

public class GestionLenguaje {
    private LenguajeProgramacion[] ArregloLenguajes = new LenguajeProgramacion [FACTOR_CRECIMIENTO];
    private int contadorLenguajes = 0;
    private static int FACTOR_CRECIMIENTO = 2;
    
    public void agregarLenguaje(int anioCreacion, String caracteristicaPrincipal, String nombre, String utilizacion) {
        if (contadorLenguajes == ArregloLenguajes.length) {
            crecerArreglo();
        }
        ArregloLenguajes[contadorLenguajes++] = new LenguajeProgramacion(anioCreacion, caracteristicaPrincipal, nombre, utilizacion);
    }

    public LenguajeProgramacion buscarLenguaje(String nombre) {
        for (int i = 0; i < contadorLenguajes; i++) {
            if (ArregloLenguajes[i].getNombre().equalsIgnoreCase(nombre)) {
                return ArregloLenguajes[i];
            }
        }
        return null;
    }

    public boolean eliminarLenguaje(String nombre) {
        for (int i = 0; i < contadorLenguajes; i++) {
            if (ArregloLenguajes[i].getNombre().equalsIgnoreCase(nombre)) {
                for (int j = i; j < contadorLenguajes - 1; j++) {
                    ArregloLenguajes[j] = ArregloLenguajes[j + 1];
                }
                ArregloLenguajes[--contadorLenguajes] = null;
                return true;
            }
        }
        return false;
    }

    public void imprimirLenguajes() {
        for (int i = 0; i < contadorLenguajes; i++) {
            System.out.println(ArregloLenguajes[i]);
        }
    }

    private void crecerArreglo() {
        LenguajeProgramacion[] nuevoArreglo = new LenguajeProgramacion[ArregloLenguajes.length + FACTOR_CRECIMIENTO];
        System.arraycopy(ArregloLenguajes, 0, nuevoArreglo, 0, ArregloLenguajes.length);
        ArregloLenguajes = nuevoArreglo;
    }
}
