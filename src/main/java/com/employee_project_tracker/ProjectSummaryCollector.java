package com.employee_project_tracker;


import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;

/**
 * *******************************************************
 * Package: com.employee_project_tracker
 * File: ProjectSummaryCollector.java
 * Author: Ochwada
 * Date: Monday, 16.Jun.2025, 4:56 PM
 * Description:
 * Objective:
 * *******************************************************
 */


public class ProjectSummaryCollector
        implements Collector<
        Employee, Map<String, ProjectSummaryCollector.Summary>,
        Map<String, ProjectSummaryCollector.Summary>
        > {
    /**
     * A summary object that holds aggregated statistics for a department:
     * total number of projects and average budget.
     */
    public static class Summary {
        // The total number of projects in the department.
        private int totalProjects = 0;
        // The total accumulated budget for the department.
        private double totalBudget = 0.0;

        /**
         * Adds a project to the summary.
         *
         * @param p the project to add
         */
        public void addProject(Project p) {
            totalProjects++;
            totalBudget += p.getBudget();
        }

        /**
         * Returns the total number of projects.
         *
         * @return total number of projects
         */
        public int getTotalProjects() {
            return totalProjects;
        }

        /**
         * Calculates and returns the average budget for the department.
         *
         * @return average budget, or 0 if no projects exist
         */
        public double getAverageBudget() {
            return totalBudget == 0 ? 0 : totalBudget / totalProjects;
        }

        /**
         * Returns a string representation of the summary.
         *
         * @return summary as a string
         */
        @Override
        public String toString() {
            return "Product: " + totalProjects + ", Avg Budget: " + getAverageBudget();
        }
    }

    /**
     * Supplies an empty accumulator (HashMap) for collecting data.
     *
     * @return supplier of empty map
     */
    @Override
    public Supplier<Map<String, Summary>> supplier() {
        return HashMap::new;
    }

    /**
     * Accumulates an employee's projects into the department summary.
     *
     * @return a function that updates the accumulating map based on the provided employee
     */
    @Override
    public BiConsumer<Map<String, Summary>, Employee> accumulator() {
        return (map, emp) -> {
            Summary summary = map.computeIfAbsent(emp.getDepartment(),
                    d -> new Summary());
            emp.getProjects().forEach(summary::addProject);
        };
    }

    /**
     * Merges two partial maps during parallel stream processing.
     *
     * @return function that merges two accumulating maps
     */
    @Override
    public BinaryOperator<Map<String, Summary>> combiner() {
        return (map1, map2) -> {
            map2.forEach((dept, s2) ->
                    map1.merge(dept, s2, (s1, s) -> {
                        s1.totalProjects += s.totalProjects;
                        s1.totalBudget += s.totalBudget;
                        return s1;
                    }));
            return map1;
        };
    }

    /**
     * Finishes the collection process. In this case, identity finisher is used.
     *
     * @return function that returns the accumulated result directly
     */
    @Override
    public Function<Map<String, Summary>, Map<String, Summary>> finisher() {
        return Function.identity();
    }

    /**
     * Defines the characteristics of this collector.
     *
     * @return a set containing {@code IDENTITY_FINISH}
     */
    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(Characteristics.IDENTITY_FINISH);
    }
}
