package com.nelkinda.training;

import io.cucumber.java.an.E;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.List;

public class ExpenseReportTest {


    @Test
    void printReportWithNoExpenses() {
        var expenseReport = new ExpenseReport();
        var expenseList = Collections.<Expense>emptyList();
        var expectedList = """
                Expenses Fri Mar 03 14:46:08 IST 2023
                Meal expenses: 0
                Total expenses: 0
                """;
        var interceptedOut = new ByteArrayOutputStream();
        var originalOut = System.out;
        System.setOut(new PrintStream(interceptedOut));
        expenseReport.printReport(expenseList);
        var actualList = interceptedOut.toString();
        Assertions.assertEquals(expectedList, actualList);
        System.setOut(originalOut);
    }
}
