/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases.SortingAlgorithms;
import java.util.Random;
import javax.swing.*;
/**
 *
 \\\* @author Axel
 */
public class QuickSort {
     static Random random = new Random();
     static int option, containExchange, containPartition, containRecursive;

    private static void swap(int[] array, int indexOne, int indexTwo) {
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

   private static int partition(int[] array, int firstIndex, int lastIndex, JTextArea textArea) {
    containPartition++;
    int indexPivot;

    switch (option) {
        case 1:
            indexPivot = firstIndex;
            break;
        case 2:
            indexPivot = (int) Math.floor((double) (lastIndex + firstIndex) / 2);
            break;
        case 3:
            indexPivot = lastIndex;
            break;
        default:
            indexPivot = random.nextInt(lastIndex - firstIndex + 1) + firstIndex;
            break;
    }

    swap(array, firstIndex, indexPivot);
    printSwap(array, firstIndex, indexPivot, textArea);
    containExchange++;
    int pivot = array[firstIndex];
    int left = firstIndex + 1;
    int right = lastIndex;

    while (true) {
        while (left <= right && array[left] <= pivot) {
            left += 1;
        }
        while (left <= right && array[right] >= pivot) {
            right -= 1;
        }
        if (right < left) {
            break;
        }
        swap(array, left, right);
        printSwap(array, left, right, textArea);
        containExchange++;
        left += 1;
        right -= 1;
    }

    swap(array, firstIndex, right);
    printSwap(array, firstIndex, right, textArea);
    containExchange++;
    return right;
}


    private static void printSwap(int[] array, int left, int right, JTextArea textArea) {
        textArea.append("[ ");
        for (int i = 0; i < array.length; i++) {
            if (right == i && left == i) {
                textArea.append(String.valueOf(array[i]));
            } else if (i == left || i == right) {
                textArea.append(String.valueOf(array[i]));
            } else {
                textArea.append(String.valueOf(array[i]));
            }
            if (i < array.length - 1) {
                textArea.append(", ");
            }
        }
        textArea.append(" ]\r\n");
    }

    public void quickSort(int[] array, int firstIndex, int lastIndex, JTextArea textArea) {
        if (firstIndex < lastIndex) {
            containRecursive++;
            int indexPivot = partition(array, firstIndex, lastIndex, textArea);
            quickSort(array, firstIndex, indexPivot - 1, textArea);
            quickSort(array, indexPivot + 1, lastIndex, textArea);
        }
    }
}
