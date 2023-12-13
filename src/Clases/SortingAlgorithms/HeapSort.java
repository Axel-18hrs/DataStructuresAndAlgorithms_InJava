/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases.SortingAlgorithms;

/**
 *
 \\\* @author Axel
 */
public class HeapSort {
    public void sort(int[] arr) {
        int n = arr.length;

        // Construir un heap (montículo) máximo
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extraer elementos uno por uno del heap
        for (int i = n - 1; i > 0; i--) {
            // Mover la raíz actual al final
            swap(arr, 0, i);

            // Llamar a heapify en el subárbol reducido
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Comparar con el hijo izquierdo
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Comparar con el hijo derecho
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // Si el mayor no es la raíz
        if (largest != i) {
            swap(arr, i, largest);

            // Recursivamente heapify el subárbol afectado
            heapify(arr, n, largest);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
