package ru.vsu.cs.oop.volkov_a_a.my_list;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyList<T> implements Iterable<T> {


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

    private Node<T> getnode(int index) throws ListException {
        if (index < 0 || index >= size) {
            throw new ListException(String.format("Incorrect index [%d]", index));
        }
        Node<T> curr;
        if (index < size/2) {
            curr = head;
            for (int i = 0; i < index; i++){
                curr = curr.next;
            }
        }
        else {
            curr = tail;
            for (int i = size - 1; i > index; i--)
                curr = curr.prev;
        }
        return curr;
    }

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

    public T remfirst() throws ListException {
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

    public T set(int index, T value) throws ListException {
        return getnode(index).value = value;
    }

    public T get(int index) throws ListException {
        return getnode(index).value;
    }

    public void cler(){
        head = null;
        tail = null;
        size = 0;
    }

    public void insert(int index, T value) throws ListException {
        if (index < 0 || index >= size) {
            throw new ListException(String.format("Incorrect index [%d]", index));
        }
        if (index == 0){
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        }
        else {
            Node<T> curr = getnode(index);
            Node<T> prev_neighbor = curr.prev;
            Node<T> n = new Node<>(value);
            n.prev = prev_neighbor;
            n.next = curr;
            prev_neighbor.next = n;
            curr.prev = n;
            size++;
        }
    }

    public T remove(int index) throws ListException {
        if (index < 0 || index >= size) {
            throw new ListException(String.format("Incorrect index [%d]", index));
        }
        if (index == 0) {
            return remfirst();
        }
        if (index == size - 1) {
            return remlast();
        }
        Node<T> node = getnode(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
        return node.value;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> curr = head;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                if (curr == null) {
                    throw new NoSuchElementException();
                }
                T value = curr.value;
                curr = curr.next;
                return value;
            }
        };
    }

    public Iterator<T> descIterator() {
        return new Iterator<T>() {
            private Node<T> curr = tail;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                if (curr == null) {
                    throw new NoSuchElementException();
                }
                T value = curr.value;
                curr = curr.prev;
                return value;
            }
        };
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
