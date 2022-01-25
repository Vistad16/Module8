package JavaCore.module8.task5;

    public class MyHashMap <T, K> {
        Node<T, K> last;
        Node<T, K> first;

        private int size = 0;

        private static class Node<T, K> {
            int hash;
            private final T key;
            private final K value;
            Node<T, K> next;

            Node(T key, K value, Node<T, K> next, int hash) {
                this.key = key;
                this.value = value;
                this.next = next;
                this.hash = hash;
            }

            public T getKey() {
                return key;
            }

            public K getValue() {
                return value;
            }

            @Override
            public String toString() {
                return key + "=" + value;
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

        @Override
        public String toString() {
            String s = "";
            for (Node<T, K> x = first; x != null; x = x.next) {
                s += x + " ";
            }
            return s;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public void put(T key, K value) {
            if (!isKeyInHashMap(key)) {
                Node<T, K> l = last;
                Node<T, K> f = first;
                final Node<T, K> newNode = new Node<T, K>(key, value, null, hashCode());
                if (l == null)
                    first = newNode;
                else
                    l.next = newNode;
                last = newNode;
                size++;

            }
        }
        public boolean isKeyInHashMap(T key){
            int count = 0;
            for (Node<T, K> y = first; y != null; y = y.next){
                if (key.equals(y.key)){
                    count++;
                }

            }
            return count==1;
        }


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

        public void clear(){
            first = null;
            setSize(0);
        }

        public int size(){
            return getSize();
        }

        public K get(T key) {
            int hashOfGivenKey = key.hashCode();

            Node<T, K> x;
            for ( x = first; x != null; x = x.next ) {
                if (key.equals(x.key)) {
                    return x.value;
                }
            }
            return null;
        }
    }