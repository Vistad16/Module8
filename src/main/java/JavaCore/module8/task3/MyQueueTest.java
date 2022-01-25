package JavaCore.module8.task3;

public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.add(23);
        myQueue.add(4);

        System.out.println(myQueue.poll());
        System.out.println(myQueue.peek());

        //myQueue.remove(0);

        System.out.println(myQueue.size());

    }
}
