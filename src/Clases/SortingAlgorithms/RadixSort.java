/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases.SortingAlgorithms;

/**
 *
 \\\* @author Axel
 */
public class RadixSort {
    public void sort(int[] arr) {
        int max = findMax(arr);

        // Aplicar Radix Sort para cada posición del dígito
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        // Inicializar el arreglo de conteo
        for (int i = 0; i < 10; i++) {
            count[i] = 0;
        }

        // Contar la frecuencia de cada elemento en la posición actual del dígito
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Actualizar el arreglo de conteo para contener las posiciones reales
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Construir el arreglo de salida
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copiar el arreglo de salida de vuelta al arreglo original
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    private static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
