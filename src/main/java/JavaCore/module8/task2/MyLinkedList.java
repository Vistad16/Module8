package JavaCore.module8.task2;

import java.util.NoSuchElementException;
import java.util.Objects;

public class MyLinkedList<T> {
    static class Node<T> {
        private T element;
        private Node<T> next;

        public Node(T element){
            this.element = element;
        }

    }

    private Node<T> last;
    private Node<T> first;
    private int size;

    public static <T> MyLinkedList<T> of(T... elements) {
        MyLinkedList<T> myLinkedList = new MyLinkedList<>();
        for (T e : elements) {
            myLinkedList.add(e);
        }
        return myLinkedList;
    }


    //add
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (first == null) {
            first = last = newNode;
        } else {
            this.last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public void add(int index, T element) {
        Objects.checkIndex(index, size + 1);
        Node<T> newNode = new Node<>(element);
        if (first == null){
            first = last = newNode;
        } else if (index == 0) {
            newNode.next = first;
        } else if (index == size) {
            last.next = newNode;
            last = newNode;
        } else {
            Node<T> current = getNodeByIndex(index - 1);
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }


    //get node by index for "set", "add" and "remove"
    private Node<T> getNodeByIndex(int index) {
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }


    //set
    public void set(int index, T element) {
        Objects.checkIndex(index, size);
        Node<T> node = getNodeByIndex(index);
        node.element = element;

    }


    //get
    public T get(int index) {
        Objects.checkIndex(index, size);
        return getNodeByIndex(index).element;
    }


    //get first
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return get(0);
    }


    //get last
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return get(size - 1);
    }


    //remove
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T removedElement;
        if (index == 0) {
            removedElement = first.element;
            first = first.next;
            if (first == null) {
                last = null;
            }
        } else {
            Node<T> prev = getNodeByIndex(index - 1);
            removedElement = prev.next.element;
            prev.next = prev.next.next;
            if (index == size - 1) {
                last = prev;
            }
        }
        size--;
        return removedElement;
    }


    //contains
    public boolean contains(T element) {
        Node<T> current = first;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    //is empty
    public boolean isEmpty() {
        return first == null;
    }


    //size
    public int size() {
        return size;
    }


    //clear
    public void clear() {
        first = last = null;
        size = 0;
    }
}
