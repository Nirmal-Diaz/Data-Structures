package structures;

interface Array<T> {
    public int length();
    public T get(int index);
    public void set(int index, T newData);
}

interface List<T> extends Array<T> {
    public int size();
    public void add(int index, T data);
    public T remove(int index);
}

interface Stack<T> {
    public void push(T data);
    public T pop();
}

interface Deque<T> extends Stack<T> {
    public T shift();
    public void unshift(T data);
}