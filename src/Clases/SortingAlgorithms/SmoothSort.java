/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases.SortingAlgorithms;

/**
 *
 \\\* @author Axel
 */
public class SmoothSort {
     private int[] heap;

    public void sort(int[] arr) {
        heap = arr;
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(i, n - 1);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(0, i);
            siftDown(0, i - 1);
        }
    }

    private void siftDown(int root, int end) {
        int i = root;

        while (2 * i + 1 <= end) {
            int j = 2 * i + 1;

            if (j + 1 <= end && heap[j] < heap[j + 1]) {
                j++;
            }

            if (heap[i] >= heap[j]) {
                break;
            }

            swap(i, j);
            i = j;
        }
    }

    private int leftChild(int i, int k) {
        return i - fibonacci(k - 1) + fibonacci(k - 2);
    }

    private int fibonacci(int n) {
        if (n <= 1)
            return n;

        int a = 0, b = 1;

        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }

        return b;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
