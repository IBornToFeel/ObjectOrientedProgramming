package ru.vsu.cs.oop.volkov_a_a.my_list;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws ListException{
        My_Сyclical_List<Integer> c = new My_Сyclical_List<>();
        System.out.println(c);
        c.addLast(1);
        c.addLast(2);
        c.addLast(3);
        c.addFirst(0);
        System.out.println(c);

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

