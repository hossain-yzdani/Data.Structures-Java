import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph {
  private class Node {
    private String label;
    private List<Edge> edges = new ArrayList<>();

    public Node(String label) {
      this.label = label;
    }

    public void addEdge(Node to, int weight) {
      Edge newEdge = new Edge(this, to, weight);
      this.edges.add(newEdge);
    }

    @Override
    public String toString() {
      return label;
    }
  }
  
  private class Edge {
    private Node from;
    private Node to;
    private int weight;

    public Edge(Node from, Node to, int weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }

    @Override
    public String toString() {
      return from + " -> " + to;
    }
  }
  
  private Map<String, Node> nodes = new HashMap<>();

  public void addNode(String label) {
    nodes.putIfAbsent(label, new Node(label));
  }

  public void addEdge(String from, String to, int weight) {
    var fromNode = nodes.get(from);
    var toNode = nodes.get(to);
    if (fromNode == null || toNode == null) {
      throw new IllegalArgumentException();
    }
    fromNode.addEdge(toNode, weight);
    toNode.addEdge(toNode, weight);
  }

  public void print() {
    for (var node : nodes.values()) {
      var targets = node.edges;
      if (!targets.isEmpty())
        System.out.println(node + " is connected to " + targets);
    }
  }

}