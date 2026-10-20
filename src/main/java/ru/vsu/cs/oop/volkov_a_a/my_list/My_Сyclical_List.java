package ru.vsu.cs.oop.volkov_a_a.my_list;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class My_Сyclical_List<T> implements Iterable<T> {

    private static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void addLast(T value) {
        Node<T> n = new Node<>(value);
        if (head == null) {
            n.next = n.prev = n;
            head = n;
        } else {
            Node<T> last = head.prev;
            n.prev = last;
            n.next = head;
            last.next = n;
            head.prev = n;
        }
        size++;
    }

    public void addFirst(T value) {
        addLast(value);
        head = head.prev;
    }

    public T getFirst() throws ListException {
        checkEmpty();
        return head.value;
    }

    public T getLast() throws ListException {
        checkEmpty();
        return head.prev.value;
    }

    public T remfirst() throws ListException{
        checkEmpty();
        T value = head.value;
        if (size == 1){
            head = null;
        }
        else {
            Node<T> last = head.prev;
            head = head.next;
            head.prev = last;
            last.next = head;
        }
        size--;
        return value;
        }

    public T remlast() throws ListException{
        checkEmpty();
        T value = head.value;
        if (size == 1){
            return remfirst();
        }
        else {
            Node<T> last = head.prev;
            Node<T> newLast = last.prev;
            newLast.next = head;
            head.prev = newLast;
        }
        size--;
        return value;
    }

    public T get(int index) throws ListException {
        if (index < 0 || index >= size) {
            throw new ListException(String.format("Incorrect index [%d]", index));
        }
        Node<T> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.value;
    }

    public void rotate(int k) {
        if (size <= 1) return;
        k = ((k % size) + size) % size;
        for (int i = 0; i < k; i++) {
            head = head.next;
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> cur = head;
        for (int i = 0; i < size; i++) {
            sb.append(cur.value);
            if (i < size - 1) {
                sb.append(", ");
            }
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> curr = head;
            private int passed = 0;

            @Override
            public boolean hasNext() {
                return passed < size;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T value = curr.value;
                curr = curr.next;
                passed++;
                return value;
            }
        };
    }

    private void checkEmpty() throws ListException {
        if (isEmpty()) {
            throw new ListException("List is empty");
        }
    }
}

