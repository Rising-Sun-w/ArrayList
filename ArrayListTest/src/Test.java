import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        MutableArrayList list=new MutableArrayList();

        MutableArrayList[] sz=new MutableArrayList[10];


        list.add("红岩网校");
//        list.print();
//        list.add(4.232);
//        list.print();
//        System.out.println(list.get(5));
//        list.remove(0);
        list.add(0,"加油冲冲冲！");
//        list.add(5);
//        list.add(true);
//        list.add('a');
//        list.add(89);
        list.print();
//        list.remove(2);
//        list.size();
//        list.add("芜湖");
//        list.print();
        System.out.println(list.get(0));
        System.out.println("List内拥有:"+list.size()+"个元素");
    }
}
