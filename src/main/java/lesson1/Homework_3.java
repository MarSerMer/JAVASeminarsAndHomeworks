package lesson1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Homework_3 {
    public static void main(String[] args) {
    task_1_hw_3();
    task_2_hw_3();
    task_3_hw_3();
    }
    public static void task_1_hw_3 () {
        //Пусть дан произвольный список целых чисел,
        // удалить из него четные числа (в языке уже есть что-то готовое для этого)
        ArrayList<Integer> numbers = new ArrayList<>();
        int listSize = 20;
        Random rand = new Random();
        for (int i=0; i<listSize;i++) {
            numbers.add(rand.nextInt(-100,100));
        }
        System.out.println("The generated list of numbers: " + numbers);
        numbers.removeIf(x->x%2==0);
        System.out.println("The list of numbers after deleting all even numbers: " + numbers);
    }
    public static void task_2_hw_3 () {
        //Задан целочисленный список ArrayList.
        // Найти минимальное, максимальное и среднее арифметическое из этого списка.
        ArrayList<Integer> numbers = new ArrayList<>();
        int listSize = 20;
        Random rand = new Random();
        for (int i=0; i<listSize;i++) {
            numbers.add(rand.nextInt(-100,100));
        }
        System.out.println("The generated list of numbers: " + numbers);
        System.out.println("Max number from the list: " + numbers.stream().max(Integer::compare).get());
        System.out.println("Min number from the list: " + numbers.stream().min(Integer::compare).get());
        System.out.println("Average of all numbers from the list: " + numbers.stream().mapToDouble(x->x).average().getAsDouble());
    }
    public static void task_3_hw_3() {
        //Пройти по списку из задания 2 с урока и удалить повторяющиеся элементы.
        String[] solarSystemPlanets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        ArrayList<String> manyPlanets = hwPlanetListFilling(solarSystemPlanets, 15);
        System.out.println("Generated list of planets:");
        System.out.println(manyPlanets);
        Collections.sort(manyPlanets);
        for (int i = 1; i<manyPlanets.size(); i++) {
            if (manyPlanets.get(i)==manyPlanets.get(i-1)) {
                manyPlanets.set((i-1), "del");
            }
        }
        manyPlanets.removeIf(x->x.equals("del"));
        System.out.println("List of planets after deleting all repeats:");
        System.out.println(manyPlanets);
    }
    private static ArrayList<String> hwPlanetListFilling(String[] planets, int listSize) {
        ArrayList<String> result = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i<listSize; i++) {
            int numberOfIndex = rand.nextInt(0,planets.length);
            result.add(planets[numberOfIndex]);
        }
        return (result);
    }

}
