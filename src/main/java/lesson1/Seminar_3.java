package lesson1;

import java.util.*;

public class Seminar_3 {
    public static void main(String[] args) {
    //task1arraySorting();
    //task1arrayListSorting();
    task_2();
    }
   private static void task1arraySorting() {
       //Заполнить список десятью случайными числами.
       //Отсортировать список методом sort() и вывести его на экран.
       int[] arr = new int[10];
       Random rand = new Random();
       for (int i = 0; i < arr.length; i++) {
           arr[i] = rand.nextInt(3,11);
       }
       System.out.println(Arrays.toString(arr));

       Arrays.sort(arr);
       System.out.println(Arrays.toString(arr));
   }
   private static void task1arrayListSorting () {
        ArrayList<Integer> arrL = new ArrayList<>() ;
        Random newNumber = new Random();
        int size = 10;
        for (int x = 0; x<size; x++) {
            arrL.add(newNumber.nextInt(3,11));
        }
        printList(arrL);
        Collections.sort(arrL); //можно было и так: arrL.sort(Comparator.naturalOrder());
        printList(arrL);
   }
   private static void printList(ArrayList <Integer> list) {
        for (int i = 0; i<list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
       System.out.println();
   }

   private static void task_2() {
       //Заполнить список названиями планет Солнечной системы
       // в произвольном порядке с повторениями.
       //Вывести название каждой планеты и количество его повторений в списке.
       //String[] solarSystemPlanets =
       // {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
       String[] solarSystemPlanets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
       ArrayList<String> manyPlanets = planetListFilling(solarSystemPlanets, 15);
       System.out.println(manyPlanets);
       //ArrayList<String> finalList = quantity(manyPlanets);
       //System.out.println(finalList);
       System.out.println(quantity(manyPlanets));
       System.out.println(countFrequencyWithMap(manyPlanets));
   }
   private static ArrayList<String> planetListFilling(String[] planets, int listSize) {
       ArrayList<String> result = new ArrayList<>();
       Random rand = new Random();
       for (int i = 0; i<listSize; i++) {
           int numberOfIndex = rand.nextInt(0,planets.length);
           result.add(planets[numberOfIndex]);
       }
       return (result);
   }
   private static ArrayList<String> quantity (ArrayList<String> list) {
        Collections.sort(list);
        System.out.println(list);
        ArrayList<String> result = new ArrayList<>();
        int count = 1;
        for (int i = 1; i<list.size(); i++) {
            if (list.get(i) == list.get(i-1)) { //можно так: if (list(i).equals(list(i-1))
                count++;
            } else {
                result.add(list.get(i-1) + "-" + count);
                count = 1;
            }
        }
        if ((list.get(list.size()-1) == (list.get(list.size()-2)))) {
           result.add(list.get(list.size()-1) + "-" + count);
        } else {
            result.add(list.get(list.size()-1) + "-" + "1");
        }
        return (result);
   }
   private static Map <String, Integer> countFrequencyWithMap (ArrayList<String> list) {
        Map <String, Integer> frequencyPlanets = new HashMap<>();
        //frequencyPlanets.put(String, Integer)
       Collections.sort(list);
       int count = 1;
       for (int i = 1; i<list.size(); i++) {
           if (list.get(i) == list.get(i-1)) { //можно так: if (list(i).equals(list(i-1))
               count++;
           } else {
               frequencyPlanets.put(list.get(i-1), count);
               count = 1;
           }
       }
       if ((list.get(list.size()-1) == (list.get(list.size()-2)))) {
           frequencyPlanets.put(list.get(list.size()-1),count);
       } else {
           frequencyPlanets.put(list.get(list.size()-1),1);
       }
       return (frequencyPlanets);
       //System.out.println(frequencyPlanets);
   }


}
