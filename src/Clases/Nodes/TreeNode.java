/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases.Nodes;
import java.util.ArrayList;
import java.util.List;
/**
 *
 \\\* @author Axel
 */
public class TreeNode {
    String name;
    List<TreeNode> children = new ArrayList<>();

    public TreeNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<TreeNode> getChildren() {
        return children;
    }
}
