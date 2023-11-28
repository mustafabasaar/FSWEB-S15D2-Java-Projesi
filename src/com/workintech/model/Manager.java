package com.workintech.model;

import java.util.HashSet;
import java.util.Set;

public class Manager {
    public Set<Task> getUnion(Set<Task> set1, Set<Task> set2) {
        Set<Task> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        return unionSet;
    }

    public Set<Task> getIntersect(Set<Task> set1, Set<Task> set2) {
        Set<Task> intersectSet = new HashSet<>(set1);
        intersectSet.retainAll(set2);
        return intersectSet;
    }

    public Set<Task> getDifference(Set<Task> set1, Set<Task> set2) {
        Set<Task> differenceSet = new HashSet<>(set1);
        differenceSet.removeAll(set2);
        return differenceSet;
    }

    public Set<Task> getTasksWithoutAssignee(Set<Task> allTasks) {
        Set<Task> tasksWithoutAssignee = new HashSet<>();
        for (Task task : allTasks) {
            if (task.getAssignee().isEmpty()) {
                tasksWithoutAssignee.add(task);
            }
        }
        return tasksWithoutAssignee;
    }

    public Set<Task> getTasksAssignedToMultiple(Set<Task> allTasks) {
        Set<Task> tasksAssignedToMultiple = new HashSet<>();
        Set<Task> uniqueTasks = new HashSet<>();
        for (Task task : allTasks) {
            if (!uniqueTasks.add(task)) {
                tasksAssignedToMultiple.add(task);
            }
        }
        return tasksAssignedToMultiple;
    }

}
