package structures;

public class ArrayStack<T> implements Array<T>, Stack<T>{
    private int topIndex = -1;
    private Object[] internalArray;

    public ArrayStack(int length) {
        internalArray = new Object[length];
    }

    public ArrayStack(T[] initialData, int length) {
        if (length < initialData.length) {
            throw new IllegalArgumentException("Length must exceed or equal to initialData.length");
        } else {
            internalArray = new Object[length];
            for (int i = 0; i < initialData.length; i++) {
                internalArray[i] = initialData[i];
            }
            topIndex = initialData.length - 1;
        }
    }

    public ArrayStack(T[] initialData) {
        this(initialData, initialData.length);
    }

    //ARRAY INTERFACE METHODS
    public int length() {
        return internalArray.length;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (isEmpty()) {
            //Case: Get when empty
            throw new IllegalStateException("Array stack is empty");
        } else if ((index < 0) || (index > size() - 1)) {
            //Case: Get at an index that is out of bounds
            throw new IllegalArgumentException("Index must honor the range '0 <= index <= size - 1'");
        } else {
            //Case: Get at an index that is between bounds
            return (T)internalArray[index];
        }
    }

    public void set(int index, T newData) {
        if (isEmpty()) {
            //Case: Set when empty
            throw new IllegalStateException("Linked list is empty");
        } else if ((index < 0) || (index > size() - 1)) {
            //Case: Set at an index that is out of bounds
            throw new IndexOutOfBoundsException("Index must honor the range '0 <= index <= size - 1'");
        } else {
            //Case: Set at an index that is between bounds
            internalArray[index] = newData;
        }
    }

    //STACK INTERFACE METHODS
    public void push(T data) {
        if (isFull()) {
            throw new IllegalStateException("Stack overflow");
        } else {
            internalArray[++topIndex] = data;
        }
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack underflow");
        } else {
            return (T)internalArray[topIndex--];
        }
    }

    //UTILITY METHODS
    public boolean isEmpty() {
        return topIndex == -1;
    }

    public boolean isFull() {
        return topIndex == internalArray.length - 1;
    }

    public int size() {
        if (topIndex == -1) {
            return 0;
        } else {
            return topIndex + 1;
        }
    }

    public T top() {
        return get(topIndex);
    }

    public void clear() {
        topIndex = -1;
    }

    @Override
    public String toString() {
        StringBuilder stringifiedInternalArray = new StringBuilder("[");
        for (int i = 0; i < size(); i++) {
            stringifiedInternalArray.append(internalArray[i] + ", ");
        }
        return stringifiedInternalArray.toString();
    }
}