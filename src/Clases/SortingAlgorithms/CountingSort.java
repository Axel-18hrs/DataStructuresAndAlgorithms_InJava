/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases.SortingAlgorithms;

/**
 *
 \\\* @author Axel
 */
public class CountingSort {
     public void sort(int[] arr) {
        int n = arr.length;

        // Encontrar el rango del arreglo
        int max = findMax(arr);

        // Crear un arreglo de conteo y un arreglo resultado
        int[] count = new int[max + 1];
        int[] output = new int[n];

        // Inicializar el arreglo de conteo
        for (int i = 0; i <= max; i++) {
            count[i] = 0;
        }

        // Contar la frecuencia de cada elemento
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // Actualizar el arreglo de conteo para contener las posiciones reales
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Construir el arreglo de salida
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
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
