public class AvlTree {
  private class AvlNode {
    private int value;
    private AvlNode left;
    private AvlNode right;
    private int height;

    @Override 
    public String toString() {
      return "Node = " + value;
    }

    public AvlNode(int number) {
      this.value = number;
    }
  }

  private AvlNode root;

  public void insert(int value) {
    root = insert(root, value);
  }

  private AvlNode insert(AvlNode node, int value) {
    if (node == null)
      return new AvlNode(value);

    if (node.value > value)
      node.left = insert(node.left, value);
    else
      node.right = insert(node.right, value);

    setHeight(node);

    return balance(node);
  }

  private AvlNode balance(AvlNode node) {
    if (isLeftHeavy(node)) {
      if (balanceFactor(node.right) < 0)
        node.left = rotateLeft(node.left);
      return rotateRight(node);
    } else if (isRightHeavy(node)) {
      if (balanceFactor(node.right) > 0)
        node.right = rotateRight(node.right);
      return rotateLeft(node);
    }

    return node;
  }
  
  private AvlNode rotateLeft(AvlNode node) {
    var newRoot = root.right;
    root.right = newRoot.left;
    newRoot.left = root;

    setHeight(root);
    setHeight(newRoot);

    return newRoot;
  }

  private AvlNode rotateRight(AvlNode node) {
    var newRoot = root.left;
    root.left = newRoot.right;
    newRoot.right = root;
    
    setHeight(root);
    setHeight(newRoot);

    return newRoot;
  }

  private void setHeight(AvlNode node) {
    node.height = Math.max(
      height(root.left),
      height(root.right)
    ) + 1;
  }

  private boolean isLeftHeavy(AvlNode node) {
    return balanceFactor(node) > 1;
  }

  private boolean isRightHeavy(AvlNode node) {
    return balanceFactor(node) < -1;
  }

  private int balanceFactor(AvlNode node) {
    return (node == null) ? 0 : height(node.left) - height(node.right);
  }
  
  private int height(AvlNode node) {
    return (node == null) ? -1 : node.height;
  }

}