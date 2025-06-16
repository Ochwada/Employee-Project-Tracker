package com.employee_project_tracker;


/**
 * *******************************************************
 * Package: com.employee_project_tracker
 * File: Project.java
 * Author: Ochwada
 * Date: Monday, 16.Jun.2025, 4:37 PM
 * Description: Represents a project with a name, budget, and status.
 * Objective: This class is immutable: once a {@code Project} object is created, its state cannot be changed.
 * *******************************************************
 */


public class Project {

    // The name of the project.
    private final String name;

    // The allocated budget for the project.
    private final double budget;

    // The current status of the project (e.g., "Active", "Completed", "Pending").
    private final String status;


    /**
     * Constructs a new {@code Project} instance with the specified name, budget, and status.
     *
     * @param name   the name of the project
     * @param budget the allocated budget for the project
     * @param status the current status of the project
     */
    public Project(String name, double budget, String status) {
        this.name = name;
        this.budget = budget;
        this.status = status;
    }

    /**
     * Returns the name of the project.
     *
     * @return the project's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the budget allocated to the project.
     *
     * @return the project's budget
     */
    public double getBudget() {
        return budget;
    }

    /**
     * Returns the current status of the project.
     *
     * @return the project's status
     */
    public String getStatus() {
        return status;
    }
}
