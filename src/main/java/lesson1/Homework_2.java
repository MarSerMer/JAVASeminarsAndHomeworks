package lesson1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Homework_2 {
    public static void main(String[] args) {
        //task_1_hw_2();
        task_2_hw_2();
    }
    private  static  void task_1_hw_2() {
        //Напишите метод, который принимает на вход строку (String)
        // и определяет является ли строка палиндромом
        // (возвращает boolean значение).
        Scanner enter = new Scanner(System.in);
        System.out.println("Please enter a phrase to find out if it is a palindrome or not: ");
        String phrase = enter.nextLine();
        phrase = phrase.trim().replaceAll("[\\s?.,:;\\d]","").toLowerCase();

        if (phrase.isBlank()) {
            System.out.println("Something strange entered. Definitely it is not s palindrome.");
        } else {
            int count = phrase.length()/2;
            int matches = 0;
            for (int i = 0; i<count; i++){
                if (phrase.charAt(i)==phrase.charAt(phrase.length()-1-i)) {
                    matches++;
                } else {
                    break;
                }
            }
            boolean answer = count == matches;
            System.out.println(answer);

        }

    }
    private static void task_2_hw_2() {
        //Напишите метод, который составит строку,
        // состоящую из 100 повторений слова TEST и метод,
        // который запишет эту строку в простой текстовый файл,
        // обработайте исключения.
        makeStringOf100TEST();
        //String a = "C:\\Users\\User\\Desktop\\Geek Brains\\9 JAVA\\JAVA_seminars\\JAVA_seminar_1\\src\\main\\java\\lesson1\\ForHomeWork2.txt";
        stringToFile(makeStringOf100TEST(), "C:\\Users\\User\\Desktop\\Geek Brains\\9 JAVA\\JAVA_seminars\\JAVA_seminar_1\\src\\main\\java\\lesson1\\ForHomeWork2.txt");
    }
    private static StringBuilder makeStringOf100TEST () {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i<100; i++){
            str.append("TEST ");
        }
        System.out.println(str);
        return (str);
    }
    private static void stringToFile(StringBuilder str, String path) {
        //File fileForString = new File(path);
        try (PrintWriter pw = new PrintWriter(path)){
            pw.print(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
