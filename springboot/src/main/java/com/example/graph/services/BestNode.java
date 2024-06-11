package com.example.graph.services;

import com.example.graph.Ant.AntColonyOptimization;
import com.example.graph.graph_base.Graph;
import com.example.graph.graph_base.Node;

import java.util.List;

public class BestNode {
    private List<String> nodeNames;

    public BestNode(List<String> nodeNames) {
        this.nodeNames = nodeNames;
    }

    // 方法：遍历并打印字符串列表
    public static void traverseAndPrintList(List<String> list) {
        for (String str : list) {
            System.out.println(str);
        }
    }

    // 方法：找到距离目标节点最近的节点
    public Node findClosestNode(AntColonyOptimization aco, Graph graph, Node targetNode) {
        Node closestNode = null;
        double shortestDistance = Double.MAX_VALUE;

        for (String nodeName : nodeNames) {
            Node currentNode = graph.findNode(nodeName);
            if (currentNode != null) {
                System.out.println("Finding path from " + currentNode.name + " to " + targetNode.name);
                List<Node> path = aco.findShortestPath(currentNode, targetNode, 10, 100); // 假设使用10个蚂蚁和100次迭代
                if (path != null) {
                    double distance = aco.calculatePathLength(path);
                    System.out.println("Path found with length: " + distance);
                    if (distance < shortestDistance) {
                        shortestDistance = distance;
                        closestNode = currentNode;
                    }
                } else {
                    System.out.println("No path found from " + currentNode.name + " to " + targetNode.name);
                }
            }
        }

        return closestNode;
    }
}