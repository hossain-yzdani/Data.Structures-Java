public class Tree {
  private class Node {
    int value;
    Node left;
    Node right;

    @Override 
    public String toString() {
      return "Node = " + value;
    }
  
    public Node(int number) {
      this.value = number;
    }
  }

  private Node root;

  public void insert(int value) {
    Node newNode = new Node(value);
    if (root == null) {
      root = newNode;
      return;
    }

    var currentNode = root;
    
    while (true) {
      if (currentNode.value >= value) {
        if (currentNode.left == null) {
          currentNode.left = newNode;
          break;
        }
        currentNode = currentNode.left;
      } else {
        if (currentNode.right == null) {
          currentNode.right = newNode;
          break;
        }
        currentNode = currentNode.right;
      }
    }
  }

  public boolean find(int value) {
    if (root == null) {
      return false;
    }

    var currentNode = root;
    while (currentNode != null) {
      if (currentNode.value > value)
        currentNode = currentNode.left;
      else if (currentNode.value < value)
        currentNode = currentNode.right;
      else
        return true;

    }

    return false;
  }

  public void traversePreOrder() {
    traversePreOrder(root);
  }

  private void traversePreOrder(Node node) {
    if (node == null) {
      return;
    }
    System.out.print(node.value + " ");
    traversePreOrder(node.left);
    traversePreOrder(node.right);
  }

  public void traverseInOrder() {
    traverseInOrder(root);
  }

  private void traverseInOrder(Node node) {
    if (node == null) {
      return;
    }
    traverseInOrder(node.left);
    System.out.print(node.value + " ");
    traverseInOrder(node.right);
  }

  public void traversePostOrder() {
    traversePostOrder(root);
  }

  private void traversePostOrder(Node node) {
    if (node == null) {
      return;
    }
    traversePostOrder(node.left);
    traversePostOrder(node.right);
    System.out.print(node.value + " ");
  }

  public int height() {
    return height(root);
  }
  
  private int height(Node node) {
    if (node == null) {
      return -1;
    }

    return (1 + Math.max(height(node.left), height(node.right)));
  }

  public int min() {
    return min(root);
  }
  
  private int min(Node node) {
    while (node.left != null) {
      node = node.left;
    }

    return node.value;
  }

  public boolean equals(Tree other) {
    return equals(root, other.root);
  }
  
  private boolean equals(Node nodeOne, Node nodeTwo) {
    if (nodeOne == null && nodeTwo == null) {
      return true;
    }

    if (nodeOne != null && nodeTwo != null) {
      return nodeOne.value == nodeTwo.value
          && equals(nodeOne.left, nodeTwo.left)
          && equals(nodeOne.right, nodeTwo.right);
    }

    return false;
  }

  public boolean isBST() {
    return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  
  private boolean isBST(Node node, int min, int max) {
    if (node == null) {
      return true;
    }

    if (node.value < min && node.value > max) {
      return false;
    }

    return isBST(node.left, min, node.value - 1)
        && isBST(node.right, node.value + 1, max);
  }

  public void printNodeAtDistance(int distance) {
    printNodeAtDistance(root, distance);
  }
  
  private void printNodeAtDistance(Node node, int distance) {
    if (node == null) {
      return;
    }
    if (distance == 0) {
      System.out.print(node.value + " ");
    }

    printNodeAtDistance(node.left, distance - 1);
    printNodeAtDistance(node.right, distance - 1);
  }

  public void traverseLevelOrder() {
    for (var i = 0; i <= height(); i++) {
      printNodeAtDistance(i);
    }
  }

}