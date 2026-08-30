package com.mycompany.sys.empleados.model;

public class OrdenamientoEmpleados {

    // punto 1: quicksort por salario neto, de mayor a menor
    public static void quicksortPorNeto(Empleado[] lista, int inicio, int fin) {
        if (inicio < fin) {
            int posPivote = particionarPorNeto(lista, inicio, fin);
            quicksortPorNeto(lista, inicio, posPivote - 1);
            quicksortPorNeto(lista, posPivote + 1, fin);
        }
    }

    private static int particionarPorNeto(Empleado[] lista, int inicio, int fin) {
        double pivote = lista[fin].getSalarioNeto();
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (lista[j].getSalarioNeto() > pivote) {
                i++;
                Empleado temp = lista[i];
                lista[i] = lista[j];
                lista[j] = temp;
            }
        }
        Empleado temp = lista[i + 1];
        lista[i + 1] = lista[fin];
        lista[fin] = temp;

        return i + 1;
    }

    // punto 2: seleccion por nombre, ascendente
    public static void seleccionPorNombre(Empleado[] lista, int n) {
        for (int i = 0; i < n - 1; i++) {
            int posMenor = i;
            for (int j = i + 1; j < n; j++) {
                if (lista[j].getNombre().compareToIgnoreCase(lista[posMenor].getNombre()) < 0) {
                    posMenor = j;
                }
            }
            Empleado temp = lista[posMenor];
            lista[posMenor] = lista[i];
            lista[i] = temp;
        }
    }

    // punto 3: shell por estrato, descendente
    public static void shellPorEstrato(Empleado[] lista, int n) {
        int salto = n / 2;
        while (salto > 0) {
            for (int i = salto; i < n; i++) {
                Empleado actual = lista[i];
                int j = i;
                while (j >= salto && lista[j - salto].getEstrato() < actual.getEstrato()) {
                    lista[j] = lista[j - salto];
                    j -= salto;
                }
                lista[j] = actual;
            }
            salto = salto / 2;
        }
    }
}