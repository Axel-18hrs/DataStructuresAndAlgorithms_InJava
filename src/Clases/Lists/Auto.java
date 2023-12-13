/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases.Lists;
import java.util.Random;
/**
 *
 \\\* @author Axel
 */
public class Auto {
    public void autoAddSimpleList(SimpleList lista, Random random, javax.swing.JTextArea textArea, int numDatos) {
        for (int i = 0; i < numDatos; i++) {
            lista.add(random.nextInt(25));
        }
        lista.show(textArea);
    }

    public void autoDeleteSimpleList(SimpleList lista, Random random, javax.swing.JTextArea textArea, int numDatos) {
        for (int i = 0; i < numDatos; i++) {
            lista.delete(random.nextInt(25), textArea);
        }
    }

    public void autoSearchSimpleList(SimpleList lista, Random random, javax.swing.JTextArea textArea, int numDatos) {
        for (int i = 0; i < numDatos; i++) {
            lista.search(random.nextInt(25), textArea);
        }
    }

    public void autoAddCircularList(CircularList lista, Random random, javax.swing.JTextArea textArea, int numDatos) {
        textArea.setText("");
        for (int i = 0; i < numDatos; i++) {
            lista.add(random.nextInt(25));
        }
        lista.show(textArea);
    }

    public void autoDeleteCircularList(CircularList lista, Random random, javax.swing.JTextArea textArea, int numDatos) {
        for (int i = 0; i < numDatos; i++) {
            lista.delete(random.nextInt(25), textArea);
        }
    }

    public void autoSearchCircularList(CircularList lista, Random random, javax.swing.JTextArea textArea, int numDatos) {
        for (int i = 0; i < numDatos; i++) {
            lista.search(random.nextInt(25), textArea);
        }
    }

    public void autoAddDoublyListLinked(DoublyLinkedList lista, Random random, javax.swing.JTextArea textArea, int numDatos) {
        for (int i = 0; i < numDatos; i++) {
            lista.add(random.nextInt(25));
        }
        lista.show(textArea);
    }

    public void autoDeleteDoublyListLinked(DoublyLinkedList lista, Random random, javax.swing.JTextArea textArea, int numDatos) {
        for (int i = 0; i < numDatos; i++) {
            lista.delete(random.nextInt(25), textArea);
        }
    }

    public void autoSearchDoublyListLinked(DoublyLinkedList lista, Random random, javax.swing.JTextArea textArea, int numDatos) {
        for (int i = 0; i < numDatos; i++) {
            lista.search(random.nextInt(25), textArea);
        }
    }

    public void autoAddCircularDoublyLinkedList(CircularDoublyLinkedList lista, Random random, javax.swing.JTextArea textArea, int numDatos) {
        for (int i = 0; i < numDatos; i++) {
            lista.add(random.nextInt(25));
        }
        lista.show(textArea);
    }

    public void autoDeleteCircularDoublyLinkedList(CircularDoublyLinkedList lista, Random random, javax.swing.JTextArea textArea, int numDatos) {
        for (int i = 0; i < numDatos; i++) {
            lista.delete(random.nextInt(25), textArea);
        }
    }

    public void autoSearchCircularDoublyLinkedList(CircularDoublyLinkedList lista, Random random, javax.swing.JTextArea textArea, int numDatos) {
        for (int i = 0; i < numDatos; i++) {
            lista.search(random.nextInt(25), textArea);
        }
    }
}
