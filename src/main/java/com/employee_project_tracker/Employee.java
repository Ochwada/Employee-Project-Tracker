package com.employee_project_tracker;


import java.util.*;

/**
 * *******************************************************
 * Package: com.employee_project_tracker
 * File: Employee.java
 * Author: Ochwada
 * Date: Monday, 16.Jun.2025, 4:41 PM
 * Description: Represents an employee with a name, department, and assigned projects.
 * Objective:
 * *******************************************************
 */


public class Employee {

    // The name of the employee.
    private  final String name;

    // The department to which the employee belongs.
    private final String department;

    // The list of projects assigned to the employee
    private final List<Project> projects;

    /**
     * Constructs a new {@code Employee} instance with the specified name, department, and projects.
     *
     * @param name        the name of the employee
     * @param department  the department of the employee
     * @param projects    the list of {@link Project} objects assigned to the employee
     */
    public Employee(String name, String department, List<Project> projects) {
        this.name = name;
        this.department = department;
        this.projects = projects;
    }

    /**
     * Returns the name of the employee.
     *
     * @return the employee's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the department of the employee.
     *
     * @return the employee's department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Returns the list of projects assigned to the employee.
     *
     * @return a list of {@link Project} objects
     */
    public List<Project> getProjects() {
        return projects;
    }
}
