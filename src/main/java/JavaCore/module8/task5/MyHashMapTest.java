package JavaCore.module8.task5;

public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        myHashMap.put(11, "aaaa");
        myHashMap.put(45, "bbbb");
        myHashMap.put(13, "cccc");
        myHashMap.put(88, "dddd");

        myHashMap.remove(11);
        System.out.println(myHashMap.get(13));
        //myHashMap.clear();
        System.out.println(myHashMap.size());

    }
}
