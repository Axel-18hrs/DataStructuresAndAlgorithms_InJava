/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases.Lists;
import Clases.Nodes.DoubleNode;
import javax.swing.*;
/**
 *
 \\\* @author Axel
 */
public class CircularDoublyLinkedList {
    private DoubleNode head;
    private DoubleNode lastNode;

    public CircularDoublyLinkedList() {
        head = null;
        lastNode = null;
    }

    public void add(int data) {
        // Case 0: Create a new node
        DoubleNode newNode = new DoubleNode(data);
        // Case 1: Insert at the beginning
        if (isEmpty()) {
            head = newNode;
            newNode.setBack(head);
            newNode.setNext(head);
            lastNode = head;
            return;
        }
        // Case 2: Prevent duplicate data
        if (exist(newNode.getData())) {
            return;
        }
        // Case 3: Insert at the beginning if the data is smaller
        if (newNode.getData() < head.getData()) {
            newNode.setNext(head);
            newNode.setBack(head);
            head.setNext(newNode);
            head.setBack(newNode);
            lastNode = head;
            head = newNode;
            return;
        }
        // Case 4: Insert at the end if the data is greater
        if (newNode.getData() > lastNode.getData()) {
            newNode.setBack(lastNode);
            lastNode.setNext(newNode);
            lastNode = newNode;
            lastNode.setNext(head);
            head.setBack(lastNode);
            return;
        }
        // Case 5: Traverse the list
        DoubleNode currentNode = head;
        while (currentNode.getNext() != head && currentNode.getNext().getData() < newNode.getData()) {
            currentNode = currentNode.getNext();
        }
        // Case 6: Insert at X position
        newNode.setNext(currentNode.getNext());
        newNode.setBack(currentNode);
        currentNode.getNext().setBack(newNode);
        currentNode.setNext(newNode);
    }

    public void delete(int data, JTextArea textBox) {
        // Case 1: If the list is empty
        if (isEmpty()) {
            return;
        }
        // Case 2: Delete and check if there is only one element
        if (head.getData() == lastNode.getData()) {
            clear();
            textBox.setText("- Data[" + data + "] Deleted from the list");
            return;
        }
        // Case 3: The data is at the beginning of the list
        if (head.getData() == data) {
            head = head.getNext();
            head.setBack(lastNode);
            lastNode.setNext(head);
            textBox.setText("- Data[" + data + "] Deleted from the list");
            return;
        }
        // Case 4: The data is at the end of the list
        if (lastNode.getData() == data) {
            lastNode = lastNode.getBack();
            lastNode.setNext(head);
            head.setBack(lastNode);
            textBox.setText("- Data[" + data + "] Deleted from the list");
            return;
        }
        // Case 5: Traverse the list
        DoubleNode currentNode = head;
        while (currentNode.getNext() != head && currentNode.getNext().getData() < data) {
            currentNode = currentNode.getNext();
        }
        // Case 6: The data is at X position in the list
        if (currentNode.getNext().getData() == data) {
            currentNode.getNext().getNext().setBack(currentNode);
            currentNode.setNext(currentNode.getNext().getNext());
            textBox.setText("- Data[" + data + "] Deleted from the list");
            return;
        }
        // Case 7: Data to be deleted not found
        textBox.setText("- Data[" + data + "] Not found/Deleted from the list");
    }

    public void search(int data, JTextArea textBox) {
        // Case 1: If the list is empty
        if (isEmpty()) {
            return;
        }
        // Case 2: If the data is at the beginning
        if (head.getData() == data) {
            textBox.setText("- Data[" + data + "] Exists in the list");
            return;
        }
        // Case 3: If the data is at the end
        if (lastNode.getData() == data) {
            textBox.setText("- Data[" + data + "] Exists in the list");
            return;
        }
        // Case 4: Traverse the list
        DoubleNode currentNode = head;
        while (currentNode.getNext() != head && currentNode.getNext().getData() <= data) {
            currentNode = currentNode.getNext();
        }
        // Case 5: If the data exists in the list
        if (currentNode.getData() == data) {
            textBox.setText("- Data[" + data + "] Exists in the list");
            return;
        }
        // Case 6: Data does not exist in the list
        textBox.setText("- Data[" + data + "] Does not Exist in the list ");
    }

    public void show(JTextArea textBox) {
        textBox.setText("");
        // Case 1: If the list is empty
        if (isEmpty()) {
            textBox.setText("Empty list");
            return;
        }
        // Case 2: Traverse the list
        DoubleNode currentNode = head;
        int i = 0;
        do {
            textBox.setText(textBox.getText() + "- Node[" + i + "] and data: " + currentNode.getData() + "\r\n");
            currentNode = currentNode.getNext();
            i++;
        } while (currentNode != head);
    }

    public boolean exist(int data) {
        // Case 1: If the list is empty
        if (isEmpty()) {
            return false;
        }
        // Case 2: If the first element already exists
        if (head.getData() == data) {
            return true;
        }
        // Case 3: If the data is at the end
        if (lastNode.getData() == data) {
            return true;
        }
        // Case 4: Traverse the list
        DoubleNode currentNode = head;
        while (currentNode.getNext() != head && currentNode.getNext().getData() <= data) {
            currentNode = currentNode.getNext();
        }
        // Case 5: The entered data exists at X position
        if (currentNode.getData() == data) {
            return true;
        }
        // Case 6: The data does not exist in the list
        return false;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
        lastNode = null;
    }
}
