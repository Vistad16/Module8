package JavaCore.module8.task3;

import java.util.NoSuchElementException;
import java.util.Objects;

public class MyQueue<T> {
    static class Node<T>{
        private T element;
        private Node<T> next;

        public Node(T element){
            this.element = element;
        }
    }

    private Node<T> last;
    private Node<T> first;
    private int size;


    //add
    public void add(T value){
        Node<T> addNode = new Node<>(value);
        if (first == null) {
            first = last = addNode;
        } else  {
            this.last.next = addNode;
            last = addNode;
        }
        size++;
    }


    //remove
    public void remove(int index){
        Objects.checkIndex(index, size);
        if (index == 0) {
            first = first.next;
            if (first == null) {
                last = null;
            }
        } else {
            Node<T> prev = getNodeByIndex(index - 1);
            prev.next = prev.next.next;
            if (index == size - 1) {
                last = prev;
            }
        }
        size--;
    }

    //get node by index for "remove"
    private Node<T> getNodeByIndex(int index) {
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }


    //clear
    public void clear(){
        first = last = null;
        size = 0;
    }


    //size
    public int size(){
        return size;
    }


    //peek
    public T peek(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return get(0);
    }

    //get
    private T get(int index) {
        Objects.checkIndex(index, size);
        return getNodeByIndex(index).element;
    }


    //poll
    public T poll(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T result = get(0);
        first = first.next;
        return result;
    }

    public boolean isEmpty(){
        return first == null;
    }

}
