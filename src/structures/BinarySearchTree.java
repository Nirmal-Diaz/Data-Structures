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

    //UTILITY METHODS
    void print(String order) {
        System.out.print(size() + " : ");
        switch (order) {
            case "pre":
                printPreOrder(root);
                break;
            case "in":
                printInOrder(root);
                break;
            case "post":
                printPostOrder(root);
                break;
            case "level":
                printLevelOrder();
                break;
            default:
                System.out.println("Invalid print order");
        }
        System.out.print("\n");
    }

    private void printPreOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.data + " ");
            printInOrder(node.right);
        }
    }

    private void printPostOrder(Node node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    private void printLevelOrder() {
        StringBuilder stringifiedTree = new StringBuilder();
        java.util.Deque<Node> printQueue = new ArrayDeque<>();

        if (root != null) {
            printQueue.add(root);
            while (!printQueue.isEmpty()) {
                Node nextNode = (Node) printQueue.removeFirst();
                stringifiedTree.append(nextNode.data + " ");
                if (nextNode.left != null) {
                    printQueue.add(nextNode.left);
                }
                if (nextNode.right != null) {
                    printQueue.add(nextNode.right);
                }
            }
        }
        
        System.out.println(stringifiedTree);
    }
}