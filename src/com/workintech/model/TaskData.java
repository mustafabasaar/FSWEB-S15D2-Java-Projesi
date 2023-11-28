package com.workintech.model;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> unassignedTasks=new HashSet<>();
    private Set<Task> annsTasks = new HashSet<>();
    private Set<Task> bobsTasks = new HashSet<>();
    private Set<Task> carolsTasks = new HashSet<>();

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }

    public void addTask(String assignee, Task task) {
        switch (assignee.toLowerCase()) {
            case  "":
                unassignedTasks.add(task);
            case "ann":
                annsTasks.add(task);
                break;
            case "bob":
                bobsTasks.add(task);
                break;
            case "carol":
                carolsTasks.add(task);
                break;
            default:
                throw new IllegalArgumentException("Invalid assignee: " + assignee);
        }
    }

    public Set<Task> getTasks(String assignee) {
        switch (assignee.toLowerCase()) {
            case"":
            return unassignedTasks;
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                Set<Task> allTasks = new HashSet<>();
                allTasks.addAll(annsTasks);
                allTasks.addAll(bobsTasks);
                allTasks.addAll(carolsTasks);
                allTasks.addAll(unassignedTasks);
                return allTasks;
            default:
                throw new IllegalArgumentException("Invalid assignee: " + assignee);
        }
    }
    public Set<Task> getAllTasks() {
        Set<Task> allTasks = new HashSet<>();
        allTasks.addAll(annsTasks);
        allTasks.addAll(bobsTasks);
        allTasks.addAll(carolsTasks);
        allTasks.addAll(unassignedTasks);
        return allTasks;
    }

    @Override
    public String toString() {
        return "TaskData{" +
                "unassignedTasks=" + unassignedTasks +
                ", annsTasks=" + annsTasks +
                ", bobsTasks=" + bobsTasks +
                ", carolsTasks=" + carolsTasks +
                '}';
    }
}

