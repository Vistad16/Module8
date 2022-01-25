package JavaCore.module8.task1;

class MyArrayListTest {

    public static void main(String[] args) {
        MyArrayList<Integer> testMyArrayList = new MyArrayList<>();

        //<String>
        /*testMyArrayList.add("sss");
        testMyArrayList.add("www");
        testMyArrayList.add("aaa");*/

        //<Integer>
        testMyArrayList.add(2);
        testMyArrayList.add(10);
        testMyArrayList.add(42);


        //testMyArrayList.remove(0);
        //System.out.println(testMyArrayList.get(1));
        //testMyArrayList.clear();
        //System.out.println(testMyArrayList.size());

        for (int i = 0; i < testMyArrayList.size(); i++) {
            System.out.println(testMyArrayList.get(i));
        }

    }

}
