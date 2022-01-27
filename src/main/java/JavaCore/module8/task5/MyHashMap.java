package JavaCore.module8.task5;

import java.util.NoSuchElementException;

public class MyHashMap<K, V> {
    private static final int CAPACITY = 16;
    private static final int BUCKET_SIZE = 8;
    private static final double LOAD_BUCKETS = 75d;
    private Node<K, V>[] startArr = new Node[CAPACITY];

    static class Node<K, V> {
        final int hash;
        final K key;
        V element;
        Node<K, V> next;

        public Node(int hash, K key, V element, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.element = element;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getElement() {
            return element;
        }

        public void setElement(V newElement) {
            element = newElement;
        }


    }


    //put
    public void put(K key, V value) {
        int defaultHash = 0;
        int hash = (key == null) ? 0 : (defaultHash = key.hashCode()) ^ (defaultHash >>> 16);
        int arrSize = startArr.length;
        int bucket = hash % arrSize;

        if (startArr[bucket] == null) {
            startArr[bucket] = new Node<K, V>(hash, key, value, null);
        } else {
            Node<K, V> temporaryNode = startArr[bucket];
            int count = 0;
            while (temporaryNode.next != null) {
                if (temporaryNode.key == key) {
                    break;
                }
                temporaryNode = temporaryNode.next;
                count++;
            }
            if (temporaryNode.key == key) {
                temporaryNode.setElement(value);

            } else {
                temporaryNode.next = new Node<K, V>(hash, key, value, null);
            }
            if (count == BUCKET_SIZE || 100d / (startArr.length * BUCKET_SIZE) * size() >= LOAD_BUCKETS) {
                sizeCollection(startArr.length * 2);
            }
        }

    }

    private void sizeCollection(int size) {
        Node<K, V>[] oldCollection = startArr;
        startArr = new Node[size];

        for (Node<K, V> kvNode : oldCollection) {
            if (kvNode == null) {
                continue;
            }
            Node<K, V> temporaryNode = kvNode;
            put(temporaryNode.getKey(), temporaryNode.getElement());

            while (temporaryNode.next != null){
                temporaryNode = temporaryNode.next;
                put(temporaryNode.getKey(), temporaryNode.getElement());
            }
        }
    }


    //remove
    public void remove(K key) {
        int defaultHash = 0;
        int hash = (key == null) ? 0 : (defaultHash = key.hashCode()) ^ (defaultHash >>> 16);
        int arrSize = startArr.length;
        int bucket = hash % arrSize;
        if (startArr[bucket] == null) {
            throw new NoSuchElementException();
        }
        Node<K, V> removable = startArr[bucket];
        Node<K, V> previousNode = null;
        if (removable.getKey() == key) {
            startArr[bucket] = removable.next;
            if (100d / (startArr.length * BUCKET_SIZE) * size() < LOAD_BUCKETS) {
                sizeCollection(startArr.length / 2);
            }
            return;
        }
        while (removable.next != null) {
            previousNode = removable;
            removable = removable.next;
            if (removable.getKey() == key) {
                previousNode.next = removable.next;
                if (100d / (startArr.length * BUCKET_SIZE) * size() < LOAD_BUCKETS) {
                    sizeCollection(startArr.length / 2);
                }
                return;
            }
        }
    }


    //clear
    public void clear() {
        startArr = new Node[0];
    }


    //size
    public int size() {
        int size = 0;
        for (Node<K, V> node : startArr) {
            if (node == null) {
                continue;
            }
            Node<K, V> temporaryNode = node;
            size++;
            while (temporaryNode.next != null) {
                temporaryNode = temporaryNode.next;
                size++;
            }
        }
        return size;
    }


    //get
    public V get(K key) {
        int defaultHash = 0;
        int hash = (key == null) ? 0 : (defaultHash = key.hashCode()) ^ (defaultHash >>> 16);
        int arrSize = startArr.length;
        int buckets = hash % arrSize;
        if (startArr[buckets] == null) {
            throw new NoSuchElementException();
        }
        Node<K, V> result = startArr[buckets];
        if (result.getKey() == key) {
            return result.getElement();
        }
        while (result.next != null) {
            result = result.next;
            if (result.getKey() == key) {
                return result.getElement();
            }
        }
        throw new NoSuchElementException();
    }

}