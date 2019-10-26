package structures;

public class ArrayDeque<T> implements Array<T>, Deque<T> {
    private int frontIndex = 0;
    private int rearIndex = 0;
    private Object[] internalArray;

    public ArrayDeque(int length) {
        internalArray = new Object[length];
    }

    public ArrayDeque(T[] initialData, int length) {
        if (length < initialData.length) {
            throw new IllegalArgumentException("Length must exceed or equal to initialData.length");
        } else {
            internalArray = new Object[length];
            for (int i = 0; i < initialData.length; i++) {
                internalArray[i] = initialData[i];
            }
            rearIndex = initialData.length - 1;
        }
    }

    public ArrayDeque(T[] initialData) {
        this(initialData, initialData.length);
    }

    //ARRAY INTERFACE METHODS
    public int length() {
        return internalArray.length;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (isEmpty()) {
            throw new IllegalStateException("Deque underflow");
        } else if ((index > rearIndex) || (index < frontIndex)) {
            throw new IndexOutOfBoundsException("Index must honor the range '0 <= index <= size - 1'");
        } else {
            index = frontIndex + index;
            if (index > internalArray.length - 1) {
                return (T)internalArray[index - internalArray.length];
            } else {
                return (T)internalArray[index];
            }
        }
    }

    public void set(int index, T newData) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Deque overflow");
        } else if ((index >= internalArray.length) || (index < 0)) {
            throw new ArrayIndexOutOfBoundsException("No such index exists");
        } else {
            index = frontIndex + index;
            if (index > internalArray.length - 1) {
                internalArray[index - internalArray.length] = newData;
            } else {
                internalArray[index] = newData;
            }
        }
    }

    //DEQUE INTERFACE METHODS
    public void push(T data) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Deque overflow");
        } else if (isEmpty()) {
            internalArray[rearIndex] = data;
        } else if (rearIndex == internalArray.length - 1) {
            rearIndex = 0;
            internalArray[rearIndex] = data;
        } else {
            internalArray[++rearIndex] = data;
        }
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Deque underflow");
        } else if (rearIndex == frontIndex) {
            T rearElement = (T)internalArray[rearIndex];
            internalArray[rearIndex] = null;
            return rearElement;
        } else if (rearIndex == 0) {
            T rearElement = (T)internalArray[rearIndex];
            internalArray[rearIndex] = null;
            rearIndex = internalArray.length - 1;
            return rearElement;
        } else {
            T rearElement = (T)internalArray[rearIndex];
            internalArray[rearIndex] = null;
            rearIndex--;
            return rearElement;
        }
    }

    @SuppressWarnings("unchecked")
    public T shift() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Deque underflow");
        } else if (frontIndex == rearIndex) {
            T frontElement = (T)internalArray[frontIndex];
            internalArray[frontIndex] = null;
            return frontElement;
        } else if (frontIndex == internalArray.length - 1) {
            T frontElement = (T)internalArray[frontIndex];
            internalArray[frontIndex] = null;
            frontIndex = 0;
            return frontElement;
        } else {
            T frontElement = (T)internalArray[frontIndex];
            internalArray[frontIndex] = null;
            frontIndex++;
            return frontElement;
        }
    }

    public void unshift(T data) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Deque overflow");
        } else if (isEmpty()) {
            internalArray[frontIndex] = data;
        } else if (frontIndex == 0) {
            frontIndex = internalArray.length - 1;
            internalArray[frontIndex] = data;
        } else {
            internalArray[--frontIndex] = data;
        }
    }

    //UTILITY METHODS
    boolean isEmpty() {
        return (frontIndex == rearIndex) && (internalArray[frontIndex] == null);
    }

    boolean isFull() {
        if ((frontIndex == 0) && (rearIndex == internalArray.length - 1)) {
            return true;
        } else if (rearIndex == frontIndex - 1) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        } else if (frontIndex < rearIndex) {
            return rearIndex - frontIndex;
        } else if (frontIndex > rearIndex) {
            return length() - (frontIndex - rearIndex);
        } else {
            return 1;
        }
    }

    public void clear() {
        frontIndex = rearIndex = 0;
        internalArray[frontIndex] = null;
    }

    @Override
    public String toString() {
        StringBuilder stringifiedInternalArray = new StringBuilder("[");
        for (int i = 0; i < internalArray.length; i++) {
            stringifiedInternalArray.append(internalArray[i] + ", ");
        }
        stringifiedInternalArray.append("]");
        return stringifiedInternalArray.toString();
    }
}