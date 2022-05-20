package org.vikki;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App {

    static List<String> list = new ArrayList<>();

    static ToDoList toDoList = new ToDoList(list);


    public static void main( String[] args ) {
        System.out.println( "******The Ultimate  Todo List!******" );
        runProgram();
    }


    public static void runProgram() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

//            readFromFile();

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
                writeToFile();
                break;

            } else if (command.equals("-del")) {
                String numOfItem = scanner.next();
                String[] chr = numOfItem.split("=");
                String numOfItemOnList = chr[1];

                String itemToRemove = null;

                for(String todo: list) {
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

    static void writeToFile() {
        try (FileWriter fileWriter = new FileWriter("/Users/mac/Desktop/todoCLI/todolist.json")) {
            ObjectMapper objectMapper = new ObjectMapper();

            for(int i =0; i < App.toDoList.todo.size(); i++) {
                fileWriter.write(objectMapper.writeValueAsString(App.toDoList.todo.get(i)));
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }

    }

    static void readFromFile() {
        try (FileReader fileReader = new FileReader("/Users/mac/Desktop/todoCLI/todolist.json")) {

            App.toDoList.todo = new ObjectMapper().readValue(fileReader, List.class);

        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
