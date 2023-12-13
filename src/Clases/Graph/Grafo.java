/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases.Graph;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *
 \\\* @author Axel
 */
public class Grafo {
      public List<Vertex> vertices;
     public List<Edge> aristas;

    public Grafo() {
        vertices = new ArrayList<>();
        aristas = new ArrayList<>();
    }

    public void agregarVertice(String nombre) {
        // Añadir un vértice a posiciones aleatorias
        Random random = new Random();
        Vertex nuevoVertice = new Vertex(nombre, new Point(random.nextInt(400), random.nextInt(300)));
        vertices.add(nuevoVertice);
    }

    public void agregarArista(String origen, String destino) {
        // Añadir una arista entre los vértices con los nombres dados
        Vertex verticeOrigen = encontrarVerticePorNombre(origen);
        Vertex verticeDestino = encontrarVerticePorNombre(destino);

        if (verticeOrigen != null && verticeDestino != null) {
            aristas.add(new Edge(verticeOrigen, verticeDestino));
        }
    }

    private Vertex encontrarVerticePorNombre(String nombre) {
        for (Vertex vertice : vertices) {
            if (vertice.getNombre().equals(nombre)) {
                return vertice;
            }
        }
        return null;
    }
}
