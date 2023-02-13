package lesson1;

//Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
//Создать множество ноутбуков (ArrayList).
//Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям. Например, спросить у пользователя минимальный размер оперативной памяти или конкретный цвет. Выводить только те ноутбуки, что соответствуют условию

import java.util.*;
import static lesson1.Notebooks.printNotebook;

public class Homework6 {
    public static void main(String[] args) {
        tasksHw6();
    }

    public static void tasksHw6() {
        Notebooks lenovo = new Notebooks("Lenovo Think Pad Edge", 115000.00, "black", 2.5, 15.0, 4, 8);
        Notebooks hp = new Notebooks("HP 1218", 98700.00, "silver", 2.0, 14.5, 4, 12);
        Notebooks apple = new Notebooks("Apple Mac Book Pro", 153000.00, "silver", 1.5, 14.2, 6, 12);
        Notebooks asus = new Notebooks("Asus Lily", 75600.0, "black", 2.6, 14.0, 4, 8);
        Notebooks dell = new Notebooks("Dell 1317", 56000.0, "grey", 2.0, 15.5, 4, 6);

        List<Notebooks> nbList = new ArrayList<>();
        nbList.add(lenovo);
        nbList.add(hp);
        nbList.add(apple);
        nbList.add(asus);
        nbList.add(dell);
        nbSearchForUser(nbList);
    }
    public static void nbSearchForUser(List<Notebooks> list){
        System.out.println("Here is a menu to find a good notebook.\nEnter 1 to see all notebooks.\nEnter 2 to enter parameters for better search\nEnter 3 to exit tne program");
        while (true){
            String enter = getInfoFromUser().trim();
            if (enter.equals("1")){
                for (Notebooks a : list){
                    printNotebook(a);
                }
            } else if (enter.equals("2")) {
                System.out.println("Please choose and enter one parameter: price, color, weight, screen size, cores, ram. Enter 'stop' to go back to main menu.");
                while (true) {
                    String par = getParameterFromUser().trim();
                    if (par.equalsIgnoreCase("price")) {
                        Double pr = Double.parseDouble(inf());
                        int count = 0;
                        for (Notebooks a : list) {
                            if (a.getPrice() <= pr) {
                                printNotebook(a);
                                count++;
                            }
                        }
                        if (count == 0) System.out.println("No such notebooks found.");
                    } else if (par.equalsIgnoreCase("color")) {
                        String c = inf().trim();
                        int count = 0;
                        for (Notebooks a : list) {
                            if (a.getColor().equalsIgnoreCase(c)) {
                                printNotebook(a);
                                count++;
                            }
                        }
                        if (count == 0) System.out.println("No such notebooks found.");
                    } else if (par.equalsIgnoreCase("weight")) {
                        Double we = Double.parseDouble(inf());
                        int count = 0;
                        for (Notebooks a : list) {
                            if (a.getWeight() <= we) {
                                printNotebook(a);
                                count++;
                            }
                        }
                        if (count == 0) System.out.println("No such notebooks found.");
                    } else if (par.equalsIgnoreCase("screen size")) {
                        Double ss = Double.parseDouble(inf());
                        int count = 0;
                        for (Notebooks a : list) {
                            if (a.getScreenSize() <= ss) {
                                printNotebook(a);
                                count++;
                            }
                        }
                        if (count == 0) System.out.println("No such notebooks found.");
                    } else if (par.equalsIgnoreCase("cores")) {
                        int cores = Integer.parseInt(inf());
                        int count = 0;
                        for (Notebooks a : list) {
                            if (a.getProcessorCores() >= cores) {
                                printNotebook(a);
                                count++;
                            }
                        }
                        if (count == 0) System.out.println("No such notebooks found.");
                    } else if (par.equalsIgnoreCase("ram")) {
                        int ram = Integer.parseInt(inf());
                        int count = 0;
                        for (Notebooks a : list) {
                            if (a.getRam() >= ram) {
                                printNotebook(a);
                                count++;
                            }
                        }
                        if (count == 0) System.out.println("No such notebooks found.");
                    } else if (par.equalsIgnoreCase("stop")){
                        System.out.println("You entered 'stop' and the program goes back to main menu.");
                        break;
                    }
                    else {
                        System.out.println("No information about this parameter.");
                    }
                }
            } else if (enter.equals("3")){
                System.out.println("You entered '3' so the program will be closed.");
                break;
            }

        }
    }
    //команды основного меню
    public static String getInfoFromUser(){
        System.out.printf("Please enter 1, 2 or 3: ");
        Scanner scan = new Scanner (System.in);
        String info = scan.nextLine();
        while (true) {
            if (info.trim().length() > 0) {
                break;
            } else {
                System.out.println("Incorrect command. Please try again: ");
                info = scan.nextLine();
            }
        }
        return info;
    }
    // для поиска по параметру
    public static String getParameterFromUser(){
        System.out.printf("Please enter parameter: ");
        Scanner scan = new Scanner (System.in);
        String parameter = scan.nextLine();
        while (true) {
            if (parameter.trim().length() > 0) {
                break;
            } else {
                System.out.println("Incorrect enter. Please try again: ");
                parameter = scan.nextLine();
            }
        }
        return parameter;
    }

    //вводить значения параметров
    public static String inf (){
        System.out.println("Please enter parameter value");
        Scanner d = new Scanner(System.in);
        String inf = d.nextLine();
        while (true) {
            if (inf.trim().length() > 0) {
                break;
            } else {
                System.out.println("Incorrect enter. Please try again: ");
                inf = d.nextLine();
            }
        }
        return inf;
    }
}
