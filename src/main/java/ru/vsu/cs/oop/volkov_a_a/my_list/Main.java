package ru.vsu.cs.oop.volkov_a_a.my_list;

public class Main {
    public static void main(String[] args) throws ListException{
        MyList<Integer> list = new MyList<>();
        list.addLast(20);
        list.addLast(30);
        list.addFirst(10);
        System.out.println(list);
        System.out.println(list.remfirst());
        System.out.println(list);
    }
}

