package lesson1;

import java.util.Arrays;
import java.util.Scanner;

public class Seminar_2 {
    public static void main(String[] args) {
       //task_1_sem_2();
       task_2_sem_2();

    }

    private static void task_1_sem_2(){

        //Дано четное число N (>0) и символы c1 и c2.
        //Написать метод, который вернет строку длины N,
        // которая состоит из чередующихся символов c1 и c2, начиная с c1.
        //устно добавлено, что символы - это должен быть формат char
        //будем спрашивать и число, и символы у пользователя

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter N: ");
        Boolean checkN = scan.hasNextInt();
        int N = 0;
        if (checkN){
            N = scan.nextInt();
            System.out.println("Please enter c1: ");
            String c1 = scan.next();

            System.out.println(" ");

            System.out.println("Please enter c2: ");
            String c2 = scan.next();

            String[] arr = new String[N];
            for (int i = 0; i< arr.length; i++){
                if (i%2 == 0){
                    arr[i] = c1;
                } else {
                    arr[i] = c2;
                }
            }
            String result = String.join(", ", arr);
            System.out.println(result);
            scan.close();
        } else {
            System.out.println("Wrong N. ");
        }
        scan.close();


    }
    private static void task_2_sem_2(){
        //напишите метод, который сжимает строку
        //пример: вход aaaabbcddd

        String enter = "aaaabbcdddf";
        if (enter.trim().length() == 0){ //=if (enter.isBlank())
            return;
        }
        String result = "";
        int count = 1;
        char temp = enter.charAt(0);
        System.out.println(temp);
        for (int i = 1; i<enter.length(); i++){
            if (enter.charAt(i) == temp){
                    count++;
            } else {
                result = (count>1) ? (result + String.valueOf(temp) + count) : (result + String.valueOf(temp));
                temp = enter.charAt(i);
                count = 1;
            }
        }
        result = (count == 1) ? result+=String.valueOf(temp) : result;
        System.out.println(result);
    }
}
