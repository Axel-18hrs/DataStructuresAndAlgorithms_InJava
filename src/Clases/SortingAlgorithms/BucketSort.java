/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases.SortingAlgorithms;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;
/**
 *
 \\\* @author Axel
 */
public class BucketSort {
    static Random rand = new Random();

    static void printBucketState(List<Integer>[] buckets, JTextArea txtArea) {
        txtArea.append("Current state of buckets:\n");
        for (int i = 0; i < buckets.length; i++) {
            txtArea.append("Bucket " + i + ": ");
            for (int item : buckets[i]) {
                txtArea.append(item + " ");
            }
            txtArea.append("\n");
        }
        txtArea.append("\n");
    }

    public void bucketSort(int[] array, JTextArea txtArea) {
        // Encuentra el valor máximo en el array
        int maxVal = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxVal) {
                maxVal = array[i];
            }
        }

        // Crea una lista de buckets vacíos
        List<Integer>[] buckets = new List[maxVal + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribuye los elementos en los buckets
        for (int i = 0; i < array.length; i++) {
            buckets[array[i]].add(array[i]);
        }
        printBucketState(buckets, txtArea);

        // Ordena cada cubo individualmente
        for (int i = 0; i < buckets.length; i++) {
            buckets[i].sort(null);
        }
        printBucketState(buckets, txtArea);

        // Concatena los elementos ordenados de cada cubo
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int item : buckets[i]) {
                array[index++] = item;
            }
        }
    }
}
