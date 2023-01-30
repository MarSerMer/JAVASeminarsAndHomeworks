package lesson1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Homework_1 {
    public static void main(String[] args) {
        task_1();
        //Задать одномерный массив и найти в нем минимальный и максимальный элементы
        task_2();
        //Написать метод, который определяет, является ли год високосным, и возвращает
        // boolean (високосный - true, не високосный - false).
        // Каждый 4-й год является високосным, кроме каждого 100-го,
        // при этом каждый 400-й – високосный.
        task_3();
        //Дан массив nums = [3,2,2,3] и число val = 3.
        //Если в массиве есть числа, равные заданному, нужно перенести
        //эти элементы в конец массива.
        //Таким образом, первые несколько (или все) элементов массива
        //должны быть отличны от заданного, а остальные - равны ему.
    }

    private static void task_1() {
        //Задать одномерный массив и найти в нем минимальный и максимальный элементы
        int[] array = new int[15];
        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(15);
        }
        System.out.println(Arrays.toString(array));
        int max = array[0];
        int min = array[0];

        for (int i = 0; i < array.length; i++) {
            max = Math.max(array[i], max);
            min = Math.min(array[i], min);
        }
        System.out.println(max);
        System.out.println(min);
    }

    private static void task_2() {
        //Написать метод, который определяет, является ли год високосным, и возвращает
        // boolean (високосный - true, не високосный - false).
        // Каждый 4-й год является високосным, кроме каждого 100-го,
        // при этом каждый 400-й – високосный.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a year:  ");
        boolean check_year = scanner.hasNextInt();
        if (check_year) {
            int year = scanner.nextInt();
            boolean result = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
            System.out.println(result);
        } else {
            System.out.println("Wrong year");
        }
        scanner.close();
    }

    private static void task_3() {
        //Дан массив nums = [3,2,2,3] и число val = 3.
        //Если в массиве есть числа, равные заданному, нужно перенести
        //эти элементы в конец массива.
        //Таким образом, первые несколько (или все) элементов массива
        //должны быть отличны от заданного, а остальные - равны ему.
        int[] nums = new int[15];
        int val = 3;
        Random rand = new Random();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(5);
            count = (nums[i] == val) ? (count + 1) : count;
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(count);
        switch (count) {
            case 0:
                System.out.println("No val in the array");
                break;
            default:
                int l = 0;
                int r = nums.length - 1;
                while (l <= r) {
                    if (nums[l] == val && nums[r] != val) {
                        nums[l] = nums[r];
                        nums[r] = val;
                        l++;
                        r--;
                    } else if (nums[l] == val && nums[r] == val) {
                        r--;
                    } else if (nums[l] != val && nums[r] == val) {
                        l++;
                        r--;
                    } else if (nums[l] != val && nums[r] != val) {
                        l++;
                    }

                }
                System.out.println(Arrays.toString(nums));
                System.out.println("Done");


        }
    }
}

