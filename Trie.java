import java.util.HashMap;

public class Trie {
  public static int ALPHABET_SIZE = 26;

  private class Node {
    private char value;
    private HashMap<Character, Node> children = new HashMap<>();
    private boolean isEndOfTheWord;

    public Node(char c) {
      this.value = c;
    }

    public boolean hasNode(char ch){
      return children.containsKey(ch);
    }

    public void addChild(char ch) {
      children.put(ch, new Node(ch));
    }

    public Node getChild(char ch) {
      return children.get(ch);
    }

    public Node[] getChildren() {
      return children.values().toArray(new Node[0]);
    }

    public boolean hasChildren(char ch) {
      return !children.isEmpty();
    }

    public void removeChild(char ch) {
      children.remove(ch);
    }

    @Override
    public String toString() {
      return "value " + value;
    }
  }

  private Node root = new Node(' ');

  public void insert(String word) {
    var currentNode = root;
    for (var ch : word.toCharArray()) {
      if (!currentNode.hasNode(ch))
        currentNode.addChild(ch);
      currentNode = currentNode.getChild(ch);
    }

    currentNode.isEndOfTheWord = true;
  }

  public boolean contains(String word) {
    if (word == null)
      return false;

    Node currentNode = root;
    for (char ch : word.toCharArray()) {
      if (currentNode.hasNode(ch))
        currentNode = currentNode.getChild(ch);
      else
        return false;
    }

    if (currentNode.isEndOfTheWord)
      return true;

    return false;
  }
  
  public void traversePreOrder() {
    traversePreOrder(root);
  }
  
  private void traversePreOrder(Node node) {
    System.out.print(node.value + " ");
    for (Node child : node.getChildren()) {
      traversePreOrder(child);
    }
  }

  public void traversePostOrder() {
    traversePostOrder(root);
  }
  
  private void traversePostOrder(Node node) {
    for (Node child : node.getChildren()) {
      traversePostOrder(child);
    }
    System.out.print(node.value + " ");
  }

  public void remove(String word) {
    remove(root, word, 0);
  }

  private void remove(Node node, String word, int index) {
    if (index == word.length()) {
      node.isEndOfTheWord = false;
      return;
    }

    var ch = word.charAt(index);
    var child = node.getChild(ch);

    remove(child, word, index + 1);

    if (child.hasChildren(ch)) {
      child.removeChild(ch);
    }
  }

}
