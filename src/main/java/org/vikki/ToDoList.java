package org.vikki;

import java.util.List;

public class ToDoList {
    List<String> todo;
    int listCounter  = 1;


    public ToDoList(List<String> todo) {
        this.todo = todo;
    }

    public void addItemToList(String item) {
        String numberedItem = "(" + listCounter + ") " + item;
        todo.add(numberedItem);
        listCounter++;
    }

    public void removeItem( String item) {
        todo.remove(item);
    }

    public void markAsCompleted(String numToMark) {
        String toMarkAsCompleted = null;

        for (String s : this.todo) {
            if(s.contains(numToMark)) {
                toMarkAsCompleted = s;
            }

        }

        var positionOfToDoOnList = Integer.parseInt(numToMark) - 1;

        var markedTodo = markWithAsterisk(toMarkAsCompleted);
        this.todo.set(positionOfToDoOnList, markedTodo);

    }

    public String markWithAsterisk(String item) {
        return "*" + item;
    }
}
