package com.employee_project_tracker;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * *******************************************************
 * Package: com.employee_project_tracker
 * File: CompanyAnalyzer.java
 * Author: Ochwada
 * Date: Monday, 16.Jun.2025, 4:47 PM
 * Description: Provides analytics and aggregation methods for employees and their projects.
 * Objective:
 * *******************************************************
 */


public class CompanyAnalyzer {

    /**
     * Retrieves all projects from the provided list of employees.
     *
     * <p>This method flattens the nested list of projects for each employee
     * into a single list containing all projects.
     *
     * @param employees the list of {@link Employee} objects
     * @return a list containing all {@link Project} objects from all employees
     */
    public List<Project> getAllProjects(List<Employee> employees) {
        return employees.stream()
                .flatMap(e -> e.getProjects().stream())
                .collect(Collectors.toList());
    }

    /**
     * Groups the given list of projects by their status and counts the number of projects in each status.
     *
     * @param projects the list of {@link Project} objects to process
     * @return a map where the key is the project status and the value is the count of projects with that status
     */
    public Map<String, Long> countProjectsByStatus(List<Project> projects) {
        return projects.stream()
                .collect(Collectors.groupingBy(Project::getStatus,
                        Collectors.counting()));
    }

    /**
     * Calculates the average budget for each project status.
     *
     * <p>This method groups projects by their status and computes the average budget
     * for each group.
     *
     * @param projects the list of {@link Project} objects to process
     * @return a map where the key is the project status and the value is the average budget for that status
     */
    public Map<String, Double> averageBudgetByStatus(List<Project> projects) {
        return projects.stream()
                .collect(Collectors.groupingBy(Project::getStatus,
                        Collectors.averagingDouble(Project::getBudget)));
    }
}
