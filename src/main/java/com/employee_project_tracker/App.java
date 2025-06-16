package com.employee_project_tracker;


import java.util.*;
/**
 *
 * Demo App
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Employee> employees = List.of(
                new Employee("Anna", "Engineering",
                        List.of(
                                new Project("Build API", 20000, "active"),
                                new Project("Refactor Module", 10000, "completed"))),
                new Employee("Ben", "Marketing",
                        List.of(
                                new Project("Ad Campaign", 15000, "active"))),
                new Employee("Clara", "Engineering",
                        List.of(
                                new Project("Mobile App", 30000, "completed")))
        );
        CompanyAnalyzer analyzer = new CompanyAnalyzer();

        System.out.println("All Projects:");
        analyzer.getAllProjects(employees).forEach(p -> System.out.println(p.getName()));

        System.out.println("\nCount by Status:");
        System.out.println(analyzer.countProjectsByStatus(analyzer.getAllProjects(employees)));

        System.out.println("\nAverage Budget by Status:");
        System.out.println(analyzer.averageBudgetByStatus(analyzer.getAllProjects(employees)));

        System.out.println("\nSummary by Department (Custom Collector):");
        Map<String, ProjectSummaryCollector.Summary> summary = employees.stream()
                .collect(new ProjectSummaryCollector());
        summary.forEach((dept, s) -> System.out.println(dept + ": " + s));
    }
}
