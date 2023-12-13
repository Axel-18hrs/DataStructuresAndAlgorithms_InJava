/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases.Lists;
import Clases.Nodes.DoubleNode;
import javax.swing.JTextArea;
/**
 *
 \\\* @author Axel
 */
public class DoublyLinkedList {
    private DoubleNode head;
    private DoubleNode lastNode;

    public DoublyLinkedList() {
        head = null;
        lastNode = null;
    }

    public void add(int data) {
        DoubleNode newNode = new DoubleNode(data);

        if (isEmpty()) {
            head = newNode;
            lastNode = newNode;
            return;
        }

        if (exist(newNode.getData())) {
            return;
        }

        if (newNode.getData() < head.getData()) {
            head.setBack(newNode);
            newNode.setNext(head);
            head = newNode;
            return;
        }

        if (newNode.getData() > lastNode.getData()) {
            lastNode.setNext(newNode);
            newNode.setBack(lastNode);
            lastNode = newNode;
            return;
        }

        DoubleNode currentNode = head;
        while (currentNode.getNext() != null && currentNode.getNext().getData() < newNode.getData()) {
            currentNode = currentNode.getNext();
        }

        newNode.setNext(currentNode.getNext());
        newNode.setBack(currentNode);
        currentNode.getNext().setBack(newNode);
        currentNode.setNext(newNode);
    }

    public void delete(int data, JTextArea textBox) {
        if (isEmpty()) {
            return;
        }

        if (head.getData() == data) {
            head = head.getNext();
            if (head != null) {
                head.setBack(null);
            }
            textBox.setText("- Data[" + data + "] Deleted from the list");
            return;
        }

        if (lastNode.getData() == data) {
            lastNode = lastNode.getBack();
            if (lastNode != null) {
                lastNode.setNext(null);
            }
            textBox.setText("- Data[" + data + "] Deleted from the list");
            return;
        }

        DoubleNode currentNode = head;
        while (currentNode.getNext() != null && currentNode.getNext().getData() < data) {
            currentNode = currentNode.getNext();
        }

        if (currentNode.getNext() != null && currentNode.getNext().getData() == data) {
            currentNode.getNext().getNext().setBack(currentNode);
            currentNode.setNext(currentNode.getNext().getNext());
            if (currentNode.getNext() != null) {
                currentNode.getNext().setBack(currentNode);
            }
            textBox.setText("- Data[" + data + "] Deleted from the list");
            return;
        }

        textBox.setText("- Data[" + data + "] Not found/Deleted from the list");
    }

    public void search(int data, JTextArea textBox) {
        if (isEmpty()) {
            return;
        }

        if (head.getData() == data) {
            textBox.setText("- Data[" + data + "] Exists in the list");
            return;
        }

        if (lastNode.getData() == data) {
            textBox.setText("- Data[" + data + "] Exists in the list");
            return;
        }

        DoubleNode currentNode = head;
        while (currentNode.getNext() != null && currentNode.getNext().getData() <= data) {
            currentNode = currentNode.getNext();
        }

        if (currentNode.getData() == data) {
            textBox.setText("- Data[" + data + "] Exists in the list");
            return;
        }

        textBox.setText("- Data[" + data + "] Does not Exist in the list");
    }

    public void show(JTextArea textBox) {
        textBox.setText("");
        if (isEmpty()) {
            textBox.setText("Empty list");
            return;
        }

        DoubleNode currentNode = head;
        int i = 0;
        while (currentNode != null) {
            textBox.append("- Node[" + i + "] and data: " + currentNode.getData() + "\r\n");
            currentNode = currentNode.getNext();
            i++;
        }
    }

    public boolean exist(int data) {
        if (isEmpty()) {
            return false;
        }

        if (head.getData() == data) {
            return true;
        }

        if (lastNode.getData() == data) {
            return true;
        }

        DoubleNode currentNode = head;
        while (currentNode.getNext() != null && currentNode.getNext().getData() <= data) {
            currentNode = currentNode.getNext();
        }

        return currentNode.getData() == data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
        lastNode = null;
    }
}
