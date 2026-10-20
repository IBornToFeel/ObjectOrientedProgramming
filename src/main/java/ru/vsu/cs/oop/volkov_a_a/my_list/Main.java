package ru.vsu.cs.oop.volkov_a_a.my_list;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws ListException{
        MyList<Integer> list = new MyList<>();
        list.addLast(10);
        list.addLast(30);
        list.addLast(50);
//        for (Integer v : list) {
//            System.out.print(v + " ");
//        }
//        System.out.println();

//        Iterator<Integer> it = list.descIterator();
//        while (it.hasNext()) {
//            System.out.print(it.next() + " ");
//        }
//        System.out.println();


    }
}

