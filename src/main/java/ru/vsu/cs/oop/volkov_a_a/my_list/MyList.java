package ru.vsu.cs.oop.volkov_a_a.my_list;

public class MyList<T> {

    private static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addLast(T value) {
        Node<T> n = new Node<>(value);
        if (head == null) {
            head = tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
        size++;
    }

    public void addFirst(T value) {
        Node<T> n = new Node<>(value);
        if (head == null) {
            head = tail = n;
        }
        else {
            head.prev = n;
            n.next = head;
            head = n;
        }
        size++;
    }

    public T getfirst() throws ListException {
        checkEmpty();
        return head.value;
    }

    public T getlast() throws ListException {
        checkEmpty();
        return tail.value;
    }

    public T remlast() throws ListException{
        checkEmpty();
        T value = tail.value;
        if (size == 1){
            head = tail = null;
        }
        else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return value;
    }

    public T remfirst() throws ListException{
        checkEmpty();
        T value = head.value;
        if (size == 1){
            head = tail = null;
        }
        else {
            head = head.next;
            tail.next = null;
        }
        size--;
        return value;
        }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> cur = head;
        while (cur != null) {
            sb.append(cur.value);
            if (cur.next != null) {
                sb.append(", ");
            }
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }

    private void checkEmpty() throws ListException {
        if (isEmpty()) {
            throw new ListException("List is empty");
        }
    }
}
class ListException extends Exception {
    public ListException(String error) {
        super(error);
    }
}
