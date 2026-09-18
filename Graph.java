import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Graph {
  private class Node {
    private String label;

    public Node(String label) {
      this.label = label;
    }

    @Override 
    public String toString() {
      return label;
    }
  }
  private Map<String, Node> nodes = new HashMap<>();
  private Map<Node, List<Node>> adjacencyList = new HashMap<>();

  public void addNode(String label) {
    var newNode = new Node(label);
    nodes.putIfAbsent(label, newNode);
    adjacencyList.putIfAbsent(newNode, new ArrayList<>());
  }

  public void addEdge(String from, String to) {
    var fromNode = nodes.get(from);
    var toNode = nodes.get(to);
    if (fromNode == null || toNode == null) {
      throw new IllegalArgumentException();
    }
    adjacencyList.get(fromNode).add(toNode);
  }

  public void removeNode(String label) {
    var node = nodes.get(label);
    if (node == null)
      return;

    for (var n : adjacencyList.keySet())
      adjacencyList.get(n).remove(node);

    adjacencyList.remove(node);
    nodes.remove(label);
  }
  
  public void remvoeEdge(String from, String to) {
    var fromNode = nodes.get(from);
    var toNode = nodes.get(to);

    if (fromNode == null || toNode == null)
      return;

    adjacencyList.get(fromNode).remove(toNode);
  }
  
  public void traverceDepthFirst(String root) {
    traverceDepthFirst(nodes.get(root), new HashSet<>());
  }
  
  private void traverceDepthFirst(Node node, Set<Node> visited) {
    System.out.println(node);
    visited.add(node);

    for(var n : adjacencyList.get(node))
      if(!visited.contains(n))
        traverceDepthFirst(n, visited);
  }
  
  public void traverceDepthFirstIte(String root) {
    var node = nodes.get(root);
    if (node == null)
      return;

    Stack<Node> stack = new Stack<>();
    Set<Node> visited = new HashSet<>();
    stack.push(node);

    while (!stack.isEmpty()) {
      var current = stack.pop();

      if (visited.contains(current))
        continue;

      System.out.println(current);
      visited.add(current);

      for (var n : adjacencyList.get(current)) {
        if (!visited.contains(n))
          stack.push(n);
      }
    }
  }
  
  public void traverceBreadthFirst(String root) {
    var node = nodes.get(root);
    if (node == null)
      return;

    Queue<Node> queue = new ArrayDeque<>();
    Set<Node> visited = new HashSet<>();
    queue.add(node);

    while (!queue.isEmpty()) {
      var current = queue.remove();

      if (visited.contains(current))
        continue;

      System.out.println(current);
      visited.add(current);

      for (var n : adjacencyList.get(current)) {
        if (!visited.contains(n))
          queue.add(n);
      }
    }
  }

  public boolean hasCycle() {
    Set<Node> all = new HashSet<>();
    all.addAll(nodes.values());

    Set<Node> visiting = new HashSet<>();
    Set<Node> visited = new HashSet<>();

    while (!all.isEmpty()) {
      var current = all.toArray(new Node[0])[0];
      if (hasCycle(current, all, visiting, visited)) {
        return true;
      }
    }

    return false;
  }

  private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
    all.remove(node);
    visiting.add(node);
    for (var n : adjacencyList.get(node)) {
      if (visited.contains(node))
        continue;

      if (visiting.contains(node))
        return true;

      var result = hasCycle(n, all, visiting, visited);
      if (result)
        return true;
    }
    
    visiting.remove(node);
    visited.add(node);

    return false;
  }

  public void print() {
    for (var source : adjacencyList.keySet()) {
      var targets = adjacencyList.get(source);
      if (!targets.isEmpty())
        System.out.println(source + " is connected to " + targets);
    }
  }
}