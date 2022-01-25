package JavaCore.module8.task4;

public class MyStackTest {
    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>();
        myStack.push("AAAAAAA");
        myStack.push("BbBbBbB");
        myStack.push("ccccccc");
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        //myStack.remove(2);
        //myStack.clear();

        System.out.println(myStack.size());
    }
}
