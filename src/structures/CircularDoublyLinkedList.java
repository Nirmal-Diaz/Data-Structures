package structures;

public class CircularDoublyLinkedList<T> implements List<T>, Deque<T> {
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    private class Node {
        T data = null;
        Node next = null;
        Node previous = null;
    }

    public CircularDoublyLinkedList(T[] initialData) {
        for (int i = 0; i < initialData.length; i++) {
            push(initialData[i]);
        }
    }

    // LIST INTERFACE METHODS
    public int length() {
        return size;
    }

    public T get(int index) {
        if (isEmpty()) {
            // Case: Get when empty
            throw new IllegalStateException("Linked list is empty");
        } else if ((index < 0) || (index > size - 1)) {
            // Case: Get at an index that is out of bounds
            throw new IllegalArgumentException("Index must honor the range '0 <= index <= size - 1'");
        } else {
            // Case: Get at an index that is between bounds
            Node nodeAtIndex = getNode(index);
            return nodeAtIndex.data;
        }
    }

    public void set(int index, T newData) {
        if (isEmpty()) {
            // Case: Set when empty
            throw new IllegalStateException("Linked list is empty");
        } else if ((index < 0) || (index > size - 1)) {
            // Case: Set at an index that is out of bounds
            throw new IndexOutOfBoundsException("Index must honor the range '0 <= index <= size - 1'");
        } else {
            // Case: Set at an index that is between bounds
            Node nodeAtIndex = getNode(index);
            nodeAtIndex.data = newData;
        }
    }

    public int size() {
        return size;
    }

    public void add(int index, T data) {
        if (isEmpty() && index == 0) {
            // Case: Add at head when empty
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = newNode;
            newNode.previous = newNode;
            head = newNode;
            tail = newNode;
            size++;
        } else if ((index < 0) || (index > size)) {
            // Case: Add at an index that is out of bounds
            throw new IllegalArgumentException("Index must honor the range '0 <= index <= size'");
        } else if (index == 0) {
            // Case: Add at head when not empty
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = head;
            newNode.previous = tail;
            head.previous = newNode;
            head = newNode;
            size++;
        } else if (index == size) {
            // Case: Add at after the tail
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = head;
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
            size++;
        } else {
            // Case: Add at an index that is between bounds
            Node nodeAtIndex = getNode(index);
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = nodeAtIndex;
            newNode.previous = nodeAtIndex.previous;
            nodeAtIndex.previous.next = newNode;
            nodeAtIndex.previous = newNode;
            size++;
        }
    }

    public T remove(int index) {
        if (isEmpty()) {
            // Case: Remove when empty
            throw new IllegalStateException("Linked list is empty");
        } else if ((index < 0) || (index > size - 1)) {
            // Case: Remove an index that is out of bounds
            throw new IndexOutOfBoundsException("Index must honor the range '0 <= index <= size - 1'");
        } else if ((index == 0) && (size == 1)) {
            // Case: Remove head/tail when only 1 element is present
            T dataOfHead = head.data;
            head = null;
            tail = null;
            size--;
            return dataOfHead;
        } else if ((index == 0) && (size == 2)) {
            // Case: Remove head when only 2 elements are present
            T dataOfHead = head.data;
            tail.next = tail;
            tail.previous = tail;
            head = tail;
            size--;
            return dataOfHead;
        } else if ((index == size - 1) && (size == 2)) {
            // Case: Remove tail when only 2 elements are present
            T dataOfTail = tail.data;
            head.next = head;
            head.previous = head;
            tail = head;
            size--;
            return dataOfTail;
        } else if ((index == 0) && (size > 2)) {
            // Case: Remove head when more than 2 elements are present
            T dataOfHead = head.data;
            head.next.previous = tail;
            tail.next = head.next;
            head = head.next;
            size--;
            return dataOfHead;
        } else if ((index == size - 1) && (size > 2)) {
            // Case: Remove tail when more than 2 elements are present
            T dataOfTail = tail.data;
            tail.previous.next = head;
            head.previous = tail.previous;
            tail = tail.previous;
            size--;
            return dataOfTail;
        } else {
            // Case: Remove an index that is between bounds
            Node nodeAtIndex = getNode(index);
            nodeAtIndex.next.previous = nodeAtIndex.previous;
            nodeAtIndex.previous.next = nodeAtIndex.next;
            size--;
            return nodeAtIndex.data;
        }
    }

    // DEQUE INTERFACE METHODS
    public void push(T data) {
        add(size, data);
    }

    public T pop() {
        return remove(size - 1);
    }

    public T shift() {
        return remove(0);
    }

    public void unshift(T data) {
        add(0, data);
    }

    // UTILITY METHODS
    private Node getNode(int index) {
        if (index <= ((size - 1) / 2)) {
            // Case: Get an index near the front
            Node nodeAtIndex = head;
            for (int i = 0; i < index; i++) {
                nodeAtIndex = nodeAtIndex.next;
            }
            return nodeAtIndex;
        } else {
            // Case: Get an index near the rear
            Node nodeAtIndex = tail;
            for (int i = size - 1; i > index; i--) {
                nodeAtIndex = nodeAtIndex.previous;
            }
            return nodeAtIndex;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        Node currentNode = head;
        StringBuilder content = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            content.append(currentNode.data + ", ");
            currentNode = currentNode.next;
        }
        content.append("]");
        return content.toString();
    }
}