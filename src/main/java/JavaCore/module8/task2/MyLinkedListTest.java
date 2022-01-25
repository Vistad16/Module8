package JavaCore.module8.task2;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList();

        myLinkedList.add("222");
        myLinkedList.add("55");
        myLinkedList.add("54h");
        //myLinkedList.add(54);
        myLinkedList.add("gdfgf");
        myLinkedList.add("435\n45");
        myLinkedList.add(2, "dfdf");


        //System.out.println(myLinkedList.size());
        //myLinkedList.clear();
        //myLinkedList.remove(1);

        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.println(myLinkedList.get(i));
        }
    }
}
