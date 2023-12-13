/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases.SortingAlgorithms;
import Clases.Nodes.BinaryTreeNode;
/**
 *
 \\\* @author Axel
 */
public class BinaryTreeSort {
    private BinaryTreeNode root;
    private int index = 0;

    public void sort(int[] arr) {
        // Construir el árbol binario
        for (int value : arr) {
            root = insert(root, value);
        }

        // Recorrer el árbol en orden para obtener los elementos ordenados
        inOrderTraversal(root, arr);
    }

    private BinaryTreeNode insert(BinaryTreeNode node, int value) {
        if (node == null) {
            return new BinaryTreeNode(value);
        }

        if (value < node.getValue()) {
            node.setLeft(insert(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(insert(node.getRight(), value));
        }

        return node;
    }

    private void inOrderTraversal(BinaryTreeNode node, int[] arr) {
        if (node != null) {
            inOrderTraversal(node.getLeft(), arr);
            arr[index++] = node.getValue();
            inOrderTraversal(node.getRight(), arr);
        }
    }
}
