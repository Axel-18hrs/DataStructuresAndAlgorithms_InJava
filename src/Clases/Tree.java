/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import Clases.Nodes.TreeNode;
import javax.swing.*;
/**
 *
 \\\* @author Axel
 */
public class Tree {
    TreeNode root;

    public Tree(TreeNode root) {
        this.root = root;
    }

    public void printTree(TreeNode node, JTextArea textArea, String indent) {
        textArea.append(indent + "└─  " + node.getName() + "\n");

        for (int i = 0; i < node.getChildren().size(); i++) {
            printTree(node.getChildren().get(i), textArea, indent + "   ");
        }
    }

    public TreeNode findNode(String nodeName, TreeNode node) {
        if (node == null)
            node = root;

        if (node.getName().equals(nodeName))
            return node;

        for (TreeNode child : node.getChildren()) {
            TreeNode foundNode = findNode(nodeName, child);
            if (foundNode != null)
                return foundNode;
        }

        return null;
    }

    public void addNode(String parentNodeName, String newNodeName, JTextArea textArea) {
        TreeNode parentNode = findNode(parentNodeName, null);

        if (parentNode != null) {
            parentNode.getChildren().add(new TreeNode(newNodeName));
            textArea.setText("");
            printTree(root, textArea, "");
        } else {
            textArea.setText("The parent node '" + parentNodeName + "' was not found.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            textArea.setText("");
            printTree(root, textArea, "");
        }
    }

    public void deleteNode(String nodeName, JTextArea textArea) {
        TreeNode nodeToDelete = findNode(nodeName, null);

        if (nodeToDelete != null) {
            TreeNode parent = findParentNode(nodeName, null);

            if (nodeToDelete == root) {
                if (nodeToDelete.getChildren().size() > 0) {
                    root = nodeToDelete.getChildren().get(0);
                    textArea.setText("The root node '" + nodeName + "' was deleted, and its first child became the new root.");
                } else {
                    root = null;
                    textArea.setText("The root node '" + nodeName + "' was deleted.");
                }
            } else if (parent != null) {
                if (nodeToDelete.getChildren().size() > 0) {
                    TreeNode firstChild = nodeToDelete.getChildren().get(0);
                    firstChild.getChildren().addAll(nodeToDelete.getChildren().subList(1, nodeToDelete.getChildren().size()));
                    parent.getChildren().add(parent.getChildren().indexOf(nodeToDelete), firstChild);
                }
                parent.getChildren().remove(nodeToDelete);
                textArea.setText("The node '" + nodeName + "' was deleted, and its first child became the new parent without changing the branch position.");
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            textArea.setText("");
            printTree(root, textArea, "");
        } else {
            textArea.setText("The node '" + nodeName + "' was not found.");
        }
    }

    private TreeNode findParentNode(String nodeName, TreeNode node) {
        if (node == null)
            node = root;

        for (TreeNode child : node.getChildren()) {
            if (child.getName().equals(nodeName))
                return node;

            TreeNode parent = findParentNode(nodeName, child);
            if (parent != null)
                return parent;
        }

        return null;
    }
}
