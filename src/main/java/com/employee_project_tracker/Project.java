package com.employee_project_tracker;


import java.time.LocalDate;

/**
 * *******************************************************
 * Package: com.employee_project_tracker
 * File: Project.java
 * Author: Ochwada
 * Date: Monday, 16.Jun.2025, 4:37 PM
 * Description: Represents a project with attributes such as name, budget, status, project type,
 * * manager, and deadline. This class models both basic and extended project details.
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


    // ---------------------------------------------------------------
    // Enhanced (BONUS)
    // ---------------------------------------------------------------
    private final String projectType;
    private final String manager;
    private final LocalDate deadline;
    // -------------------------END-----------------------------------

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
        this.projectType = null;
        this.manager = null;
        this.deadline = null;
    }

    // ---------------------------------------------------------------
    // Constructor 2
    // ---------------------------------------------------------------

    /**
     * Constructs a new {@code Project} instance with the specified details.
     *
     * @param name        the name of the project
     * @param budget      the allocated budget for the project
     * @param status      the current status of the project (e.g., "Active", "Completed", "Pending")
     * @param projectType the type of the project (e.g., "Internal", "Client", "Research")
     * @param manager     the name of the manager responsible for the project
     * @param deadline    the deadline for the project completion
     */
    public Project(String name, double budget, String status, String projectType, String manager, LocalDate deadline) {
        this.name = name;
        this.budget = budget;
        this.status = status;
        this.projectType = projectType;
        this.manager = manager;
        this.deadline = deadline;
    }
    // -------------------------END-----------------------------------

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

    // ---------------------------------------------------------------
    // Getters (BONUS)
    // ---------------------------------------------------------------

    public String getProjectType() {
        return projectType;
    }

    public String getManager() {
        return manager;
    }

    public LocalDate getDeadline() {
        return deadline;
    }
    // -------------------------END-----------------------------------
}
