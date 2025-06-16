package com.employee_project_tracker;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.time.LocalDate;

/**
 * *******************************************************
 * Package: com.employee_project_tracker
 * File: CompanyAnalyzerTest.java
 * Author: Ochwada
 * Date: Monday, 16.Jun.2025, 5:28 PM
 * Description:
 * Objective:
 * *******************************************************
 */

public class CompanyAnalyzerTest {
    private final CompanyAnalyzer analyzer = new CompanyAnalyzer();

    private final List<Employee> employees = List.of(
            new Employee("Alice", "IT", List.of(
                    new Project("P1", 1000, "Active", "Internal", "Bob", LocalDate.now().plusDays(30)),
                    new Project("P2", 2000, "Completed", "Client", "Bob", LocalDate.now().plusDays(60))
            )),
            new Employee("John", "HR", List.of(
                    new Project("P3", 1500, "Active", "Research", "Eve", LocalDate.now().plusDays(90))
            ))
    );

    @BeforeAll // JUnit runs this once before any test method in this class.
    static void beforeAllTests() {
        System.out.println("\uD83E\uDDFF Stating ... Tests...  ");
    }

    @BeforeEach
    void setUp() {
        List<Employee> employees = List.of(
                new Employee("Alice", "IT", List.of(
                        new Project("P1", 1000, "Active", "Internal", "Bob", LocalDate.now().plusDays(30)),
                        new Project("P2", 2000, "Completed", "Client", "Bob", LocalDate.now().plusDays(60))
                )),
                new Employee("John", "HR", List.of(
                        new Project("P3", 1500, "Active", "Research", "Eve", LocalDate.now().plusDays(90))
                )));
        System.out.println("\uD83D\uDD38 New Setup: Create a new object.");

    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        System.out.println("✔\uFE0FTest Passed: 📃 " + testInfo.getDisplayName());
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("✅  .... ✨ Tests  Successfully Done ✨");
    }

    // -----------------------------------------------------
    // TESTS
    // -----------------------------------------------------
    @Test
    @DisplayName("Get All Projects")
    void testGetAllProjects() {
        List<Project> projects = analyzer.getAllProjects(employees);
        assertEquals(3, projects.size());
    }

    @Test
    @DisplayName("Count Projects By Status")
    void testCountProjectsByStatus() {
        List<Project> projects = analyzer.getAllProjects(employees);
        Map<String, Long> result = analyzer.countProjectsByStatus(projects);
        assertEquals(2, result.get("Active"));
        assertEquals(1, result.get("Completed"));
    }

    @Test
    @DisplayName("Average Budget By Status")
    void testAverageBudgetByStatus() {
        List<Project> projects = analyzer.getAllProjects(employees);
        Map<String, Double> result = analyzer.averageBudgetByStatus(projects);
        assertEquals(1250.0, result.get("Active"));  // (1000 + 1500)/2
        assertEquals(2000.0, result.get("Completed"));
    }
}
