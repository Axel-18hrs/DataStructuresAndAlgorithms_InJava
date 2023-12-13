/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases.SortingAlgorithms;

/**
 *
 \\\* @author Axel
 */
public class CocktailSort {
    public void cocktailSort(int[] arr) {
        int n = arr.length;
        boolean swapped = true;
        int start = 0;
        int end = n - 1;

        while (swapped) {
            // Moverse de izquierda a derecha
            swapped = false;
            for (int i = start; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }

            end--;

            // Moverse de derecha a izquierda
            swapped = false;
            for (int i = end - 1; i >= start; i--) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }

            start++;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
