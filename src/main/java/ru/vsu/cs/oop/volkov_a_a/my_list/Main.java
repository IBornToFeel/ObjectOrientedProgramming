package ru.vsu.cs.oop.volkov_a_a.my_list;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        System.out.println(list);
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        System.out.println(list);
        System.out.println(list.size());
    }
}

