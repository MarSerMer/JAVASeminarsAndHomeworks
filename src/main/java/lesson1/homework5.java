package lesson1;

import java.lang.reflect.Array;
import java.util.*;

import static java.util.Collections.list;

public class homework5 {
    public static void main(String[] args) {
        task1hw5();
        task2hw5();
    }
    //Реализуйте структуру телефонной книги с помощью HashMap,
    // учитывая, что 1 человек может иметь несколько телефонов.
    public static void task1hw5(){
        phoneBook();
    }
    public static void phoneBook() {
        HashMap<String, List<String>> phones = new HashMap<>();
        System.out.println("Here is a new phonebook.\nPlease enter 'add' to add information (surnames and numbers are entered separately).\nEnter 'find' to extract information.\nEnter 'stop' to exit the program.");
        while (true) {
            String enter = getInfoFromUser("command");
            if (enter.equalsIgnoreCase("stop")){
                System.out.println("You entered 'stop' and you exit the program.");
                break;
            } else if (enter.equalsIgnoreCase("find")) {
                if (phones.size()<=0){
                    System.out.println("The phonebook is empty.");
                } else {
                    String str = getInfoFromUser("surname");
                    if (phones.containsKey(str)){
                        System.out.println(phones.get(str));
                    } else {
                        System.out.println("No such surname in the phonebook.");
                    }
                }
            } else if (enter.equalsIgnoreCase("add")){
                String temp = getInfoFromUser("surname");
                if (phones.containsKey(temp)){
                    phones.get(temp).add(getInfoFromUser("phone number"));
                } else {
                    List<String> num = new ArrayList<>();
                    num.add(getInfoFromUser("phone number"));
                    phones.put(temp, num);
                }
            } else {
                System.out.println("I don't know this command.");
            }
        }
    }
    public static String getInfoFromUser(String word){
        System.out.printf("Please enter %s: ", word);
        Scanner scan = new Scanner (System.in);
        String info = scan.nextLine();
        while (true) {
            if (info.trim().length() > 0) {
                break;
            } else {
                System.out.printf("Incorrect %s. Please try again: ", word);
                info = scan.nextLine();
            }
        }
        return info;
    }

    //Пусть дан список сотрудников:Иван Иванов
    //Светлана Петрова
    //Кристина Белова
    //Анна Мусина
    //Анна Крутова
    //Иван Юрин
    //Петр Лыков
    //Павел Чернов
    //Петр Чернышов
    //Мария Федорова
    //Марина Светлова
    //Мария Савина
    //Мария Рыкова
    //Марина Лугова
    //Анна Владимирова
    //Иван Мечников
    //Петр Петин
    //Иван Ежов
    //Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.

    public static void task2hw5(){
        ArrayList<String> listOfNames = new ArrayList<>();
        listOfNames.add("Иван Иванов");
        listOfNames.add("Светлана Петрова");
        listOfNames.add("Кристина Белова");
        listOfNames.add("Анна Мусина");
        listOfNames.add("Анна Крутова");
        listOfNames.add("Иван Юрин");
        listOfNames.add("Петр Лыков");
        listOfNames.add("Павел Чернов");
        listOfNames.add("Петр Чернышов");
        listOfNames.add("Мария Федорова");
        listOfNames.add("Марина Светлова");
        listOfNames.add("Мария Савина");
        listOfNames.add("Мария Рыкова");
        listOfNames.add("Марина Лугова");
        listOfNames.add("Анна Владимирова");
        listOfNames.add("Иван Мечников");
        listOfNames.add("Петр Петин");
        listOfNames.add("Иван Ежов");
        System.out.println(listOfNames);
        countNames(listOfNames);
    }
    public static void countNames(ArrayList<String> names){
        HashMap<String,Integer> result = new HashMap<>();
        for (int i = 0; i < names.size(); i++) {
            String str = names.get(i).substring(0,names.get(i).indexOf(" "));
            if (result.containsKey(str)){
                int r = result.get(str)+1;
                result.put(str,r);
            } else {
                result.put(str,1);
            }
        }
        result.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);
    }
}
