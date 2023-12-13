/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases.SortingAlgorithms;

/**
 *
 \\\* @author Axel
 */
public class PigeonHole {
    public void pigeonholeSort(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        int range, i, j, index;

        for (int a = 1; a < arr.length; a++) {
            if (arr[a] > max)
                max = arr[a];
            if (arr[a] < min)
                min = arr[a];
        }

        range = max - min + 1;
        int[] pigeonholes = new int[range];

        for (i = 0; i < arr.length; i++)
            pigeonholes[i] = 0;

        for (i = 0; i < arr.length; i++)
            pigeonholes[arr[i] - min]++;

        index = 0;

        for (j = 0; j < range; j++)
            while (pigeonholes[j]-- > 0)
                arr[index++] = j + min;
    }
}
