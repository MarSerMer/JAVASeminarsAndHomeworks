package lesson1;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Seminar_1 {
    public static void main(String[] args) {
        //ex1();
        ex2();
    }

    private static void ex1() {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("What is your name?  ");
        String userName = iScanner.nextLine();
        String greeting = "Hello, " + userName + "! Nice to see you here!";
        System.out.println(greeting);
        System.out.printf("Hello, %s!\n", userName);
        iScanner.close();
    }

    private static void ex2() {
        //дан массив двоичных чисел: {1,10,0,1,1,1,0}.
        //вывести максимальное количество подряд идущих 1
        //можно просто ручками задать массив:
        //int[] array= new int [] {0,1,1,1,0,1,0,1,1,0};
        //либо же можно заполнять массив случайными числами:
        int[] array = new int[100];
        Random rand = new Random();
        //тогда нужен цикл, который заполнит наш массив:
        for (int i = 0; i<array.length; i++){
            array[i] = rand.nextInt(2);
        }
        //вообще я сделала цикл для вывода массива в консоль:
        //for (int i = 0; i<array.length; i++){
        //    System.out.printf("%s, ", array[i]);
        //}

        //но для этого есть другой способ:
        System.out.println(Arrays.toString(array));

        System.out.println(" ");

        int count = 0;
        int temp = 0;
        for (int i = 0; i<array.length; i++){
            if (array[i] == 1){
                count ++;

            } else {
                //вариант 1:
               /* if (count > temp){
                    temp = count;
                    count = 0;
                }*/
                //вариант 2 - тернарный оператор:
                //(condition) ? true : false;
                //temp = (count>temp) ? count : temp:
                //count= 0;

                //вариант 3, победитель гонки:
                temp = Math.max(temp, count);
                count = 0;

            }
        }
        System.out.println(Math.max(temp, count));


    }
}
