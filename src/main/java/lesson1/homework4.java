package lesson1;

import java.util.*;

public class homework4 {
    public static void main(String[] args) {
        task1hw4();
        task2hw4();
    }

    //Реализовать консольное приложение, которое:
    //Принимает от пользователя и “запоминает” строки.
    //Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
    //Если введено revert, удаляет предыдущую введенную строку из памяти.
    public static void task1hw4() {
        Deque<String> list = new ArrayDeque<>();
        String e;
        System.out.println("Please enter some strings you need to save. \nEnter 'print' to see saved strings. \nEnter 'revert' to delete the last entered string. \nEnter 'stop' to exit the program.\nEnter 'help' to see this message again.\nHave a nice work!");
        while (true){
            e = getString();
            if (e.trim().equalsIgnoreCase("print")) {
                if (list.size()>0) {
                    for (String text : list) {
                        System.out.println(text);
                    }
                } else {
                    System.out.println("The list is empty");
                }
            } else if (e.trim().equalsIgnoreCase("revert")) {
                if (list.size()>0) {
                    list.removeFirst();
                    System.out.println("The last entered string deleted");
                } else {
                    System.out.println("No strings to delete");
                }
            } else if (e.trim().equalsIgnoreCase("stop")){
                break;
            }  else if (e.trim().equalsIgnoreCase("help")){
                System.out.println("Please enter some strings you need to save. \nEnter 'print' to see saved strings. \nEnter 'revert' to delete the last entered string. \nEnter 'stop' to exit the program.\nEnter 'help' to see this message again.\nHave a nice work!");
            } else {
                list.addFirst(e);
                System.out.println("The entered string added to list.");
            }
        }
        System.out.println("You exited the program");
        if (list.size()>0) {
            System.out.println("Now there is the list:");
            for (String text : list) {
                System.out.println(text);
            }
        } else {
            System.out.println("The list is empty");
        }

    }
    public static String getString () {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    //Пусть дан LinkedList с несколькими элементами.
    //Реализуйте метод, который вернет “перевернутый” список.
    public static void task2hw4 () {
        LinkedList<String> firstList = new LinkedList<>();
        firstList.add("one");
        firstList.add("two");
        firstList.add("three");
        firstList.add("four");
        firstList.add("five");
        System.out.println(firstList);
        System.out.println(invertLinkedList(firstList));
    }
    public static LinkedList<String> invertLinkedList(LinkedList<String> list) {
        LinkedList<String> invertedList = new LinkedList<>(list);
        Collections.reverse(invertedList);
        return invertedList;
    }
}
