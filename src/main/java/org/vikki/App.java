package org.vikki;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App {

    public static void main( String[] args ) {
        System.out.println( "******The Ultimate  Todo List!******" );
        runProgram();
    }


    public static void runProgram() {

        List<String> list = new ArrayList<>();
        ToDoList toDoList = new ToDoList(list);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("./todo ");
            String command = scanner.next();

            if(command.equals("-add")) {
                String item = scanner.nextLine();
                toDoList.addItemToList(item);

            } else if(command.equals("-list")) {
                toDoList.todo.forEach(System.out::println);

            } else if(command.equals("-completed")) {

                String item = scanner.nextLine();
                String[] chr = item.split("=");
                String num = chr[1];


                toDoList.markAsCompleted(num);

            } else if (command.equals("-end")) {

                break;

            } else if (command.equals("-del")) {
                String numOfItem = scanner.next();
                String[] chr = numOfItem.split("=");
                String numOfItemOnList = chr[1];

                String itemToRemove = null;

                for(String todo: list) {gi
                    if(todo.contains(numOfItemOnList)) {
                        itemToRemove = todo;
                    }
                }

                toDoList.removeItem(itemToRemove);

            } else {
                System.out.println("Invalid entry!");
            }
        }

    }
}


