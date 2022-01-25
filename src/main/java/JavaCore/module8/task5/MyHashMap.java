package JavaCore.module8.task5;


import java.util.Objects;

public class MyHashMap<T, K> {

    static class Node<T, K>{
        private T key;
        private K velue;
        private Node<T, K> next;

        public Node(T key, K velue){
            this.key = key;
            this.velue = velue;
        }

        public final int hashCode() {
            return Objects.hashCode(key);
        }

        @Override
        public final boolean equals(Object o) {
            if (o == null) {
                return false;
            }

            if (!(o instanceof Node)) {
                return false;
            }

            Node<T, K> another = (Node<T, K>) o;
            int hashOfO = o.hashCode();
            int hashAnother = another.hashCode();
            return hashOfO == hashAnother;
        }

    }

    private Node<T, K> last;
    private Node<T, K> first;
    private int size;


    //put
    public void put(T key, K value){
        Node<T, K> addNode = new Node<>(key, value);
        if (first == null) {
            first = last = addNode;
        } else  {
            this.last.next = addNode;
            last = addNode;
        }
        size++;
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


    //get
    public K get(T key) {

        Node<T,K> x;
        for ( x = first; x != null; x = x.next ) {
            if (key.equals(x.key)) {
                return x.velue;
            }
        }
        return null;
    }


    //remove
    public void remove(T key) {
        size--;
        Node<T, K> nodeToRemove;
        int index = -1;
        for (Node<T, K> y = first; y != null; y = y.next) {
            index++;

            if (key.equals(y.key)) {
                nodeToRemove = y;
                Node<T, K> pointerForNextNode;
                pointerForNextNode = nodeToRemove.next;

                if (index >= 0 && index < size) {
                    Node<T, K> z = first;

                    if (index == 0){
                        first = z.next;
                    } else {
                        for (int i = 0; i < index - 1; i++) {
                            z = z.next;
                        }
                        z.next = pointerForNextNode;
                    }
                }
            }
        }
    }

}