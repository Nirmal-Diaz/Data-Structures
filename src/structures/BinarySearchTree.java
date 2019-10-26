package structures;

import java.util.ArrayDeque;

public class BinarySearchTree {
    private Node root = null;
    private int size = 0;

    private class Node {
        Integer data = null;
        Node left = null;
        Node right = null;
    }

    public enum TreeTraversalOrder {
        PRE_ORDER, IN_ORDER, POST_ORDER, LEVEL_ORDER
    }

    public BinarySearchTree(int[] initialData) {
        for (int i = 0; i < initialData.length; i++) {
            add(initialData[i]);
        }
    }

    public int size() {
        return size;
    }

    public void add(int data) {
        if (isEmpty()) {
            Node newNode = new Node();
            newNode.data = data;
            root = newNode;
        } else {
            Node parentNode = root;
            while (true) {
                if (data > parentNode.data) {
                    if (parentNode.right == null) {
                        Node newNode = new Node();
                        newNode.data = data;
                        parentNode.right = newNode;
                        break;
                    } else {
                        parentNode = parentNode.right;
                    }
                } else {
                    if (parentNode.left == null) {
                        Node newNode = new Node();
                        newNode.data = data;
                        parentNode.left = newNode;
                        break;
                    } else {
                        parentNode = parentNode.left;
                    }
                }
            }
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return print(TreeTraversalOrder.LEVEL_ORDER);
    }

    public String print(TreeTraversalOrder order) {
        StringBuilder content = new StringBuilder("[");
        switch (order) {
            case PRE_ORDER:
                printPreOrder(root, content);
                break;
            case IN_ORDER:
                printInOrder(root, content);
                break;
            case POST_ORDER:
                printPostOrder(root, content);
                break;
            case LEVEL_ORDER:
                printLevelOrder(content);
                break;
            default:
                throw new IllegalArgumentException("Invalid print order");
        }
        content.append("]");
        System.out.println(content);
        return content.toString();
    }

    private void printPreOrder(Node node, StringBuilder content) {
        if (node != null) {
            content.append(node.data + ", ");
            printPreOrder(node.left, content);
            printPreOrder(node.right, content);
        }
    }

    private void printInOrder(Node node, StringBuilder content) {
        if (node != null) {
            printInOrder(node.left, content);
            content.append(node.data + ", ");
            printInOrder(node.right, content);
        }
    }

    private void printPostOrder(Node node, StringBuilder content) {
        if (node != null) {
            printPostOrder(node.left, content);
            printPostOrder(node.right, content);
            content.append(node.data + ", ");
        }
    }

    private void printLevelOrder(StringBuilder stringifiedTree) {
        java.util.Deque<Node> printQueue = new ArrayDeque<>();

        if (root != null) {
            printQueue.add(root);
            while (!printQueue.isEmpty()) {
                Node nextNode = (Node) printQueue.removeFirst();
                stringifiedTree.append(nextNode.data + ", ");
                if (nextNode.left != null) {
                    printQueue.add(nextNode.left);
                }
                if (nextNode.right != null) {
                    printQueue.add(nextNode.right);
                }
            }
        }
    }
}