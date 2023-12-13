/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases.SortingAlgorithms;

/**
 *
 \\\* @author Axel
 */
public class CombSort {
    public void sort(int[] arr) {
        int n = arr.length;

        // Inicializar el tamaño del salto
        int gap = n;

        // Factor de reducción
        double shrink = 1.3;

        boolean swapped;

        do {
            // Aplicar un salto mínimo de 1
            if (gap > 1) {
                gap = (int) (gap / shrink);
            }

            swapped = false;

            // Realizar comparaciones y swaps
            for (int i = 0; i + gap < n; i++) {
                if (arr[i] > arr[i + gap]) {
                    swap(arr, i, i + gap);
                    swapped = true;
                }
            }
        } while (gap > 1 || swapped);
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
