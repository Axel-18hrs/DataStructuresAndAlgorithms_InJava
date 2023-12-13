/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases.SortingAlgorithms;
import javax.swing.*;
/**
 *
 \\\* @author Axel
 */
public class ShellSort {
    private void printArray(int[] array, JTextArea textArea) {
        for (int num : array) {
            textArea.append(num + " ");
        }
        textArea.append("\n");
    }

    public void shellSort(int[] array, JTextArea textArea) {
        // se obtiene la longitud del array
        int n = array.length;
        // se obtiene el tamaño de espacio entre elementos
        int gap = n / 2;

        textArea.append("\nInicio del algoritmo Shell Sort:\n");

        // Mientras el espacio entre elementos sea mayor que 0
        while (gap > 0) {
            textArea.append("\nGap actual: " + gap + "\n");

            // Aplicar el algoritmo de inserción para cada "subarray" con el tamaño de gap
            for (int i = gap; i < n; i++) {
                // Guardar el valor actual del elemento en una variable temporal
                int temp = array[i];
                int j = i;

                textArea.append("\nComparando " + temp + " con los elementos en su subarray:\n");

                // Realizar la inserción
                while (j >= gap && array[j - gap] > temp) {
                    // Desplazar elementos hacia la derecha hasta encontrar la posición correcta
                    array[j] = array[j - gap];
                    j -= gap;

                    printArray(array, textArea);
                }

                // Colocar el valor temporal en la posición correcta en el subarray
                array[j] = temp;
                textArea.append("Insertar " + temp + " en la posición " + j + " del subarray:\n");
                printArray(array, textArea);
            }

            // Reducir el espacio entre elementos a la mitad en cada iteración
            gap /= 2;
        }

        textArea.append("\nFin del algoritmo Shell Sort:");
    }
}
