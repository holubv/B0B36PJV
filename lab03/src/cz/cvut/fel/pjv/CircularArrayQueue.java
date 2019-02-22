package cz.cvut.fel.pjv;

/**
 * Implementation of the {@link Queue} backed by fixed size array.
 */
public class CircularArrayQueue implements Queue {

    private int capacity;
    private int size;

    private String[] arr;
    private int head;
    private int tail;

    public CircularArrayQueue() {
        this(5);
    }

    public CircularArrayQueue(int capacity) {
        this.capacity = capacity;
        this.arr = new String[capacity];
    }

    private int incrementPos(int pos) {
        return (pos + 1) % this.capacity;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean isFull() {
        return this.size() == this.capacity;
    }

    @Override
    public boolean enqueue(String obj) {
        if (obj == null || this.isFull()) {
            return false;
        }

        this.size++;
        this.arr[this.tail] = obj;
        this.tail = this.incrementPos(this.tail);
        return true;
    }

    @Override
    public String dequeue() {
        if (isEmpty()) {
            return null;
        }

        String val = this.arr[this.head];
        this.size--;
        this.head = this.incrementPos(this.head);

        return val;
    }

    @Override
    public void printAllElements() {

        for (int i = this.head; i != this.tail; i = this.incrementPos(i)) {
            System.out.println(this.arr[i]);
        }
    }
}
